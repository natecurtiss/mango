package com.natecurtiss.mango;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public abstract class Entity extends JPanel {
    private Image image;
    private Game game;

    public abstract void start();
    public abstract void end();
    public abstract void update(double dt);
    public abstract void render();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var graphics = (Graphics2D) g;
        graphics.drawImage(image, 0, 0, this);
    }

    public void setSprite(String path) {
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void init(Game g) {
        game = g;
    }

    void destroy() {

    }

    protected Game getGame() { return game; }
}
