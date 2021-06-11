package com.company;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Printer {
    private static PrintStream writer;
    private static Scanner scanner;
    private static Printer instance;

    private Printer(InputStream reader, PrintStream Writer) {
        writer = Writer;
        scanner = new Scanner(reader);
    }

    public static Printer getInstance() {
        if(instance == null){
            instance = new Printer(System.in, System.out);
        }
        return instance;
    }
    public static void Init(InputStream reader, PrintStream Writer){
        instance = new Printer(reader, Writer);
    }
    public String ReadLine(){
        return scanner.nextLine();
    }
    public void WriteLine(Object str){
        writer.println(str);
    }
    public void InvalidValue(){
        WriteLine("значение неверно");
    }
    public void Write(Object s){
        writer.print(s);
    }
}
