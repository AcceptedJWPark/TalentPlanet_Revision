package com.example.accepted.Home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    Context mContext;
    ViewPager vp_home;
    DrawerLayout drawerLayout;
    View view_DarawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        mContext = getApplicationContext();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(Color.WHITE);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout_TalentSharing);
        view_DarawerLayout = (View) findViewById(R.id.view_DarawerLayout_Home);

        ((View) findViewById(R.id.view_divider1_toolbar)).setVisibility(View.VISIBLE);
        ((View) findViewById(R.id.view_divider2_toolbar)).setVisibility(View.VISIBLE);
        ((TextView) findViewById(R.id.tv_toolbarTitle)).setText("HOME");
        ((TextView) findViewById(R.id.tv_toolbarTitle)).setVisibility(View.VISIBLE);
        ((ImageView) findViewById(R.id.iv_RightBtn_Toolbar)).setVisibility(View.GONE);
        ((ImageView) findViewById(R.id.iv_LeftBtn_Toolbar)).setVisibility(View.VISIBLE);
        ((ImageView) findViewById(R.id.iv_LeftBtn_Toolbar)).setImageResource(R.drawable.icon_menu);
        ((ImageView) findViewById(R.id.iv_LeftBtn_Toolbar)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(view_DarawerLayout);
            }
        });
        clickTalentCategory();

        vp_home = findViewById(R.id.vp_home);
        vp_home.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("position", position + "");
                if (position%3 == 0)
                {
                    ((ImageView)findViewById(R.id.img_firstImg_Home)).setImageResource(R.drawable.viewpager_selected);
                    ((ImageView)findViewById(R.id.img_secondImg_Home)).setImageResource(R.drawable.viewpager_unselected);
                    ((ImageView)findViewById(R.id.img_thirdImg_Home)).setImageResource(R.drawable.viewpager_unselected);
                }
                else if(position%3 == 1)
                {
                    ((ImageView)findViewById(R.id.img_firstImg_Home)).setImageResource(R.drawable.viewpager_unselected);
                    ((ImageView)findViewById(R.id.img_secondImg_Home)).setImageResource(R.drawable.viewpager_selected);
                    ((ImageView)findViewById(R.id.img_thirdImg_Home)).setImageResource(R.drawable.viewpager_unselected);
                }
                else if(position%3 == 2)
                {
                    ((ImageView)findViewById(R.id.img_firstImg_Home)).setImageResource(R.drawable.viewpager_unselected);
                    ((ImageView)findViewById(R.id.img_secondImg_Home)).setImageResource(R.drawable.viewpager_unselected);
                    ((ImageView)findViewById(R.id.img_thirdImg_Home)).setImageResource(R.drawable.viewpager_selected);
                }

                if(position < 3)
                    vp_home.setCurrentItem(position+3,false);
                else if(position >= 3*2)
                    vp_home.setCurrentItem(position - 3, false);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        vp_home.setAdapter(new pagerAdapter(MainActivity.this));
        vp_home.setCurrentItem(3);



    }

    public int getStatusBarHeight()
    {
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
            result = getResources().getDimensionPixelSize(resourceId);

        return result;
    }


    public void clickTalentCategory()
    {
        final Intent intent= new Intent(mContext, com.example.accepted.TalentSharing.MainActivity.class);

        ((LinearLayout)findViewById(R.id.ll_career_home)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","취업");
                startActivity(intent);
            }
        });

        ((LinearLayout)findViewById(R.id.ll_study_home)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","학습");
                startActivity(intent);
            }
        });

        ((LinearLayout)findViewById(R.id.ll_money_home)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","재테크");
                startActivity(intent);
            }
        });

        ((LinearLayout)findViewById(R.id.ll_it_home)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","IT");
                startActivity(intent);
            }
        });

        ((LinearLayout)findViewById(R.id.ll_camera_home)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","사진");
                startActivity(intent);
            }
        });

        ((LinearLayout)findViewById(R.id.ll_music_home)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","음악");
                startActivity(intent);
            }
        });

        ((LinearLayout)findViewById(R.id.ll_design_home)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","디자인");
                startActivity(intent);
            }
        });

        ((LinearLayout)findViewById(R.id.ll_sports_home)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","스포츠");
                startActivity(intent);
            }
        });

        ((LinearLayout)findViewById(R.id.ll_living_home)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","생활");
                startActivity(intent);
            }
        });

        ((LinearLayout)findViewById(R.id.ll_beauty_home)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","뷰티");
                startActivity(intent);
            }
        });

        ((LinearLayout)findViewById(R.id.ll_travel_home)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","여행");
                startActivity(intent);
            }
        });

        ((LinearLayout)findViewById(R.id.ll_culture_home)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","문화");
                startActivity(intent);
            }
        });

        ((LinearLayout)findViewById(R.id.ll_volunteer_home)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","사회봉사");
                startActivity(intent);
            }
        });

        ((LinearLayout)findViewById(R.id.ll_game_home)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("talentType","게임");
                startActivity(intent);
            }
        });



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
            position %= 3;
            View view = null;
            if(position == 0) {
                view = mInflate.inflate(R.layout.home_viewpager1, null);
                Glide.with(mContext).load(R.drawable.mainbanner1).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE)).into((ImageView) view.findViewById(R.id.viewpager1));
            }
            else if(position == 1)
            {
                view = mInflate.inflate(R.layout.home_viewpager2, null);
                Glide.with(mContext).load(R.drawable.mainbanner2).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE)).into((ImageView)view.findViewById(R.id.viewpager2));
            }
            else{
                view = mInflate.inflate(R.layout.home_viewpager3, null);
                Glide.with(mContext).load(R.drawable.mainbanner3).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.NONE)).into((ImageView)view.findViewById(R.id.viewpager3));
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
            return 3*3;
        }
    }



}
