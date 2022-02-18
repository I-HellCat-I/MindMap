package com.example.projectsas;

import java.util.ArrayList;

public class MindMapFA {
    private String name;
    private int iconId;
    private static ArrayList<MindMapFA> MindMapsFA = new ArrayList<>();
    public MindMapFA(String n, int id){
        name = n;
        iconId = id;
        MindMapsFA.add(this);
    }

    public static void setMindMapsFA(ArrayList<MindMapFA> mindMapsFA) {
        MindMapsFA = mindMapsFA;
    }

    public static ArrayList<MindMapFA> getMindMapsFA() {
        return MindMapsFA;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

