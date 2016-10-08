package org.alex.bossanim.adapter;

import android.app.Activity;
import android.view.View;

import com.chad.adapter.BaseViewHolder;
import com.chad.adapter.SingleRecyclerAdapter;

import org.alex.bossanim.R;
import org.alex.bosszoomanim.BossZoomHelper;
import org.alex.util.LogUtil;

/**
 * 作者：Alex
 * 时间：2016年10月01日
 * 简述：
 */

public class GridAdapter extends SingleRecyclerAdapter<String> {
    @Override
    public int getLayoutResId() {
        return R.layout.item_grid;
    }

    @Override
    protected void onConvert(BaseViewHolder holder, String bean) {
        //holder.addOnClickListener(R.id.zim);

        int position = holder.getLayoutPosition();

        if (position % 2 == 0) {
            holder.findView(R.id.iv).setOnClickListener(new MyOnClickListener(position, holder.findView(R.id.iv)));
        } else {
            holder.findView(R.id.iv).setOnClickListener(new MyOnClickListener(position, holder.findView(R.id.layout_logo)));
        }

    }

    private final class MyOnClickListener implements View.OnClickListener {
        private View bossJumpView;
        private int position;


        public MyOnClickListener(int position, View bossJumpView) {
            this.position = position;
            this.bossJumpView = bossJumpView;
        }

        /**
         * Called when a view has been clicked.
         *
         * @param v The view that was clicked.
         */
        @Override
        public void onClick(View v) {
            LogUtil.e("position = " + position);
            new BossZoomHelper((Activity) context, bossJumpView, 400);
        }
    }

}
