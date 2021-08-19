package ru.lang.tuto.lex;

import ru.lang.tuto.lex.em.*;
import ru.lang.tuto.poi.CharPointer;
import ru.lang.tuto.poi.Pointer;
import ru.lang.tuto.typ.Digit;

import java.util.ArrayList;
import java.util.List;

public class Lexer {

    private List<Character> chars = new ArrayList<>();

    public static void main(String[] args) throws InvalidSymbolException, CloneNotSupportedException {
        Lexer lexer = new Lexer();
        String sourceCode = "15555 + 88882";

        var lexems = lexer.parseLexems(sourceCode);
        System.out.println(sourceCode);
        for (var t : lexems) {
            System.out.println(t);
        }
    }

    public List<Lexem> parseLexems(String source) throws InvalidSymbolException, CloneNotSupportedException {
        List<Lexem> lexems = new ArrayList<>();
        chars = CharUtils.toChars(source);
        Lexem lexem = null;
        do {
            if (lexem == null) {
                lexem = parseLexem(new CharPointer(chars, 0));
            } else {
                lexem = parseLexem(lexem.getEnd());
            }

            lexems.add(lexem);
        } while (lexem.getEnd().getPosition() < chars.size());

        return lexems;
    }

    public Lexem parseLexem(Pointer<Character> from) throws InvalidSymbolException, CloneNotSupportedException {
        if (! from.get().isPresent()) return null;
        switch (from.get().get()) {
            case ' ':
                return makeWhiteSpace(from);
            case '0': case '1': case '2': case '3': case '4':
            case '5': case '6': case '7': case '8': case '9':
                return makeNumber(from);
            case '+':
                return makePlus(from);
            case '-':
                return makeMinus(from);
            default:
                throw new InvalidSymbolException("SYMBOL '" + from.lookup(1) + "' at " + from.getPosition() + " position unsupported");
        }
    }

    private Lexem makeNumber(Pointer<Character> begin) throws CloneNotSupportedException, InvalidSymbolException {

        List<DigitLexem> digits = new ArrayList<>();
        var point = begin;
        while (point.get().isPresent() && Digit.isDigit(point.get().get())) {
            digits.add(new DigitLexem(point, point.move(1)));
            point = point.move(1);
        }

        return new NumberLexem(begin, begin.move(digits.size()), digits);
    }

    private Lexem makePlus(Pointer<Character> begin) throws CloneNotSupportedException {
        return new PlusLexem(begin, begin.move(1));
    }

    private Lexem makeMinus(Pointer<Character> begin) throws CloneNotSupportedException {
        return new MinusLexem(begin, begin.move(1));
    }

    private Lexem makeWhiteSpace(Pointer<Character> begin) throws CloneNotSupportedException {
        return new WhiteSpaceLexem(begin, begin.move(1));
    }



}
