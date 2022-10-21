package com.natecurtiss.samplegame;

import com.natecurtiss.mango.Game;
import com.natecurtiss.mango.Input;

public class Main {
    public static void main(String[] args) {
        var player = new Player();
        player.xScale = 0.08;
        player.yScale = 0.08;
        new Game().create(player).start();
    }
}
