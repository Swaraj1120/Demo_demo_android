package com.vallabhjoshi.demo_demo_android.API;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.vallabhjoshi.demo_demo_android.UI.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Audio_Api {
    private static Context mContext ;
    private static ArrayList<String> mCategoryNames = new ArrayList<>();

    public Audio_Api(Context mContext){
        this.mContext = mContext;

    }


    public void setCategoryNames(){
    if(mCategoryNames.isEmpty()){
        RequestQueue mRequestQueue = Volley.newRequestQueue(mContext);
        String url = Constants.IP_ADDRESS + "/audios/category";
        JsonArrayRequest mJsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            JSONObject mJSONObject = new JSONObject(String.valueOf(response.getJSONObject(0)));
                            mCategoryNames.add(mJSONObject.getString("Category"));
                            Log.i("Category Names",mCategoryNames.toString());
                            Log.i("Category Size",String.valueOf(mCategoryNames.size()));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Category Name Error" + error);
            }
        });
    }

    }
}
