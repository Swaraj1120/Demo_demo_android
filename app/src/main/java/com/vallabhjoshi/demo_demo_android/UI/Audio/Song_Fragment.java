package com.vallabhjoshi.demo_demo_android.UI.Audio;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vallabhjoshi.demo_demo_android.Adapter.All_Audio_Adapters.Audio_Fragemt_Custom_Adapter;
import com.vallabhjoshi.demo_demo_android.Adapter.All_Audio_Adapters.Song_Fragment_Custom_Adapter;
import com.vallabhjoshi.demo_demo_android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Song_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Song_Fragment extends Fragment {
    RecyclerView mRecycler;
    public static Context songFragmentContext ;
    String newDemoString;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Song_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Song_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Song_Fragment newInstance(String param1, String param2) {
        Song_Fragment fragment = new Song_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_song_, container, false);
        mRecycler = view.findViewById(R.id.playlist_songs_recyclerview);
        songFragmentContext = getContext();
        mRecycler.setLayoutManager(new LinearLayoutManager(songFragmentContext));
        Song_Fragment_Custom_Adapter mSong_Fragment_Custom_Adapter = new Song_Fragment_Custom_Adapter(songFragmentContext,newDemoString);
        mRecycler.setAdapter(mSong_Fragment_Custom_Adapter);

        return view;
    }
}