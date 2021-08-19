package ru.lang.tuto.typ;

public enum Digit implements Typ {
    _0(0),
    _1(1),
    _2(2),
    _3(3),
    _4(4),
    _5(5),
    _6(6),
    _7(7),
    _8(8),
    _9(9)
    ;

    private int value;

    Digit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public char getValueChar() {
        return (String.valueOf(value)).charAt(0);
    }

    public static boolean isDigit(char ch) {
        for (var v: Digit.values()) {
            if (v.getValueChar() == ch) return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return "DIGIT";
    }
}
