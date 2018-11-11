package hackathon;

import hackathon.engine.ControllableGameObject;
import hackathon.engine.Drawable;
import hackathon.engine.DrawingPanel;

import java.awt.*;

public class Enemy extends ControllableGameObject implements Drawable {

    public Enemy(final int x, final int y, final int width, final int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(final DrawingPanel panel, final Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(position.getX(), position.getY(), bounds.getWidth(), bounds.getHeight());
    }

    public void tick(int durationMs) {
        this.position.setX(this.position.getX() + (this.getVelocity().getX() * durationMs / 200));
        this.position.setY(this.position.getY() + (this.getVelocity().getY() * durationMs / 200));
    }
}
