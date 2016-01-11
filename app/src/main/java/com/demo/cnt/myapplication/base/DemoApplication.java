package com.demo.cnt.myapplication.base;

import com.demo.cnt.myapplication.dagger.Injector;
import com.demo.cnt.myapplication.dagger.RootModule;

import android.app.Application;


public class DemoApplication extends Application {

  private static DemoApplication sInstance;

  public static DemoApplication getInstance(){
    return sInstance;
  }

  public DemoApplication(){
    sInstance = this;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    initObjectGraph();
  }

  private void initObjectGraph() {
    Injector.init(getRootModule(), this);
  }

  protected Object getRootModule(){
    return new RootModule();
  }
}
