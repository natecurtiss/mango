package com.natecurtiss.mango;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

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
        var x = (int) Math.round(xPosition) + Game.WIDTH / 2 - getWidth() / 2;
        var y = (int) Math.round(yPosition) + Game.HEIGHT / 2 - getHeight() / 2;
        var w = (int) (image.getWidth(this) * xScale);
        var h = (int) (image.getHeight(this) * yScale);
        graphics.drawImage(image, x, y, this);
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
