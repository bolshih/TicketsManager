package ru.netology.tiketsSearch;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<Tickets> {

     public int compare(Tickets o1, Tickets o2) {
        return o1.getTravelTime() - o2.getTravelTime();
    }
}
