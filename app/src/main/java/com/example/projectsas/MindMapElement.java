package com.example.projectsas;

public class MindMapElement {
    public final int height;
    public final int width;
    // top left corner coordinates
    private int x;
    private int y;

    public MindMapElement(int x, int y,int height, int width){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
}
