package hackathon;

import hackathon.engine.Collidable;
import hackathon.engine.Drawable;
import hackathon.engine.DrawingPanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    private static void drawBackground(DrawingPanel panel, Graphics g) {
        g.setColor(Color.white);
        g.fillRect(34,89,30, 30);
        g.fillRect(45,12,30, 30);
        g.fillRect(405,527,30, 30);
        g.fillRect(524,245,30, 30);
        g.fillRect(234,543,30, 30);
        g.fillRect(134,453,30, 30);
        g.fillRect(53,144,30, 30);
    }

    public static void main(String [] args) throws InterruptedException {
        DrawingPanel panel = new DrawingPanel(600, 600);
        Graphics g = panel.getGraphics();

        Player player = new Player(100, 100);
        KeyboardController controller = new KeyboardController(player);

        panel.addKeyListener(controller);

        List<Obstacle> obstacles = Arrays.asList(
                new Obstacle(34,89,30, 30),
                new Obstacle(45,12,30, 30),
                new Obstacle(405,527,30, 30),
                new Obstacle(524,245,30, 30),
                new Obstacle(234,543,30, 30),
                new Obstacle(134,453,30, 30),
                new Obstacle(53,144,30, 30)
        );

        List<Enemy> enemies = Arrays.asList(
                new Enemy(200, 100, 15, 15),
                new Enemy(200, 200, 15, 15),
                new Enemy(200, 300, 15, 15),
                new Enemy(200, 400, 15, 15),
                new Enemy(200, 500, 15, 15)
        );

        List<AiController> controllers = enemies.stream()
                    .map(e -> new AiController(e)).collect(Collectors.toList());

        List<Drawable> drawables = new ArrayList<>(obstacles);
        drawables.add(player);
        drawables.addAll(enemies);

        List<Collidable> collidables = new ArrayList<>(obstacles);
        collidables.addAll(enemies);

        long last = System.currentTimeMillis();
        while (!player.isDead()) {
            long current = System.currentTimeMillis();

            // Update state
            player.tick((int) (current - last));

            for (AiController ai : controllers)
                ai.tick((int) (current - last));

            for (Enemy e : enemies)
                e.tick((int) (current - last));

            last = current;

            // Calculate physics
            for (Collidable o : collidables) {
                if (player.isColliding(o) || o.isColliding(player)) {
                    player.kill();
                    break;
                }
            }

            // Render
            g.setColor(Color.black);
            g.fillRect(0, 0, 600, 600);

            drawBackground(panel, g);

            for (Drawable d : drawables)
                d.draw(panel, g);

            Thread.sleep(50);
        }

        Font font = new Font("Dialog", Font.PLAIN, 64);
        g.setFont(font);
        g.setColor(Color.BLUE);
        g.drawString("Damn bro!", 150, 150);
        g.drawString("You dead!", 150, 220);
    }

}
