package com.softpian.redditvm.main;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public abstract class InfiniteScrollListener extends RecyclerView.OnScrollListener {

    private int mVisibleThreshold = 2;
    private int mPreviousTotalItemCount = 0;
    private boolean mLoading = true;

    private RecyclerView.LayoutManager mLayoutManager;

    InfiniteScrollListener(LinearLayoutManager layoutManager) {
        mLayoutManager = layoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        int lastVisibleItemPosition = 0;
        int totalItemCount = mLayoutManager.getItemCount();

        lastVisibleItemPosition = ((LinearLayoutManager) mLayoutManager).findLastVisibleItemPosition();

        if (totalItemCount < mPreviousTotalItemCount) {
            mPreviousTotalItemCount = totalItemCount;
            if (totalItemCount == 0) {
                mLoading = true;
            }
        }

        if (mLoading && (totalItemCount > mPreviousTotalItemCount)) {
            mLoading = false;
            mPreviousTotalItemCount = totalItemCount;
        }

        if (!mLoading && (lastVisibleItemPosition + mVisibleThreshold) > totalItemCount) {
            onLoadMore();
            mLoading = true;
        }
    }

    public void resetState() {
        mPreviousTotalItemCount = 0;
        mLoading = true;
    }

    public abstract void onLoadMore();
}
