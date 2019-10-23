package ucy.ece318;

import bird.GamePanel;
import bird.Pipe;

import java.awt.*;
import java.awt.event.MouseEvent;

public class GameExtendedPanel extends GamePanel {


    public  GameExtendedPanel ( ){
        super();
        this.bird= new MyBird (172,250);
    }

    public void gameOver(java.awt.Graphics g){

        g.drawString("sorry!",100,400);
    }


    public void movePipes(Graphics g) {
        for (Pipe p : pipes) {

            // Move the pipe
            if (bird.isAlive()) {
                p.move();
            }
            drawpipe(p,g);

            // Check if bird hits pipes
            if(checkcollision(p)==1){
                System.out.println("collision");
                bird.kill();
            }
        }
    }
    public void mousePressed (MouseEvent e) {

        // Save clicked point
        clickedPoint = e.getPoint();

        if (gameState == MENU) {

            if (isTouching(textures.get("playButton").getRect())) {
                gameState = GAME;
                inStartGameState = true;
            }

        } else if (gameState == GAME) {

            if (bird.isAlive()) {

                // Allow jump with clicks
                if (inStartGameState) {
                    inStartGameState = false;
                }
                bird.jump();


            }

        }
    }

    @Override
    public void paintComponent (Graphics g) {

        super.paintComponent(g);

        g.drawString("hello",100,100);
    }
}
