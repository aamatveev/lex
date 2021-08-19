package ru.lang.tuto.lex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LexerTest {

    @Test
    void lexerTest() throws CloneNotSupportedException, InvalidSymbolException {
        Lexer lexer = new Lexer();
        String sourceCode = "15555 - 88882";

        var lexems = lexer.parseLexems(sourceCode);
        Assertions.assertTrue(lexems.size() > 0);
        System.out.println(sourceCode);
        for (var t : lexems) {
            System.out.println(t);
        }
    }
}
