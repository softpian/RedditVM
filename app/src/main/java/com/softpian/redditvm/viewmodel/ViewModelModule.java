package com.softpian.redditvm.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.softpian.redditvm.main.NewsListViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsListViewModel.class)
    abstract ViewModel bindListViewModel(NewsListViewModel viewModel);
}
