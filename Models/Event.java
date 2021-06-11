package com.company.Models;

import com.company.Printer;

import java.time.ZonedDateTime;

public class Event {
    private Long id;
    private String name;
    private java.time.ZonedDateTime date;
    private Integer minAge;
    private long ticketsCount;
    private String description;

    public Event(String name, ZonedDateTime date, Integer minAge, long ticketsCount, String description) {
        setName(name);
        setDate(date);
        setMinAge(minAge);
        setTicketsCount(ticketsCount);
        setDescription(description);
        id = (long)Tickets.getId1();
    }


    public Event() {
        id = (long)Tickets.getId1();
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", minAge=" + minAge +
                ", ticketsCount=" + ticketsCount +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.equals("")){
            name = "name";
            Printer.getInstance().WriteLine("Значение неверно. Заменено");
        }
        this.name = name;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public void setMinAge(Integer minAge) {
        this.minAge = minAge;
    }

    public long getTicketsCount() {
        return ticketsCount;
    }

    public void setTicketsCount(long ticketsCount) {
        if(ticketsCount < 0){
            ticketsCount = 0;
            Printer.getInstance().WriteLine("Значение неверно. Заменено");
        }
        this.ticketsCount = ticketsCount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if(description.length() > 416){
            description = "desc";
            Printer.getInstance().WriteLine("Значение неверно. Заменено");
        }
        this.description = description;
    }
}