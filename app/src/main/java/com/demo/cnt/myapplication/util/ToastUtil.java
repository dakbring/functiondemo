package com.demo.cnt.myapplication.util;

import android.content.Context;
import android.widget.Toast;

public final class ToastUtil {
  /**
   * Show a toast and dismiss it after Toast#LENGTH_LONG.
   */
  public static Toast showLongToast(Context context, int textId) {
    Toast toast = Toast.makeText(context, textId, Toast.LENGTH_LONG);
    toast.show();
    return toast;
  }

  /**
   * Show a toast and dismiss it after Toast#LENGTH_LONG.
   */
  public static Toast showShortToast(Context context, String text) {
    Toast toast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
    toast.show();
    return toast;
  }

  public ToastUtil() {
  }
}
