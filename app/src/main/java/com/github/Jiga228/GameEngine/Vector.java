package com.github.Jiga228.GameEngine;

public class Vector {
    private float X, Y, Z;

    public Vector(float x, float y, float z) {
        X = x;
        Y = y;
        Z = z;
    }

    public Vector() {
        X = 0;
        Y = 0;
        Z = 0;
    }

    public Vector add(Vector v)
    {
        return new Vector(X + v.X, Y + v.Y, Z + v.Z);
    }

    public Vector sub(Vector v)
    {
        return new Vector(X - v.X, Y - v.Y, Z - v.Z);
    }

    public float mult(Vector v)
    {
        return X*v.X + Y*v.Y + Z*v.Z;
    }

    public Vector mult(float len)
    {
        return new Vector(X*len, Y*len, Z*len);
    }
}
