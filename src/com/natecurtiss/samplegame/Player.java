package com.natecurtiss.samplegame;

import com.natecurtiss.mango.Sprite;

import java.awt.event.KeyEvent;

public class Player extends Sprite {
    @Override
    public void start() {
        setSprite("src/com/natecurtiss/samplegame/IMG_8545.jpg");
    }

    @Override
    public void end() {

    }

    @Override
    public void update(double dt) {
        if (getInput().getKeyPressed(KeyEvent.VK_SPACE))
            System.out.println("Space");
    }

    @Override
    public void render() {

    }
}
