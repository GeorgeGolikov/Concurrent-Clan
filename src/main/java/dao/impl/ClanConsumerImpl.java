package dao.impl;

import dao.ClanConsumer;
import entity.Clan;

import java.util.HashMap;
import java.util.Map;

public class ClanConsumerImpl implements ClanConsumer {
    private final static Map<Long, Clan> clans = new HashMap<>();

    @Override
    public void save(Clan clan) {
        clans.put(clan.getId(), clan);
    }
}
