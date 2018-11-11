package hackathon;

import hackathon.engine.ControllableGameObject;
import hackathon.engine.Drawable;
import hackathon.engine.DrawingPanel;

import java.awt.*;

public class Player extends ControllableGameObject implements Drawable {

    private boolean dead = false;

    public Player(int x, int y) {
        super(x, y, 25, 25);
    }

    public void tick(int durationMs) {
        this.position.setX(this.position.getX() + (this.getVelocity().getX() * durationMs / 100));
        this.position.setY(this.position.getY() + (this.getVelocity().getY() * durationMs / 100));
    }

    @Override
    public void draw(final DrawingPanel panel, final Graphics g) {
        g.setColor(Color.red);
        g.fillRect(position.getX(), position.getY(), bounds.getWidth(), bounds.getHeight());
    }

    public void kill() {
        dead = true;
    }

    public boolean isDead() {
        return dead;
    }

}
