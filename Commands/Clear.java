package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Printer;

public class Clear implements Command {
    @Override
    public void Execute(String command) throws Exception {
        Main.tickets.getTickets().clear();
        Printer.getInstance().WriteLine("Коллекция очищена");
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
