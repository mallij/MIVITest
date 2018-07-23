package com.android.mivitest.model;

import java.util.ArrayList;

public class CollectionData {
    private UserData userData;
    private ArrayList<Details> details;

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public ArrayList<Details> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<Details> details) {
        this.details = details;
    }
}
