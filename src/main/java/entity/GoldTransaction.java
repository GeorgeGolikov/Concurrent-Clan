package entity;

import java.sql.Timestamp;

public class GoldTransaction {
    private final long clanId;
    private final Timestamp timestamp;
    private final String cause;
    private final long causeId;
    private final long goldBefore;
    private final int goldUpdateAmount;
    private final long goldAfter;

    private GoldTransaction(Builder builder) {
        this.clanId = builder.clanId;
        this.timestamp = builder.timestamp;
        this.cause = builder.cause;
        this.causeId = builder.causeId;
        this.goldBefore = builder.goldBefore;
        this.goldUpdateAmount = builder.goldUpdateAmount;
        this.goldAfter = builder.goldAfter;
    }

    public long getClanId() {
        return clanId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public String getCause() {
        return cause;
    }

    public long getCauseId() {
        return causeId;
    }

    public long getGoldBefore() {
        return goldBefore;
    }

    public int getGoldUpdateAmount() {
        return goldUpdateAmount;
    }

    public long getGoldAfter() {
        return goldAfter;
    }

    public static class Builder {
        private long clanId;
        private Timestamp timestamp;
        private String cause;
        private long causeId;
        private long goldBefore;
        private int goldUpdateAmount;
        private long goldAfter;

        public Builder clanId(long clanId) {
            this.clanId = clanId;
            return this;
        }

        public Builder timestamp(Timestamp timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder cause(String cause) {
            this.cause = cause;
            return this;
        }

        public Builder causeId(long causeId) {
            this.causeId = causeId;
            return this;
        }

        public Builder goldBefore(long goldBefore) {
            this.goldBefore = goldBefore;
            return this;
        }

        public Builder goldUpdateAmount(int goldUpdateAmount) {
            this.goldUpdateAmount = goldUpdateAmount;
            return this;
        }

        public Builder goldAfter(long goldAfter) {
            this.goldAfter = goldAfter;
            return this;
        }

        public GoldTransaction build() {
            return new GoldTransaction(this);
        }
    }
}
