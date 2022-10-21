package com.natecurtiss.mango;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class Spritesheet {
    private final LinkedList<Image> imgs = new LinkedList<>();

    private LinkedList<Image> getImages(BufferedImage img, int tileSize) {
        var width = img.getWidth() / tileSize;
        var height = img.getHeight() / tileSize;

        imgs.clear();
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                imgs.add(img.getSubimage(i * tileSize, j * tileSize, tileSize, tileSize));
        return imgs;
    }
}
