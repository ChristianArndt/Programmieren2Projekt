import javax.swing.*;
import java.awt.*;

/**
 * Lädt und verkleinert die eingefügten Chips
 */
public class ImageManager {
    public static ImageIcon img1;
    public ImageIcon img2;

    public void loadandresize() {
        //Roter Punkt angepasst
        img1 = new ImageIcon("images/redcircle.png");
        Image image = img1.getImage();
        Image newImg = image.getScaledInstance(65,65, Image.SCALE_SMOOTH);
        img1 = new ImageIcon(newImg);
        //Gelber Punkt angepasst
        img2 = new ImageIcon("images/yellowcircle.png");
        Image image2 = img2.getImage();
        Image newImg2 = image2.getScaledInstance(65,65,Image.SCALE_SMOOTH);
        img2 = new ImageIcon(newImg2);
    }
}
