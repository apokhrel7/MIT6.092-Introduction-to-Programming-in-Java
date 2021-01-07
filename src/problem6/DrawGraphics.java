package problem6;

import java.awt.*;
import java.util.ArrayList;

public class DrawGraphics {
    // No need for 2 arrays for bouncers and straightmovers as interface (Mover) is created
//    private final ArrayList <Bouncer> shapeList = new ArrayList<Bouncer>();
//    private final ArrayList <StraightMover> moversStraight = new ArrayList<StraightMover>();
    private final ArrayList<Mover> listShapes = new ArrayList<Mover>();

    /** Initializes this class for drawing. */
    public DrawGraphics() {
        Rectangle box = new Rectangle(15, 20, Color.RED);
        Circle circle = new Circle(20, 20, Color.BLUE);
        Circle circle2 = new Circle(30, 20, Color.CYAN);

        listShapes.add(new Bouncer (100, 170, box));
        listShapes.add(new Bouncer (100, 170, circle2));
        listShapes.add(new StraightMover(90, 100, box));  // StraightMover will go past the screen
        listShapes.add(new StraightMover(100, 60, circle));

        // Sets the speed of each shape in the listShapes array
        listShapes.get(0).setMovementVector(3, 1);
        listShapes.get(1).setMovementVector(-2, -5);
        listShapes.get(2).setMovementVector(-1, 2);
        listShapes.get(3).setMovementVector(-3, 1);
    }

    /** Draw the contents of the window on surface. */
    public void draw(Graphics surface) {
//        movingSprite.draw(surface);
        for (Mover shapes : listShapes) {
            shapes.draw(surface);
        }

    }
}
