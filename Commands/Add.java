package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Ticket;
import com.company.Models.Tickets;

public class Add implements Command {
    @Override
    public void Execute(String command) throws Exception {
        Main.tickets.getTickets().add(Tickets.Set_Fields());
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
