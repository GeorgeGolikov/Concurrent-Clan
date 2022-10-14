package service.transaction;

import entity.GoldTransaction;

public interface GoldTransactionTracker {
    void track(GoldTransaction transaction);
}
