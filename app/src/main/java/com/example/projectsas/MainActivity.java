package com.example.projectsas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

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

    public static void changeFragment(String fragmentName){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        switch (fragmentName){
            case "editorFragment_new":
                fragmentTransaction.replace(R.id.fragment_container, new MMEditorFragment(), "editorFragment");
                break;
            case "menuFragment":
                fragmentTransaction.replace(R.id.fragment_container, menuFragment);
                break;
        }
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}