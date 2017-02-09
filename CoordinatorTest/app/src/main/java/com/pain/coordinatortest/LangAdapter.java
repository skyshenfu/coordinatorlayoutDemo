package com.pain.coordinatortest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangty on 2017/2/8.
 */

public class LangAdapter extends RecyclerView.Adapter<LangViewHolder> {
    private ArrayList<String> langList;
    private Context context;
    private LangViewHolder.OnEventListener listener;

    public void setListener(LangViewHolder.OnEventListener listener) {
        this.listener = listener;
    }

    public LangAdapter(Context context) {
        this.context = context;
        langList=new ArrayList<>(Arrays.asList(context.getResources().getStringArray(R.array.text_array)));
    }

    @Override
    public LangViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LangViewHolder viewHolder=new LangViewHolder(LayoutInflater.from(context).inflate(R.layout.item_lang,parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final LangViewHolder holder, int position) {
        //涉及到RecyclerView的元素个数变化时，通过以下操作拿到item真实的position
        holder.tv.setText(langList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int realPosition=holder.getLayoutPosition();
                listener.onClick(v,realPosition);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                 int realPosition=holder.getLayoutPosition();
                removeItem(realPosition);
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return langList.size();

    }
    public void removeItem(int position){
        langList.remove(position);
        notifyItemRemoved(position);
    }
    public void addItem(int position){
        langList.add(position+"new");
        notifyItemInserted(position);
    }
}
class LangViewHolder extends RecyclerView.ViewHolder{
    TextView tv;
    public LangViewHolder(View itemView) {
        super(itemView);
        tv = (TextView)itemView.findViewById(R.id.lang_textview);
    }
    interface OnEventListener{
        void onClick(View view, int position);
        void  onLongClick(View view,int positon);
    }
}
