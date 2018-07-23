package com.android.mivitest.model;

public class UserAttributes {
    private String paymentType;
    private String unbilledCharges;
    private String nextBillingDate;
    private String title;
    private String firstName;
    private String lastName;
    private String dob;
    private String contactNumber;
    private String emailId;

    private boolean emailIdVerified;
    private boolean emailIdSubscriptionStatus;

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getUnbilledCharges() {
        return unbilledCharges;
    }

    public void setUnbilledCharges(String unbilledCharges) {
        this.unbilledCharges = unbilledCharges;
    }

    public String getNextBillingDate() {
        return nextBillingDate;
    }

    public void setNextBillingDate(String nextBillingDate) {
        this.nextBillingDate = nextBillingDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public boolean isEmailIdVerified() {
        return emailIdVerified;
    }

    public void setEmailIdVerified(boolean emailIdVerified) {
        this.emailIdVerified = emailIdVerified;
    }

    public boolean isEmailIdSubscriptionStatus() {
        return emailIdSubscriptionStatus;
    }

    public void setEmailIdSubscriptionStatus(boolean emailIdSubscriptionStatus) {
        this.emailIdSubscriptionStatus = emailIdSubscriptionStatus;
    }
}
