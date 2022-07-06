package cinema;

import java.util.Scanner;

public class Cinema {

    private static final String ROWS_PROMPT = "Enter the number of rows:";
    private static final String ROW_NUMBER_PROMPT = "Enter a row number:";
    private static final String SEATS_PROMPT = "Enter the number of seats in each row:";
    private static final String SEAT_NUMBER_PROMPT = "Enter a seat number in that row:";
    private static final String TOTAL_INCOME_HEADER = "Total income: $%d\n";
    private static final String TICKET_PRICE_HEADER = "Ticket price: $%d\n";
    private static final String NUMBER_OF_PURCHASED_TICKETS_HEADER = "Number of purchased tickets: %d\n";
    private static final String PERCENTAGE_HEADER = "Percentage: %.2f%%\n";
    private static final String CURRENT_INCOME_HEADER = "Current income: $%d\n";
    private static final String MENU = "1. Show the seats\n"
            + "2. Buy a ticket\n"
            + "3. Statistics\n"
            + "0. Exit";
    private static final String TICKET_PURCHASED_MESSAGE = "That ticket has already been purchased!";
    private static final String WRONG_INPUT_MESSAGE = "Wrong input!\n";
    private static final String BOOKED = "B";
    private static final String SEAT = "S";
    private static final Integer PREMIUM_PRICE = 10;
    private static final Integer STANDARD_PRICE = 8;
    private static Scanner scanner = new Scanner(System.in);
    private static String[][] room;
    private static int rows = 7;
    private static int seats = 8;
    private static int row;
    private static int seat;
    private static int command;

    private static void print(String text) {
        System.out.print(String.format("%s ", text));
    }

    private static void print(Integer i) {
        print(String.valueOf(i));
    }

    public static void main(String[] args) {
        initializeRoom();
        do {
            displayMenu();
            command = readCommand();
            if (command == 1) {
                printRoom();
            } else if (command == 2) {
                bookSeat();
            } else if (command == 3) {
                statistics();
            }
        } while (command != 0);
    }

    private static void statistics() {
        System.out.printf(NUMBER_OF_PURCHASED_TICKETS_HEADER, getNumberOfPurchasedTickets());
        System.out.printf(PERCENTAGE_HEADER, getPercentageOfPurchasedTickets());
        System.out.printf(CURRENT_INCOME_HEADER, getCurrentIncome());
        System.out.printf(TOTAL_INCOME_HEADER, getTotalIncome());
        System.out.println();
    }

    private static int getCurrentIncome() {
        int currentIncome = 0;
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (BOOKED.equals(room[i][j])) {
                    currentIncome += getTicketPrice(i + 1);
                }
            }
        }
        return currentIncome;
    }

    private static float getPercentageOfPurchasedTickets() {
        return 1f * getNumberOfPurchasedTickets() / seats / rows * 100;
    }

    private static int getNumberOfPurchasedTickets() {
        int bookedCnt = 0;
        for (int i = 0; i < room.length; i++) {
            for (int j = 0; j < room[i].length; j++) {
                if (BOOKED.equals(room[i][j])) {
                    bookedCnt++;
                }
            }
        }
        return bookedCnt;
    }

    private static int readCommand() {
        return scanner.nextInt();
    }

    private static void bookSeat() {
        boolean booked = false;
        while (!booked) {
            try {
                System.out.println(ROW_NUMBER_PROMPT);
                row = scanner.nextInt();
                System.out.println(SEAT_NUMBER_PROMPT);
                seat = scanner.nextInt();
                if (BOOKED.equals(room[row - 1][seat - 1])) {
                    System.out.println(TICKET_PURCHASED_MESSAGE);
                } else {
                    room[row - 1][seat - 1] = BOOKED;
                    booked = true;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(WRONG_INPUT_MESSAGE);
            }
        }
        System.out.println();
        printPrice();
    }

    private static void initializeRoom() {
        System.out.println(ROWS_PROMPT);
        rows = scanner.nextInt();
        System.out.println(SEATS_PROMPT);
        seats = scanner.nextInt();
        room = new String[rows][seats];
        System.out.println();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                room[i][j] = SEAT;
            }
        }
    }

    private static void printPrice() {
        System.out.println(String.format(TICKET_PRICE_HEADER, getTicketPrice(row)));
    }

    private static Integer getTicketPrice(int row) {
        if (rows * seats <= 60) {
            return PREMIUM_PRICE;
        } else if (row <= rows / 2) {
            return PREMIUM_PRICE;
        } else {
            return STANDARD_PRICE;
        }
    }

    private static int getTotalIncome() {
        Integer income = 0;
        if (rows * seats <= 60) {
            income = rows * seats * PREMIUM_PRICE;
        } else {
            int firstHalf = rows / 2;
            income = firstHalf * seats * PREMIUM_PRICE + (rows - firstHalf) * seats * STANDARD_PRICE;
        }
        return income;
    }

    private static void printRoom() {
        System.out.println("Cinema:");
        for (int i = 0; i < rows + 1; i++) {
            for (int j = 0; j < seats + 1; j++) {
                if (i == 0) {
                    if (j == 0) {
                        print(" ");
                    } else {
                        print(j);
                    }
                } else {
                    if (j == 0) {
                        print(i);
                    } else {
                        print(room[i - 1][j - 1]);
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void displayMenu() {
        System.out.println(MENU);
    }

}