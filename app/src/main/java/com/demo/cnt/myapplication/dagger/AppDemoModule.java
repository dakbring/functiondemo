package com.demo.cnt.myapplication.dagger;

import com.demo.cnt.myapplication.MainActivity;
import com.demo.cnt.myapplication.base.DemoApplication;
import com.demo.cnt.myapplication.image.HandleImageActivity;
import com.demo.cnt.myapplication.map.GoogleMapActivity;

import dagger.Module;

@Module(
    complete = false,
    library = true,
    injects = {

        //Activity
        DemoApplication.class,
        MainActivity.class,
        HandleImageActivity.class,
        GoogleMapActivity.class

    }
)
public class AppDemoModule {

}
