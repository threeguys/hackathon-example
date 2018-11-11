package hackathon;

import hackathon.engine.Controllable;

import java.util.Random;

public class AiController {

    private Controllable controllable;
    private Random random;
    private long lastChange;

    public AiController(Controllable controllable) {
        this.controllable = controllable;
        this.lastChange = 0;
        this.random = new Random();
    }

    public void tick(int durationMs) {
        long current = System.currentTimeMillis();
        if (current > (lastChange + 1000)) {
            double chance = random.nextDouble();
            if (chance < 0.25)
                controllable.setVelocity(-10, -10);
            else if (chance < 0.50)
                controllable.setVelocity(-10, 10);
            else if (chance < 0.75)
                controllable.setVelocity(10, 10);
            else
                controllable.setVelocity(10, -10);
            lastChange = current;
        }
    }

}
