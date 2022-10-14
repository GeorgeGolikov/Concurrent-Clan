package service.concurrent;

import dto.GoldBeforeAndAfter;
import entity.Clan;

public interface ConcurrentGoldAdder {
    GoldBeforeAndAfter add(Clan clan, int gold);
}
