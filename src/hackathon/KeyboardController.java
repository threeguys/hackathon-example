package hackathon;

import hackathon.engine.Controllable;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController implements KeyListener {

    private Controllable controlled;

    public KeyboardController(final Controllable controlled) {
        this.controlled = controlled;
    }

    @Override
    public void keyTyped(final KeyEvent e) {

    }

    @Override
    public void keyPressed(final KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_W:
                controlled.setVelocity(0, -10);
                break;
            case KeyEvent.VK_S:
                controlled.setVelocity(0, 10);
                break;
            case KeyEvent.VK_D:
                controlled.setVelocity(10, 0);
                break;
            case KeyEvent.VK_A:
                controlled.setVelocity(-10, 0);
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        controlled.setVelocity(0, 0);
    }

}
