package game;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics2D;



public class Board extends JPanel {
    private int[][] board = Game.getBoard();
    Board(int[][] board){
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

//        int[][] test = {{16,8, 16, 4},
//                        {16,16, 32, 2048},
//                        {16,0, 16, 16},
//                        {2,16, 64, 16}};
        ((Graphics2D) g).setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.fillRoundRect(5, 5, 125, 125, 5, 5);
        g.setColor(Color.GRAY);
        String txt = Integer.toString(board[0][0]);
        FontMetrics metrics = getFontMetrics(new Font("TimesRoman",Font.BOLD,60));
        g.setColor(Color.BLACK);
        g.drawString(txt,
                (130-metrics.stringWidth(txt)) / 2,
                (+65+ metrics.getAscent() / 3));
        g.setFont(new Font("TimesRoman",Font.PLAIN,50));
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                Color c = NumberTiles(board[i][j]);
                g.setColor(c);
                g.fillRoundRect(5+130 * j, 5+130 * i, 125, 125, 5, 5);
                String text = Integer.toString(board[i][j]);
                FontMetrics metrics1 = getFontMetrics(new Font("TimesRoman",Font.BOLD,50));
                g.setColor(Color.BLACK);
                g.drawString(text,
                        130*j+(130-metrics1.stringWidth(text)) / 2,
                        (130*i+65+ metrics1.getAscent() / 3));
                g.setFont(new Font("TimesRoman",Font.PLAIN,50));
            }
        }
    }

    private Color NumberTiles(int value){
        Color[] colors = new Color[12];
        colors[0] = new Color(255,255,204);
        colors[1] = new Color(255,229,204);
        colors[2] = new Color(255,204,204);
        colors[3] = new Color(255,204,229);
        colors[4] = new Color(153,255,255);
        colors[5] = new Color(204,255,255);
        colors[6] = new Color(204,229,255);
        colors[7] = new Color(255,153,153);
        colors[8] = new Color(255,102,102);
        colors[9] = new Color(255,153,204);
        colors[10] = new Color(255,102,255);
        colors[11] = new Color(255,51,153);
        if(value == 0){
            return Color.CYAN;
        }
        for (int i = 0; i < 12; i++) {
            if(value== Math.pow(2,i+1)){
                return colors[i];
            }
        }
        return Color.GREEN;
    }


}
