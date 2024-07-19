package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class WindowImage extends JFrame {
    private BufferedImage image; //בשביל התמונה
    private JLabel imageLabel;


    public WindowImage() {
        try {
            this.image = ImageIO.read(new File("src/main/java/org/example/data/test.png"));
            Color color = brightest();
            paintImage(color);
            this.imageLabel = new JLabel(new ImageIcon(image));
        } catch (Exception e) {
            e.printStackTrace();


        }

        this.setSize(500, 500); //גודל מסך
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //אופציה לסגור דרך האיקס בחלון
        this.setVisible(true); // ייצוג פעיל
    }

    public Color brightest() {
        Color color;
        int max = 0; //למספר הכי כהה משנים ל- 755
        Color maxColor = null;
        for (int x = 0; x < this.image.getWidth(); x++) {
            for (int y = 0; y < this.image.getHeight(); y++) {
                color = new Color((this.image.getRGB(x, y))); //אובייקט של צבע שקיבלנו
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                int sumOfColor = red + green + blue; //סכום של הצבעים ביחד
                if (sumOfColor > max) { //אם רוצים את הכהה אז משנים סימן
                    max = sumOfColor; //שומר את המספר של הצבע כי בהיר
                    maxColor = color; // לשמור את הצבע הכי בהיר
                }
            }
        }
        return maxColor;
    }

    public void paintImage(Color color) {
        for (int i = 0; i < this.image.getWidth(); i++) {
            for (int j = 0; j < this.image.getHeight(); j++) {
                this.image.setRGB(i, j, color.getRGB());

            }
        }
    }

}




