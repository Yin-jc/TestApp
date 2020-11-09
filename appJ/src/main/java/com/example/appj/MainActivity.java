package com.example.appj;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

/**
 * ViewGroup布局（myLayout）中有2个子View = 2个按钮
 */
public class MainActivity extends AppCompatActivity {

    Button button1,button2;
    ViewGroup myLayout;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        myLayout = (LinearLayout) findViewById(R.id.my_layout);

        // 1.为ViewGroup布局设置监听事件
        myLayout.setOnClickListener(v -> Log.d("TAG", "点击了ViewGroup"));

        // 2. 为按钮1设置监听事件
        button1.setOnClickListener(v -> Log.d("TAG", "点击了button1"));

        // 3. 为按钮2设置监听事件
        button2.setOnClickListener(v -> Log.d("TAG", "点击了button2"));

        button1.setOnTouchListener((v, event) -> {
            Log.d("TAG", "button1执行了onTouch(), 动作是:" + event.getAction());
            return false;
        });

        button2.setOnTouchListener((v, event) -> {
            Log.d("TAG", "button2执行了onTouch(), 动作是:" + event.getAction());
            return true;
        });

    }
}

