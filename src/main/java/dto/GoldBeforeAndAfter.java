package dto;

public class GoldBeforeAndAfter {
    private long goldBefore;
    private long goldAfter;

    public GoldBeforeAndAfter() {
        goldBefore = -1;
        goldAfter = -1;
    }

    public long getGoldBefore() {
        return goldBefore;
    }

    public long getGoldAfter() {
        return goldAfter;
    }

    public void setGoldBefore(long goldBefore) {
        this.goldBefore = goldBefore;
    }

    public void setGoldAfter(long goldAfter) {
        this.goldAfter = goldAfter;
    }
}
