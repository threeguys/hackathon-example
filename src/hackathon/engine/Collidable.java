package hackathon.engine;

public interface Collidable {

    boolean isColliding(Collidable collidable);
    boolean isCollidingTop(Collidable collidable);
    boolean isCollidingBottom(Collidable collidable);
    boolean isCollidingLeft(Collidable collidable);
    boolean isCollidingRight(Collidable collidable);
    Position getPosition();
    Bounds getBounds();

}
