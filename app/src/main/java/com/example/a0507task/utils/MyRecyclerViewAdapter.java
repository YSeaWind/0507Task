package com.example.a0507task.utils;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a0507task.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder> {
    private List<Message> messageList;
    private Context context;
    private int pos;//给改变的页面一个标签，用于判断
    public MyRecyclerViewAdapter(List<Message> messageList, Context context) {
        this.messageList = messageList;
        this.context = context;
    }
    class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        //itemView 表示item布局
        public ViewHolder(@NonNull View itemView) {

            super(itemView);

            textView = itemView.findViewById(R.id.tv_r_item);


        }
    }
    //利用系统的点击事件的接口自定义自己想要用的接口
    private OnItemClickListener onItemClickListener;
    public void  setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener{
        void OnItemClick(View view);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //找到加载布局item
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_item, null);
        //获取返回值viewHolder
        ViewHolder viewHolder = new ViewHolder(view);
        //itemview表示每一个item布局对象   给item对象设置点击事件
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.OnItemClick(view);
            }
        });

        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (pos==position){
            holder.textView.setBackground(context.getDrawable(R.drawable.button));
        }else {
            holder.textView.setBackground(null);
        }
        holder.textView.setText(messageList.get(position).getMessagename());
    }

    public int getItemCount() {
        return messageList !=null? messageList.size():0;
    }

    public void setBg(int pos){
        this.pos = pos;
        notifyDataSetChanged();
    }
}
