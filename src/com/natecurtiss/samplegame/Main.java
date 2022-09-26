package com.natecurtiss.samplegame;

import com.natecurtiss.mango.Game;

public class Main {
    public static void main(String[] args) {
        var player = new Player();
        new Game().add(player).start();
    }
}
