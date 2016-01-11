package com.demo.cnt.myapplication.base;


import com.demo.cnt.myapplication.dagger.Injector;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;


public abstract class BaseActivity extends AppCompatActivity {

  private CompositeSubscription mCompositeSubscription;
  protected Handler mHandler = new Handler();

  protected abstract boolean didYouRememberToAddClassToInjectionList();

  //We're using Dagger, that's why we need to make sure the class has been added to the injection list.
  private void rememberToAddClassToInjectionList(){
    if(!didYouRememberToAddClassToInjectionList()){
      throw new RuntimeException(AppConstants.INJECTION_ERROR);
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    rememberToAddClassToInjectionList(); //never remove this method while we're using dagger
    Injector.inject(this);
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

  public synchronized Subscription manageSubscription(Subscription subscription) {
    if (!isFinishing()) {
      if (mCompositeSubscription == null || mCompositeSubscription.isUnsubscribed()) {
        mCompositeSubscription = new CompositeSubscription();
      }
      mCompositeSubscription.add(subscription);
      return subscription;
    }
    return null;
  }
}
