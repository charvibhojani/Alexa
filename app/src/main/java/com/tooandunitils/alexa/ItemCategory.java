package com.tooandunitils.alexa;

public class ItemCategory {

    int imageResource;
    String name;

    public ItemCategory(int imageResource, String name) {
        this.imageResource = imageResource;
        this.name = name;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getName() {
        return name;
    }
}
