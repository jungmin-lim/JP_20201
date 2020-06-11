import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class GameObject {
    protected int x, y;
    protected Image image;
    public int dx, dy;
    protected int width, height;

    public GameObject(int x, int y, String imageFile){
        ImageIcon icon = new ImageIcon(imageFile);
        this.image = icon.getImage();

        this.x = x;
        this.y = y;

        this.width = icon.getIconWidth();
        this.height = icon.getIconHeight();
    }

    public boolean collideWith(GameObject o){
        Rectangle myRect = new Rectangle();
        myRect.setBounds(x, y, width, height);
        Rectangle otherRect = new Rectangle();
        otherRect.setBounds(o.x, o.y, o.width, o.height);

        return myRect.intersects(otherRect);
    }
}