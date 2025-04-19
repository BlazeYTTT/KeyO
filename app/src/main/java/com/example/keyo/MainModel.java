package com.example.keyo;

public class MainModel {
    String name, subname, orientationq, reproductionq, speakq;


    MainModel(){
        
    }
    public MainModel(String name, String subname, String orientationq, String reproductionq, String speakq) {
        this.name = name;
        this.subname = subname;
        this.orientationq = orientationq;
        this.reproductionq = reproductionq;
        this.speakq = speakq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getOrientationq() {
        return orientationq;
    }

    public void setOrientationq(String orientationq) {
        this.orientationq = orientationq;
    }

    public String getReproductionq() {
        return reproductionq;
    }

    public void setReproductionq(String reproductionq) {
        this.reproductionq = reproductionq;
    }

    public String getSpeakq() {
        return speakq;
    }

    public void setSpeakq(String speakq) {
        this.speakq = speakq;
    }
}
