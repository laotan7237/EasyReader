package com.laotan.easyreader.adapter;

import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.laotan.easyreader.R;
import com.laotan.easyreader.bean.topnews.NewsListBean;
import com.laotan.easyreader.utils.DensityUtil;
import com.laotan.easyreader.utils.GlideUtils;

import java.util.List;

/**
 * Created by quantan.liu on 2017/3/27.
 */

public class TopNewsAdapter extends BaseQuickAdapter<NewsListBean.NewsBean,BaseViewHolder> {
    public TopNewsAdapter(List<NewsListBean.NewsBean> data) {
        super(R.layout.item_top_news,data);
    }

    @Override
    protected void convert(final BaseViewHolder helper, final NewsListBean.NewsBean item) {
        if (helper.getPosition() % 2 == 0) {
            DensityUtil.setViewMargin(helper.itemView, false, 0, 0, 0, 40);
        } else {
            DensityUtil.setViewMargin(helper.itemView, false, 5, 0, 0, 40);
        }
        helper.setText(R.id.tv_item_top_news,item.getTitle());
        GlideUtils.loadImage(3,item.getImgsrc(), (ImageView) helper.getView(R.id.iv_item_top_news));
        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClickListener(item.getDocid(), item.getImgsrc(),helper.getView(R.id.iv_item_top_news));
            }
        });

    }
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClickListener(String id, String imgUrl,View view);}

}
