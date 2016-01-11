package com.demo.cnt.myapplication.base;

import com.demo.cnt.myapplication.dagger.Injector;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class BaseFragment extends Fragment {
    protected BaseActivity mHost;
    protected Handler mHandler = new Handler();
    private CompositeSubscription mCompositeSubscription;

    public abstract String getFragmentTitle();
    protected abstract boolean didYouRememberToAddClassToInjectionList();

    //We're using Dagger, that's why we need to make sure the class has been added to the injection list.
    private void addClassToInjectionList(){
        if(!didYouRememberToAddClassToInjectionList()) {
            throw new RuntimeException(AppConstants.INJECTION_ERROR);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addClassToInjectionList(); //never remove this method while we're using dagger
        Injector.inject(this);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mHost = (BaseActivity)activity;
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
            mCompositeSubscription.clear();
            mCompositeSubscription = null;
        }
    }

    //we're using rxjava: this one is to manage the subcriptions
    public synchronized Subscription manageSubscription(Subscription subscription) {
        if (isAdded() && !getActivity().isFinishing()) {
            if (mCompositeSubscription == null || mCompositeSubscription.isUnsubscribed()) {
                mCompositeSubscription = new CompositeSubscription();
            }
            mCompositeSubscription.add(subscription);
            return subscription;
        }
        return null;
    }
}
