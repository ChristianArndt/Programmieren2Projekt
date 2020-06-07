import javax.swing.*;
import java.awt.*;

public class ImageManager {
    public static ImageIcon img1;
    public static ImageIcon img2;

    public static void loadandresize()
    {
        //Roter Punkt verkleinert
        img1 = new ImageIcon("images/redcircle.png");
        Image image = img1.getImage();
        Image newImg = image.getScaledInstance(55,55, Image.SCALE_SMOOTH);
        img1 = new ImageIcon(newImg);
        //Gelber Punkt verkleinert
        img2 = new ImageIcon("images/yellowcircle.png");
        Image image2 = img2.getImage();
        Image newImg2 = image2.getScaledInstance(55,55,Image.SCALE_SMOOTH);
        img2 = new ImageIcon(newImg2);
    }
}