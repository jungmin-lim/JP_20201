import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

public class MyPanel extends JPanel{

    public Vector<Line> lines = new Vector<Line>();
    public Vector<Oval> ovals = new Vector<Oval>();

    Line currentLine = null;
    Oval currentOval = null;

    boolean selected = true;

    class Line{
        public int x1, y1, x2, y2;
    }

    class Oval{
        public int x1, y1, x2, y2;
    }

    public MyPanel(){
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.addMouseListener(new MyMouseListener());
        this.addMouseMotionListener(new MyMouseMotionListener());
    }

    class MyMouseListener implements MouseListener{
        public void mouseClicked(MouseEvent e){
            // Do Nothing
        }

        public void mousePressed(MouseEvent e){

            // draw line
            if(selected){
                currentLine = new Line();
                currentLine.x1 = e.getX();
                currentLine.y1 = e.getY();
            }
            // draw oval
            else{
                currentOval = new Oval();
                currentOval.x1 = e.getX();
                currentOval.y1 = e.getY();
            }
        }

        public void mouseReleased(MouseEvent e){
            // draw Line
            if(selected){
                currentLine.x2 = e.getX();
                currentLine.y2 = e.getY();
                lines.add(currentLine);
                currentLine = null;
                MyPanel.this.repaint();
            }
            // draw Oval
            else{
                currentOval.x2 = e.getX();
                currentOval.y2 = e.getY();
                ovals.add(currentOval);
                currentOval = null;
                MyPanel.this.repaint();
            }
        }
        
        public void mouseEntered(MouseEvent e){
            // Do Nothing
        }
        public void mouseExited(MouseEvent e){
            // Do Mothing
        }
    }

    class MyMouseMotionListener implements MouseMotionListener {
        public void mouseDragged(MouseEvent e){
            if(selected){
                currentLine.x2 = e.getX();
                currentLine.y2 = e.getY();
                MyPanel.this.repaint();
            }
            else{
                currentOval.x2 = e.getX();
                currentOval.y2 = e.getY();
                MyPanel.this.repaint();
            }
        }
        
        public void mouseMoved(MouseEvent e){
            // Do Nothing
        }
    }

    public void paintComponent(Graphics g){
        int x, y, width, height;
        super.paintComponent(g);

        for(Line line : lines){
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
        }

        if(currentLine != null){
            g.drawLine(currentLine.x1, currentLine.y1, currentLine.x2, currentLine.y2);
        }

        for(Oval oval : ovals){
            x = Math.min(oval.x1, oval.x2);
            y = Math.min(oval.y1, oval.y2);
            width = Math.abs(oval.x1-oval.x2);
            height = Math.abs(oval.y1-oval.y2);
            g.drawOval(x, y, width, height);
        }

        if(currentOval != null){
            x = Math.min(currentOval.x1, currentOval.x2);
            y = Math.min(currentOval.y1, currentOval.y2);
            width = Math.abs(currentOval.x1-currentOval.x2);
            height = Math.abs(currentOval.y1-currentOval.y2);
            g.drawOval(x, y, width, height);
        }
    }
}