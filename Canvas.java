package game;

import g.Tile;

import javax.swing.*;
import java.awt.*;

public class Canvas extends JPanel {
    private int ROWS;
    private int COLUMNS;
    Tile[][] numbers;

    public void init(int xSize,int ySize){
//        removeAll();
        COLUMNS = xSize;
        ROWS = ySize;
        setLayout(new GridLayout(ROWS, COLUMNS));
        numbers = new Tile[COLUMNS][ROWS];

    }

    Canvas(int xSize,int ySize){
        init(xSize,ySize);


    }
    @Override
    public void paintComponent(Graphics g) {
//        g.fillRect(100,0,125,125);
//        int[][] test = {{0,1,2,4},{8,16,32,64},{128,256,512,1024},{0,0,0,0}};
//        for(int y = 1;y<5;y++){
//            for(int x = 1;x<5;x++){
//                int X =8*y +100+64*(x-1);
//                int Y = 8*y + 64*(y-1);
//              //  g.setColor(NumberTiles(test[y-1][x-1]));
//            }
//        }

    }
    public int getValue(int column,int row) {
        return numbers[column][row].getValue();
    }

    public void setValue(int column,int row,int value) {
        this.numbers[column][row].setValue(value);
    }

}
