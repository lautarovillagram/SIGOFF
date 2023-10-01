package com.developer.sigoff1;

public class Checked {
    private String domain;
    private String id;

    public void setDomain (String dom) {
        this.domain = dom;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public Checked(String dom, String id) {
        this.domain = dom;
        this.id = id;
    }
}


