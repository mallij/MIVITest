package com.android.mivitest.model;

public class ProductAttributes extends Attributes{
    private String name;
    private String includedData;
    private String includedCredit;
    private String includedInternationalTalk;
    private boolean unlimitedText;
    private boolean unlimitedTalk;
    private boolean unlimitedInternationalText;
    private boolean unlimitedInternationalTalk;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIncludedData() {
        return includedData;
    }

    public void setIncludedData(String includedData) {
        this.includedData = includedData;
    }

    public String getIncludedCredit() {
        return includedCredit;
    }

    public void setIncludedCredit(String includedCredit) {
        this.includedCredit = includedCredit;
    }

    public String getIncludedInternationalTalk() {
        return includedInternationalTalk;
    }

    public void setIncludedInternationalTalk(String includedInternationalTalk) {
        this.includedInternationalTalk = includedInternationalTalk;
    }

    public boolean isUnlimitedText() {
        return unlimitedText;
    }

    public void setUnlimitedText(boolean unlimitedText) {
        this.unlimitedText = unlimitedText;
    }

    public boolean isUnlimitedTalk() {
        return unlimitedTalk;
    }

    public void setUnlimitedTalk(boolean unlimitedTalk) {
        this.unlimitedTalk = unlimitedTalk;
    }

    public boolean isUnlimitedInternationalText() {
        return unlimitedInternationalText;
    }

    public void setUnlimitedInternationalText(boolean unlimitedInternationalText) {
        this.unlimitedInternationalText = unlimitedInternationalText;
    }

    public boolean isUnlimitedInternationalTalk() {
        return unlimitedInternationalTalk;
    }

    public void setUnlimitedInternationalTalk(boolean unlimitedInternationalTalk) {
        this.unlimitedInternationalTalk = unlimitedInternationalTalk;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
