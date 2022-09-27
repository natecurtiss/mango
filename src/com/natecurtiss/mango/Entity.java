package com.natecurtiss.mango;

import javax.swing.*;
import java.awt.*;

public abstract class Entity extends JPanel {
    public double xScale = 1;
    public double yScale = 1;
    public double xPosition;
    public double yPosition;

    private Game game;

    public abstract void start();
    public abstract void end();
    public abstract void update(double dt);
    public abstract void render();

    void init(Game g) { game = g; }
    void destroy() { }

    protected Game getGame() { return game; }
}
