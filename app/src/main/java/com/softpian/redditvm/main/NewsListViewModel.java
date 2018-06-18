package com.softpian.redditvm.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.softpian.redditvm.model.ChildrenItem;
import com.softpian.redditvm.model.RedditNewsResponse;
import com.softpian.redditvm.network.RedditApi;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListViewModel extends ViewModel {

    private final MutableLiveData<List<ChildrenItem>> mNewsItems = new MutableLiveData<>();
    private final MutableLiveData<Boolean> mNewsLoadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> mLoading = new MutableLiveData<>();

    private Call<RedditNewsResponse> mRedditNewsCall;
    private RedditApi mRedditApi;

    private RedditNewsResponse mPreviousRedditNewsResponse;

    @Inject
    public NewsListViewModel(RedditApi redditApi) {

        mRedditApi = redditApi;
        getRedditNews();
    }

    public MutableLiveData<List<ChildrenItem>> getNewsItems() {
        return mNewsItems;
    }

    public MutableLiveData<Boolean> getNewsLoadError() {
        return mNewsLoadError;
    }

    public MutableLiveData<Boolean> getLoading() {
        return mLoading;
    }

    public void getRedditNews() {

        mLoading.setValue(true);

        if (mPreviousRedditNewsResponse != null
                && mPreviousRedditNewsResponse.getData() != null
                && mPreviousRedditNewsResponse.getData().getAfter() != null) {

            mRedditNewsCall = mRedditApi.getTopPosts(mPreviousRedditNewsResponse.getData().getAfter(), "20");
        } else {

            mRedditNewsCall = mRedditApi.getTopPosts("", "20");
        }
        mRedditNewsCall.enqueue(new Callback<RedditNewsResponse>() {
            @Override
            public void onResponse(Call<RedditNewsResponse> call, Response<RedditNewsResponse> response) {

                if (response.isSuccessful()) {
                    RedditNewsResponse redditNewsResponse = response.body();
                    mPreviousRedditNewsResponse = redditNewsResponse;
                    List<ChildrenItem> childrenItemList = redditNewsResponse.getData().getChildren();
                    mNewsItems.setValue(childrenItemList);
                    mNewsLoadError.setValue(false);
                } else {
                    mNewsLoadError.setValue(true);
                }

                mLoading.setValue(false);
                mRedditNewsCall = null;
            }

            @Override
            public void onFailure(Call<RedditNewsResponse> call, Throwable t) {

                mNewsLoadError.setValue(true);
                mLoading.setValue(false);
                mRedditNewsCall = null;
            }
        });
    }

    @Override
    protected void onCleared() {

        if (mRedditNewsCall != null) {
            mRedditNewsCall.cancel();
            mRedditNewsCall = null;
        }
    }
}
