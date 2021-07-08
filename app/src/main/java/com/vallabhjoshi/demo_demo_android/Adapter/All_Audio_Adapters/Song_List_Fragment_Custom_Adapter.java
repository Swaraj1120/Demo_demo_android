package com.vallabhjoshi.demo_demo_android.Adapter.All_Audio_Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vallabhjoshi.demo_demo_android.MainActivity;
import com.vallabhjoshi.demo_demo_android.R;
import com.vallabhjoshi.demo_demo_android.UI.Audio.Song_Fragment;

public class Song_List_Fragment_Custom_Adapter extends RecyclerView.Adapter<Song_List_Fragment_Custom_Adapter.ViewHolder> {

//    private ImageView localDataSet;
//    String mDhyanUrls , newDemoString;
    public static Context mSong_List_Fragment_Custom_Adapter;
//    SlidingPanelFragment mSlidingPanelFragment = new SlidingPanelFragment();

    TextView durationOfSong, titleOfSong;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public  class ViewHolder extends RecyclerView.ViewHolder {
//        private  ImageView mImageView;
//        private TextView mTextView;

//        private
//        dhyanUrls = "https://drive.google.com/uc?export=download&id=1WqekKLluvjRlI6gguQqqpLCEdpqpMov4";

        //
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            mSong_List_Fragment_Custom_Adapter = view.getContext();
durationOfSong = view.findViewById(R.id.duration_of_song);
titleOfSong = view.findViewById(R.id.title_of_song);
        }
        //
        public TextView getTextView() {
            return titleOfSong;
        }
//        public ImageView getmImageView(){
//            return mImageView;
//        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public Song_List_Fragment_Custom_Adapter(Context context, String dataSet) {

//        this.mDhyanUrls = dataSet;
//        this.mContext = context;
//        this.newDemoString = dataSet;
//       this.mDhyanUrls = dhyanUrls;
    }
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ui_of_fragment_songlist_xml, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {


        viewHolder.getTextView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Song_Fragment mSongFragment = new Song_Fragment();
                FragmentManager fragmentManager = ((MainActivity)mSong_List_Fragment_Custom_Adapter).getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.windowFrame,mSongFragment).commit();;
            }
        });
//        fragmentManager.beginTransaction().add(R.id.windowFrame, mSlidingPanelFragment).commit();
//        viewHolder.getTextView().setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(mSong_List_Fragment_Custom_Adapter, "Jingalala", Toast.LENGTH_SHORT).show();
//            }
//        });


        // Get element from your dataset at this position and replace the
        // contents of the view with that element
//        try{
//            RequestOptions requestOptions = new RequestOptions();
//            requestOptions=requestOptions.placeholder(R.drawable.dhyan);
//
////            Glide.with(mContext)
////                    .load("https://drive.google.com/uc?export=download&id=1WqekKLluvjRlI6gguQqqpLCEdpqpMov4")
////                    .apply(requestOptions)
////                    .into(viewHolder.mImageView);
//
//            //OnImageClick->SongListFragment
////            viewHolder.mImageView.setOnClickListener(new View.OnClickListener() {
////                @Override
////                public void onClick(View v) {
////                    FragmentManager fragmentManager = ((MainActivity) mContext).getSupportFragmentManager();
////                    fragmentManager.beginTransaction().add(R.id.windowFrame,new SongListFragment()).commit();
////                }
//            });
//            Glide.with(mContext)
//                    .asBitmap()
//                    .load("https://drive.google.com/uc?export=download&id=1WqekKLluvjRlI6gguQqqpLCEdpqpMov4")
//                    .into(viewHolder.mImageView);
//
//            Glide.with(mContext)
//                    .asBitmap()
//                    .load(mData.get(position).getUrl())
//                    .into(holder.image);
//
//            viewHolder.getmImageView().setImageURI(uri);
//    }
//        catch(Exception e){
//
//            Log.i("Image Exception", String.valueOf(e));
//        }
//        viewHolder.mTextView.setText("Jay Shri Ram");

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 1;
    }
}


