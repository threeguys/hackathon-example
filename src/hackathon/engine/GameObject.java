package hackathon.engine;

public class GameObject implements Collidable {

    protected Position position;
    protected Bounds bounds;

    public GameObject(int x, int y, int width, int height) {
        this.position = new Position(x, y);
        this.bounds = new Bounds(width, height);
    }

    private boolean isInside(int x, int y, Position p, Bounds b) {
        int left = p.getX();
        int bottom = p.getY();
        int right = left + b.getWidth();
        int top = bottom + b.getHeight();
        return isInside(x, y, left, bottom, right, top);
    }

    private boolean isInside(int x, int y, int left, int bottom, int right, int top)
    {
        return  x >= left && x <= right && y >= bottom && y <= top;
    }

    @Override
    public boolean isColliding(final Collidable collidable) {
        Position p = collidable.getPosition();
        Bounds b = collidable.getBounds();

        int left = p.getX();
        int bottom = p.getY();
        int right = left + b.getWidth();
        int top = bottom + b.getHeight();

        if (isInside(position.getX(), position.getY(), left, bottom, right, top))
            return true;
        if (isInside(position.getX() + bounds.getWidth(), position.getY(), left, bottom, right, top))
            return true;
        if (isInside(position.getX(), position.getY() + bounds.getHeight(), left, bottom, right, top))
            return true;
        if (isInside(position.getX() + bounds.getWidth(), position.getY() + bounds.getHeight(), left, bottom, right, top))
            return true;

        return false;
    }

    @Override
    public boolean isCollidingTop(final Collidable collidable) {
        Position p = collidable.getPosition();
        Bounds b = collidable.getBounds();
        return isInside(position.getX(), position.getY() + bounds.getHeight(), p, b)
                || isInside(position.getX() + bounds.getWidth(), position.getY() + bounds.getHeight(), p, b);
    }

    @Override
    public boolean isCollidingBottom(final Collidable collidable) {
        Position p = collidable.getPosition();
        Bounds b = collidable.getBounds();
        return isInside(position.getX(), position.getY(), p, b)
                || isInside(position.getX() + bounds.getWidth(), position.getY(), p, b);
    }

    @Override
    public boolean isCollidingLeft(final Collidable collidable) {
        Position p = collidable.getPosition();
        Bounds b = collidable.getBounds();
        return isInside(position.getX(), position.getY(), p, b)
                || isInside(position.getX(), position.getY() + bounds.getHeight(), p, b);
    }

    @Override
    public boolean isCollidingRight(final Collidable collidable) {
        Position p = collidable.getPosition();
        Bounds b = collidable.getBounds();
        return isInside(position.getX() + bounds.getWidth(), position.getY(), p, b)
                || isInside(position.getX() + bounds.getWidth(), position.getY() + b.getHeight(), p, b);
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public Bounds getBounds() {
        return bounds;
    }
}
