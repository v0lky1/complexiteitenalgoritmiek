package Opdracht3.Models;


import Opdracht3.GameColor;

import java.util.ArrayList;
import java.util.List;

public class Field {
    private static int nextId = 1;

    private GameColor color;
    private int id;
    private List<Connection> connections = new ArrayList<>();

    public Field(GameColor color){
        this.color = color;
        this.id = nextId++;
    }

    public GameColor getColor() {
        return color;
    }

    public int getId() {
        return id;
    }

    public void addConnection(Connection connection) {
        connections.add(connection);
    }

    public List<Connection> getConnections() {
        return connections;
    }
}
