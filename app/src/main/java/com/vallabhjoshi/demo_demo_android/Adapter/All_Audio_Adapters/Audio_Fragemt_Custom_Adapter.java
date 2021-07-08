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

public class Audio_Fragemt_Custom_Adapter extends RecyclerView.Adapter<Audio_Fragemt_Custom_Adapter.ViewHolder> {

    private ImageView localDataSet;
    String mDhyanUrls , newDemoString;
    public static Context mContext;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public  class ViewHolder extends RecyclerView.ViewHolder {
        private  ImageView mImageView;
        private TextView mTextView;
//        private
//        dhyanUrls = "https://drive.google.com/uc?export=download&id=1WqekKLluvjRlI6gguQqqpLCEdpqpMov4";

//
        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
        mImageView = view.findViewById(R.id.dhyanImage);
        mTextView = view.findViewById(R.id.dhyanCategoryName);
//            textView = (TextView) view.findViewById(R.id.textView);
        }
//
//        public TextView getTextView() {
//            return textView;
//        }
        public ImageView getmImageView(){
            return mImageView;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public Audio_Fragemt_Custom_Adapter(Context context, String dataSet) {

        this.mDhyanUrls = dataSet;
        this.mContext = context;
        this.newDemoString = dataSet;
//       this.mDhyanUrls = dhyanUrls;
    }
    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.ui_of_fragemnt_audio, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        try{
            RequestOptions requestOptions = new RequestOptions();
            requestOptions=requestOptions.placeholder(R.drawable.dhyan);

            Glide.with(mContext)
                    .load("https://drive.google.com/uc?export=download&id=1WqekKLluvjRlI6gguQqqpLCEdpqpMov4")
                    .apply(requestOptions)
                    .into(viewHolder.mImageView);

            //OnImageClick->SongListFragment
            viewHolder.mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FragmentManager fragmentManager = ((MainActivity) mContext).getSupportFragmentManager();
                    fragmentManager.beginTransaction().add(R.id.windowFrame,new SongListFragment()).commit();
                }
            });
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
        }
        catch(Exception e){

            Log.i("Image Exception", String.valueOf(e));
        }
        viewHolder.mTextView.setText("Jay Shri Ram");

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 1;
    }
}

//mDhyanImageUrls.add("https://drive.google.com/uc?export=download&id=1WqekKLluvjRlI6gguQqqpLCEdpqpMov4");