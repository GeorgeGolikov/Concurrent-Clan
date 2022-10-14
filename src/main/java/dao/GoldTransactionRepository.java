package dao;

import entity.GoldTransaction;

public interface GoldTransactionRepository {
    void save(GoldTransaction transaction);
}
