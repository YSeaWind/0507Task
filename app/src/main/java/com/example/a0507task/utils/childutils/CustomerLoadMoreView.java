package com.example.a0507task.utils.childutils;

import com.chad.library.adapter.base.loadmore.LoadMoreView;
import com.example.a0507task.R;

public class CustomerLoadMoreView extends LoadMoreView {
    @Override
    public int getLayoutId() {
        return R.layout.load_more;
    }

    @Override
    protected int getLoadingViewId() {
        return R.id.load_more_loading_view;
    }

    @Override
    protected int getLoadFailViewId() {
        return R.id.load_more_load_fail_view;
    }

    @Override
    protected int getLoadEndViewId() {
        return R.id.load_more_load_end_view;
    }
}
