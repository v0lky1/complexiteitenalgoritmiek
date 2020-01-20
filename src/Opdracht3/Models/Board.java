package Opdracht3.Models;

import Opdracht3.GameColor;

import java.util.ArrayList;
import java.util.List;

public class Board {

    public Board() {}

    public List<Field> createBoard() {
        //Made the board according to the image supplied by Saxion. It can be found in the documents folder.
        //Pardon our naming conventions. We like to have fun here.
        Field field1 = new Field(GameColor.PINK);
        Field field2 = new Field(GameColor.BLACK);
        Field field3 = new Field(GameColor.GREEN);
        Field field4 = new Field(GameColor.GREEN);
        Field field5 = new Field(GameColor.GREEN);
        Field field6 = new Field(GameColor.ORANGE);
        Field field7 = new Field(GameColor.ORANGE);
        Field field8 = new Field(GameColor.PINK);
        Field field9 = new Field(GameColor.PINK);
        Field field10 = new Field(GameColor.BLACK);
        Field field11 = new Field(GameColor.ORANGE);
        Field field12 = new Field(GameColor.PINK);
        Field field13 = new Field(GameColor.ORANGE);
        Field field14 = new Field(GameColor.GREEN);
        Field field15 = new Field(GameColor.ORANGE);
        Field field16 = new Field(GameColor.GREEN);
        Field field17 = new Field(GameColor.GREEN);
        Field field18 = new Field(GameColor.BLACK);
        Field field19 = new Field(GameColor.ORANGE);
        Field field20 = new Field(GameColor.GREEN);
        Field field21 = new Field(GameColor.BLACK);
        Field field22 = new Field(GameColor.BLACK);
        Field field23 = new Field(GameColor.BLUE);

        field1.addConnection(new Connection(field4, GameColor.PINK));
        field1.addConnection(new Connection(field5, GameColor.BLACK));
        field2.addConnection(new Connection(field6, GameColor.GREEN));
        field2.addConnection(new Connection(field12, GameColor.PINK));
        field3.addConnection(new Connection(field4, GameColor.ORANGE));
        field3.addConnection(new Connection(field1, GameColor.ORANGE));
        field4.addConnection(new Connection(field13, GameColor.BLACK));
        field5.addConnection(new Connection(field9, GameColor.ORANGE));
        field6.addConnection(new Connection(field9, GameColor.GREEN));
        field6.addConnection(new Connection(field10, GameColor.PINK));
        field7.addConnection(new Connection(field2, GameColor.GREEN));
        field8.addConnection(new Connection(field3, GameColor.PINK));
        field9.addConnection(new Connection(field4, GameColor.GREEN));
        field9.addConnection(new Connection(field14, GameColor.BLACK));
        field10.addConnection(new Connection(field15, GameColor.GREEN));
        field11.addConnection(new Connection(field10, GameColor.PINK));
        field11.addConnection(new Connection(field12, GameColor.GREEN));
        field12.addConnection(new Connection(field7, GameColor.GREEN));
        field13.addConnection(new Connection(field8, GameColor.GREEN));
        field13.addConnection(new Connection(field18, GameColor.GREEN));
        field14.addConnection(new Connection(field20, GameColor.ORANGE));
        field14.addConnection(new Connection(field23, GameColor.GREEN));
        field15.addConnection(new Connection(field22, GameColor.GREEN));
        field15.addConnection(new Connection(field23, GameColor.PINK));
        field16.addConnection(new Connection(field15, GameColor.GREEN));
        field17.addConnection(new Connection(field11, GameColor.BLACK));
        field17.addConnection(new Connection(field12, GameColor.PINK));
        field17.addConnection(new Connection(field16, GameColor.BLACK));
        field18.addConnection(new Connection(field9, GameColor.ORANGE));
        field18.addConnection(new Connection(field20, GameColor.ORANGE));
        field19.addConnection(new Connection(field18, GameColor.GREEN));
        field20.addConnection(new Connection(field19, GameColor.BLACK));
        field20.addConnection(new Connection(field21, GameColor.ORANGE));
        field21.addConnection(new Connection(field22, GameColor.ORANGE));
        field21.addConnection(new Connection(field23, GameColor.BLACK));
        field22.addConnection(new Connection(field17, GameColor.ORANGE));

        List<Field> startFields = new ArrayList<>();
        startFields.add(field1);
        startFields.add(field2);
        return startFields;
    }
}
