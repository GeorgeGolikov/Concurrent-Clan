package service;

import dao.ClanConsumer;
import dao.ClanProducer;
import dao.impl.ClanConsumerImpl;
import dao.impl.ClanProducerImpl;
import dto.GoldBeforeAndAfter;
import entity.Clan;
import entity.GoldTransaction;
import service.concurrent.ConcurrentGoldAdder;
import service.concurrent.impl.ConcurrentGoldAdderImpl;
import service.transaction.GoldTransactionTracker;
import service.transaction.impl.GoldTransactionTrackerImpl;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TaskService {
    private final ClanProducer clans = new ClanProducerImpl();
    private final ConcurrentGoldAdder concurrentGoldAdder = new ConcurrentGoldAdderImpl();
    private final GoldTransactionTracker tracker = new GoldTransactionTrackerImpl();

    public void completeTask(long clanId, long taskId) {
        boolean taskCompleted = tryCompleteTask(taskId);

        if (taskCompleted) {
            int gold = getTaskPrice(taskId);
            Clan clan = clans.get(clanId);
            GoldBeforeAndAfter goldBeforeAndAfter = concurrentGoldAdder.add(clan, gold);
            GoldTransaction transaction = new GoldTransaction.Builder()
                    .clanId(clanId)
                    .timestamp(Timestamp.valueOf(LocalDateTime.now()))
                    .cause("Task")
                    .causeId(taskId)
                    .goldBefore(goldBeforeAndAfter.getGoldBefore())
                    .goldUpdateAmount(gold)
                    .goldAfter(goldBeforeAndAfter.getGoldAfter())
                    .build();
            tracker.track(transaction);
        }
    }

    private boolean tryCompleteTask(long taskId) {
        System.out.printf("Doing very important task #%d", taskId);
        return taskId < Math.random() * 50;
    }

    private int getTaskPrice(long taskId) {
        return taskId <= Integer.MAX_VALUE ? (int) taskId : 100;
    }
}
