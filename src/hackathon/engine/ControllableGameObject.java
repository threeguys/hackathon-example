package hackathon.engine;

public class ControllableGameObject extends GameObject implements Controllable {

    private Velocity velocity;

    public ControllableGameObject(final int x, final int y, final int width, final int height) {
        super(x, y, width, height);
        velocity = new Velocity(0, 0);
    }

    public Velocity getVelocity() {
        return velocity;
    }

    public void setVelocity(final Velocity velocity) {
        this.velocity = velocity;
    }

    public void reflect() {
        reflectX();
        reflectY();
    }

    public void reflectX() {
        this.velocity.setX(this.velocity.getX() * -1);
    }

    public void reflectY() {
        this.velocity.setY(this.velocity.getY() * -1);
    }

    @Override
    public void setVelocity(final int x, final int y) {
        this.velocity.setX(x);
        this.velocity.setY(y);
    }
}
