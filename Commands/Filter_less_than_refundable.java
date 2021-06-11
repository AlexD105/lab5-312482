package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Ticket;
import com.company.Printer;

public class Filter_less_than_refundable implements Command {
    @Override
    public void Execute(String command) throws Exception {
        String[] strings = command.split(",");
        if(strings.length >= 2){
            try{
                float c = Float.parseFloat(strings[1]);
                for (Ticket ticket : Main.tickets.getTickets()){
                    if(ticket.getPrice() < c){
                        Printer.getInstance().WriteLine(ticket);
                    }
                }
            }
            catch (NumberFormatException e){
                Printer.getInstance().WriteLine("Не число");
            }
            catch (IndexOutOfBoundsException e){
                Printer.getInstance().WriteLine("Недостаточно аргументов");
            }
        }
        else{
            Printer.getInstance().WriteLine("Недостаточно аргументов");
        }
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
