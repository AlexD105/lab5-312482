package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Ticket;
import com.company.Models.Tickets;
import com.company.Printer;

public class Show implements Command {
    @Override
    public void Execute(String command) {
        if(Main.tickets.getTickets().size() != 0) {
            for (Ticket ticket : Main.tickets.getTickets()) {
                Printer.getInstance().WriteLine(ticket.toString());
            }
        }
        else{
            Printer.getInstance().WriteLine("Ни одного элемента нет");
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
