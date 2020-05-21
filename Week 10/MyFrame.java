import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MyFrame extends JFrame {
    JLabel label;
    JPanel panel;

    public MyFrame() {	
        setTitle("Jungmin's GUI PROGRAM");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(0, 0));

        // LABEL
        label = new JLabel("Move Me");
        label.setSize(150, 40);
        label.setLocation(100, 100);

        // PANEL 
        panel = new JPanel();
        panel.setLayout(null);
        panel.add(label);

        // contentPane
        JButton button = new JButton("NORTH");
        contentPane.add(button, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.CENTER);

        setVisible(true);

        MyMouseListener listener = new MyMouseListener();
        panel.addKeyListener(new MyKeyListener());
        panel.addMouseListener(listener);
        panel.addMouseMotionListener(listener);

        panel.setFocusable(true);
        panel.requestFocus();

        button.setFocusable(false);
    }

    class MyKeyListener implements KeyListener{
        @Override
        public void keyTyped(KeyEvent e){
            // Do nothing
        }

        @Override
        public void keyPressed(KeyEvent e){
            if(e.getKeyCode() == KeyEvent.VK_F1){
                label.setText("F1 pressed");
            }
        }

        @Override
        public void keyReleased(KeyEvent e){
            // Do Nothing
        }
    }

    class MyMouseListener implements MouseListener, MouseMotionListener{
        @Override
        public void mouseDragged(MouseEvent e){
            label.setText("Dragged at (" + e.getX() + "," + e.getY() + ")");
        }

        @Override
        public void mouseMoved(MouseEvent e){
            // Do Nothing
        }
        @Override
        public void mouseClicked(MouseEvent e){
            // Do Nothing
        }

        @Override
        public void mousePressed(MouseEvent e){
            // Do Nothing
        }

        @Override
        public void mouseReleased(MouseEvent e){
            // Do Nothing
        }

        @Override
        public void mouseEntered(MouseEvent e){
            label.setText("Entered at (" + e.getX() + "," + e.getY() + ")");
        }

        @Override
        public void mouseExited(MouseEvent e){
            label.setText("Exited at (" + e.getX() + "," + e.getY() + ")");
        }
    }
    public static void main(String[] args){
        new MyFrame();
    }
}

