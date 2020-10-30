package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.MemoryFile;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.widget.FrameLayout;

import com.example.testapp.utils.HaierLogUtils;

import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "IPC";

    private static final int TRANSACT_CODE = 1;

    /**
     * 需要写入到共享内存中的数据
     */
    private String str = "落霞与孤鹜齐飞，秋水共长天一色。";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        intent.setAction("com.example.testapp.IPCService");
        intent.setPackage("com.example.testappB");
        /*bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (iBinder == null) {
                    return;
                }

                try {
                    ParcelFileDescriptor parcelFileDescriptor = createMemoryFile();
                    Parcel sendData = Parcel.obtain();
                    sendData.writeParcelable(parcelFileDescriptor, 0);
                    sendData.writeInt(str.getBytes().length);

                    Parcel reply = Parcel.obtain();
                    iBinder.transact(TRANSACT_CODE, sendData, reply, 0);

                    Log.i(TAG, "onServiceConnected: " + reply.readString());
                } catch (IOException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, BIND_AUTO_CREATE);*/

        /*bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        }, BIND_AUTO_CREATE);*/

        HaierLogUtils.i("111111111111111111111111", "Haier log info");
        HaierLogUtils.i("我我我我我我我11", "Haier log info");
    }

    private ParcelFileDescriptor createMemoryFile() throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        MemoryFile memoryFile = new MemoryFile("TestAshmemFile", 1024);
        FileDescriptor fileDescriptor = (FileDescriptor) invokeMethod("getFileDescriptor", memoryFile);
        if (fileDescriptor == null) {
            Log.e(TAG, "createMemoryFile fail!!!");
            return null;
        }
        memoryFile.writeBytes(str.getBytes(), 0, 0, str.getBytes().length);
        return ParcelFileDescriptor.dup(fileDescriptor);
    }

    private Object invokeMethod(String name, Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = object.getClass().getDeclaredMethod(name);
        return method.invoke(object);
    }
}
