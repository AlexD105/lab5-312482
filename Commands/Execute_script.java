package com.company.Commands;

import com.company.Command;
import com.company.CommandsManager;
import com.company.Main;
import com.company.Models.Coordinates;
import com.company.Models.Event;
import com.company.Models.Ticket;
import com.company.Models.TicketType;
import com.company.Printer;
import java.io.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Locale;

public class Execute_script implements Command {
    @Override
    public void Execute(String command) throws Exception {
        try {
            String[] strings123 = command.split ( ",",2 );
            if(strings123.length >= 2) {
                FileReader fileReader = new FileReader(strings123[1]);
                char[] chars = new char[(int)new File(strings123[1]).length()];
                fileReader.read(chars);
                String[] strings = new String(chars).split("\r\n");
                for (String next : strings) {
                    Printer.getInstance().WriteLine("Введите команду");
                    boolean isCommand = false;
                    for (Command command12 : CommandsManager.getInstance().getCommands()) {
                        if (next.startsWith(command12.getName()) || next.startsWith(command12.getName().toLowerCase(Locale.ROOT))) {
                            command12.Execute(next);
                            isCommand = true;
                        }
                    }
                    if (!isCommand) {
                        Printer.getInstance().WriteLine("Нет такой команды");
                    }
                }
            }
            else{
                System.out.println ("Нет пути. Повторите");
                Execute ( getName () + "," + Printer.getInstance().ReadLine() );
            }
        }
        catch (NumberFormatException e){
            System.out.println ("Неверный путь. Повторите");
            Execute ( getName () + "," + Printer.getInstance().ReadLine() );
        }
        catch (FileNotFoundException e){
            System.out.println ("Нет файла");
        }
    }

    @Override
    public String getName() {
        return getClass ().getSimpleName ();
    }
}