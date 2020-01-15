package Opdracht3.Models;


import Opdracht3.GameColor;

public class Field {
    private static int nextId = 1;

    private GameColor color;
    private int id;

    public Field(GameColor color){
        this.color = color;
        this.id = nextId++;
    }

    public GameColor getColor() {
        return color;
    }

    public void setColor(GameColor color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }
}
