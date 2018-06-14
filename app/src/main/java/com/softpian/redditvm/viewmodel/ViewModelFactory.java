package com.softpian.redditvm.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class ViewModelFactory implements ViewModelProvider.Factory {

    private Map<Class<? extends ViewModel>, Provider<ViewModel>> mViewModels;

    @Inject
    public ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModels) {
        mViewModels = viewModels;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        try {
            return (T) mViewModels.get(modelClass).get();
        } catch (Exception e) {
            throw new RuntimeException("Exception: creating ViewModel");
        }
    }
}
