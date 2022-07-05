package ru.netology.tiketsSearch;

import java.util.Arrays;


public class TicketsManager {

    private TicketsRepository repo;

    public TicketsManager(TicketsRepository repo) {
        this.repo = repo;
    }

    public void addTikets(Tickets ticket) {
        repo.addTicket(ticket);
    }

    public Tickets[] findAll() {
        return repo.getTickets();
    }

    public Tickets[] searchBy(String from, String to) {
        Tickets[] result = new Tickets[0];
        int count = 0;
        for (Tickets ticket : repo.getTickets()) {
            if (ticket.matches(ticket, from, to)) {
                Tickets[] tmp = new Tickets[result.length + 1];
                if (count > 0) {
                    for (int i = 0; i < result.length; i++) {
                        tmp[i] = result[i];
                    }
                }
                tmp[count] = ticket;
                result = tmp;
                count++;
            }
        }
        Arrays.sort(result);
        return result;
    }


}
