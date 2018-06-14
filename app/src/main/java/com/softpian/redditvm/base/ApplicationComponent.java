package com.softpian.redditvm.base;


import com.softpian.redditvm.main.NewsListFragment;
import com.softpian.redditvm.network.RestfulServiceModule;
import com.softpian.redditvm.viewmodel.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {
        RestfulServiceModule.class,
        ViewModelModule.class
})
public interface ApplicationComponent {

    void inject(NewsListFragment newsListFragment);
}
