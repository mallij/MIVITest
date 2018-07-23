package com.android.mivitest.model;

public class Details {
    private String type;
    private String id;
    private Attributes attributes;
    private String linkSelf;
    private String relationShipLink;

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

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
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
}
