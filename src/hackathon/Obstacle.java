package hackathon;

import hackathon.engine.Drawable;
import hackathon.engine.DrawingPanel;
import hackathon.engine.GameObject;

import java.awt.*;

public class Obstacle extends GameObject implements Drawable {

    public Obstacle(final int x, final int y, final int width, final int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(final DrawingPanel panel, final Graphics g) {
        g.setColor(Color.white);
        g.fillRect(position.getX(), position.getY(), bounds.getWidth(), bounds.getHeight());
    }

}
