package wr.bc.com.livebroadcast.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import wr.bc.com.livebroadcast.R;
import wr.bc.com.livebroadcast.bean.LiveBean;

/**
 * Created by Administrator on 2017/8/17.
 */
public class ChoiceAdapter extends RecyclerView.Adapter<MyChoiceHolder> {

    private Context mContext;
    private List<LiveBean.ResultBean.ListBean> alist;
    public ChoiceAdapter(Context context, List<LiveBean.ResultBean.ListBean> list) {
        mContext = context;
        alist = list;
    }

    @Override
    public MyChoiceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.choice_son, parent,false);
        MyChoiceHolder myChoiceHolder = new MyChoiceHolder(view);
        return myChoiceHolder;
    }

    @Override
    public void onBindViewHolder(MyChoiceHolder holder, int position) {
        holder.tv1.setText(alist.get(position).getUser().getUser_data().getUser_name());
        holder.tv2.setText(alist.get(position).getData().getLive_name());
        Log.d("TAG",alist.get(position).getUser().getUser_data().getUser_name()+"dasdasdsa");
        Picasso.with(mContext).load(alist.get(position).getUser().getUser_data().getAvatar())
                .into(holder.iv1);
        Picasso.with(mContext).load(alist.get(position).getData().getPic())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.iv2);
    }

    @Override
    public int getItemCount() {
        return alist == null?0:alist.size();
    }
}
class MyChoiceHolder extends RecyclerView.ViewHolder{

    public ImageView iv1;
    public ImageView iv2;
    public TextView tv1;
    public TextView tv2;

    public MyChoiceHolder(View itemView) {
        super(itemView);
        iv1 = (ImageView) itemView.findViewById(R.id.iv_choice_photo);
        iv2 = (ImageView) itemView.findViewById(R.id.iv_choice_audio);
        tv1 = (TextView) itemView.findViewById(R.id.tv_choice_name);
        tv2 = (TextView) itemView.findViewById(R.id.tv_choice_content);
    }
}

