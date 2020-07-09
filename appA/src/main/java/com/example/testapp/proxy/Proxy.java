package com.example.testapp.proxy;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

import com.example.testapp.bean.Book;
import com.example.testapp.server.BookManager;
import com.example.testapp.server.Stub;

import java.util.List;

/**
 * <pre>
 * author: 01516728
 * e-mail: 01516728@haier.com
 * time: 2020/6/29 14:36
 * desc:
 * version: 1.0
 * </pre>
 */
public class Proxy implements BookManager {

    private static final String DESCRIPTOR = BookManager.class.getName();

    private IBinder remote;

    public Proxy(IBinder binder) {
        remote = binder;
    }

    public String  getInterfaceDescriptor() {
        return DESCRIPTOR;
    }

    @Override
    public List<Book> getBooks() throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();
        List<Book> result;

        try {
            data.writeInterfaceToken(DESCRIPTOR);
            remote.transact(Stub.TRANSACTION_getBooks, data, reply, 0);
            reply.readException();
            result = reply.createTypedArrayList(Book.CREATOR);
        } finally {
            data.recycle();
            reply.recycle();
        }
        return result;
    }

    @Override
    public void addBook(Book book) throws RemoteException {
        Parcel data = Parcel.obtain();
        Parcel reply = Parcel.obtain();

        try {
            data.writeInterfaceToken(DESCRIPTOR);
            if (book != null) {
                data.writeInt(1);
                book.writeToParcel(data, 0);
            } else {
                data.writeInt(0);
            }
            remote.transact(Stub.TRANSACTION_addBook, data, reply, 0);
            reply.readException();
        } finally {
            data.recycle();
            reply.recycle();
        }
    }

    @Override
    public IBinder asBinder() {
        return remote;
    }
}
