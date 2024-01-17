package com.tooandunitils.alexa;

public class CustomItem {

    String text;
    private boolean isFavorite;

    public CustomItem(String text, boolean isFavorite) {
        this.text = text;
        this.isFavorite = isFavorite;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }
}
