import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{


    // Just a single image, TODO: Generalize
    // To keep track of a single car's position
    private ArrayList<Vehicle> cars;

    Point volvoWorkshopPoint = new Point(0,300); //Hur vi kopplar denna till Workshops x och y?
    BufferedImage volvoWorkshopImage;
    BufferedImage saab95Image;
    BufferedImage scaniaImage;
    BufferedImage volvoImage;

    // TODO: Make this general for all cars



    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, ArrayList<Vehicle> cars) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        this.cars = cars;
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            //volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));
            saab95Image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Vehicle car : cars) {

            BufferedImage image = null;

            if (car instanceof Volvo240) image = volvoImage;
            else if (car instanceof Saab95) image = saab95Image;
            else if (car instanceof Scania) image = scaniaImage;

            g.drawImage(image, (int)car.getX(), (int)car.getY(), null);
        }
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);

    }
}
