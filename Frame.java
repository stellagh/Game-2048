package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Frame extends JFrame implements java.awt.event.KeyListener {
    private static int frameWidth = 525;
    private static int frameHeight = 625;
    Canvas panel = new Canvas(4, 4);
    Game game = new Game();

    Board gameboard = new Board(game.getBoard());

    Frame() {
        super("2048");
        setVisible(true);
        setSize(frameWidth, frameHeight);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        gameboard.setFocusable(true);

        panel.setLayout(new GridLayout());
        panel.setPreferredSize(new Dimension(frameWidth, 100));

        this.addKeyListener(this);
        JLabel label = new JLabel("2048", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 40));
        panel.add(label);
        panel.add(new JLabel("<html>Score:<br>" + "" + game.getScore() +
                "<html>", SwingConstants.CENTER));

        panel.setBackground(Color.WHITE);
        this.getContentPane().add(panel, BorderLayout.NORTH);
        this.getContentPane().add(gameboard, BorderLayout.CENTER);
        this.getContentPane().setPreferredSize(new Dimension(frameWidth, frameHeight));
        this.pack();
        if (game.boardmax() == 32) {
            setVisible(false);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        boolean b = false;
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (Game.ifwin() + Game.ifgameover() > 0) {
                System.out.println("Game Over!");
                this.setVisible(false);
                dispose();
            }
            System.out.println("up is called "+Game.getUndoStack().size());
            System.out.println("score is " + game.getScore());
            if(Game.testup()==1){
                b = true;
            }
            Game.up();
            if(b) {
                Game.addnewnumber();
            }
            Game.print();
            gameboard.repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (Game.ifwin() + Game.ifgameover() > 0) {
                System.out.println("Game Over!");
                this.setVisible(false);
                dispose();
            }
            System.out.println("down is called "+Game.getUndoStack().size());
            System.out.println("score is " + game.getScore());
            if(Game.testdown()==1){
                b = true;
            }
            Game.down();
            if(b) {
                Game.addnewnumber();
            }
            Game.print();
            gameboard.repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (Game.ifwin() + Game.ifgameover() > 0) {
                System.out.println("Game Over!");
                this.setVisible(false);
                dispose();
            }
            System.out.println("left is called "+Game.getUndoStack().size());
            System.out.println("score is " + game.getScore());
            if(Game.testleft() == 1){
                b = true;
            }
            Game.left();
            if(b){
                Game.addnewnumber();
            }
            Game.print();
            gameboard.repaint();
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (Game.ifwin() + Game.ifgameover() > 0) {
                System.out.println("Game Over!");
                this.setVisible(false);
                dispose();
            }
            System.out.println("right is called "+Game.getUndoStack().size());
            System.out.println("score is " + game.getScore());
            if(Game.testright() == 1){
                b = true;
            }

            Game.right();
            if(b) {
                Game.addnewnumber();
            }
            Game.print();
            gameboard.repaint();
        } else if (e.getKeyCode() == 'U' || e.getKeyCode() == 'u') {
            if (Game.ifwin() + Game.ifgameover() > 0) {
                System.out.println("Game Over!");
                this.setVisible(false);
                dispose();
            }
            System.out.println("undo is called "+Game.getUndoStack().size());
            Game.undo();
            Game.print();
            gameboard.repaint();

        } else if (e.getKeyCode() == 'R' || e.getKeyCode() == 'r') {
            if (Game.ifwin() + Game.ifgameover() > 0) {
                System.out.println("Game Over!");
                this.setVisible(false);
                dispose();
            }
            System.out.println("redo is called "+Game.getUndoStack().size());
            Game.redo();
            Game.print();
            gameboard.repaint();
        }
        b = false;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }


    public static void main(String[] args) {
        Frame frame = new Frame();
        //undo redo
        //up,down...
        //main
    }
}
