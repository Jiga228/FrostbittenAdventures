package com.github.Jiga228.GameEngine;

public class Vector {
    private float X, Y;

    public Vector(float x, float y) {
        X = x;
        Y = y;
    }

    public Vector() {
        X = 0;
        Y = 0;
    }

    public Vector add(Vector v)
    {
        return new Vector(X + v.X, Y + v.Y);
    }

    public Vector sub(Vector v)
    {
        return new Vector(X - v.X, Y - v.Y);
    }

    public float mult(Vector v)
    {
        return X*v.X + Y*v.Y;
    }

    public Vector mult(float len)
    {
        return new Vector(X*len, Y*len);
    }

    public float X() { return X; }
    public float Y() { return Y; }
}
