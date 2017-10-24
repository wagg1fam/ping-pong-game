package Controller;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main extends JPanel implements ActionListener {

    Image img = new ImageIcon("res/stol.png").getImage();

    Timer timer = new Timer(20, this);

    Player player;
    Player player2;
    Ball ball;
    Map map;

    JFrame frame;

    public Main(JFrame frame) {
        this.frame = frame;
        player = new Player(frame, ball);
        player.setxCoordinate(150);
        player.setyCoordinate(200);
        player.setSpeed(10);
        player2 = new Player(frame, ball);
        player2.setxCoordinate(1125);
        player2.setyCoordinate(200);
        player2.setSpeed(10);
        ball = new Ball(frame, player, player2);
        ball.setBallX(650);
        ball.setBallY(300);
        timer.start();
        ball.setBallDirection(2);


        frame.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }

        });

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                player2.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player2.keyReleased(e);
            }
        });
    }

    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, frame.getWidth(), frame.getHeight(), null);
        g.drawImage(player.img, player.getxCoordinate(), player.getyCoordinate(), null);
        g.drawImage(player2.img2, player2.getxCoordinate(), player2.getyCoordinate(), null);
        g.drawImage(ball.img, ball.getBallX(), ball.getBallY(), null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        player.move(-1);
        player.stopZone(-1);
        frame.repaint();
        player2.move(-1);
        player2.stopZone(-1);
        ball.ballMove();
        ball.dirCheck();
        // ball.playerScore();
        ball.showResult();

        ball.ballCentre();

        repaint();
    }

}