package ru.lang.tuto.lex.em;

import ru.lang.tuto.poi.Pointer;
import ru.lang.tuto.tok.Token;

/**
 *
 */
public class Lexem implements Token<Character, Pointer<Character>> {
    private Pointer<Character> begin;
    private Pointer<Character> end;

    public Lexem(Pointer<Character> begin, Pointer<Character> end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public Pointer<Character> getBegin() {
        return begin;
    }

    @Override
    public Pointer<Character> getEnd() {
        return end;
    }
}
