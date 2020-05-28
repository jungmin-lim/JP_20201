import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyFrame extends JFrame{

    MyPanel panel = new MyPanel();
    JButton buttons[] = new JButton[2];
    String buttonsText[] = {"Line", "Oval"};

    JMenuItem newMenuItem;

    public MyFrame(){
        setTitle("직접 제작한 component 활용한 그림판");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(2,5));
        contentPane.add(panel, BorderLayout.CENTER);

        JPanel bPanel = new JPanel();
        bPanel.setLayout(new GridLayout(2,1));
        contentPane.add(bPanel, BorderLayout.EAST);

        for(int i = 0; i < buttons.length; ++i){
            buttons[i] = new JButton(buttonsText[i]);
            bPanel.add(buttons[i]);
        }
        buttons[0].addActionListener(new LineButtonsItemListener());
        buttons[1].addActionListener(new OvalButtonsItemListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        newMenuItem = new JMenuItem("New");
        newMenuItem.addActionListener(new NewMenuItemActionListener());
        menu.add(newMenuItem);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        setVisible(true);
    }

    class LineButtonsItemListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            panel.selected = true;
        }
    }

    class OvalButtonsItemListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            panel.selected = false;
        }
    }
    class NewMenuItemActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            panel.lines.clear();
            panel.ovals.clear();
            panel.repaint();
        }
    }

    public static void main(String args[]){
        new MyFrame();
    }
}