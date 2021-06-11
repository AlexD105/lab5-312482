package com.company;

public interface Command {
    public void Execute(String command) throws Exception;
    public String getName();
}
