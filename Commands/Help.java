package com.company.Commands;

import com.company.Command;
import com.company.CommandsManager;
import com.company.Printer;

public class Help implements Command {
    @Override
    public void Execute(String command) {
        for (Command a: CommandsManager.getInstance().getCommands()) {
            Printer.getInstance().WriteLine("Команда: " + a.getName());
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
