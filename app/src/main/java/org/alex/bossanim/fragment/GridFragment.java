package org.alex.bossanim.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.adapter.listener.OnItemChildClickListener;

import org.alex.bossanim.R;
import org.alex.bossanim.adapter.GridAdapter;
import org.alex.bossanim.adapter.ListAdapter;
import org.alex.mvcapp.baseui.BaseFragment;
import org.alex.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Alex
 * 时间：2016年10月01日
 * 简述：
 */

public class GridFragment extends BaseFragment {
    private GridAdapter adapter;

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_grid;
    }

    @Override
    public void onCreateData(Bundle bundle) {
        adapter = new GridAdapter();
        RecyclerView recyclerView = findView(R.id.rv);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new MyOnItemChildClickListener());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            list.add("");
        }
        adapter.addItem(list);
    }

    private final class MyOnItemChildClickListener extends OnItemChildClickListener<ListAdapter> {

        @Override
        public void SimpleOnItemChildClick(ListAdapter listAdapter, View view, int position) {
            LogUtil.e("position = " + position);
        }
    }
}
