import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class RGBGrid {

    public static void main(String[] args) {
        BufferedImage img = new BufferedImage(4074, 4074, BufferedImage.TYPE_INT_RGB);
        int num = 0;
        ArrayList<Point> points = new ArrayList<>();
        for (int y = 0; y < 4074; y++) {
            for (int x = 0; x < 4074; x++) {
                points.add(new Point(x, y));
            }
        }

        // Set red
        for (int i = 0; i < points.size(); i+=4 ) {
            Point p = points.get(i);
            int x = p.x;
            int y = p.y;
            img.setRGB(x, y, 16711680);
        }

        // Set green
        for (int j = 1; j < points.size(); j+=4 ) {
            Point p = points.get(j);
            int x = p.x;
            int y = p.y;
            img.setRGB(x, y, 65280);            
        }
        
        // Set blue
        for (int k = 2; k < points.size(); k+=4 ) {
            Point p = points.get(k);
            int x = p.x;
            int y = p.y;
            img.setRGB(x, y, 255);            
        }
        
        // Set black
        for (int h = 3; h < points.size(); h+=4 ) {
            Point p = points.get(h);
            int x = p.x;
            int y = p.y;
            img.setRGB(x, y, 0);            
        }

        try {
            ImageIO.write(img, "png", new File("RGBGrid.png"));
        } catch (IOException ex) {
            Logger.getLogger(color.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}