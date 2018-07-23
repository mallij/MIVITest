package com.android.mivitest.model;

public class ServiceAttributes extends Attributes{
    private String msn;
    private String credit;
    private String creditExpiry;
    private boolean dataUsageThreshold;

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCreditExpiry() {
        return creditExpiry;
    }

    public void setCreditExpiry(String creditExpiry) {
        this.creditExpiry = creditExpiry;
    }

    public boolean isDataUsageThreshold() {
        return dataUsageThreshold;
    }

    public void setDataUsageThreshold(boolean dataUsageThreshold) {
        this.dataUsageThreshold = dataUsageThreshold;
    }
}
