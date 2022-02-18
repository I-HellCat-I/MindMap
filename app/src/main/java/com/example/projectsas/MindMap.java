package com.example.projectsas;

import java.util.LinkedList;

public class MindMap {
    LinkedList<MindMapElement> mindMapElements;
    MindMap(){

    }
    public void addElement(MindMapElement element){
        mindMapElements.addLast(element);
    }
}
