package com.github.Jiga228.GameEngine.Actors;

import com.github.Jiga228.GameEngine.Vector;
import com.github.Jiga228.GameEngine.World;

public class Mesh extends Actor{
    public Mesh(World world, Vector loc, Vector direct) {
        super(world, loc, direct);
    }

    public Mesh(World world, Vector loc) {
        super(world, loc);
    }

    public Mesh(World world) {
        super(world);
    }
}
