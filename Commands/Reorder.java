package com.company.Commands;

import com.company.Command;
import com.company.Main;

import java.util.Collections;

public class Reorder implements Command {
    @Override
    public void Execute(String command) throws Exception {
        Collections.reverse(Main.tickets.getTickets());
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
