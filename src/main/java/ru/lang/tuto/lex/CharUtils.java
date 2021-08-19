package ru.lang.tuto.lex;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class CharUtils {

    private CharUtils() {
    }

    public static List<Character> toChars(String origin) {
        List<Character> list = new ArrayList<>();
        Reader reader = new StringReader(origin);
        try {
            int k;
            while ((k = reader.read()) != -1) {
                list.add((char) k);
            }
        } catch (IOException e) {
            // end of stream
        }
        return list;
    }
}
