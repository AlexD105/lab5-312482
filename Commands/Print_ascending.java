package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Ticket;
import com.company.Printer;
import java.util.ArrayList;
import java.util.Collections;

public class Print_ascending implements Command {
    @Override
    public void Execute(String command) throws Exception {
        ArrayList<Ticket> tickets = new ArrayList<>(Main.tickets.tickets);
        Collections.sort(tickets);
        for (Ticket ticket : tickets){
            Printer.getInstance().WriteLine(ticket.toString());
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
