package com.github.Jiga228;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.github.Jiga228.GameEngine.Actors.Actor;
import com.github.Jiga228.GameEngine.Actors.Mesh;
import com.github.Jiga228.GameEngine.Vector;
import com.github.Jiga228.GameEngine.World;
import com.github.Jiga228.databinding.ActivityGameBinding;


public class GameActivity extends AppCompatActivity  {
    private ActivityGameBinding binding;
    private World world = new World();

    public static Intent getIntent(Context context)
    {
        return new Intent(context, GameActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGameBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());

        world.Start();
        binding.drawer.SetWorld(world);
        binding.drawer.invalidate();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            world.close();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}