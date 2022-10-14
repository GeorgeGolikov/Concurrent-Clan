package dao.impl;

import dao.ClanProducer;
import entity.Clan;

import java.util.HashMap;
import java.util.Map;

public class ClanProducerImpl implements ClanProducer {
    private final static Map<Long, Clan> clans = new HashMap<>();

    static {
        clans.put(0L, new Clan(0L, "Clan0"));
        clans.put(1L, new Clan(1L, "Clan1"));
        clans.put(2L, new Clan(2L, "Clan2"));
        clans.put(3L, new Clan(3L, "Clan3"));
        clans.put(4L, new Clan(4L, "Clan4"));
    }

    @Override
    public Clan get(long clanId) {
        return clans.get(clanId);
    }
}
