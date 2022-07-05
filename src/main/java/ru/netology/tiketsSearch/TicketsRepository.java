package ru.netology.tiketsSearch;

public class TicketsRepository {

    private Tickets[] tickets = new Tickets[0];

    public TicketsRepository() {
    }

    public void addTicket(Tickets ticket) {
        Tickets[] tmp = new Tickets[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Tickets[] getTickets() {
        return tickets;
    }

    public Tickets[] removeById(int id) {
        Tickets[] tmp = new Tickets[tickets.length - 1];
        int copyToIndex = 0;
        for (Tickets ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
        return tickets;
    }


}
