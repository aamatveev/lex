package ru.lang.tuto.poi;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public abstract class Pointer<T> implements Cloneable {
    private List<T> source;
    private int position;

    public Pointer(List<T> source, int position) {
        this.position = position;
        this.source = source;
    }

    public int getPosition() {
        return position;
    }

    public Optional<T> get() {
        if (position > source.size() - 1) {
            return Optional.empty();
        }
        return Optional.of(source.get(position));
    }


    public Pointer<T> move(int offset) throws CloneNotSupportedException {
        var newPointer = (Pointer)this.clone();
        newPointer.position = newPointer.position + offset;
        return newPointer;
    }

    public List<T> lookup(int amount) {
        List<T> list = new ArrayList<>();
        for (int i = position; i < position + amount; i++) {
            list.add(source.get(i));
        }
        return list;
    }
}
