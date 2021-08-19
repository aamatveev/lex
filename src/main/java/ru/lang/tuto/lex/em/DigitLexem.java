package ru.lang.tuto.lex.em;

import ru.lang.tuto.poi.Pointer;

public class DigitLexem extends Lexem {


    public DigitLexem(Pointer<Character> begin, Pointer<Character> end) {
        super(begin, end);
    }

    @Override
    public String toString() {
        return getBegin().lookup(1).toString();
    }
}
