package com.android.mivitest.model;

public class SubscriptionAttributes extends Attributes{
    private String includedDataBalance;
    private String includedCreditBalance;
    private String includedRolloverCreditBalance;
    private String includedRolloverDataBalance;
    private String includedInternationalTalkBalance;
    private String expiryDate;
    private boolean autoRenewal;
    private boolean primarySubscription;

    public String getIncludedDataBalance() {
        return includedDataBalance;
    }

    public void setIncludedDataBalance(String includedDataBalance) {
        this.includedDataBalance = includedDataBalance;
    }

    public String getIncludedCreditBalance() {
        return includedCreditBalance;
    }

    public void setIncludedCreditBalance(String includedCreditBalance) {
        this.includedCreditBalance = includedCreditBalance;
    }

    public String getIncludedRolloverCreditBalance() {
        return includedRolloverCreditBalance;
    }

    public void setIncludedRolloverCreditBalance(String includedRolloverCreditBalance) {
        this.includedRolloverCreditBalance = includedRolloverCreditBalance;
    }

    public String getIncludedRolloverDataBalance() {
        return includedRolloverDataBalance;
    }

    public void setIncludedRolloverDataBalance(String includedRolloverDataBalance) {
        this.includedRolloverDataBalance = includedRolloverDataBalance;
    }

    public String getIncludedInternationalTalkBalance() {
        return includedInternationalTalkBalance;
    }

    public void setIncludedInternationalTalkBalance(String includedInternationalTalkBalance) {
        this.includedInternationalTalkBalance = includedInternationalTalkBalance;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isAutoRenewal() {
        return autoRenewal;
    }

    public void setAutoRenewal(boolean autoRenewal) {
        this.autoRenewal = autoRenewal;
    }

    public boolean isPrimarySubscription() {
        return primarySubscription;
    }

    public void setPrimarySubscription(boolean primarySubscription) {
        this.primarySubscription = primarySubscription;
    }
}
