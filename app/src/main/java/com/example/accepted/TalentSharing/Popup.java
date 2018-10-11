package com.example.accepted.TalentSharing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.accepted.Home.R;
import com.example.accepted.TalentResist.MainActivity_big;

import java.util.ArrayList;

public class Popup extends FragmentActivity {

    Context mContext;
    boolean ismapclicked = false;

    LinearLayout ll_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.talentsharing_popup_activity);


        mContext = getApplicationContext();

        ((ImageView)findViewById(R.id.iv_close_popup_talentsharing)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ll_map = findViewById(R.id.ll_map_popup_talentsharing);
        ll_map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ismapclicked)
                {
                    ismapclicked = false;
                    ((LinearLayout)findViewById(R.id.ll_mapcontainer_popup_talentsharing)).setVisibility(View.GONE);
                    ((LinearLayout)findViewById(R.id.ll_profilecontainer_popup_talentsharing)).setVisibility(View.VISIBLE);
                    ((ImageView)findViewById(R.id.iv_map_popup_talentsharing)).setImageResource(R.drawable.icon_map);
                    ((TextView)findViewById(R.id.tv_map_popup_talentsharing)).setText("위치");
                }
                else
                {
                    ismapclicked = true;
                    ((LinearLayout)findViewById(R.id.ll_mapcontainer_popup_talentsharing)).setVisibility(View.VISIBLE);
                    ((LinearLayout)findViewById(R.id.ll_profilecontainer_popup_talentsharing)).setVisibility(View.GONE);
                    ((ImageView)findViewById(R.id.iv_map_popup_talentsharing)).setImageResource(R.drawable.icon_homebottom_home);
                    ((TextView)findViewById(R.id.tv_map_popup_talentsharing)).setText("프로필");
                }
            }
        });



        ShapeDrawable drawable =new ShapeDrawable(new OvalShape());
        drawable.getPaint().setColor(Color.WHITE);
        drawable.getPaint().setStyle(Paint.Style.STROKE);
        ((ImageView)findViewById(R.id.iv_talent_talentSharing_popup)).setBackground(drawable);
        ((ImageView)findViewById(R.id.iv_talent_talentSharing_popup)).setClipToOutline(true);

        
        
    }
}
