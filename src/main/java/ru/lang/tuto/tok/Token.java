package ru.lang.tuto.tok;

import ru.lang.tuto.poi.Pointer;

public interface Token<T, P extends Pointer<T>> {
    P getBegin();
    P getEnd();
}
