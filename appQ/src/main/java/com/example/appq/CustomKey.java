package com.example.appq;

import java.util.Objects;

public class CustomKey {

    private int id;
    private String name;

    public CustomKey(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomKey key = (CustomKey) o;
        return id == key.id &&
                Objects.equals(name, key.name);
    }

    /**
     * 只重写equals则作为散列数据结构的key时会出现多个"相同"的key
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
