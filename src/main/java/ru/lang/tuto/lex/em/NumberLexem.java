package ru.lang.tuto.lex.em;

import ru.lang.tuto.poi.Pointer;

import java.util.ArrayList;
import java.util.List;

public class NumberLexem extends Lexem {
    private List<DigitLexem> digits;

    public NumberLexem(Pointer<Character> begin, Pointer<Character> end, List<DigitLexem> digits) {
        super(begin, end);
        this.digits = digits;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("NumberLexem{");
        sb.append("digits=").append(digits);
        sb.append('}');
        return sb.toString();
    }
}
