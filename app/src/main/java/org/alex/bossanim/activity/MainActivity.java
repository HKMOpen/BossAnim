package org.alex.bossanim.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.chad.adapter.listener.OnItemChildClickListener;

import org.alex.bossanim.R;
import org.alex.bossanim.adapter.ListAdapter;
import org.alex.bosszoomanim.BossZoomHelper;
import org.alex.mvcapp.baseui.BaseActivity;
import org.alex.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private ListAdapter adapter;
    private ImageView imageView;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void onCreateData(Bundle bundle) {
        setOnClickListener(R.id.tv, R.id.iv);
        imageView = findView(R.id.iv);
        adapter = new ListAdapter();
        RecyclerView recyclerView = findView(R.id.rv);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new MyOnItemChildClickListener());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            list.add("");
        }
        adapter.addItem(list);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (R.id.tv == v.getId()) {
            startActivity(ZoomActivity.class);
        } else if (R.id.iv == v.getId()) {
            new BossZoomHelper(this, imageView, 400);
        }
    }

    private final class MyOnItemChildClickListener extends OnItemChildClickListener<ListAdapter> {

        @Override
        public void SimpleOnItemChildClick(ListAdapter listAdapter, View view, int position) {
            LogUtil.e("position = " + position);
            ImageView imageView = findView(view, R.id.iv);
            FrameLayout frameLayout = findView(view, R.id.layout_logo);
            if (position % 2 == 0) {
                new BossZoomHelper(activity, imageView, 400);
            } else {
                new BossZoomHelper(activity, frameLayout, 400);
            }
        }
    }
}
