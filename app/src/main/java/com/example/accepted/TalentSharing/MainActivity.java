package com.example.accepted.TalentSharing;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.accepted.Home.R;
import com.example.accepted.TalentResist.MainActivity_big;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    Intent intent;
    String talentType;

    ListView lv_sharinglist;
    Lv_Adapter lv_adapter;
    ArrayList arrayList;
    View header;

    TextView[] tv_career;
    TextView[] tv_study;
    TextView[] tv_money;
    TextView[] tv_it;
    TextView[] tv_camera;
    TextView[] tv_music;
    TextView[] tv_design;
    TextView[] tv_sports;
    TextView[] tv_living;
    TextView[] tv_beauty;
    TextView[] tv_travel;
    TextView[] tv_culture;
    TextView[] tv_volunteer;
    TextView[] tv_game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talentsharing_activity);

        mContext = getApplicationContext();
        intent = getIntent();
        talentType = intent.getStringExtra("talentType");

        talentSelected(talentType);


        lv_sharinglist = findViewById(R.id.lv_talentsharing);
        arrayList = new ArrayList();
        arrayList.add(new ListItem(R.drawable.picture_basic,"박종우","#헬스 #운동 #크로스핏 ","7km"));
        arrayList.add(new ListItem(R.drawable.picture_basic,"민권홍","#필라테스 #요가 #필라테스 강사","15km"));
        arrayList.add(new ListItem(R.drawable.picture_basic,"문건우","#수영 #수영 중급 #자유형 #수영 강사","21km"));
        arrayList.add(new ListItem(R.drawable.picture_basic,"우승제","#야구 #야구 캐치볼 #배팅연습 #투수 # 타자","21km"));
        arrayList.add(new ListItem(R.drawable.picture_basic,"최지웅","#축구 #풋살 #축구 드리블 연습","21km"));
        lv_adapter = new Lv_Adapter(mContext,arrayList);
        lv_sharinglist.setAdapter(lv_adapter);

        header = getLayoutInflater().inflate(R.layout.talentsharing_listview_header, null, false) ;
        lv_sharinglist.addHeaderView(header);



        ((TextView)findViewById(R.id.tv_edit_talentsharing)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MainActivity_big.class);
                startActivity(intent);
            }
        });
    }

    public void talentSelected(String talent)
    {
        talentId();
        ((TextView)findViewById(R.id.tv_talent_talentsharing)).setText(talent);

        if(talent.equals("취업"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentsharing)).setImageResource(R.drawable.test_career);
            ((HorizontalScrollView)findViewById(R.id.hs_career_category)).setVisibility(View.VISIBLE);
            for (int i = 0; i<tv_career.length; i++)
            {
                final int finalI=i;

                tv_career[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickCategoryBackGround(finalI,tv_career);
                    }
                });
            }


        }
        else if(talent.equals("학습"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentsharing)).setImageResource(R.drawable.test_study);
            ((HorizontalScrollView)findViewById(R.id.hs_study_category)).setVisibility(View.VISIBLE);

            for (int i = 0; i<tv_study.length; i++)
            {
                final int finalI=i;
                tv_study[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickCategoryBackGround(finalI,tv_study);
                    }
                });
            }
        }
        else if(talent.equals("재테크"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentsharing)).setImageResource(R.drawable.test_money);
            ((HorizontalScrollView)findViewById(R.id.hs_money_category)).setVisibility(View.VISIBLE);

            for (int i = 0; i<tv_money.length; i++)
            {
                final int finalI=i;
                tv_money[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickCategoryBackGround(finalI,tv_money);
                    }
                });
            }
        }
        else if(talent.equals("IT"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentsharing)).setImageResource(R.drawable.test_it);
            ((HorizontalScrollView)findViewById(R.id.hs_it_category)).setVisibility(View.VISIBLE);

            for (int i = 0; i<tv_it.length; i++)
            {
                final int finalI=i;
                tv_it[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickCategoryBackGround(finalI,tv_it);
                    }
                });
            }
        }
        else if(talent.equals("사진"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentsharing)).setImageResource(R.drawable.test_camera);
            ((HorizontalScrollView)findViewById(R.id.hs_camera_category)).setVisibility(View.VISIBLE);
            for (int i = 0; i<tv_camera.length; i++)
            {
                final int finalI=i;
                tv_camera[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickCategoryBackGround(finalI,tv_camera);
                    }
                });
            }
        }
        else if(talent.equals("음악"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentsharing)).setImageResource(R.drawable.test_music);
            ((HorizontalScrollView)findViewById(R.id.hs_music_category)).setVisibility(View.VISIBLE);

            for (int i = 0; i<tv_music.length; i++)
            {
                final int finalI=i;
                tv_music[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickCategoryBackGround(finalI,tv_music);
                    }
                });
            }
        }
        else if(talent.equals("디자인"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentsharing)).setImageResource(R.drawable.test_design);
            ((HorizontalScrollView)findViewById(R.id.hs_design_category)).setVisibility(View.VISIBLE);

            for (int i = 0; i<tv_design.length; i++)
            {
                final int finalI=i;
                tv_design[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickCategoryBackGround(finalI,tv_design);
                    }
                });
            }
        }
        else if(talent.equals("스포츠"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentsharing)).setImageResource(R.drawable.test_sports);
            ((HorizontalScrollView)findViewById(R.id.hs_sports_category)).setVisibility(View.VISIBLE);

            for (int i = 0; i<tv_sports.length; i++)
            {
                final int finalI=i;
                tv_sports[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickCategoryBackGround(finalI,tv_sports);
                    }
                });
            }
        }
        else if(talent.equals("생활"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentsharing)).setImageResource(R.drawable.test_living);
            ((HorizontalScrollView)findViewById(R.id.hs_living_category)).setVisibility(View.VISIBLE);

            for (int i = 0; i<tv_living.length; i++)
            {
                final int finalI=i;
                tv_living[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickCategoryBackGround(finalI,tv_living);
                    }
                });
            }
        }
        else if(talent.equals("뷰티"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentsharing)).setImageResource(R.drawable.test_beauty);
            ((HorizontalScrollView)findViewById(R.id.hs_beauty_category)).setVisibility(View.VISIBLE);

            for (int i = 0; i<tv_beauty.length; i++)
            {
                final int finalI=i;
                tv_beauty[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickCategoryBackGround(finalI,tv_beauty);
                    }
                });
            }
        }
        else if(talent.equals("여행"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentsharing)).setImageResource(R.drawable.test_travel);
            ((HorizontalScrollView)findViewById(R.id.hs_travel_category)).setVisibility(View.VISIBLE);

            for (int i = 0; i<tv_travel.length; i++)
            {
                final int finalI=i;
                tv_travel[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickCategoryBackGround(finalI,tv_travel);
                    }
                });
            }
        }
        else if(talent.equals("문화"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentsharing)).setImageResource(R.drawable.test_culture);
            ((HorizontalScrollView)findViewById(R.id.hs_culture_category)).setVisibility(View.VISIBLE);

            for (int i = 0; i<tv_culture.length; i++)
            {
                final int finalI=i;
                tv_culture[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickCategoryBackGround(finalI,tv_culture);
                    }
                });
            }
        }
        else if(talent.equals("사회봉사"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentsharing)).setImageResource(R.drawable.test_volunteer);
            ((HorizontalScrollView)findViewById(R.id.hs_volunteer_category)).setVisibility(View.VISIBLE);

            for (int i = 0; i<tv_volunteer.length; i++)
            {
                final int finalI=i;
                tv_volunteer[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickCategoryBackGround(finalI,tv_volunteer);
                    }
                });
            }
        }
        else if(talent.equals("게임"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentsharing)).setImageResource(R.drawable.test_game);
            ((HorizontalScrollView)findViewById(R.id.hs_game_category)).setVisibility(View.VISIBLE);

            for (int i = 0; i<tv_game.length; i++)
            {
                final int finalI=i;
                tv_game[i].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clickCategoryBackGround(finalI,tv_game);
                    }
                });
            }
        }
    }

    public void clickCategoryBackGround(int index, TextView[] tv)
    {

        for(int i=0; i<tv.length; i++)
        {
            if(i==index)
            {
                tv[i].setTextColor(Color.WHITE);
                tv[i].setBackgroundResource(R.drawable.bgr_talentselected);
            }
            else
            {
                tv[i].setTextColor(getResources().getColor(R.color.textColor_object));
                tv[i].setBackgroundResource(R.drawable.bgr_talentunselected);
            }
        }
    }

    public void talentId()
    {
        tv_career = new TextView[6];
        tv_study = new TextView[6];
        tv_money = new TextView[6];
        tv_it = new TextView[8];
        tv_camera = new TextView[6];
        tv_music = new TextView[7];
        tv_design = new TextView[6];
        tv_sports = new TextView[12];
        tv_living = new TextView[7];
        tv_beauty = new TextView[6];
        tv_travel = new TextView[7];
        tv_culture = new TextView[6];
        tv_volunteer = new TextView[5];
        tv_game = new TextView[7];

        tv_career[0] = findViewById(R.id.tv_career1);
        tv_career[1] = findViewById(R.id.tv_career2);
        tv_career[2] = findViewById(R.id.tv_career3);
        tv_career[3] = findViewById(R.id.tv_career4);
        tv_career[4] = findViewById(R.id.tv_career5);
        tv_career[5] = findViewById(R.id.tv_career6);

        tv_study[0] = findViewById(R.id.tv_study1);
        tv_study[1] = findViewById(R.id.tv_study2);
        tv_study[2] = findViewById(R.id.tv_study3);
        tv_study[3] = findViewById(R.id.tv_study4);
        tv_study[4] = findViewById(R.id.tv_study5);
        tv_study[5] = findViewById(R.id.tv_study6);

        tv_money[0] = findViewById(R.id.tv_money1);
        tv_money[1] = findViewById(R.id.tv_money2);
        tv_money[2] = findViewById(R.id.tv_money3);
        tv_money[3] = findViewById(R.id.tv_money4);
        tv_money[4] = findViewById(R.id.tv_money5);
        tv_money[5] = findViewById(R.id.tv_money6);

        tv_it[0] = findViewById(R.id.tv_it1);
        tv_it[1] = findViewById(R.id.tv_it2);
        tv_it[2] = findViewById(R.id.tv_it3);
        tv_it[3] = findViewById(R.id.tv_it4);
        tv_it[4] = findViewById(R.id.tv_it5);
        tv_it[5] = findViewById(R.id.tv_it6);
        tv_it[6] = findViewById(R.id.tv_it7);
        tv_it[7] = findViewById(R.id.tv_it8);

        tv_camera[0] = findViewById(R.id.tv_camera1);
        tv_camera[1] = findViewById(R.id.tv_camera2);
        tv_camera[2] = findViewById(R.id.tv_camera3);
        tv_camera[3] = findViewById(R.id.tv_camera4);
        tv_camera[4] = findViewById(R.id.tv_camera5);
        tv_camera[5] = findViewById(R.id.tv_camera6);
        
        tv_music[0] = findViewById(R.id.tv_music1);
        tv_music[1] = findViewById(R.id.tv_music2);
        tv_music[2] = findViewById(R.id.tv_music3);
        tv_music[3] = findViewById(R.id.tv_music4);
        tv_music[4] = findViewById(R.id.tv_music5);
        tv_music[5] = findViewById(R.id.tv_music6);
        tv_music[6] = findViewById(R.id.tv_music7);

        tv_design[0] = findViewById(R.id.tv_design1);
        tv_design[1] = findViewById(R.id.tv_design2);
        tv_design[2] = findViewById(R.id.tv_design3);
        tv_design[3] = findViewById(R.id.tv_design4);
        tv_design[4] = findViewById(R.id.tv_design5);
        tv_design[5] = findViewById(R.id.tv_design6);

        tv_sports[0] = findViewById(R.id.tv_sports1);
        tv_sports[1] = findViewById(R.id.tv_sports2);
        tv_sports[2] = findViewById(R.id.tv_sports3);
        tv_sports[3] = findViewById(R.id.tv_sports4);
        tv_sports[4] = findViewById(R.id.tv_sports5);
        tv_sports[5] = findViewById(R.id.tv_sports6);
        tv_sports[6] = findViewById(R.id.tv_sports7);
        tv_sports[7] = findViewById(R.id.tv_sports8);
        tv_sports[8] = findViewById(R.id.tv_sports9);
        tv_sports[9] = findViewById(R.id.tv_sports10);
        tv_sports[10] = findViewById(R.id.tv_sports11);
        tv_sports[11] = findViewById(R.id.tv_sports12);

        tv_living[0] = findViewById(R.id.tv_living1);
        tv_living[1] = findViewById(R.id.tv_living2);
        tv_living[2] = findViewById(R.id.tv_living3);
        tv_living[3] = findViewById(R.id.tv_living4);
        tv_living[4] = findViewById(R.id.tv_living5);
        tv_living[5] = findViewById(R.id.tv_living6);
        tv_living[6] = findViewById(R.id.tv_living7);

        tv_beauty[0] = findViewById(R.id.tv_beauty1);
        tv_beauty[1] = findViewById(R.id.tv_beauty2);
        tv_beauty[2] = findViewById(R.id.tv_beauty3);
        tv_beauty[3] = findViewById(R.id.tv_beauty4);
        tv_beauty[4] = findViewById(R.id.tv_beauty5);
        tv_beauty[5] = findViewById(R.id.tv_beauty6);

        tv_travel[0] = findViewById(R.id.tv_travel1);
        tv_travel[1] = findViewById(R.id.tv_travel2);
        tv_travel[2] = findViewById(R.id.tv_travel3);
        tv_travel[3] = findViewById(R.id.tv_travel4);
        tv_travel[4] = findViewById(R.id.tv_travel5);
        tv_travel[5] = findViewById(R.id.tv_travel6);
        tv_travel[6] = findViewById(R.id.tv_travel7);


        tv_culture[0] = findViewById(R.id.tv_culture1);
        tv_culture[1] = findViewById(R.id.tv_culture2);
        tv_culture[2] = findViewById(R.id.tv_culture3);
        tv_culture[3] = findViewById(R.id.tv_culture4);
        tv_culture[4] = findViewById(R.id.tv_culture5);
        tv_culture[5] = findViewById(R.id.tv_culture6);

        tv_volunteer[0] = findViewById(R.id.tv_volunteer1);
        tv_volunteer[1] = findViewById(R.id.tv_volunteer2);
        tv_volunteer[2] = findViewById(R.id.tv_volunteer3);
        tv_volunteer[3] = findViewById(R.id.tv_volunteer4);
        tv_volunteer[4] = findViewById(R.id.tv_volunteer5);


        tv_game[0] = findViewById(R.id.tv_game1);
        tv_game[1] = findViewById(R.id.tv_game2);
        tv_game[2] = findViewById(R.id.tv_game3);
        tv_game[3] = findViewById(R.id.tv_game4);
        tv_game[4] = findViewById(R.id.tv_game5);
        tv_game[5] = findViewById(R.id.tv_game6);
        tv_game[6] = findViewById(R.id.tv_game7);


        
        
    }
}
