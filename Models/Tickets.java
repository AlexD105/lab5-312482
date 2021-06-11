package com.company.Models;

import com.company.Printer;

import java.time.ZonedDateTime;
import java.util.ArrayList;

public class Tickets {
    public static int id = -1;
    public static  int id1 = -1;

    public ArrayList<Ticket> tickets = new ArrayList<>();

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public static Ticket Set_Fields() {
        Ticket product = new Ticket();//создаем перемнные
        product.setCoordinates(new Coordinates());
        product.setEvent(new Event());

        String name = getString("name");
        while (name == null || name.equals("")) {
            Printer.getInstance().InvalidValue();
            name = getString("name");
        }

        float price = getFloat("price");
        while (price <= 0) {
            Printer.getInstance().InvalidValue();
            price = getFloat("price");
        }

        Printer.getInstance().WriteLine("Вводится coordinate");

        long x = getLong("x");
        while (x > 146) {
            Printer.getInstance().InvalidValue();
            x = getLong("x");
        }

        float y = getFloat("Y");
        while (y < - 826) {
            Printer.getInstance().InvalidValue();
            y = getFloat("Y");
        }


        String comment = getString("comment");
        while (comment == null || comment.length() > 850) {
            Printer.getInstance().InvalidValue();
            comment = getString("comment");
        }


        boolean refundable = getBoolean("refundable");


        TicketType type = null;
        while (true){
            try{
                Printer.getInstance().WriteLine("Введите TicketType");
                for (TicketType TicketType: TicketType.values()) {
                    Printer.getInstance().Write("\t\t\t\t" + TicketType);
                }
                Printer.getInstance().WriteLine("");
                String next = Printer.getInstance().ReadLine();
                if(next.equals("null") || next.equals("")){
                    break;
                }
                type = TicketType.valueOf(next);
                break;
            }
            catch (Exception ignored){

            }
        }

        String name1 = getString("name");
        while (name1.equals("")) {
            Printer.getInstance().InvalidValue();
            name1 = getString("name");
        }

        int minAge = getInt("minAge");


        long ticketsCount = getLong("ticketsCount");
        while (ticketsCount <= 0) {
            Printer.getInstance().InvalidValue();
            ticketsCount = getLong("ticketsCount");
        }

        String description = getString("description");
        while (description == null || description.length() > 416) {
            Printer.getInstance().InvalidValue();
            description = getString("description");
        }

        ZonedDateTime time = getBTime("Date");


        product.setName(name);
        product.setCoordinates(new Coordinates(x, y));
        product.setPrice(price);
        product.setComment(comment);
        product.setRefundable(refundable);
        product.setType(type);
        product.setEvent(new Event(name1,time , minAge, ticketsCount, description));




        return product;
    }

    public static int getId() {
        id++;
        return id;
    }

    public static int getId1() {
        id1++;
        return id1;
    }

    public static String getString(String name){
        String str = "";
        while (str.equals("")){
            Printer.getInstance().WriteLine("Введите поле " + name);
            str = Printer.getInstance().ReadLine();
        }
        return str;
    }
    public static boolean getBoolean(String name){
        boolean str = false;
        while (true){
            try {
                Printer.getInstance().WriteLine("Введите поле " + name);
                str = Boolean.getBoolean(Printer.getInstance().ReadLine());
                break;
            }
            catch (Exception e){
                Printer.getInstance().InvalidValue();
            }
        }
        return str;
    }
    public static ZonedDateTime getBTime(String name){
        ZonedDateTime str = null;
        while (true){
            try {
                Printer.getInstance().WriteLine("Введите поле " + name);
                str = ZonedDateTime.parse(Printer.getInstance().ReadLine());
                break;
            }
            catch (Exception e){
                Printer.getInstance().InvalidValue();
            }
        }
        return str;
    }
    private static int getInt(String name){
        int str;
        while (true){
            try {
                Printer.getInstance().WriteLine("Введите поле " + name);
                str = Integer.parseInt(Printer.getInstance().ReadLine());
                break;
            }
            catch (Exception ignored){

            }
        }
        return str;
    }
    private static long getLong(String name){
        long str;
        while (true){
            try {
                Printer.getInstance().WriteLine("Введите поле " + name);
                str = Long.parseLong(Printer.getInstance().ReadLine());
                break;
            }
            catch (Exception ignored){

            }
        }
        return str;
    }
    private static double getDouble(String name){
        double str;
        while (true){
            try {
                Printer.getInstance().WriteLine("Введите поле " + name);
                str = Double.parseDouble(Printer.getInstance().ReadLine());
                break;
            }
            catch (Exception ignored){

            }
        }
        return str;
    }
    private static float getFloat(String name){
        float str;
        while (true){
            try {
                Printer.getInstance().WriteLine("Введите поле " + name);
                str = Float.parseFloat(Printer.getInstance().ReadLine());
                break;
            }
            catch (Exception ignored){

            }
        }
        return str;
    }


}
