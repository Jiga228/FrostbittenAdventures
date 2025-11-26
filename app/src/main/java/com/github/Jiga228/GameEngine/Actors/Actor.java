package com.github.Jiga228.GameEngine.Actors;

import com.github.Jiga228.GameEngine.Vector;

public class Actor {
    private Vector loc = new Vector();
    private Vector direct = new Vector();

    public Actor(Vector loc, Vector direct) {
        this.loc = loc;
        this.direct = direct;
    }

    public Actor(Vector loc) {
        this.loc = loc;
    }

    public Actor() {}

    public void SetLoc(Vector loc)
    {
        this.loc = loc;
    }

    public void SetDirect(Vector direct)
    {
        this.direct = direct;
    }

    public Vector getLoc() {
        return loc;
    }

    public Vector getDirect() {
        return direct;
    }

    public void BeginPlay() {}
    public void Tick(float DeltaTime) {}
}
