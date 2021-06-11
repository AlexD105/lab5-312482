package com.company.Commands;

import com.company.Command;
import com.company.Converter;

public class Save implements Command {
    @Override
    public void Execute(String command) throws Exception {
        Converter.getInstance().SetObject();
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
