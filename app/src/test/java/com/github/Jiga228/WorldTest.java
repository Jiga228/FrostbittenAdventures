package com.github.Jiga228;

import com.github.Jiga228.GameEngine.Actors.Actor;
import com.github.Jiga228.GameEngine.World;

import org.junit.Test;

class ExampleActor extends Actor
{
    private int cnt = 10;

    public ExampleActor(World world) {
        super(world);
    }

    @Override
    public void Tick(float DeltaTime) {
        if(cnt != 0)
            cnt--;
    }

    public int getCnt() {
        return cnt;
    }
}
public class WorldTest {
    @Test
    public void Test()
    {
        try {
            World t = new World();
            ExampleActor actor = new ExampleActor(t);
            t.Start();
            Thread.sleep(100);
            assert 0 == actor.getCnt();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
