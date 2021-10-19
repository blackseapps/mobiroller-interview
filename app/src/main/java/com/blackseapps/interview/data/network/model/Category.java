package com.blackseapps.interview.data.network.model;

import javax.inject.Inject;

/**
 * Created by mertKaradeniz on 19.10.2021
 * <p>
 * This is an interview project.
 */

public class Category {

    private String uid;
    private String name;
    private String description;

    @Inject
    public Category() {

    }

    public Category(String uid, String name, String description) {
        this.uid = uid;
        this.name = name;
        this.description = description;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
