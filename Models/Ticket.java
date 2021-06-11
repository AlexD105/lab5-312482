package com.company.Models;

import com.company.Printer;

import java.time.LocalDateTime;

public class Ticket implements Comparable<Ticket>{
    private Integer id;
    private String name;
    private Coordinates coordinates;
    private java.time.LocalDateTime creationDate;
    private float price;
    private String comment;
    private boolean refundable;
    private TicketType type;
    private Event event;

    public Ticket() {
        creationDate = LocalDateTime.now();
        id = Tickets.getId();
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", price=" + price +
                ", comment='" + comment + '\'' +
                ", refundable=" + refundable +
                ", type=" + type +
                ", event=" + event +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        if(price <= 0 ){
            price = 1;
            Printer.getInstance().WriteLine("Значение неверно. Заменено");
        }
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if(comment.length() > 850){
            comment = "comment";
            Printer.getInstance().WriteLine("Значение неверно. Заменено");
        }
        this.comment = comment;
    }

    public boolean isRefundable() {
        return refundable;
    }

    public void setRefundable(boolean refundable) {
        this.refundable = refundable;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public int compareTo(Ticket ticket) {
        return name.compareTo(ticket.name);
    }
}