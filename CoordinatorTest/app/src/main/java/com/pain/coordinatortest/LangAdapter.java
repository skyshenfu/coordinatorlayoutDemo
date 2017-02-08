package com.pain.coordinatortest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by zhangty on 2017/2/8.
 */

public class LangAdapter extends RecyclerView.Adapter<LangViewHolder> {
    private String [] langArray;
    private Context context;

    public LangAdapter(Context context) {
        this.context = context;
        langArray=context.getResources().getStringArray(R.array.text_array);
    }

    @Override
    public LangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LangViewHolder viewHolder=new LangViewHolder(LayoutInflater.from(context).inflate(R.layout.item_lang,parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LangViewHolder holder, int position) {
        holder.tv.setText(position+"XXXX");
    }

    @Override
    public int getItemCount() {
        return langArray.length;

    }
}
class LangViewHolder extends RecyclerView.ViewHolder{
    TextView tv;
    public LangViewHolder(View itemView) {
        super(itemView);
        tv = (TextView)itemView.findViewById(R.id.lang_textview);
    }
}
