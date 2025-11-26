package com.github.Jiga228;

import com.github.Jiga228.GameEngine.Actors.Actor;
import com.github.Jiga228.GameEngine.World;

import org.junit.Test;

class ExampleActor extends Actor
{
    private int cnt = 10;

    @Override
    public void Tick(float DeltaTime) {
        if(cnt != 0)
            cnt--;
    }

    public int getCnt() {
        return cnt;
    }
}
class TestWorld extends World
{
    public TestWorld(ExampleActor actor)
    {
        AddActor(actor);
    }
}
public class WorldTest {
    @Test
    public void Test()
    {
        ExampleActor actor = new ExampleActor();
        try (TestWorld t = new TestWorld(actor)) {
            Thread.sleep(100);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        assert 10 == actor.getCnt();
    }
}
