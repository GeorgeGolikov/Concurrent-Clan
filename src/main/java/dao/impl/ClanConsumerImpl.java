package dao.impl;

import dao.ClanConsumer;
import entity.Clan;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClanConsumerImpl implements ClanConsumer {
    private final static Map<Long, Clan> clans = new ConcurrentHashMap<>();

    @Override
    public void save(Clan clan) {
        clans.put(clan.getId(), clan);
    }

    public static void printClansGold() {
        clans.forEach((k, v) -> {
            System.out.println(v.getGold());
        });
    }
}
