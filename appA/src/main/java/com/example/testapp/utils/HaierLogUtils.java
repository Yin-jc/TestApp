package com.example.testapp.utils;

import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.Size;

/**
 * Description: Haier log封装
 * Author: 01516728 2020/7/8 17:00
 * Version: 1.0
 */
public class HaierLogUtils {

    /**
     * VERBOSE级别输出
     */
    public static void v(@Size(max = 23) String tag, String msg) {
        if (Log.isLoggable(tag, Log.VERBOSE)) {
            Log.v(tag, msg);
        }
    }

    /**
     * DEBUG级别输出
     */
    public static void d(@Size(max = 23) String tag, String msg) {
        if (Log.isLoggable(tag, Log.DEBUG)) {
            Log.d(tag, msg);
        }
    }

    /**
     * INFO级别输出
     */
    public static void i(@Size(max = 23) String tag, String msg) {
        try {
            if (Log.isLoggable(tag, Log.INFO)) {
                Log.i(tag, msg);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * WARN级别输出
     */
    public static void w(@Size(max = 23) String tag, String msg) {
        if (Log.isLoggable(tag, Log.WARN)) {
            Log.w(tag, msg);
        }
    }

    /**
     * ERROR级别输出
     */
    public static void e(@Size(max = 23) String tag, String msg) {
        if (Log.isLoggable(tag, Log.ERROR)) {
            Log.e(tag, msg);
        }
    }

}
