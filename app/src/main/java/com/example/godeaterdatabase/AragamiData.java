package com.example.godeaterdatabase;

public class AragamiData {
    String name;
    String details;
    String bonds;
    String weakness;
    int img;
    public AragamiData(String name, String details, String bonds, String weakness, int img) {
        this.name=name;
        this.details=details;
        this.bonds=bonds;
        this.weakness=weakness;
        this.img=img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getBonds() {
        return bonds;
    }

    public void setBonds(String bonds) {
        this.bonds = bonds;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
