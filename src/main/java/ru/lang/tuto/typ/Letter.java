package ru.lang.tuto.typ;

public enum Letter implements Typ {
    A,B,C,D,E,F
    ;

    @Override
    public String getName() {
        return "LETTER";
    }
}
