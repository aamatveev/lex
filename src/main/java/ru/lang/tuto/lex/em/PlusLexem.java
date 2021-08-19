package ru.lang.tuto.lex.em;

import ru.lang.tuto.poi.Pointer;

public class PlusLexem extends Lexem {

    public PlusLexem(Pointer<Character> begin, Pointer<Character> end) {
        super(begin, end);
    }

    @Override
    public String toString() {
        return "PlusLexem{}";
    }
}
