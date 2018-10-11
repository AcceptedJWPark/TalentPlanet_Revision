package com.example.accepted.TalentResist;

import android.content.Context;
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
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        final int index = position;

        View view = convertView;
        final ViewHolder holder;
        view = null;


        if(view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.lv_keyword_bgr, viewGroup, false);

            holder = new ViewHolder();

            holder.tv_talent = view.findViewById(R.id.tv_talentkeyword_lv);
            holder.iv_delete = view.findViewById(R.id.iv_delete_lv);

            holder.tv_talent.setText(arrayList.get(position).getTalent());
            holder.iv_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    arrayList.remove(position);
                    notifyDataSetChanged();
                }
            });

        }
            return view;

    }

    static class ViewHolder
    {
        TextView tv_talent;
        ImageView iv_delete;
    }


}
