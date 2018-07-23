package com.android.mivitest.model;

public class UserData {
    private String type;
    private String id;
    private String linkSelf;
    private String relationShipLink;
    private UserAttributes userAttributes;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLinkSelf() {
        return linkSelf;
    }

    public void setLinkSelf(String linkSelf) {
        this.linkSelf = linkSelf;
    }

    public String getRelationShipLink() {
        return relationShipLink;
    }

    public void setRelationShipLink(String relationShipLink) {
        this.relationShipLink = relationShipLink;
    }

    public UserAttributes getUserAttributes() {
        return userAttributes;
    }

    public void setUserAttributes(UserAttributes userAttributes) {
        this.userAttributes = userAttributes;
    }
}
