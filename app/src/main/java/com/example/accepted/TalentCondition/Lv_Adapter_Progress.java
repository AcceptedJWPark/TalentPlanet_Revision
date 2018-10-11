package com.example.accepted.TalentCondition;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.accepted.Home.R;
import com.example.accepted.TalentSharing.Popup;

import java.util.ArrayList;


public class Lv_Adapter_Progress extends BaseAdapter {

    private Context mContext;
    private ArrayList<ListItem_Progress> arrayList;

    public Lv_Adapter_Progress(Context context, ArrayList<ListItem_Progress> arrayList) {
        this.mContext = context;
        this.arrayList = arrayList;
    }


    @Override
    public int getCount() {
        return this.arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final int index = position;

        View view = convertView;
        final ViewHolder holder;
        view = null;


        if(view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.talentcondition_listviewbg, viewGroup, false);
            holder = new ViewHolder();

            ShapeDrawable drawable =new ShapeDrawable(new OvalShape());
            drawable.getPaint().setColor(Color.WHITE);
            drawable.getPaint().setStyle(Paint.Style.STROKE);
            ((RelativeLayout)view.findViewById(R.id.rl_picture_talentcondition_listview)).setBackground(drawable);
            ((RelativeLayout)view.findViewById(R.id.rl_picture_talentcondition_listview)).setClipToOutline(true);

            ((RelativeLayout)view.findViewById(R.id.rl_picture_talentcondition_listview)).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(mContext, Popup.class);
                    mContext.startActivity(intent);
                }
            });

            holder.tv_mentor = view.findViewById(R.id.tv_mentor_talentcondition_listview);
            holder.tv_name = view.findViewById(R.id.tv_name_talentcondition_listview);
            holder.tv_point = view.findViewById(R.id.tv_point_talentcondition_listview);
            holder.tv_point2 = view.findViewById(R.id.tv_point2_talentcondition_listview);
            holder.tv_date = view.findViewById(R.id.tv_date_talentcondition_listview);
            holder.tv_talent1 = view.findViewById(R.id.tv_talent1_talentcondition_listview);
            holder.tv_talent2 = view.findViewById(R.id.tv_talent2_talentcondition_listview);
            holder.iv_talent = view.findViewById(R.id.iv_talent_talentcondition_listview);
            holder.btn_progress = view.findViewById(R.id.btn_progress_talentcondition_listview);

            ((TextView)view.findViewById(R.id.tv_point3_talentcondition_listview)).setText("재능공유 진행 시 ");

            String nameTxt;
            String dateTxt;

            if(arrayList.get(position).isIsmentor())
            {
                holder.tv_point.setTextColor(view.getResources().getColor(R.color.loginPasswordLost));
                holder.tv_point.setText("-" + arrayList.get(position).getPoint() + "P");
                holder.tv_point2.setText(" 차감 됩니다.");
                if (arrayList.get(position).isIsrequest())
                {
                    nameTxt = arrayList.get(position).getName() + " 멘토가 재능공유를" + " 요청하였습니다.";
                    dateTxt = arrayList.get(position).getDate() + "에 요청받음";
                    holder.btn_progress.setText("진행");
                    holder.btn_progress.setBackgroundResource(R.drawable.bgr_talentcondition_okbtn);

                }
                else
                {
                    nameTxt = arrayList.get(position).getName() + " 멘토에게 재능공유를" + " 요청하였습니다.";
                    dateTxt = arrayList.get(position).getDate() + "에 요청함";
                    holder.btn_progress.setText("대기 중");
                    holder.btn_progress.setBackgroundResource(R.drawable.bgr_talentcondition_waitbtn);
                }

                holder.tv_mentor.setText("Mentor");
            }
            else
            {
                holder.tv_point.setTextColor(view.getResources().getColor(R.color.colorPrimary));
                holder.tv_point.setText("+" + arrayList.get(position).getPoint() + "P");
                holder.tv_point2.setText(" 적립 됩니다.");

                if (arrayList.get(position).isIsrequest())
                {
                    nameTxt = arrayList.get(position).getName() + " 멘티가 재능 공유를" + " 요청하였습니다.";
                    dateTxt = arrayList.get(position).getDate() + "에 요청받음";
                    holder.btn_progress.setText("진행");
                    holder.btn_progress.setBackgroundResource(R.drawable.bgr_talentcondition_okbtn);
                }
                else
                {
                    nameTxt = arrayList.get(position).getName() + " 멘티에게 재능 공유를" + " 요청하였습니다.";
                    dateTxt = arrayList.get(position).getDate() + "에 요청함";
                    holder.btn_progress.setText("대기 중");
                    holder.btn_progress.setBackgroundResource(R.drawable.bgr_talentcondition_waitbtn);
                }

                holder.tv_mentor.setText("Mentee");
            }
            holder.tv_name.setText(nameTxt);
            holder.tv_date.setText(dateTxt);
            talentCategory(arrayList.get(position).getTalent1(),holder.iv_talent,holder.tv_talent1);
            holder.tv_talent2.setText(arrayList.get(position).getTalent2());

        }
            return view;

    }

    static class ViewHolder
    {
        TextView tv_mentor;
        TextView tv_name;
        TextView tv_point;
        TextView tv_point2;
        TextView tv_date;
        TextView tv_talent1;
        TextView tv_talent2;
        ImageView iv_talent;
        Button btn_progress;

    }

    public void talentCategory(String talent, ImageView iv, TextView tv) {
        tv.setText(talent);
        if (talent.equals("취업"))
        {
            iv.setImageResource(R.drawable.test_career);
        } else if (talent.equals("학습")) {
            iv.setImageResource(R.drawable.test_study);
        } else if (talent.equals("재테크")) {
            iv.setImageResource(R.drawable.test_money);
        } else if (talent.equals("IT")) {
            iv.setImageResource(R.drawable.test_it);
        } else if (talent.equals("사진")) {
            iv.setImageResource(R.drawable.test_camera);
        } else if (talent.equals("음악")) {
            iv.setImageResource(R.drawable.test_music);
        } else if (talent.equals("디자인")) {
            iv.setImageResource(R.drawable.test_design);
        } else if (talent.equals("스포츠")) {
            iv.setImageResource(R.drawable.test_sports);
        } else if (talent.equals("생활")) {
            iv.setImageResource(R.drawable.test_living);
        } else if (talent.equals("뷰티")) {
            iv.setImageResource(R.drawable.test_beauty);
        } else if (talent.equals("여행")) {
            iv.setImageResource(R.drawable.test_travel);
        } else if (talent.equals("문화")) {
            iv.setImageResource(R.drawable.test_culture);
        } else if (talent.equals("사회봉사")) {
            iv.setImageResource(R.drawable.test_volunteer);
        } else if (talent.equals("게임")) {
            iv.setImageResource(R.drawable.test_game);
        }
    }



}
