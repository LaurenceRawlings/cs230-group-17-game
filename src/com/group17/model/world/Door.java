package com.group17.model.world;

public abstract class Door extends Cell{
    private boolean state;

    public Door() {
        super(false);
        state = false;
    }

    public boolean getState() {
        return state;
    }

    public void open() {
        state = true;
    }

    public void close() {
        state = false;
    }

    public void toggle() { state = !state; }
}
