package com.example.testapp;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testappB.IPerson;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author Yin jiacheng
 * @date 2020/6/3.
 * description：
 */
public class IPCService extends Service {

    private static final String TAG = "IPC";

    private static final int TRANSACT_CODE = 1;
    private String name;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private Binder binder = new IPerson.Stub() {
        @Override
        public void setName(String s) {
            name = s;
        }

        @Override
        public String getName() {
            return name;
        }
    };

    static class IPCBinder extends Binder {
        @Override
        protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
            boolean parent = super.onTransact(code, data, reply, flags);
            if (code != TRANSACT_CODE) {
                return parent;
            }
            ParcelFileDescriptor parcelFileDescriptor = data.readParcelable(ParcelFileDescriptor.class.getClassLoader());
            if (parcelFileDescriptor == null) {
                return parent;
            }
            FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();

            int size = data.readInt();
            FileInputStream fileInputStream = new FileInputStream(fileDescriptor);
            byte[] bytes = new byte[1024];
            try {
                fileInputStream.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String message = new String(bytes, 0, size, StandardCharsets.UTF_8);
            Log.i(TAG, "onTransact: " + message);
            if (reply != null) {
                reply.writeString("reply: " + message);
            }
            return true;
        }
    }
}
