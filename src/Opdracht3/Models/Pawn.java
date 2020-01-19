package Opdracht3.Models;

public class Pawn {
    private static int nextId = 1;

    private Field currentField;
    private int id;

    public Pawn(Field currentField){
        this.currentField = currentField;
        this.id = nextId++;
    }

    public Field getCurrentField() {
        return currentField;
    }

    public void setCurrentField(Field currentField) {
        this.currentField = currentField;
    }

    @Override
    public String toString() {
        return "Pawn " + id;
    }
}
