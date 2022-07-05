package ru.netology.tiketsSearch;

public class Tickets implements Comparable<Tickets> {

    private int id;
    private int price;
    private String departureAirport;
    private String arrivalAirport;
    private int travelTime;

    public Tickets(int id, int price, String departureAirport, String arrivalAirport, int travelTime) {
        this.id = id;
        this.price = price;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public int getTravelTime() {
        return travelTime;
    }

    @Override
    public int compareTo(Tickets o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }

    public boolean matches(Tickets ticket, String dAirport, String aAirport) {
        if (departureAirport.contains(dAirport)) {
            if (arrivalAirport.contains(aAirport)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
