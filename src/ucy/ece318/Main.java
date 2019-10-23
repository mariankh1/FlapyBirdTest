package ucy.ece318; /**
 * bird.FlappyBird.java
 * Main game class
 */


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    public GameExtendedPanel game;
    public Timer gameTimer;

    // Game setup constants
    public static final int WIDTH  = 375;
    public static final int HEIGHT = 667;
    private static final int DELAY = 12;

    public Main () {

        super("Flappy bird.Bird");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);

        // Game timer
        gameTimer = new Timer(DELAY, this);
        gameTimer.start();

        // Add Panel to Frame
        game = new GameExtendedPanel();
        add(game);

        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed (ActionEvent e) {

        if (game != null && game.ready) {
            game.repaint();
        }
    }

    public static void main(String[] args) {

        Main game = new Main();

    }

}

