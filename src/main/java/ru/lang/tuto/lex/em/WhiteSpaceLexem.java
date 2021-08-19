package ru.lang.tuto.lex.em;

import ru.lang.tuto.poi.Pointer;

public class WhiteSpaceLexem extends Lexem {

    public WhiteSpaceLexem(Pointer<Character> begin, Pointer<Character> end) {
        super(begin, end);
    }

    @Override
    public String toString() {
        return "WhiteSpaceLexem{}";
    }
}
