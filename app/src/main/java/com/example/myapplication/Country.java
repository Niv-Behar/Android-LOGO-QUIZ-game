package com.example.myapplication;

public class Country {

    private String name;
    private int flagResId;
    private boolean Active;
    private String complited;
    private boolean hasComplited;

    public Country(String name, int flagResId, boolean Active, String complited) {
        this.name = name;
        this.flagResId = flagResId;
        this.Active = Active;
        this.complited = complited;
        hasComplited = true;
    }

    public Country(String name, int flagResId, boolean Active) {
        this.name = name;
        this.flagResId = flagResId;
        this.Active = Active;
    }

    public String getComplited() {
        return complited;
    }

    public void setComplited(String complited) {
        this.complited = complited;
    }

    public boolean isHasComplited() {
        return hasComplited;
    }

    public void setHasComplited(boolean hasComplited) {
        this.hasComplited = hasComplited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlagResId() {
        return flagResId;
    }

    public void setFlagResId(int flagResId) {
        this.flagResId = flagResId;
    }

    public boolean Active() {
        return Active;
    }

    public void getActive(boolean good) {
        Active = good;
    }
}
