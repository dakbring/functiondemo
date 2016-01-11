package com.demo.cnt.myapplication.base;


import com.demo.cnt.myapplication.dagger.Injector;

import android.support.v4.view.PagerAdapter;


public abstract class BasePagerAdapter extends PagerAdapter {

  protected abstract boolean didYouRememberToAddClassToInjectionList();

  //We're using Dagger, that's why we need to make sure the class has been added to the injection list.
  private void rememberToAddClassToInjectionList(){
    if(!didYouRememberToAddClassToInjectionList()){
      throw new RuntimeException(AppConstants.INJECTION_ERROR);
    }
  }

  public BasePagerAdapter(){
    rememberToAddClassToInjectionList(); //never remove this method while we're using dagger
    Injector.inject(this);
  }
}
