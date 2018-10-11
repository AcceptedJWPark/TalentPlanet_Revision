package com.example.accepted.TalentResist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.accepted.Home.R;

public class MainActivity_big extends AppCompatActivity {

    Context mContext;
    LinearLayout talent[];
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talentresist_big_activity);

        mContext = getApplicationContext();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.WHITE);


        ((View) findViewById(R.id.view_divider1_toolbar)).setVisibility(View.GONE);
        ((View) findViewById(R.id.view_divider2_toolbar)).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.tv_toolbarTitle)).setText("Mentor 등록");
        ((TextView) findViewById(R.id.tv_toolbarTitle)).setVisibility(View.VISIBLE);
        ((ImageView) findViewById(R.id.iv_RightBtn_Toolbar)).setVisibility(View.GONE);
        ((ImageView) findViewById(R.id.iv_LeftBtn_Toolbar)).setVisibility(View.VISIBLE);
        ((ImageView) findViewById(R.id.iv_LeftBtn_Toolbar)).setImageResource(R.drawable.icon_backbtn);
        ((ImageView) findViewById(R.id.iv_LeftBtn_Toolbar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        clickTalentCategory();

    }

    public void clickTalentCategory()
    {
        talent = new LinearLayout[15];
        talent[0] = findViewById(R.id.ll_career_resist);
        talent[1] = findViewById(R.id.ll_study_resist);
        talent[2] = findViewById(R.id.ll_money_resist);
        talent[3] = findViewById(R.id.ll_it_resist);
        talent[4] = findViewById(R.id.ll_camera_resist);
        talent[5] = findViewById(R.id.ll_music_resist);
        talent[6] = findViewById(R.id.ll_design_resist);
        talent[7] = findViewById(R.id.ll_sports_resist);
        talent[8] = findViewById(R.id.ll_living_resist);
        talent[9] = findViewById(R.id.ll_beauty_resist);
        talent[10] = findViewById(R.id.ll_travel_resist);
        talent[11] = findViewById(R.id.ll_culture_resist);
        talent[12] = findViewById(R.id.ll_volunteer_resist);
        talent[13] = findViewById(R.id.ll_game_resist);
        talent[14] = findViewById(R.id.ll_add_resist);


        intent= new Intent(mContext, com.example.accepted.TalentResist.MainActivity_small.class);

        talent[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","취업");
                startActivity(intent);
            }
        });

        talent[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","학습");
                startActivity(intent);
            }
        });

        talent[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","재테크");
                startActivity(intent);
            }
        });

        talent[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","IT");
                startActivity(intent);
            }
        });

        talent[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","사진");
                startActivity(intent);
            }
        });

        talent[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","음악");
                startActivity(intent);
            }
        });

        talent[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","디자인");
                startActivity(intent);
            }
        });

        talent[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","스포츠");
                startActivity(intent);
            }
        });

        talent[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","생활");
                startActivity(intent);
            }
        });

        talent[9].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","뷰티");
                startActivity(intent);
            }
        });

        talent[10].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","여행");
                startActivity(intent);
            }
        });

        talent[11].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","문화");
                startActivity(intent);
            }
        });

        talent[12].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","사회봉사");
                startActivity(intent);
            }
        });

        talent[13].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","게임");
                startActivity(intent);
            }
        });

        talent[14].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"직접 입력",Toast.LENGTH_SHORT).show();
            }
        });



    }


    
}
