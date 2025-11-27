package com.github.Jiga228.GameEngine;

import com.github.Jiga228.GameEngine.Actors.Actor;
import com.github.Jiga228.GameEngine.Actors.Mesh;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class World {
    private final ArrayList<Actor> actors = new ArrayList<>();
    private final Object mActors = new Object();
    private final AtomicBoolean isRunning = new AtomicBoolean(true);
    private final Thread ActorsThread = new Thread(()->{
        long delta_time = 0;
        while (isRunning.get())
        {
            long first_time = System.currentTimeMillis();
            for(Actor i : actors) {
                synchronized (mActors) {
                    i.Tick(delta_time);
                }
            }
            delta_time = System.currentTimeMillis() - first_time;
        }
    });

    public void Start()
    {
        for(Actor i : actors) {
            synchronized (mActors) {
                i.BeginPlay();
            }
        }

        ActorsThread.start();
    }

    public void close() throws InterruptedException {
        isRunning.set(false);
        ActorsThread.join();
        actors.clear();
    }

    public void AddActor(Actor actor)
    {
        synchronized (mActors)
        {
            actors.add(actor);
        }
    }

    public ArrayList<Mesh> GetMeshes()
    {
        ArrayList<Mesh> meshes = new ArrayList<>();
        synchronized (mActors)
        {
            for (Actor i : actors)
            {
                if(i instanceof Mesh)
                    meshes.add((Mesh)i);
            }
        }
        return meshes;
    }
}
