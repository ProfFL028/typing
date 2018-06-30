package com.proffl.typing.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GenerateWordSql {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("src\\main\\resources\\word.txt"));
        String newLine = reader.readLine();
        while (newLine != null && newLine.length() > 1) {
            System.out.println("insert into word values('" + newLine.substring(0, 1) + "', '" + newLine.substring(1) + "');");
            newLine = reader.readLine();
        }
    }
}
