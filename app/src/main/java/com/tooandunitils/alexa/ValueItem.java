package com.tooandunitils.alexa;

public class ValueItem {

    String text;
    private boolean isFavorite;

    public ValueItem(String text, boolean isFavorite) {
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
