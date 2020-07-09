package com.example.testapp.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testapp.bean.Book;
import com.example.testapp.server.BookManager;
import com.example.testapp.server.RemoteService;
import com.example.testapp.server.Stub;

import java.util.List;

/**
 * <pre>
 * author: 01516728
 * e-mail: 01516728@haier.com
 * time: 2020/6/29 14:16
 * desc:
 * version: 1.0
 * </pre>
 */
public class ClientActivity extends AppCompatActivity {

    private static final String TAG = ClientActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, RemoteService.class);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                BookManager bookManager = Stub.asInterface(iBinder);
                if (bookManager != null) {
                    try {
                        List<Book> books =  bookManager.getBooks();
                        Log.e(TAG, "onServiceConnected: " + books.size());
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, Context.BIND_AUTO_CREATE);
    }
}
