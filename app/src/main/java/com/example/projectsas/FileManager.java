package com.example.projectsas;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
    //protected
    static int numberOfItems = 0;

    public static int getNumberOfItems() {
        File f = new File("/MindMaps");
        return numberOfItems;
    }

    public static void backup(String mindMapName, MindMap mindMap) {
        File f = new File("prettyfile.mm.bak");
        try {
            f.createNewFile();
        } catch (java.io.IOException e){

        }
    }
    public static void save(String mindMapName, MindMap mindMap){

    }

    public static ArrayList<MindMapFA> getMindMapsFA() {
        File f = new File("/MindMaps");
        ArrayList<MindMapFA> mindMapsFA = new ArrayList<>();
        File[] filesList = f.listFiles();
        try {
            for (int i = 0; i < filesList.length; i++){
                mindMapsFA.add(new MindMapFA(filesList[i].getName(), -1));
            }
        } catch (NullPointerException e) {
            mindMapsFA.add(new MindMapFA("Тут ничего нет", -1));
        }
        return mindMapsFA;

    }

    // TODO: make it work
    MindMap importMindMap(String mindMapName){
        MindMap mindMap = new MindMap();

        return mindMap;
    }
}
