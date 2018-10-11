package com.example.accepted.TalentResist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.accepted.Home.R;

import java.util.ArrayList;

public class MainActivity_small extends AppCompatActivity {

    Context mContext;
    EditText et_keyword;
    private Lv_Adapter lv_adapter;
    ListView talent_listView;
    ArrayList<ListItem> talent_keyword;
    Intent intent;


    String[] career;
    String[] study;
    String[] money;
    String[] it;
    String[] camera;
    String[] music;
    String[] design;
    String[] sports;
    String[] living;
    String[] beauty;
    String[] travel;
    String[] culture;
    String[] volunteer;
    String[] game;


    String talentType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talentresist_small_activity);

        mContext = getApplicationContext();


        ((View) findViewById(R.id.view_divider1_toolbar)).setVisibility(View.GONE);
        ((View) findViewById(R.id.view_divider2_toolbar)).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.tv_toolbarTitle)).setText("Mentor 등록");
        ((TextView) findViewById(R.id.tv_toolbarTitle)).setVisibility(View.VISIBLE);
        ((ImageView) findViewById(R.id.iv_RightBtn_Toolbar)).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.tv_RightBtn_Toolbar)).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.tv_RightBtn_Toolbar)).setText("완료");
        ((ImageView) findViewById(R.id.iv_LeftBtn_Toolbar)).setVisibility(View.VISIBLE);
        ((ImageView) findViewById(R.id.iv_LeftBtn_Toolbar)).setImageResource(R.drawable.icon_backbtn);
        ((ImageView) findViewById(R.id.iv_LeftBtn_Toolbar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        ((LinearLayout)findViewById(R.id.ll_addTalent_talentresist)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                talent_keyword.add(0,new ListItem(et_keyword.getText().toString()));
                talent_listView.setAdapter(lv_adapter);
                et_keyword.setText("");
            }
        });



        intent = getIntent();
        talentType = intent.getStringExtra("talentType");

        talent_listView = findViewById(R.id.lv_talent_listView);
        talent_keyword = new ArrayList<ListItem>();
        talentSelected(talentType);

        et_keyword = findViewById(R.id.et_keyword_talentresist_small);
        et_keyword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(et_keyword.length()==0)
                {
                    ((TextView)findViewById(R.id.tv_keyword_talentresist_small)).setTextColor(Color.argb(255,128,128,128));
                }
                else
                {
                    ((TextView)findViewById(R.id.tv_keyword_talentresist_small)).setTextColor(Color.BLACK);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    public void talentSelected(String talent)
    {
        talentCategory();
        lv_adapter = new Lv_Adapter(this,talent_keyword);
        ((TextView)findViewById(R.id.tv_talent_talentresist_small)).setText(talent);


        if(talent.equals("취업"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentresist_small)).setImageResource(R.drawable.test_career);
            for(int i=0; i<career.length; i++)
            {
                talent_keyword.add(new ListItem(career[i]));
            }
        }
        else if(talent.equals("학습"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentresist_small)).setImageResource(R.drawable.test_study);
            for(int i=0; i<study.length; i++)
            {
                talent_keyword.add(new ListItem(study[i]));
            }
        }
        else if(talent.equals("재테크"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentresist_small)).setImageResource(R.drawable.test_money);
            for(int i=0; i<money.length; i++)
            {
                talent_keyword.add(new ListItem(money[i]));
            }
        }
        else if(talent.equals("IT"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentresist_small)).setImageResource(R.drawable.test_it);
            for(int i=0; i<it.length; i++)
            {
                talent_keyword.add(new ListItem(it[i]));
            }
        }
        else if(talent.equals("사진"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentresist_small)).setImageResource(R.drawable.test_camera);
            for(int i=0; i<camera.length; i++)
            {
                talent_keyword.add(new ListItem(camera[i]));
            }
        }
        else if(talent.equals("음악"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentresist_small)).setImageResource(R.drawable.test_music);
            for(int i=0; i<music.length; i++)
            {
                talent_keyword.add(new ListItem(music[i]));
            }
        }
        else if(talent.equals("디자인"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentresist_small)).setImageResource(R.drawable.test_design);
            for(int i=0; i<design.length; i++)
            {
                talent_keyword.add(new ListItem(design[i]));
            }
        }
        else if(talent.equals("스포츠"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentresist_small)).setImageResource(R.drawable.test_sports);
            for(int i=0; i<sports.length; i++)
            {
                talent_keyword.add(new ListItem(sports[i]));
            }
        }
        else if(talent.equals("생활"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentresist_small)).setImageResource(R.drawable.test_living);
            for(int i=0; i<living.length; i++)
            {
                talent_keyword.add(new ListItem(living[i]));
            }
        }
        else if(talent.equals("뷰티"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentresist_small)).setImageResource(R.drawable.test_beauty);
            for(int i=0; i<beauty.length; i++)
            {
                talent_keyword.add(new ListItem(beauty[i]));
            }
        }
        else if(talent.equals("여행"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentresist_small)).setImageResource(R.drawable.test_travel);
            for(int i=0; i<travel.length; i++)
            {
                talent_keyword.add(new ListItem(travel[i]));
            }
        }
        else if(talent.equals("문화"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentresist_small)).setImageResource(R.drawable.test_culture);
            for(int i=0; i<culture.length; i++)
            {
                talent_keyword.add(new ListItem(culture[i]));
            }
        }
        else if(talent.equals("사회봉사"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentresist_small)).setImageResource(R.drawable.test_volunteer);
            for(int i=0; i<volunteer.length; i++)
            {
                talent_keyword.add(new ListItem(volunteer[i]));
            }
        }
        else if(talent.equals("게임"))
        {
            ((ImageView)findViewById(R.id.iv_talent_talentresist_small)).setImageResource(R.drawable.test_game);
            for(int i=0; i<game.length; i++)
            {
                talent_keyword.add(new ListItem(game[i]));
            }
        }
        talent_listView.setAdapter(lv_adapter);
    }



    public void talentCategory()
    {
        career = getResources().getStringArray(R.array.career);
        study = getResources().getStringArray(R.array.study);
        money = getResources().getStringArray(R.array.money);
        it = getResources().getStringArray(R.array.it);
        camera = getResources().getStringArray(R.array.camera);
        music = getResources().getStringArray(R.array.music);
        design = getResources().getStringArray(R.array.design);
        sports = getResources().getStringArray(R.array.sports);
        living = getResources().getStringArray(R.array.living);
        beauty = getResources().getStringArray(R.array.beauty);
        travel = getResources().getStringArray(R.array.travel);
        culture = getResources().getStringArray(R.array.culture);
        volunteer = getResources().getStringArray(R.array.volunteer);
        game = getResources().getStringArray(R.array.game);
    }
}
