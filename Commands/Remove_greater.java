package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Ticket;
import com.company.Models.Tickets;

public class Remove_greater implements Command {
    @Override
    public void Execute(String command) throws Exception {
        Ticket ticket = Tickets.Set_Fields();
        Main.tickets.getTickets().removeIf(u -> u.compareTo(ticket) > 0);
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
