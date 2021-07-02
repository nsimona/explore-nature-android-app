package com.example.naturalwonders;

import java.util.ArrayList;

public class WonderGroup {
    private String areaName;
    private int color;
    private ArrayList<Wonder> wonders;

    public WonderGroup(String area, ArrayList<Wonder> wonders) {
        this.areaName = area;
        this.wonders = wonders;
    }

    public WonderGroup(String areaName, ArrayList<Wonder> wonders, int color) {
        this.areaName = areaName;
        this.color = color;
        this.wonders = wonders;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public WonderGroup(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public ArrayList<Wonder> getAttractions() {
        return wonders;
    }

    public void setAttractions(ArrayList<Wonder> wonders) {
        this.wonders = wonders;
    }

    public void addAttraction(Wonder wonder) {
        wonders.add(wonder);
    }
}
