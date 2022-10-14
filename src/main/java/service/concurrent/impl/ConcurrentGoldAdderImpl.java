package service.concurrent.impl;

import dao.ClanConsumer;
import dao.impl.ClanConsumerImpl;
import dto.GoldBeforeAndAfter;
import entity.Clan;
import service.concurrent.ConcurrentGoldAdder;

import java.util.concurrent.locks.Lock;

public class ConcurrentGoldAdderImpl implements ConcurrentGoldAdder {
    private final ClanConsumer clansRepo = new ClanConsumerImpl();

    @Override
    public GoldBeforeAndAfter add(Clan clan, int gold) {
        GoldBeforeAndAfter goldBeforeAndAfter = new GoldBeforeAndAfter();
        Lock lock = clan.getLock();
        lock.lock();
        try {
            long goldBefore = clan.getGold();
            goldBeforeAndAfter.setGoldBefore(clan.getGold());
            clan.setGold(goldBefore + gold);
            goldBeforeAndAfter.setGoldAfter(clan.getGold());
            clansRepo.save(clan);
            return goldBeforeAndAfter;
        } finally {
            lock.unlock();
        }
    }
}
