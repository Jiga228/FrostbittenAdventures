package com.github.Jiga228;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import com.github.Jiga228.GameEngine.Actors.Mesh;
import com.github.Jiga228.GameEngine.Vector;
import com.github.Jiga228.GameEngine.World;

import java.util.ArrayList;

public class Drawer extends View
{
    public World world;
    private Paint paint;

    public void SetWorld(World world)
    {
        this.world = world;
    }

    public Drawer(Context context) {
        super(context);
        init();
    }

    public Drawer(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        if (world == null) return;

        ArrayList<Mesh> meshes = world.GetMeshes();
        for (Mesh i : meshes) {
            Vector loc = i.getLoc();
            canvas.drawCircle(loc.X(), loc.Y(), 100, paint);
        }
    }
}
