package com.example.projectsas;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MMEditorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MMEditorFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_MIND_MAP_NAME = "mindMapName";
    Button buttonAddElement;
    DrawView forDraw;

    // TODO: Rename and change types of parameters
    private MindMap mindMap;
    /** @ editorMode Editor's mode
     * 0 - creating new
     * 1 - redacting already created and saved instance
     */
    private String mindMapName;

    public MMEditorFragment() {
        // Required (quite not) empty public constructor
        mindMap = new MindMap();
    }

    public MMEditorFragment(String mindMapName) {
        mindMap = new FileManager().importMindMap(mindMapName);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param mindMapName Parameter 2.
     * @return A new instance of fragment CreateNewFragment.
     */
    public static MMEditorFragment newInstance(int editorMode, String mindMapName) {
        MMEditorFragment fragment = new MMEditorFragment();
        Bundle args = new Bundle();
        args.putString(ARG_MIND_MAP_NAME, mindMapName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mindMapName = getArguments().getString(ARG_MIND_MAP_NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        buttonAddElement = view.findViewById(R.id.button_add_basic_leaf);
        forDraw = view.findViewById(R.id.surfaceView);
        buttonAddElement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mindMap.addElement(new MindMapElement());

            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        FileManager.backup(mindMapName, mindMap);
    }

}