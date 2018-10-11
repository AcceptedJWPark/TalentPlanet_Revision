package com.example.accepted.Profile;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.accepted.Home.R;

public class MainActivity extends AppCompatActivity {

    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        mContext = getApplicationContext();

        ((TextView) findViewById(R.id.tv_toolbarTitle)).setText("Profile");
        ((ImageView) findViewById(R.id.iv_RightBtn_Toolbar)).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.tv_RightBtn_Toolbar)).setVisibility(View.VISIBLE);
        ((ImageView) findViewById(R.id.iv_LeftBtn_Toolbar)).setVisibility(View.VISIBLE);
        ((ImageView) findViewById(R.id.iv_LeftBtn_Toolbar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ShapeDrawable drawable =new ShapeDrawable(new OvalShape());
        drawable.getPaint().setColor(Color.WHITE);
        drawable.getPaint().setStyle(Paint.Style.STROKE);
        ((RelativeLayout)findViewById(R.id.rl_picture_profile)).setBackground(drawable);
        ((RelativeLayout)findViewById(R.id.rl_picture_profile)).setClipToOutline(true);



    }



}
