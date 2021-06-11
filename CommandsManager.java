package com.company;

import com.company.Commands.*;

import java.util.ArrayList;

public class CommandsManager {

    private final ArrayList<Command> commands = new ArrayList<>();
    private static CommandsManager instance;

    private CommandsManager() {
        commands.add(new Add());
        commands.add(new Execute_script());
        commands.add(new Filter_less_than_refundable());
        commands.add(new Group_counting_by_price());
        commands.add(new Help());
        commands.add(new Info());
        commands.add(new Insert_at());
        commands.add(new Print_ascending());
        commands.add(new Remove_by_id());
        commands.add(new Remove_greater());
        commands.add(new Reorder());
        commands.add(new Save());
        commands.add(new Show());
        commands.add(new Update());
        commands.add(new Clear());
    }

    public static CommandsManager getInstance() {
        if(instance == null){
            instance = new CommandsManager();
        }
        return instance;
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }
}
