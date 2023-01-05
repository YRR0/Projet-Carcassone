package view.jtuile;

import components.tuiles.Tuile;
import components.tuiles.TuileCarcassonne;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class JTTuileCarcassonne extends JTuile {

    public JTTuileCarcassonne() {
        initTuile();
        repaint();
    }

    private void initTuile() {
        setSize(TUILE_WIDTH, TUILE_HEIGHT);
        tuile = null;
    }

    public Tuile getTuile() {
        return tuile;
    }

    @Override
    public void setTuile(Tuile t) {
        if(t == null) {
            this.tuile = null;
            repaint();
        } else {
            if(!(t instanceof TuileCarcassonne tile)) return;
            this.tuile = tile;
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image, partisanImg;
        String tuileDescription = "";
        try {
            if(tuile == null) {
                //image = ImageIO.read(new File("src/Resources/images/Carcassonne/back.jpg"));
                //g.drawImage(image, 0, 0, TUILE_WIDTH, TUILE_HEIGHT, null);
                g.setColor(new Color(151, 222, 206));
                g.fillRect(0, 0, TUILE_WIDTH, TUILE_HEIGHT);
            } else  {
                tuileDescription = tuile.toString();
                image =ImageIO.read(new File("src/Resources/images/Carcassonne/Tuiles/" + tuileDescription + ".png"));
                g.drawImage(image, 0, 0, TUILE_WIDTH, TUILE_HEIGHT, null);
                if(((TuileCarcassonne)tuile).getPartisan() != null) {
                    partisanImg = ImageIO.read(new File("src/Resources/images/Carcassonne/Partisans/" + ((TuileCarcassonne)tuile).getPartisan().couleur() + ".png"));
                    Point partisanPos = getPartisanPosition();
                    g.drawImage(partisanImg, (int) partisanPos.getX(), (int) partisanPos.getY(), JPartisan.PARTISAN_WIDTH, JPartisan.PARTISAN_HEIGHT, this);
                }
            }
        } catch (Exception e) {
            System.err.println("Error while loading image of tuile");
            System.out.println(tuileDescription);
        }
    }

    private Point getPartisanPosition() {
        System.out.println(((TuileCarcassonne)tuile).getCotePartisan());
        return switch (((TuileCarcassonne)tuile).getCotePartisan()) {
            case 0 -> new Point(0, 35);
            case 1 -> new Point(35, 0);
            case 2 -> new Point(60, 35);
            case 3 -> new Point(35, 60);
            default -> new Point(37, 37);
        };
    }
}
