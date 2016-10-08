package org.alex.bossanim.activity;


import android.os.Bundle;
import android.view.View;

import org.alex.bossanim.R;
import org.alex.bossanim.fragment.GridFragment;
import org.alex.bossanim.fragment.ListFragment;
import org.alex.bossanim.fragment.ScrollFragment;
import org.alex.mvcapp.baseui.LayoutFragmentActivity;

public class ZoomActivity extends LayoutFragmentActivity {


    @Override
    public int getLayoutResId() {
        return R.layout.activity_zoom;
    }

    @Override
    public void onCreateData(Bundle bundle) {
        super.onCreateData(bundle);
        setDoubleClick(false,0,null);
        setBackView(R.id.tv_back);
        setOnClickListener(R.id.bt_list, R.id.bt_grid, R.id.bt_scroll);
        initFragment(R.id.layout_logo, 0, new ListFragment(), new GridFragment(), new ScrollFragment());
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (R.id.bt_list == v.getId()) {
            switchFragment(0);
        } else if (R.id.bt_grid == v.getId()) {
            switchFragment(1);
        } else if (R.id.bt_scroll == v.getId()) {
            switchFragment(2);
        }
    }
}
