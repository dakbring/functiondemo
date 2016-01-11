package com.demo.cnt.myapplication.dagger;

import com.demo.cnt.myapplication.MainActivity;
import com.demo.cnt.myapplication.base.DemoApplication;

import dagger.Module;

@Module(
    complete = false,
    library = true,
    injects = {

        //Activity
        DemoApplication.class,
        MainActivity.class

    }
)
public class AppDemoModule {

}
