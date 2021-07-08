package com.vallabhjoshi.demo_demo_android.UI.Home;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vallabhjoshi.demo_demo_android.Adapter.Recent_Item_Custom_Adapter;
import com.vallabhjoshi.demo_demo_android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link com.vallabhjoshi.demo_demo_android.UI.Home} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {
    RecyclerView mRecyclerViewRecentList;
    Context context = getContext();
//    SendingContextToMainActivity mContextSend;

    String[] demoString ={"Dhyan1","Dhyan2","Dhyan3"};



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        mContextSend.sendingData(context);

        mRecyclerViewRecentList = view.findViewById(R.id.recent_item_recyclerview);
        mRecyclerViewRecentList.setLayoutManager(new LinearLayoutManager(context));
        Recent_Item_Custom_Adapter mRecentAdapter = new Recent_Item_Custom_Adapter(demoString);
        mRecyclerViewRecentList.setAdapter(mRecentAdapter);

        return view;
    }

//    public  interface SendingContextToMainActivity{
//        public void sendingData(Context context);
//    }
}