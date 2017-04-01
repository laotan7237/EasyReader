package com.laotan.easyreader.ui.activity.zhihu;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.blankj.utilcode.utils.SPUtils;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.laotan.easyreader.R;
import com.laotan.easyreader.adapter.AdjustmentAdapter;
import com.laotan.easyreader.ui.activity.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by quantan.liu on 2017/3/26.
 */

public class HomeAdjustmentListActivity extends BaseActivity {

    private List<String> mlist;

    @BindView(R.id.rv_adjustment)
    RecyclerView rvAdjustment;

    @BindView(R.id.toolbar_adjustment_home_list)
    Toolbar toolbar;
    private SPUtils spUtils;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_adjustment_home_list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        setToolBar(toolbar, "调整栏目顺序");
        rvAdjustment.setLayoutManager(new LinearLayoutManager(this));
        mlist = new ArrayList<>();
        spUtils = new SPUtils("home_list");
        String homeListString = spUtils.getString("home_list");
        final String[] split = homeListString.split("&&");
        for (int i = 0; i < split.length; i++) {
            mlist.add(split[i]);
        }
        AdjustmentAdapter adjustmentAdapter = new AdjustmentAdapter(mlist);
        rvAdjustment.setAdapter(adjustmentAdapter);
        OnItemDragListener listener = new OnItemDragListener() {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {

            }

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
                /**
                 *    String fromName = mlist.get(from);
                 *    mlist.remove(from);
                 *    mlist.add(to,fromName);
                 *    不需要去做集合超做了，adapter都帮我们做好了
                 */
                StringBuilder homeListString = new StringBuilder();
                for (String name : mlist) {
                    homeListString.append(name + "&&");
                }
                spUtils.putString("home_list", homeListString.toString());
                spUtils.putBoolean("home_list_ischange",true);
            }

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {

            }
        };
        ItemTouchHelper mItemTouchHelper = new ItemTouchHelper(new ItemDragAndSwipeCallback(adjustmentAdapter));
        mItemTouchHelper.attachToRecyclerView(rvAdjustment);
        adjustmentAdapter.enableDragItem(mItemTouchHelper);
        adjustmentAdapter.setOnItemDragListener(listener);


    }
}
