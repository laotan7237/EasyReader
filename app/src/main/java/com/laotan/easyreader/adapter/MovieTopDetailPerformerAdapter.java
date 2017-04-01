package com.laotan.easyreader.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.laotan.easyreader.R;
import com.laotan.easyreader.bean.douban.PersonBean;
import com.laotan.easyreader.utils.GlideUtils;
import com.laotan.easyreader.webview.WebViewActivity;

import java.util.List;

/**
 * Created by quantan.liu on 2017/3/29.
 */

public class MovieTopDetailPerformerAdapter extends BaseQuickAdapter<PersonBean,BaseViewHolder> {
    public MovieTopDetailPerformerAdapter(List<PersonBean> data) {
        super(R.layout.item_movie_top_detail_performer,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, final PersonBean item) {
        helper.setText(R.id.tv_performer_name,item.getName());
        helper.setText(R.id.tv_performer,item.getType());
        if (item.getAvatars()!=null)
        GlideUtils.loadImage(3,item.getAvatars().getLarge(), (ImageView) helper.getView(R.id.iv_avatar));

        helper.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (item != null && !TextUtils.isEmpty(item.getAlt())) {
                    WebViewActivity.loadUrl(v.getContext(), item.getAlt(), item.getName());
                }
            }
        });
    }
}
