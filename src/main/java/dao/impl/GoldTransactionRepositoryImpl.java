package dao.impl;

import dao.GoldTransactionRepository;
import dao.db.DBConnection;
import entity.GoldTransaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GoldTransactionRepositoryImpl implements GoldTransactionRepository {
    private final Connection connection;
    private final String insertSql =
            "INSERT INTO gold_transactions (clanId, timestamp, cause, causeId, goldBefore, goldUpdateAmount, goldAfter)" +
            "VALUES (?, ?, ?, ?, ?, ?, ?);";

    public GoldTransactionRepositoryImpl() {
        try {
            connection = DBConnection.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException("Database not reachable");
        }
    }

    @Override
    public void save(GoldTransaction transaction) {
        try (
            PreparedStatement ps = connection.prepareStatement(insertSql)
        ) {
            fillInParameters(ps, transaction);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fillInParameters(PreparedStatement ps, GoldTransaction transaction) throws SQLException {
        ps.setLong(1, transaction.getClanId());
        ps.setTimestamp(2, transaction.getTimestamp());
        ps.setString(3, transaction.getCause());
        ps.setLong(4, transaction.getCauseId());
        ps.setLong(5, transaction.getGoldBefore());
        ps.setInt(6, transaction.getGoldUpdateAmount());
        ps.setLong(7, transaction.getGoldAfter());
    }
}
