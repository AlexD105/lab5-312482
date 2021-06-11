package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Tickets;
import com.company.Printer;

import java.io.FileNotFoundException;

public class Insert_at implements Command {
    @Override
    public void Execute(String command) throws Exception {
        try {
            String[] strings = command.split ( ",",2 );
            if(strings.length >= 2) {
                Main.tickets.getTickets().add(Integer.parseInt(strings[1]), Tickets.Set_Fields());
            }
            else{
                Printer.getInstance().WriteLine("Неверное кол-во аргументов");
            }
        }
        catch (NumberFormatException e){
            Printer.getInstance().WriteLine("Это не число");
        }
        catch (IndexOutOfBoundsException e){
            Printer.getInstance().WriteLine("Неверное кол-во аргументов");
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
