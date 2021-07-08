package com.vallabhjoshi.demo_demo_android.UI.Audio.AudioService;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vallabhjoshi.demo_demo_android.R;

public class SlidingPanelFragment extends Fragment {

    TextView mSongName,mSongTimeTxt;
    String mName = "Sliding Panel";
    String mSongTime;
    ImageView playPause;
    SetPlayPauseBtn setPlayPauseBtn;
    public Context slidePanelContext;
    public static ProgressBar progressBar;

    public static SlidingPanelFragment newInstance(String param1, String param2) {
        SlidingPanelFragment fragment = new SlidingPanelFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        // This makes sure that the host activity has implemented the callback interface
        // If not, it throws an exception
        if(context instanceof SlidingPanelFragment.SetPlayPauseBtn){
            setPlayPauseBtn = (SlidingPanelFragment.SetPlayPauseBtn) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSongName = view.findViewById(R.id.songText);
        playPause = view.findViewById(R.id.ivPlayPause);
        mSongTimeTxt = view.findViewById(R.id.songTime);

        progressBar = view.findViewById(R.id.progressBar);


        mSongName.setText(mName);
        mSongTimeTxt.setText(mSongTime);


        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayPauseBtn.playPause();
            }
        });



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sliding_panel, container, false);     //inflating layout for bottom sliding panel
    }

    public void setData(String mName, String mSongTime){

        this.mName = mName;
        this.mSongTime = mSongTime;
        mSongName.setText(mName);
        mSongTimeTxt.setText(mSongTime);

        playPause.setImageResource(R.drawable.ic_baseline_pause_circle_filled_24);

    }



    public interface SetPlayPauseBtn{
        void playPause();
    }

    public void setPlayPauseBtn(Boolean isPlaying){
        if(isPlaying){
            playPause.setImageResource(R.drawable.ic_baseline_play_circle_filled_24);
        }
        else{
            playPause.setImageResource(R.drawable.ic_baseline_pause_circle_filled_24);
        }

    }

    public void updateBtn(Boolean state){
        if(state){
            playPause.setImageResource(R.drawable.ic_baseline_pause_circle_filled_24);
        }
        else{
            playPause.setImageResource(R.drawable.ic_baseline_play_circle_filled_24);
        }
    }
}