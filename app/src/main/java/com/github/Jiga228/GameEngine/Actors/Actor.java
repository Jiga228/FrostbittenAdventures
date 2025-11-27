package com.github.Jiga228.GameEngine.Actors;

import com.github.Jiga228.GameEngine.Vector;
import com.github.Jiga228.GameEngine.World;

public class Actor {
    private Vector loc = new Vector();
    private Vector direct = new Vector();
    private World owner;

    public Actor(World world, Vector loc, Vector direct) {
        this.owner = world;
        this.loc = loc;
        this.direct = direct;
        world.AddActor(this);
    }

    public Actor(World world, Vector loc) {
        this.owner = world;
        this.loc = loc;
        world.AddActor(this);
    }

    public Actor(World world) {
        this.owner = world;
        world.AddActor(this);
    }

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
