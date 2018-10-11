package com.example.accepted.Join;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.accepted.Home.R;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    ViewPager vp_join;
    int viewpagerPosition = 0;

    View v_mentor[];
    TextView tv_mentor[];
    ImageView iv_mentor[];
    LinearLayout ll_mentor[];

    View v_mentee[];
    TextView tv_mentee[];
    ImageView iv_mentee[];
    LinearLayout ll_mentee[];

    Button [] btn_jointype;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.join_activity);

        mContext = getApplicationContext();

        ((TextView) findViewById(R.id.tv_toolbarTitle)).setText("JOIN US");
        ((ImageView) findViewById(R.id.iv_RightBtn_Toolbar)).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.tv_RightBtn_Toolbar)).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.tv_RightBtn_Toolbar)).setText("다음");
        ((ImageView) findViewById(R.id.iv_LeftBtn_Toolbar)).setVisibility(View.GONE);
        ((TextView) findViewById(R.id.tv_LeftBtn_Toolbar)).setText("이전");
        ((TextView) findViewById(R.id.tv_LeftBtn_Toolbar)).setTextColor(getResources().getColor(R.color.textColor_addtion));

        btn_jointype = new Button[4];
        btn_jointype[0] = findViewById(R.id.btn_basicinfo_join);
        btn_jointype[1] = findViewById(R.id.btn_location_join);
        btn_jointype[2] = findViewById(R.id.btn_mentor_join);
        btn_jointype[3] = findViewById(R.id.btn_mentee_join);
        vp_join = findViewById(R.id.vp_join);
        vp_join.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("position", position + "");
                if (position%4 == 0)
                {
                    ((TextView) findViewById(R.id.tv_RightBtn_Toolbar)).setText("다음");
                    ((TextView) findViewById(R.id.tv_LeftBtn_Toolbar)).setText("이전");
                    ((TextView) findViewById(R.id.tv_LeftBtn_Toolbar)).setTextColor(getResources().getColor(R.color.textColor_addtion));
                    buttonClick(0,btn_jointype);
                }
                else if(position%4 == 1)
                {
                    ((TextView) findViewById(R.id.tv_RightBtn_Toolbar)).setText("다음");
                    ((TextView) findViewById(R.id.tv_LeftBtn_Toolbar)).setText("이전");
                    ((TextView) findViewById(R.id.tv_LeftBtn_Toolbar)).setTextColor(Color.BLACK);
                    buttonClick(1,btn_jointype);
                }
                else if(position%4 == 2)
                {
                    ((TextView) findViewById(R.id.tv_RightBtn_Toolbar)).setText("다음");
                    ((TextView) findViewById(R.id.tv_LeftBtn_Toolbar)).setText("이전");
                    ((TextView) findViewById(R.id.tv_LeftBtn_Toolbar)).setTextColor(Color.BLACK);
                    buttonClick(2,btn_jointype);
                }
                else{
                    ((TextView) findViewById(R.id.tv_RightBtn_Toolbar)).setText("완료");
                    ((TextView) findViewById(R.id.tv_LeftBtn_Toolbar)).setText("이전");
                    ((TextView) findViewById(R.id.tv_LeftBtn_Toolbar)).setTextColor(Color.BLACK);
                    buttonClick(3,btn_jointype);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        vp_join.setAdapter(new com.example.accepted.Join.MainActivity.pagerAdapter(com.example.accepted.Join.MainActivity.this));
        vp_join.setCurrentItem(viewpagerPosition);

        for (int i = 0; i<btn_jointype.length; i++)
        {
            final int finalI=i;
            btn_jointype[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonClick(finalI,btn_jointype);
                }
            });
        }


        ((TextView) findViewById(R.id.tv_RightBtn_Toolbar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewpagerPosition<3)
                {viewpagerPosition++;}
                buttonClick(viewpagerPosition,btn_jointype);
                vp_join.setCurrentItem(viewpagerPosition);
            }
        });

        ((TextView) findViewById(R.id.tv_LeftBtn_Toolbar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewpagerPosition>0) {
                    viewpagerPosition--;
                    buttonClick(viewpagerPosition,btn_jointype);
                    vp_join.setCurrentItem(viewpagerPosition);
                }
            }
        });


    }

    public void buttonClick(int index, Button btn[])
    {
        for(int i=0; i<btn.length; i++)
        {
            if(i==index) {
                btn[i].setBackgroundResource(R.drawable.bgr_clicked);
                btn[i].setTextColor(getResources().getColor(R.color.colorPrimary));
                btn[i].setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources().getDimension(R.dimen.SubTxt));
                viewpagerPosition = i;
                vp_join.setCurrentItem(viewpagerPosition);
            }
            else
            {
                btn[i].setBackgroundResource(R.drawable.bgr_unclicked);
                btn[i].setTextColor(getResources().getColor(R.color.textColor_addtion));
                btn[i].setTextSize(TypedValue.COMPLEX_UNIT_PX, mContext.getResources().getDimension(R.dimen.AdditionTxt));
            }
        }
    }


    public void talentClick(int index, TextView tv[], ImageView iv[], View v[])
    {
        for(int i=0; i<tv.length; i++)
        {
            if(i==index) {
                tv[i].setBackgroundColor(Color.argb(0,0,0,0));
                v[i].setVisibility(View.VISIBLE);
                iv[i].setVisibility(View.VISIBLE);
            }
            else
            {
                tv[i].setBackgroundColor(Color.argb(95,0,0,0));
                v[i].setVisibility(View.GONE);
                iv[i].setVisibility(View.GONE);

            }
        }
    }

    private class pagerAdapter extends PagerAdapter
    {

        private LayoutInflater mInflate;

        public pagerAdapter(Context context) {
            super();
            mInflate = LayoutInflater.from(context);
        }

        @Override
        public Object instantiateItem(ViewGroup pager, int position)
        {
            View view = null;


            if(position == 0) {
                view = mInflate.inflate(R.layout.join_viewpager1, null);
                RelativeLayout rl_picture_join = view.findViewById(R.id.rl_picture_join);
                ShapeDrawable drawable =new ShapeDrawable(new OvalShape());
                drawable.getPaint().setColor(Color.WHITE);
                drawable.getPaint().setStyle(Paint.Style.STROKE);
                rl_picture_join.setBackground(drawable);
                rl_picture_join.setClipToOutline(true);


                final TextView tv_manselect = view.findViewById(R.id.tv_manselect_join);
                final TextView tv_womanselect = view.findViewById(R.id.tv_womanselect_join);
                tv_manselect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tv_manselect.setBackgroundResource(R.drawable.bgr_joininput_genderselect);
                        tv_manselect.setTextColor(Color.WHITE);
                        tv_womanselect.setTextColor(getResources().getColor(R.color.textColor_object));
                        tv_womanselect.setBackgroundResource(R.drawable.bgr_joininput);
                    }
                });
                tv_womanselect.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tv_womanselect.setBackgroundResource(R.drawable.bgr_joininput_genderselect);
                        tv_womanselect.setTextColor(Color.WHITE);
                        tv_manselect.setTextColor(getResources().getColor(R.color.textColor_object));
                        tv_manselect.setBackgroundResource(R.drawable.bgr_joininput);
                    }
                });

            }
            else if(position == 1)
            {
                view = mInflate.inflate(R.layout.join_viewpager2, null);

            }
            else if(position == 2)
            {
                view = mInflate.inflate(R.layout.join_viewpager3, null);
                mentorTalentId(view);
            }
            else{
                view = mInflate.inflate(R.layout.join_viewpager4, null);
                menteeTalentId(view);
            }
            pager.addView(view, 0);
            return view;
        }

        public void destroyItem(ViewGroup pager, int position, Object view)
        {
            pager.removeView((View)view);
        }

        public boolean isViewFromObject(View pager, Object obj)
        {
            return pager == obj;
        }

        public void restoreState(Parcelable arg0, ClassLoader arg1) {}
        public Parcelable saveState() { return null; }
        public void startUpdate(ViewGroup arg0) {}
        public void finishUpdate(ViewGroup arg0) {}

        @Override
        public int getCount() {
            return 4;
        }
    }

    public void mentorTalentId(View view)
    {
        tv_mentor = new TextView[15];
        iv_mentor = new ImageView[15];
        ll_mentor = new LinearLayout[15];
        v_mentor = new View[15];

        v_mentor[0] = view.findViewById(R.id.view_mentor_career_join);
        v_mentor[1] = view.findViewById(R.id.view_mentor_study_join);
        v_mentor[2] = view.findViewById(R.id.view_mentor_money_join);
        v_mentor[3] = view.findViewById(R.id.view_mentor_it_join);
        v_mentor[4] = view.findViewById(R.id.view_mentor_camera_join);
        v_mentor[5] = view.findViewById(R.id.view_mentor_music_join);
        v_mentor[6] = view.findViewById(R.id.view_mentor_design_join);
        v_mentor[7] = view.findViewById(R.id.view_mentor_sports_join);
        v_mentor[8] = view.findViewById(R.id.view_mentor_living_join);
        v_mentor[9] = view.findViewById(R.id.view_mentor_beauty_join);
        v_mentor[10] = view.findViewById(R.id.view_mentor_travel_join);
        v_mentor[11] = view.findViewById(R.id.view_mentor_culture_join);
        v_mentor[12] = view.findViewById(R.id.view_mentor_volunteer_join);
        v_mentor[13] = view.findViewById(R.id.view_mentor_game_join);
        v_mentor[14] = view.findViewById(R.id.view_mentor_add_join);

        tv_mentor[0] = view.findViewById(R.id.tv_mentor_career_join);
        tv_mentor[1] = view.findViewById(R.id.tv_mentor_study_join);
        tv_mentor[2] = view.findViewById(R.id.tv_mentor_money_join);
        tv_mentor[3] = view.findViewById(R.id.tv_mentor_it_join);
        tv_mentor[4] = view.findViewById(R.id.tv_mentor_camera_join);
        tv_mentor[5] = view.findViewById(R.id.tv_mentor_music_join);
        tv_mentor[6] = view.findViewById(R.id.tv_mentor_design_join);
        tv_mentor[7] = view.findViewById(R.id.tv_mentor_sports_join);
        tv_mentor[8] = view.findViewById(R.id.tv_mentor_living_join);
        tv_mentor[9] = view.findViewById(R.id.tv_mentor_beauty_join);
        tv_mentor[10] = view.findViewById(R.id.tv_mentor_travel_join);
        tv_mentor[11] = view.findViewById(R.id.tv_mentor_culture_join);
        tv_mentor[12] = view.findViewById(R.id.tv_mentor_volunteer_join);
        tv_mentor[13] = view.findViewById(R.id.tv_mentor_game_join);
        tv_mentor[14] = view.findViewById(R.id.tv_mentor_add_join);

        iv_mentor[0] = view.findViewById(R.id.iv_mentor_career_join);
        iv_mentor[1] = view.findViewById(R.id.iv_mentor_study_join);
        iv_mentor[2] = view.findViewById(R.id.iv_mentor_money_join);
        iv_mentor[3] = view.findViewById(R.id.iv_mentor_it_join);
        iv_mentor[4] = view.findViewById(R.id.iv_mentor_camera_join);
        iv_mentor[5] = view.findViewById(R.id.iv_mentor_music_join);
        iv_mentor[6] = view.findViewById(R.id.iv_mentor_design_join);
        iv_mentor[7] = view.findViewById(R.id.iv_mentor_sports_join);
        iv_mentor[8] = view.findViewById(R.id.iv_mentor_living_join);
        iv_mentor[9] = view.findViewById(R.id.iv_mentor_beauty_join);
        iv_mentor[10] = view.findViewById(R.id.iv_mentor_travel_join);
        iv_mentor[11] = view.findViewById(R.id.iv_mentor_culture_join);
        iv_mentor[12] = view.findViewById(R.id.iv_mentor_volunteer_join);
        iv_mentor[13] = view.findViewById(R.id.iv_mentor_game_join);
        iv_mentor[14] = view.findViewById(R.id.iv_mentor_add_join);

        ll_mentor[0] = view.findViewById(R.id.ll_mentor_career_join);
        ll_mentor[1] = view.findViewById(R.id.ll_mentor_study_join);
        ll_mentor[2] = view.findViewById(R.id.ll_mentor_money_join);
        ll_mentor[3] = view.findViewById(R.id.ll_mentor_it_join);
        ll_mentor[4] = view.findViewById(R.id.ll_mentor_camera_join);
        ll_mentor[5] = view.findViewById(R.id.ll_mentor_music_join);
        ll_mentor[6] = view.findViewById(R.id.ll_mentor_design_join);
        ll_mentor[7] = view.findViewById(R.id.ll_mentor_sports_join);
        ll_mentor[8] = view.findViewById(R.id.ll_mentor_living_join);
        ll_mentor[9] = view.findViewById(R.id.ll_mentor_beauty_join);
        ll_mentor[10] = view.findViewById(R.id.ll_mentor_travel_join);
        ll_mentor[11] = view.findViewById(R.id.ll_mentor_culture_join);
        ll_mentor[12] = view.findViewById(R.id.ll_mentor_volunteer_join);
        ll_mentor[13] = view.findViewById(R.id.ll_mentor_game_join);
        ll_mentor[14] = view.findViewById(R.id.ll_mentor_add_join);

        for(int i=0; i<ll_mentor.length; i++)
        {
            final int finalI = i;
            ll_mentor[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    talentClick(finalI,tv_mentor,iv_mentor,v_mentor);
                }
            });
        }

    }

    public void menteeTalentId(View view)
    {
        tv_mentee = new TextView[15];
        iv_mentee = new ImageView[15];
        ll_mentee = new LinearLayout[15];
        v_mentee = new View[15];

        v_mentee[0] = view.findViewById(R.id.view_mentee_career_join);
        v_mentee[1] = view.findViewById(R.id.view_mentee_study_join);
        v_mentee[2] = view.findViewById(R.id.view_mentee_money_join);
        v_mentee[3] = view.findViewById(R.id.view_mentee_it_join);
        v_mentee[4] = view.findViewById(R.id.view_mentee_camera_join);
        v_mentee[5] = view.findViewById(R.id.view_mentee_music_join);
        v_mentee[6] = view.findViewById(R.id.view_mentee_design_join);
        v_mentee[7] = view.findViewById(R.id.view_mentee_sports_join);
        v_mentee[8] = view.findViewById(R.id.view_mentee_living_join);
        v_mentee[9] = view.findViewById(R.id.view_mentee_beauty_join);
        v_mentee[10] = view.findViewById(R.id.view_mentee_travel_join);
        v_mentee[11] = view.findViewById(R.id.view_mentee_culture_join);
        v_mentee[12] = view.findViewById(R.id.view_mentee_volunteer_join);
        v_mentee[13] = view.findViewById(R.id.view_mentee_game_join);
        v_mentee[14] = view.findViewById(R.id.view_mentee_add_join);

        tv_mentee[0] = view.findViewById(R.id.tv_mentee_career_join);
        tv_mentee[1] = view.findViewById(R.id.tv_mentee_study_join);
        tv_mentee[2] = view.findViewById(R.id.tv_mentee_money_join);
        tv_mentee[3] = view.findViewById(R.id.tv_mentee_it_join);
        tv_mentee[4] = view.findViewById(R.id.tv_mentee_camera_join);
        tv_mentee[5] = view.findViewById(R.id.tv_mentee_music_join);
        tv_mentee[6] = view.findViewById(R.id.tv_mentee_design_join);
        tv_mentee[7] = view.findViewById(R.id.tv_mentee_sports_join);
        tv_mentee[8] = view.findViewById(R.id.tv_mentee_living_join);
        tv_mentee[9] = view.findViewById(R.id.tv_mentee_beauty_join);
        tv_mentee[10] = view.findViewById(R.id.tv_mentee_travel_join);
        tv_mentee[11] = view.findViewById(R.id.tv_mentee_culture_join);
        tv_mentee[12] = view.findViewById(R.id.tv_mentee_volunteer_join);
        tv_mentee[13] = view.findViewById(R.id.tv_mentee_game_join);
        tv_mentee[14] = view.findViewById(R.id.tv_mentee_add_join);

        iv_mentee[0] = view.findViewById(R.id.iv_mentee_career_join);
        iv_mentee[1] = view.findViewById(R.id.iv_mentee_study_join);
        iv_mentee[2] = view.findViewById(R.id.iv_mentee_money_join);
        iv_mentee[3] = view.findViewById(R.id.iv_mentee_it_join);
        iv_mentee[4] = view.findViewById(R.id.iv_mentee_camera_join);
        iv_mentee[5] = view.findViewById(R.id.iv_mentee_music_join);
        iv_mentee[6] = view.findViewById(R.id.iv_mentee_design_join);
        iv_mentee[7] = view.findViewById(R.id.iv_mentee_sports_join);
        iv_mentee[8] = view.findViewById(R.id.iv_mentee_living_join);
        iv_mentee[9] = view.findViewById(R.id.iv_mentee_beauty_join);
        iv_mentee[10] = view.findViewById(R.id.iv_mentee_travel_join);
        iv_mentee[11] = view.findViewById(R.id.iv_mentee_culture_join);
        iv_mentee[12] = view.findViewById(R.id.iv_mentee_volunteer_join);
        iv_mentee[13] = view.findViewById(R.id.iv_mentee_game_join);
        iv_mentee[14] = view.findViewById(R.id.iv_mentee_add_join);

        ll_mentee[0] = view.findViewById(R.id.ll_mentee_career_join);
        ll_mentee[1] = view.findViewById(R.id.ll_mentee_study_join);
        ll_mentee[2] = view.findViewById(R.id.ll_mentee_money_join);
        ll_mentee[3] = view.findViewById(R.id.ll_mentee_it_join);
        ll_mentee[4] = view.findViewById(R.id.ll_mentee_camera_join);
        ll_mentee[5] = view.findViewById(R.id.ll_mentee_music_join);
        ll_mentee[6] = view.findViewById(R.id.ll_mentee_design_join);
        ll_mentee[7] = view.findViewById(R.id.ll_mentee_sports_join);
        ll_mentee[8] = view.findViewById(R.id.ll_mentee_living_join);
        ll_mentee[9] = view.findViewById(R.id.ll_mentee_beauty_join);
        ll_mentee[10] = view.findViewById(R.id.ll_mentee_travel_join);
        ll_mentee[11] = view.findViewById(R.id.ll_mentee_culture_join);
        ll_mentee[12] = view.findViewById(R.id.ll_mentee_volunteer_join);
        ll_mentee[13] = view.findViewById(R.id.ll_mentee_game_join);
        ll_mentee[14] = view.findViewById(R.id.ll_mentee_add_join);

        for(int i=0; i<ll_mentee.length; i++)
        {
            final int finalI = i;
            ll_mentee[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    talentClick(finalI,tv_mentee,iv_mentee,v_mentee);
                }
            });
        }

    }


}
