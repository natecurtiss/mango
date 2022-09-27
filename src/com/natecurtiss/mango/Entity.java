package com.natecurtiss.mango;

import javax.swing.*;
import java.awt.*;

public abstract class Entity extends JPanel {
    public double xScale = 1;
    public double yScale = 1;
    public double xPosition;
    public double yPosition;

    private Image image;
    private Game game;

    public abstract void start();
    public abstract void end();
    public abstract void update(double dt);
    public abstract void render();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image == null)
            return;
        var graphics = (Graphics2D) g;
        var w = (int) (image.getWidth(this) * xScale);
        var h = (int) (image.getHeight(this) * yScale);
        var x = (int) Math.round(xPosition) + Game.WIDTH / 2 - w / 2;
        var y = (int) Math.round(yPosition) + Game.HEIGHT / 2 - h / 2;

        graphics.drawImage(image, x, y, w, h, this);
    }

    public void setSprite(String path) {
        image = new ImageIcon(path).getImage();
        var w = image.getWidth(this);
        var h = image.getHeight(this);
        setSize(w, h);
    }

    void init(Game g) { game = g; }
    void destroy() { }

    protected Game getGame() { return game; }
}
