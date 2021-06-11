package com.company.Models;

import com.company.Printer;

public class Coordinates {
    private Long x;
    private Float y;

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Coordinates(Long x, Float y) {
        setX(x);
        setY(y);
    }

    public Coordinates() {
    }

    public Long getX() {
        return x;
    }

    public void setX(Long x) {
        if(x > 146){
            x = (long)0;
            Printer.getInstance().WriteLine("Значение неверно. Заменено");
        }
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        if(y < -826){
            y = (float)0;
            Printer.getInstance().WriteLine("Значение неверно. Заменено");
        }
        this.y = y;
    }
}