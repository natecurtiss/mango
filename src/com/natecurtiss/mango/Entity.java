package com.natecurtiss.mango;

import javax.swing.*;

public abstract class Entity extends JPanel {
    public double xScale = 1;
    public double yScale = 1;
    public double xPosition;
    public double yPosition;

    private Input input;
    private Game game;

    public abstract void start();
    public abstract void end();
    public abstract void update(double dt);
    public abstract void render();

    void init(Game g, Input i) {
        game = g;
        input = i;
    }

    void destroy() {

    }

    protected Input getInput() { return input; }
    protected Game getGame() { return game; }
}
