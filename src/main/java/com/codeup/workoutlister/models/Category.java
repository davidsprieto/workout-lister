package com.codeup.workoutlister.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Category {
    private long id;
    private String category;

    public Category() {}

    public Category(long id, String category) {
        this.id = id;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}