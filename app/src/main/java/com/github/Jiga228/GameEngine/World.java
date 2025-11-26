package com.github.Jiga228.GameEngine;

import com.github.Jiga228.GameEngine.Actors.Actor;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class World implements AutoCloseable {
    private final ArrayList<Actor> actors = new ArrayList<>();
    private final Object mActors = new Object();
    // private final ArrayList<IController> controllers = new ArrayList<>();
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
//    private Thread ControllersThread = new Thread(()->{
//        while (isRunning.get())
//        {
//
//        }
//    });

    public void Start()
    {
        for(Actor i : actors) {
            synchronized (mActors) {
                i.BeginPlay();
            }
        }

        ActorsThread.start();
        //ControllersThread.start();
    }

    @Override
    public void close() throws Exception {
        isRunning.set(false);
        ActorsThread.join();
        actors.clear();
        // controllers.clear();
    }

    public void AddActor(Actor actor)
    {
        synchronized (mActors)
        {
            actors.add(actor);
        }
    }
}
