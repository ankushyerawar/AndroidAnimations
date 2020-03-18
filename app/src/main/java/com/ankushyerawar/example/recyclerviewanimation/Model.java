package com.ankushyerawar.example.recyclerviewanimation;

public class Model {

    private String mTitle, mDescription, mInfo, mRelease;
    private int mStars;
    private boolean isExpanded;

    public Model(String title, String description, String info, String release, int stars) {
        this.mTitle = title;
        this.mDescription = description;
        this.mInfo = info;
        this.mRelease = release;
        this.mStars = stars;
        this.isExpanded = false;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getRelease() {
        return mRelease;
    }

    public String getInfo() {
        return mInfo;
    }

    public int getStars() {
        return mStars;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }
}
