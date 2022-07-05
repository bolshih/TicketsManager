package ru.netology.tiketsSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketsManagerTests {

    TicketsRepository repo = new TicketsRepository();
    TicketsManager manager = new TicketsManager(repo);

    Tickets ticket1 = new Tickets(1, 500, "AGK", "MOW", 345);
    Tickets ticket2 = new Tickets(2, 421, "MOW", "AGK", 345);
    Tickets ticket3 = new Tickets(3, 900, "SFX", "YBO", 600);
    Tickets ticket4 = new Tickets(4, 200, "MOW", "AGK", 360);
    Tickets ticket5 = new Tickets(5, 345, "KAF", "MOW", 435);
    Tickets ticket6 = new Tickets(6, 500, "MOW", "AGK", 345);
    Tickets ticket7 = new Tickets(7, 435, "PAB", "UAL", 365);
    Tickets ticket8 = new Tickets(8, 2234, "YAG", "PAB", 900);

    @BeforeEach
    public void setup() {
        repo.addTicket(ticket1);
        repo.addTicket(ticket2);
        repo.addTicket(ticket3);
        repo.addTicket(ticket4);
        repo.addTicket(ticket5);
        repo.addTicket(ticket6);
        repo.addTicket(ticket7);
        repo.addTicket(ticket8);
    }

    @Test

    public void shouldAddTicket() {

        Tickets[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        Tickets[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void shouldFindBy() {

        Tickets[] expected = {ticket4, ticket2, ticket6};
        Tickets[] actual = manager.searchBy("MOW", "AGK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //нет совпадений

    public void shouldFindByNot() {

        Tickets[] expected = {};
        Tickets[] actual = manager.searchBy("JOW", "UGK");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //одно совпадение

    public void shouldFindByOne() {

        Tickets[] expected = {ticket7};
        Tickets[] actual = manager.searchBy("PAB", "UAL");

        Assertions.assertArrayEquals(expected, actual);
    }
}
