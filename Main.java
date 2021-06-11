package com.company;

import com.company.Models.Tickets;

import java.io.PrintStream;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Locale;

public class Main {

    public static Tickets tickets = new Tickets();
    public static LocalDateTime start;

    public static void main(String[] args) {
        System.out.println(ZonedDateTime.now());
        Printer.Init(System.in, new PrintStream(System.out, true, Charset.forName("windows-1251")));

        Converter.getInstance().getObject();

        start = LocalDateTime.now();

        while (true){
            try {
                Printer.getInstance().WriteLine("Введите команду");
                String next = Printer.getInstance().ReadLine().trim();
                boolean isCommand = false;
                for (Command command : CommandsManager.getInstance().getCommands()) {
                    if (next.startsWith(command.getName()) || next.startsWith(command.getName().toLowerCase(Locale.ROOT))) {
                        command.Execute(next);
                        isCommand = true;
                    }
                }
                if (!isCommand) {
                    Printer.getInstance().WriteLine("Команда не найдена");
                }
            }
            catch (Exception e){
                Printer.getInstance().WriteLine("Ошибка");
            }
        }
    }
}
