package com.example.naturalwonders;

public class Wonder {
    private String name;
    private int imageDrawable;
    private String description;
    private String[] coordinates;

    public Wonder(String name, int imageDrawable, String description, String[] coordinates) {
        this.name = name;
        this.imageDrawable = imageDrawable;
        this.description = description;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageDrawable() {
        return imageDrawable;
    }

    public void setImageDrawable(int imageDrawable) {
        this.imageDrawable = imageDrawable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String[] coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return name;
    }
}
