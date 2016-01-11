package com.demo.cnt.myapplication.dagger;


import dagger.Module;

/*
Add all modules to RootModule
 */
@Module(
    includes = {
        AndroidModule.class,
        AppDemoModule.class
    }
)
public class RootModule {

}
