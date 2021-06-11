package com.company;

import com.company.Models.Coordinates;
import com.company.Models.Event;
import com.company.Models.Ticket;
import com.company.Models.TicketType;

import javax.swing.text.StyledEditorKit;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.stream.Collectors;

public class Converter {
    private static String path = "";
    private static Converter instance;

    public synchronized static Converter getInstance() {
        if(instance == null){
            instance = new Converter();
        }
        return instance;
    }
    public Converter(){
        path = System.getenv("laba");
    }

    public void SetObject(){
        try{
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(path));
            for (Ticket ticket : Main.tickets.getTickets()){
                String str = ticket.getName() + "," + ticket.getCoordinates().getX() + "," +
                        ticket.getCoordinates().getY() + "," + ticket.getCreationDate().toString() + "," +
                        ticket.getPrice() + "," + ticket.getComment() + "," + ticket.isRefundable() + "," +
                        ticket.getType() + "," + ticket.getEvent().getName() + "," + ticket.getEvent().getDate() + "," +
                        ticket.getEvent().getMinAge() + "," + ticket.getEvent().getTicketsCount() + "," + ticket.getEvent()
                        .getDescription();
                outputStreamWriter.write(str, 0, str.length());
            }
            outputStreamWriter.close();
        }
        catch (Exception e){
            Printer.getInstance().WriteLine("Данные не сохранены" + e.getMessage());
            e.printStackTrace();
        }
    }

    public void getObject(){
        try {
            FileReader fileReader = new FileReader(path);
            char[] chars = new char[(int)new File(path).length()];
            fileReader.read(chars);
            String[] strings = new String(chars).split("\r\n");
            for (String str : strings){
                String[] strings1 = str.split(",");
                try{
                    Ticket ticket = new Ticket();
                    ticket.setName(strings1[0]);
                    ticket.setCoordinates(new Coordinates(Long.parseLong(strings1[1]), Float.parseFloat(strings1[2])));
                    ticket.setCreationDate(LocalDateTime.parse(strings1[3]));
                    ticket.setPrice(Float.parseFloat(strings1[4]));
                    ticket.setComment(strings1[5]);
                    ticket.setRefundable(Boolean.parseBoolean(strings1[6]));
                    ticket.setType(TicketType.valueOf(strings1[7]));
                    ticket.setEvent(new Event(strings1[8], ZonedDateTime.parse(strings1[9]), Integer.parseInt(strings1[10]),
                            Integer.parseInt(strings1[11]), strings1[12]));

                    Main.tickets.getTickets().add(ticket);
                }
                catch (Exception e){
                    Printer.getInstance().WriteLine("Объект пропущен");
                }
            }
        }
        catch (IllegalArgumentException e){
            Printer.getInstance().WriteLine("Обьект введен неверно. Он пропускается " + e.getMessage());
        }
        catch (DateTimeParseException e){
            Printer.getInstance().WriteLine("Время введено не по формату. Обьект пропускается");
        }
        catch (IndexOutOfBoundsException e){
            Printer.getInstance().WriteLine("В обьекте были не все значения. Обьект пропускается");
        }
        catch (Exception e){
            Printer.getInstance().WriteLine(e.getMessage());
        }
    }
}
