package org.alex.bossanim.fragment;

import android.os.Bundle;
import android.view.View;

import org.alex.bossanim.R;
import org.alex.bosszoomanim.BossZoomHelper;
import org.alex.mvcapp.baseui.BaseFragment;

/**
 * 作者：Alex
 * 时间：2016年10月01日
 * 简述：
 */

public class ScrollFragment extends BaseFragment {

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_scroll;
    }

    @Override
    public void onCreateData(Bundle bundle) {
        setOnClickListener(R.id.civ_1, R.id.civ_2);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        new BossZoomHelper(activity, v, 400);
    }
}
