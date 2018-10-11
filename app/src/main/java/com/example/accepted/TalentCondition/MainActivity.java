package com.example.accepted.TalentCondition;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.accepted.Home.R;

import java.util.ArrayList;

import static android.graphics.Typeface.BOLD;
import static android.graphics.Typeface.NORMAL;

public class MainActivity extends AppCompatActivity {

    Context mContext;

    ListView lv_progress;
    ArrayList arrayList_progress;
    Lv_Adapter_Progress lv_adapterProgress;


    ListView lv_complete;
    ArrayList arrayList_complete;
    Lv_Adapter_Complete lv_adapter_complete;

    boolean isProgress = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.talentcondition_activity);

        mContext = getApplicationContext();

        lv_progress = findViewById(R.id.lv_talentcondition_progress);
        arrayList_progress = new ArrayList();
        lv_adapterProgress = new Lv_Adapter_Progress(mContext, arrayList_progress);
        arrayList_progress.add(new ListItem_Progress(true,true,"박종우","120","2018.10.7 12:20pm","취업","#해외 취업 #유학 #유학 정보"));
        arrayList_progress.add(new ListItem_Progress(false,true,"민권홍","70","2018.10.3 11:20am","스포츠","#헬스 #운동"));
        arrayList_progress.add(new ListItem_Progress(true,false,"문건우","90","2018.9.11 12:20pm","디자인","#생활 취미 #그림 그리기 #유화"));
        arrayList_progress.add(new ListItem_Progress(true,true,"이태훈","100","2018.9.7 19:20pm","카메라","#사진 스팟 #카메라 정보 #필름 카메라"));
        arrayList_progress.add(new ListItem_Progress(false,false,"우승제","320","2018.8.14 19:20pm","생활","#패션 #쇼핑 #네일 #화장"));
        arrayList_progress.add(new ListItem_Progress(true,true,"김용인","30","2018.7.7 07:20am","학습","#외국어 #영어 #영어 회화 #영어 말하기"));
        lv_progress.setAdapter(lv_adapterProgress);


        lv_complete = findViewById(R.id.lv_talentcondition_complete);
        arrayList_complete = new ArrayList();
        lv_adapter_complete = new Lv_Adapter_Complete(mContext, arrayList_complete);
        arrayList_complete.add(new ListItem_Complete(true,"박종우","120","2018.10.7 12:20pm","취업","#해외 취업 #유학 #유학 정보"));
        arrayList_complete.add(new ListItem_Complete(false,"민권홍","70","2018.10.3 11:20am","스포츠","#헬스 #운동"));
        arrayList_complete.add(new ListItem_Complete(false,"문건우","90","2018.9.11 12:20pm","디자인","#생활 취미 #그림 그리기 #유화"));
        arrayList_complete.add(new ListItem_Complete(true,"이태훈","100","2018.9.7 19:20pm","카메라","#사진 스팟 #카메라 정보 #필름 카메라"));
        arrayList_complete.add(new ListItem_Complete(true,"김용인","30","2018.7.7 07:20am","학습","#외국어 #영어 #영어 회화 #영어 말하기"));
        lv_complete.setAdapter(lv_adapter_complete);


        ((Button)findViewById(R.id.btn_progress_talentcondition)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isProgress = true;
                lv_progress.setVisibility(View.VISIBLE);
                lv_complete.setVisibility(View.GONE);
                ((Button)findViewById(R.id.btn_progress_talentcondition)).setTextColor(getResources().getColor(R.color.colorPrimary));
                ((Button)findViewById(R.id.btn_progress_talentcondition)).setBackgroundResource(R.drawable.bgr_clicked);
                ((Button)findViewById(R.id.btn_progress_talentcondition)).setTypeface(null,BOLD);
                ((Button)findViewById(R.id.btn_complete_talentcondition)).setTextColor(getResources().getColor(R.color.textColor_addtion));
                ((Button)findViewById(R.id.btn_complete_talentcondition)).setBackgroundResource(R.drawable.bgr_unclicked);
                ((Button)findViewById(R.id.btn_complete_talentcondition)).setTypeface(null,NORMAL);

                lv_progress.smoothScrollToPosition(0);
            }
        });

        ((Button)findViewById(R.id.btn_complete_talentcondition)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isProgress = true;
                lv_progress.setVisibility(View.GONE);
                lv_complete.setVisibility(View.VISIBLE);

                ((Button)findViewById(R.id.btn_complete_talentcondition)).setTextColor(getResources().getColor(R.color.colorPrimary));
                ((Button)findViewById(R.id.btn_complete_talentcondition)).setBackgroundResource(R.drawable.bgr_clicked);
                ((Button)findViewById(R.id.btn_complete_talentcondition)).setTypeface(null,BOLD);
                ((Button)findViewById(R.id.btn_progress_talentcondition)).setTextColor(getResources().getColor(R.color.textColor_addtion));
                ((Button)findViewById(R.id.btn_progress_talentcondition)).setBackgroundResource(R.drawable.bgr_unclicked);
                ((Button)findViewById(R.id.btn_progress_talentcondition)).setTypeface(null,NORMAL);

                lv_complete.smoothScrollToPosition(0);
            }
        });





    }
}

