package com.demo.cnt.myapplication.map;


import com.demo.cnt.myapplication.base.BaseActivity;

import android.content.Context;
import android.content.Intent;

public class GoogleMapActivity extends BaseActivity{
  public static Intent newIntent(Context context){
    Intent intent = new Intent(context, GoogleMapActivity.class);
    return intent;
  }

  @Override
  protected boolean didYouRememberToAddClassToInjectionList() {
    return true;
  }
}
