package com.github.Jiga228.GameEngine.Controller;

public interface IController {
    default void BeginPlay(float delta_time) {};
    default void Tick(float delta_time) {};
}
