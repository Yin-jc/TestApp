package com.example.testapp.server;

import android.os.IInterface;
import android.os.RemoteException;

import com.example.testapp.bean.Book;

import java.util.List;

/**
 * <pre>
 * author: 01516728
 * e-mail: 01516728@haier.com
 * time: 2020/6/29 14:22
 * desc:
 * version: 1.0
 * </pre>
 */
public interface BookManager extends IInterface {
    List<Book> getBooks() throws RemoteException;
    void addBook(Book book) throws RemoteException;
}
