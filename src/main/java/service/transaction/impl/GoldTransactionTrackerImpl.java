package service.transaction.impl;

import dao.GoldTransactionRepository;
import dao.impl.GoldTransactionRepositoryImpl;
import entity.GoldTransaction;
import service.transaction.GoldTransactionTracker;

public class GoldTransactionTrackerImpl implements GoldTransactionTracker {
    private final static GoldTransactionRepository transactionRepository = new GoldTransactionRepositoryImpl();

    @Override
    public void track(GoldTransaction transaction) {
        transactionRepository.save(transaction);
    }
}
