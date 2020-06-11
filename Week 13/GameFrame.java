import javax.swing.JFrame;

public class GameFrame extends JFrame{
    public GameFrame(){
        setTitle("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(800,600);
        setResizable(false);

        GamePanel gamePanel = new GamePanel();
        setContentPane(gamePanel);

        setLocationRelativeTo(null);
        setVisible(true);
    }    

    public static void main(String[] args){
        new GameFrame();
    }
}