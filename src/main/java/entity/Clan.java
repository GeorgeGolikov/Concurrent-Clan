package entity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Clan {
    private long id;
    private String name;
    private volatile long gold;
    private final Lock lock = new ReentrantLock();

    public Clan() {

    }

    public Clan(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getGold() {
        return gold;
    }

    public void setGold(long gold) {
        this.gold = gold;
    }

    public long getId() {
        return id;
    }

    public Lock getLock() {
        return lock;
    }
}
