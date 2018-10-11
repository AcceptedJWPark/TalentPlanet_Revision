package com.example.accepted.TalentSharing;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.accepted.Home.R;

import java.util.ArrayList;


public class Lv_Adapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<ListItem> arrayList;

    public Lv_Adapter(Context context, ArrayList<ListItem> arrayList) {
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
            view = LayoutInflater.from(mContext).inflate(R.layout.talentsharing_listviewbg, viewGroup, false);

            holder = new ViewHolder();

            holder.iv_picture = view.findViewById(R.id.iv_picture_TalentSharing);
            holder.tv_name = view.findViewById(R.id.tv_name_TalentSharing);
            holder.tv_txt = view.findViewById(R.id.tv_keyword_TalentSharing);
            holder.tv_distance = view.findViewById(R.id.tv_distance_TalentSharing);


            holder.iv_picture.setImageResource(arrayList.get(position).getPicture());
            holder.tv_name.setText(arrayList.get(position).getName());
            holder.tv_txt.setText(arrayList.get(position).getKeyword());
            holder.tv_distance.setText(arrayList.get(position).getDistance());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,Popup.class);
                    mContext.startActivity(intent);
                }
            });
        }
            return view;

    }

    static class ViewHolder
    {
        ImageView iv_picture;
        TextView tv_name;
        TextView tv_txt;
        TextView tv_distance;
    }


}
