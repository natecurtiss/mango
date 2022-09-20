package com.natecurtiss.mango;

public abstract class Entity {
    private Game game;

    public abstract void update(double dt);
    public abstract void render();

    public void init(Game g) { game = g; }
    protected Game getGame() { return game; }
}
