package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Tickets;
import com.company.Printer;

public class Remove_by_id implements Command {
    @Override
    public void Execute(String command) throws Exception {
        String[] strs = command.split(",");
        try {
            if (strs.length > 1) {
                int id = Integer.parseInt(strs[1]);
                if (id + 1 < strs.length) {
                    Main.tickets.getTickets().remove(id);
                    Printer.getInstance().WriteLine("Успех");
                } else {
                    Printer.getInstance().WriteLine("Неудача");
                }
            } else {
                Printer.getInstance().WriteLine("Нет id");
            }
        }
        catch (IndexOutOfBoundsException e){
            Printer.getInstance().WriteLine("Недостаточно аргументов");
        }
        catch (NumberFormatException e){
            Printer.getInstance().WriteLine("Это не число");
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}