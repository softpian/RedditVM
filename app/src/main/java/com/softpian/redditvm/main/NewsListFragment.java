package com.softpian.redditvm.main;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.softpian.redditvm.R;
import com.softpian.redditvm.base.MyApplication;
import com.softpian.redditvm.viewmodel.ViewModelFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NewsListFragment extends Fragment {

    @Inject
    ViewModelFactory mViewModelFactory;

    @BindView(R.id.rvNewsList) RecyclerView mNewsListView;
    @BindView(R.id.tvError) TextView mErrorView;
    @BindView(R.id.pbLoading) ProgressBar mLoadingView;

    private NewsListViewModel mViewModel;
    private Unbinder mUnbinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        MyApplication.getApplicationComponent(context).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mUnbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(NewsListViewModel.class);

        mNewsListView.setAdapter(new NewsListAdapter(mViewModel, this));
        mNewsListView.setLayoutManager(new LinearLayoutManager(getContext()));

        observeViewModel();
    }

    private void observeViewModel() {

        mViewModel.getNewsItems().observe(this, childrenItems -> {
            if (childrenItems != null) {
                mNewsListView.setVisibility(View.VISIBLE);
            }
        });

        mViewModel.getNewsLoadError().observe(this, isError -> {
            if (isError) {
                mNewsListView.setVisibility(View.GONE);
                mErrorView.setVisibility(View.VISIBLE);
                mErrorView.setText("Error while loading news posts");
            } else {
                mErrorView.setVisibility(View.GONE);
                mErrorView.setText(null);
            }
        });

        mViewModel.getLoading().observe(this, isLoading -> {
            mLoadingView.setVisibility(isLoading ? View.VISIBLE : View.GONE);
            if (isLoading) {
                mNewsListView.setVisibility(View.GONE);
                mErrorView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mUnbinder != null) {
            mUnbinder.unbind();
            mUnbinder = null;
        }
    }
}
