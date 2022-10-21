package com.natecurtiss.mango;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame implements Runnable {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = WIDTH / 16 * 9;
    public static final String NAME = "mango";
    private static final double UPDATE_RATE = 1.0 / 60.0;

    private final Input input = new Input();
    private final List<Entity> entities = new ArrayList<>();
    private boolean running;
    private int fps = 60;

    public Game() {
        var dimension = new Dimension(WIDTH, HEIGHT);
        setSize(dimension);
        setMinimumSize(dimension);
        setMaximumSize(dimension);
        setPreferredSize(dimension);
        setResizable(false);
        setTitle(NAME);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        addKeyListener(input);
    }

    public synchronized void start() {
        new Thread(this).start();
        running = true;
    }

    public synchronized void stop() {
        running = false;
    }

    @Override
    public void run() {
        var last = System.currentTimeMillis();
        var frameTimer = 0.0;
        var updateTimer = 0.0;
        var frames = 0;
        while (running) {
            var current = System.currentTimeMillis();
            var delta = (current - last) / 1000.0;
            last = current;
            updateTimer += delta;
            frameTimer += delta;
            if (frameTimer >= 1) {
                fps = frames;
                frames = 0;
                frameTimer = 0.0;
            }
            if (updateTimer >= UPDATE_RATE)
                while (updateTimer >= UPDATE_RATE) {
                    updateTimer -= UPDATE_RATE;
                    frames++;
                    update(delta);
                    render();
                }
        }
    }

    public void update(double dt) {
        for (Entity e : entities)
            e.update(dt);
        input.update();
    }

    public void render() {
        for (Entity e : entities)
            e.render();
    }

    public Game create(Entity entity) {
        add(entity);
        pack();
        entity.init(this, input);
        entity.start();
        entities.add(entity);
        return this;
    }

    public Game destroy(Entity entity) {
        remove(entity);
        entity.end();
        entities.remove(entity);
        return this;
    }

    public int getFps() { return fps; }
}
