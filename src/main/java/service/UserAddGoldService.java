package service;

import dao.ClanProducer;
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

public class UserAddGoldService {
    private final ClanProducer clans = new ClanProducerImpl();
    private final ConcurrentGoldAdder concurrentGoldAdder = new ConcurrentGoldAdderImpl();
    private final GoldTransactionTracker tracker = new GoldTransactionTrackerImpl();

    public void addGoldToClan(long userId, long clanId, int gold) {
        Clan clan = clans.get(clanId);
        GoldBeforeAndAfter goldBeforeAndAfter = concurrentGoldAdder.add(clan, gold);
        GoldTransaction transaction = new GoldTransaction.Builder()
                .clanId(clanId)
                .timestamp(Timestamp.valueOf(LocalDateTime.now()))
                .cause("User")
                .causeId(userId)
                .goldBefore(goldBeforeAndAfter.getGoldBefore())
                .goldUpdateAmount(gold)
                .goldAfter(goldBeforeAndAfter.getGoldAfter())
                .build();
        tracker.track(transaction);

        System.out.println(clan.getGold());
    }
}
