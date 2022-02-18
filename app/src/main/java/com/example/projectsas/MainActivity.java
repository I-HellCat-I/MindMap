package com.example.projectsas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private ResViewAdapter rvAdapter;
    private Button btnCreateNew;
    private static FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    static MMEditorFragment editorFragment;
    static MenuFragment menuFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){/* Ignore */}

        menuFragment = new MenuFragment(5, this);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, menuFragment, "menuFragment");
        fragmentTransaction.commit();
        setContentView(R.layout.activity_main);
    }

    public static void changeFragment(String fragmentName, @Nullable String mindMapName){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (fragmentName){
            case "editorFragment_new":
                fragmentTransaction.replace(R.id.fragment_container, new MMEditorFragment(), "editorFragment");
                break;
            case "menuFragment":
                fragmentTransaction.replace(R.id.fragment_container, menuFragment);
                break;
            case "editorFragment":
                fragmentTransaction.replace(R.id.fragment_container, new MMEditorFragment(mindMapName), "editorFragment");
                break;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}