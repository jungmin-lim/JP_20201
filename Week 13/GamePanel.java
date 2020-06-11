import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.Vector;

public class GamePanel extends JPanel{
    private Player player;
    private Vector<Bullet> bulletList = new Vector<Bullet>();
    private Vector<Alien> alienList = new Vector<Alien>();
    private int state;
    private int score = 0;
    private String scoreStr;

    public GamePanel(){
        state = 1;

        player = new Player(370, 500);
        Thread tPlayer = new Thread(new PlayerRunnable());
        tPlayer.start();

        Thread tBullet = new Thread(new BulletRunnable());
        tBullet.start();

        for(int y = 0; y < 5; ++y){
            for(int x = 0; x < 12; ++x){
                Alien alien = new Alien(100 + (x * 50), 100 + (y * 30));
                alienList.add(alien);
            }
        }

        Thread tAlien = new Thread(new AlienRunnable());
        tAlien.start();

        this.addKeyListener(new PlayerKeyListener());
        this.setFocusable(true);
        this.requestFocus();
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        g.drawImage(player.image, player.x, player.y, null);

        synchronized(GamePanel.this){
            for(Bullet bullet:bulletList){
                g.drawImage(bullet.image, bullet.x, bullet.y, null);
            }
            for(Alien alien:alienList){
                g.drawImage(alien.image, alien.x, alien.y, null);
            }
        }

        scoreStr = String.valueOf(score);
        scoreStr = "Score : " + scoreStr;

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.WHITE);
        g.drawString(scoreStr, 660, 30);

        if(state == -1){
            g.setFont(new Font("Arial", Font.BOLD, 100));
            g.setColor(Color.WHITE);
            g.drawString("Game Over", 120, 300);
        }
        else if(state == 0){
            g.setFont(new Font("Arial", Font.BOLD, 100));
            g.setColor(Color.WHITE);
            g.drawString("You Win", 180, 300);
        }
    }

    class PlayerKeyListener implements KeyListener{
        public void keyTyped(KeyEvent e){
            // Do Nothing
        }

        public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                player.dx = -Player.speedX;
            }
            else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                player.dx = Player.speedX;
            }
            else{
                // Do Nothing
            }
        }

        public void keyReleased(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_LEFT){
                if(player.dx == -Player.speedX) player.dx = 0;
            }
            else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                if(player.dx == Player.speedX) player.dx = 0;
            }
            else if(e.getKeyCode() == KeyEvent.VK_SPACE){
                Bullet bullet = new Bullet(player.x+10, player.y-30);
                synchronized(GamePanel.this){
                    bulletList.add(bullet);
                }
            }
        }
    }

    class PlayerRunnable implements Runnable{
        public void run(){
            while(true){
                try{
                    if(state == 1){
                        player.move();
                        GamePanel.this.repaint();
                    }
                    Thread.sleep(10);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    class BulletRunnable implements Runnable{
        public void run(){
            while(true){
                try{
                    if(state == 1){
                        synchronized(GamePanel.this){
                            Iterator<Bullet> iterBullet = bulletList.iterator();
                            while(iterBullet.hasNext()){
                                Bullet bullet = iterBullet.next();
                                bullet.move();
                                if(bullet.isOutOfScreen()) iterBullet.remove();
                                else{
                                    Iterator<Alien> iterAlien = alienList.iterator();
                                    while(iterAlien.hasNext()){
                                        Alien alien = iterAlien.next();
                                        if(bullet.collideWith(alien)){
                                            iterAlien.remove();
                                            iterBullet.remove();
                                            score += 100;
                                            if(alienList.isEmpty()){
                                                state = 0;
                                            }
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        GamePanel.this.repaint();
                    }
                    Thread.sleep(10);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    class AlienRunnable implements Runnable{
        public void run(){
            while(true){
                try{
                    if(state == 1){
                        synchronized(GamePanel.this){
                            Iterator<Alien> iterAlien = alienList.iterator();
                            while(iterAlien.hasNext()){
                                Alien alien = iterAlien.next();
                                alien.move();
                                if(alien.isOutOfScreen()) iterAlien.remove();
                                else if(alien.collideWith(player)){
                                    state = -1;
                                }
                            }
                        }
                        GamePanel.this.repaint();
                    }
                    Thread.sleep(10);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
}