package com.example.testapp.bean;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

/**
 * <pre>
 * author: 01516728
 * e-mail: 01516728@haier.com
 * time: 2020/6/29 14:19
 * desc:
 * version: 1.0
 * </pre>
 */
public class Book implements Parcelable {

    private int price;
    private String name;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book() {

    }

    protected Book(Parcel in) {
        price = in.readInt();
        name = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(price);
        parcel.writeString(name);
    }

    @NonNull
    @Override
    public String toString() {
        return "Book{price = " + price + ", name = " + name + "}";
    }
}
