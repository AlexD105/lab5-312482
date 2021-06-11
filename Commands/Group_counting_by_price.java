package com.company.Commands;

import com.company.Command;
import com.company.Main;
import com.company.Models.Ticket;
import com.company.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Group_counting_by_price implements Command {
    @Override
    public void Execute(String command) throws Exception {

        List<Ticket> tickets = new ArrayList<>(Main.tickets.tickets);

        Collections.sort(tickets, (ticket, t1) -> (int) (ticket.getPrice() - t1.getPrice()));
        int count = 1;
        for (int i = 1; i < tickets.size(); i++){
            if(tickets.get(i).getPrice() == tickets.get(i-1).getPrice()){
                count++;
            }
            else{
                Printer.getInstance().WriteLine(tickets.get(i).toString());
                Printer.getInstance().WriteLine(count);
            }
        }
        Printer.getInstance().WriteLine(tickets.get(tickets.size()-1).toString());
        Printer.getInstance().WriteLine(count);
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }
}
