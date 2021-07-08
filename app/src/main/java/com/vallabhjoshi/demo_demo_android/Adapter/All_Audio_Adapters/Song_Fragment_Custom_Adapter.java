package com.vallabhjoshi.demo_demo_android.Adapter.All_Audio_Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.vallabhjoshi.demo_demo_android.MainActivity;
import com.vallabhjoshi.demo_demo_android.R;
import com.vallabhjoshi.demo_demo_android.UI.SongList.SongListFragment;


public class Song_Fragment_Custom_Adapter extends RecyclerView.Adapter<Song_Fragment_Custom_Adapter.ViewHolder> {

    private String localDataSet;
//    String mDhyanUrls , newDemoString;
    public static Context mContext;


    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public  class ViewHolder extends RecyclerView.ViewHolder {
        public TextView song1;
//        private
//        dhyanUrls = "https://drive.google.com/uc?export=download&id=1WqekKLluvjRlI6gguQqqpLCEdpqpMov4";

        //
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
           song1 = view.findViewById(R.id.song_no_1_text);
        }
        //


    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public Song_Fragment_Custom_Adapter(Context context ,String dataSet) {
        this.localDataSet = dataSet;

//       this.mDhyanUrls = dhyanUrls;
    }
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ui_in_fragment_song_xml, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.song1.setText("Song jingala");

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 1;
    }
}

