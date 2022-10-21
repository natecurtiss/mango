package com.natecurtiss.mango;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Input extends KeyAdapter {
    private final ArrayList<Integer> down = new ArrayList<>();
    private final ArrayList<Integer> up = new ArrayList<>();
    private final ArrayList<Integer> pressed = new ArrayList<>();
    private final ArrayList<Integer> released = new ArrayList<>();

    Input() {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        var key = e.getKeyCode();
        down.add(key);
        pressed.add(key);
        if (up.contains(key))
            up.remove(up.indexOf(key));
        if (released.contains(key))
            released.remove(released.indexOf(key));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        var key = e.getKeyCode();
        released.add(key);
        up.add(key);
        if (down.contains(key))
            down.remove(down.indexOf(key));
        if (pressed.contains(key))
            pressed.remove(pressed.indexOf(key));
    }

    public boolean getKeyDown(int key) { return down.contains(key); }
    public boolean getKeyUp(int key) { return up.contains(key); }
    public boolean getKeyPressed(int key) { return pressed.contains(key); }
    public boolean getKeyReleased(int key) { return released.contains(key); }

    void update() {
        pressed.clear();
        released.clear();
    }
}
