package com.vallabhjoshi.demo_demo_android.UI.SongList;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.vallabhjoshi.demo_demo_android.MainActivity;
import com.vallabhjoshi.demo_demo_android.R;

public class SongListFragment extends Fragment {

    private SongListViewModel mViewModel;
    ImageView play_btn;
    ImageView shuffle_btn;
    RecyclerView dhyanSongsRecyclerView;
    public static TextView dhyanSubcategoryText;

    public static SongListFragment newInstance() {
        return new SongListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.dhyan_subfolder, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity.bottomNavigation.show(2, true);


        play_btn = view.findViewById(R.id.play_button);
        /*shuffle_btn = view.findViewById(R.id.shuffle_button);*/

        dhyanSongsRecyclerView = view.findViewById(R.id.dhyan_songs_recyclerview);
        dhyanSubcategoryText = view.findViewById(R.id.dhyan_subfolder_text);
    }

    private void initSubcategory(View view) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity(), LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = null;

        /*recyclerView = view.findViewById(R.id.dhyan_subfolder_recyclerview);
        recyclerView.setLayoutManager(layoutManager);
        DhyanSubFolderAdapter adapter = new DhyanSubFolderAdapter(this.getActivity(), subcategorylist, this,pos);
        recyclerView.setAdapter(adapter);*/


    }



}