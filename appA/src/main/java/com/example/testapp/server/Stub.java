package com.example.testapp.server;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.testapp.bean.Book;
import com.example.testapp.proxy.Proxy;

import java.util.List;

/**
 * <pre>
 * author: 01516728
 * e-mail: 01516728@haier.com
 * time: 2020/6/29 14:25
 * desc:
 * version: 1.0
 * </pre>
 */
public abstract class Stub extends Binder implements BookManager {

    private static final String TAG = Stub.class.getSimpleName();

    private static final String DESCRIPTOR = BookManager.class.getName();

    public static final int TRANSACTION_getBooks = FIRST_CALL_TRANSACTION;
    public static final int TRANSACTION_addBook = FIRST_CALL_TRANSACTION + 1;

    public Stub() {
        attachInterface(this, DESCRIPTOR);
    }

    public static BookManager asInterface(IBinder binder) {
        if (binder == null) {
            return null;
        }
        IInterface iin = binder.queryLocalInterface(DESCRIPTOR);
        if (iin instanceof BookManager) {
            Log.e(TAG, "asInterface: local!!!");
            return (BookManager) iin;
        }
        Log.e(TAG, "asInterface: remote!!!");
        return new Proxy(binder);

    }

    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    protected boolean onTransact(int code, @NonNull Parcel data, @Nullable Parcel reply, int flags) throws RemoteException {
        switch (code) {
            case INTERFACE_TRANSACTION:
                reply.writeString(DESCRIPTOR);
                return true;

            case TRANSACTION_getBooks:
                data.enforceInterface(DESCRIPTOR);
                List<Book> result = getBooks();
                reply.writeNoException();
                reply.writeTypedList(result);
                return true;

            case TRANSACTION_addBook:
                data.enforceInterface(DESCRIPTOR);
                Book arg0 = null;
                if (data.readInt() != 0) {
                    arg0 = Book.CREATOR.createFromParcel(data);
                }
                addBook(arg0);
                reply.writeNoException();
                return true;
        }
        return super.onTransact(code, data, reply, flags);
    }
}
