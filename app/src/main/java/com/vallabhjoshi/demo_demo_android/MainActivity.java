package com.vallabhjoshi.demo_demo_android;

import androidx.appcompat.app.AppCompatActivity;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.sothree.slidinguppanel.SlidingUpPanelLayout;
import com.vallabhjoshi.demo_demo_android.API.Audio_Api;
import com.vallabhjoshi.demo_demo_android.UI.Audio.AudioFragment;
import com.vallabhjoshi.demo_demo_android.UI.Audio.AudioService.SlidingPanelFragment;
import com.vallabhjoshi.demo_demo_android.UI.Home.Home;

public class MainActivity extends AppCompatActivity{
    //RecyclerView mRecyclerViewRecentList;
    //Context mContext;


    //String demoString = "https://drive.google.com/uc?export=download&id=1WqekKLluvjRlI6gguQqqpLCEdpqpMov4";
    public static MeowBottomNavigation bottomNavigation;
    Audio_Api audioApiCall;
    public final int homeTab = 1 , audioTab = 2;
    public SlidingUpPanelLayout slidingPanel;
    private SlidingPanelFragment slidingPanelFragment;
    public static Context mainActivityContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mainActivityContext = getApplicationContext();

        slidingPanelFragment = new SlidingPanelFragment();

        audioApiCall = new Audio_Api(getApplicationContext());
        audioApiCall.setCategoryNames();
        bottomNavigation = findViewById(R.id.bottom_navigation_view);

        bottomNavigation.add(new MeowBottomNavigation.Model(homeTab, R.drawable.ic_home));
        bottomNavigation.add(new MeowBottomNavigation.Model(audioTab, R.drawable.ic_audio));
        bottomNavigation.show(1, true);
//        bottomNavigation.show(2, true);

        getSupportFragmentManager().beginTransaction().replace(R.id.windowFrame,new Home()).commit();

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES
//                getSupportFragmentManager().beginTransaction().replace(R.id.windowFrame,new AudioFragment()).commit();
                switch (model.getId()){
                    case homeTab:
                        if(slidingPanel.getPanelState().equals(SlidingUpPanelLayout.PanelState.EXPANDED)){
                            slidingPanel.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.windowFrame,new Home()).commit();
                        break;
                    case audioTab:
                        if(slidingPanel.getPanelState().equals(SlidingUpPanelLayout.PanelState.EXPANDED)){
                            slidingPanel.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.windowFrame,new AudioFragment()).commit();
                        break;
                }
                return null;
            }
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.bottomPanelFrame, new SlidingPanelFragment()).commit();


        View songActivity = findViewById(R.id.songActivity);
        View bottomPanel = findViewById(R.id.bottomPanelFrame);
        slidingPanel = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);
        slidingPanel.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                //Called when a sliding pane's position changes.

                //setAlpha() -
                //Sets the opacity of the view to a value from 0 to 1, where 0 means the view is
                //completely transparent and 1 means the view is completely opaque.
                bottomPanel.setAlpha(1-slideOffset);
//              bottomPanel.setAlpha(0-slideOffset);
                songActivity.setAlpha(slideOffset);
                if(slideOffset == 1){
                    bottomPanel.setEnabled(false);
                }
                if(slideOffset == 0){
                    bottomPanel.setEnabled(true);
                }

            }

            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

            }
        });



    }
}