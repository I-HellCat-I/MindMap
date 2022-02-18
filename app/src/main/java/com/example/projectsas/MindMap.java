package com.example.projectsas;

import java.util.LinkedList;

public class MindMap {
    LinkedList<MindMapElement> mindMapElements = new LinkedList<>();
    MindMap(){}

    public void addElement(MindMapElement element){
        mindMapElements.addLast(element);
    }
}
