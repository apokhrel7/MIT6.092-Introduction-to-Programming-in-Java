package problem6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Circle implements Sprite {
    private final int width;
    private final int height;
    private final Color color;

    /**
     * Create a circle that has dimensions width and height, filled with
     * startColor.
     */
    public Circle(int width, int height, Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void draw(Graphics surface, int x, int y) {
        // Draw the circle object
        surface.setColor(color);
        surface.fillArc(x, y, width, height, 0, 360);
        surface.setColor(Color.BLACK); // Colour of the outline
        ((Graphics2D) surface).setStroke(new BasicStroke(3.0f));
        surface.drawOval(x, y, width, height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
