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


public class RGBRandom {

    public static void main(String[] args) {
        BufferedImage img = new BufferedImage(4076, 4076, BufferedImage.TYPE_INT_RGB);
        int num = 0;
        ArrayList<Point> points = new ArrayList<>();
        for (int y = 0; y < 4076; y++) {
            for (int x = 0; x < 4076; x++) {
                points.add(new Point(x, y));
            }
        }
        Collections.shuffle(points, new Random(0));
        
        // Set red
        for (int i = 0; i < points.size()/4; i++ ) {
            Point p = points.get(i);
            int x = p.x;
            int y = p.y;
			img.setRGB(x, y, 16711680);
        }

        // Set green
        for (int j = points.size()/4; j < 2*points.size()/4; j++ ) {
            Point p = points.get(j);
            int x = p.x;
            int y = p.y;
			img.setRGB(x, y, 65280);              
        }
        
        // Set blue
        for (int k = 2*points.size()/4; k < 3*points.size()/4; k++ ) {
            Point p = points.get(k);
            int x = p.x;
            int y = p.y;
			img.setRGB(x, y, 255);        
        }

		// set black
        for (int h = 3*points.size()/4; h < points.size(); h++ ) {
            Point p = points.get(h);
            int x = p.x;
            int y = p.y;
            img.setRGB(x, y, 0); //black
        }
        
        try {
            ImageIO.write(img, "png", new File("RGBRandom.png"));
        } catch (IOException ex) {
            Logger.getLogger(color.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}