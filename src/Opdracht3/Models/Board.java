package Opdracht3.Models;

import java.util.ArrayList;

public class Board {
    ArrayList<Field> fields = new ArrayList<>();

    public ArrayList<Field> getFields() {
        return fields;
    }

    public void setFields(ArrayList<Field> fields) {
        this.fields = fields;
    }
}
