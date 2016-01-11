package com.demo.cnt.myapplication.dagger;

import com.demo.cnt.myapplication.base.DemoApplication;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.content.Context;
import android.os.PowerManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(
    complete = false,
    library = true
)
public class AndroidModule {

  @Singleton
  @Provides
  Context provideAppContext() {
    return DemoApplication.getInstance().getApplicationContext();
  }

  @Singleton
  @Provides
  ContentResolver provideContentResolver(Context context) {
    return context.getContentResolver();
  }

  @Singleton
  @Provides
  AlarmManager provideAlarmManager(Context context) {
    return (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
  }

  @Singleton
  @Provides
  PowerManager providePowerManager(Context context) {
    return (PowerManager) context.getSystemService(Context.POWER_SERVICE);
  }

  @Provides
  @Singleton
  NotificationManager provideNotificationManager(Context context) {
    return (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
  }
}
