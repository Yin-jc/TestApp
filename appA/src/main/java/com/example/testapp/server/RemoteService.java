package com.example.testapp.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import com.example.testapp.bean.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * author: 01516728
 * e-mail: 01516728@haier.com
 * time: 2020/6/29 15:28
 * desc:
 * version: 1.0
 * </pre>
 */
public class RemoteService extends Service {

    private List<Book> books = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();

        Book book = new Book();
        book.setName("三体");
        book.setPrice(88);
        books.add(book);
    }

    private Stub bookManager = new Stub() {
        @Override
        public List<Book> getBooks() throws RemoteException {
            synchronized (this) {
                if (books != null) {
                    return books;
                }
                return new ArrayList<>();
            }
        }

        @Override
        public void addBook(Book book) throws RemoteException {
            synchronized (this) {
                if (books == null) {
                    books = new ArrayList<>();
                }

                if (book == null) {
                    return;
                }

                book.setPrice(book.getPrice());
                books.add(book);
            }
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return bookManager;
    }
}
