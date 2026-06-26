import java.util.Scanner;

public class Main {
    public static void printSeating(int[][] seating) {
        System.out.println("Current Seating Chart: ");
        for (int row[] : seating) {
            for (int seat : row) {
                System.out.print(seat + "\t");
            }
            System.out.println();
        }
    }

    public static void pickSeatByLocation(int[][] seating, int row, int col) {
        if (row < 0 || row >= seating.length || col < 0 || col >= seating[0].length) {
            System.out.println("Invalid Seat Location.");
        } else if (seating[row][col] == 0) {
            System.out.println("Seat at row: " + (row + 1) + ", column " + (col + 1) + " is already sold.");
        } else {
            int price = seating[row][col];
            seating[row][col] = 0;
            System.out.println("Seat at row " + (row + 1) + ", column " + (col + 1) + " purchased for $" + price + ".");
        }

    }

    public static void pickSeatByPrice(int[][] seating, int price) {
        boolean seatFound = false;
        for (int row = 0; row < seating.length; row++) {
            for (int col = 0; col < seating[row].length; col++) {
                if (seating[row][col] == price) {
                    seating[row][col] = 0;
                    System.out.println(
                            "Seat at row " + (row + 1) + ", column " + (col + 1) + " purchased for $" + price + ".");
                    seatFound = true;
                    break;
                }
            }
            if (seatFound)
                break;// ends the code if a seat has been found.
        }
        if (!seatFound) {
            System.out.println("No seat available at this price.");// this code is ran when a seat isn't found
        }
    }

    public static void main(String[] args) {
        int[][] seating = { { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 },
                { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
                { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 }, { 10, 10, 20, 20, 20, 20, 20, 20, 10, 10 },
                { 20, 20, 30, 30, 40, 40, 30, 30, 20, 20 }, { 20, 30, 30, 40, 50, 50, 40, 30, 30, 20 },
                { 30, 40, 50, 50, 50, 50, 50, 50, 40, 30 } };
        Scanner scanner = new Scanner(System.in);
        boolean done = false;

        while (!done) {
            printSeating(seating);
            System.out.println(
                    "Would you like to pick a seat by (1) location/row and column or (2) price? Enter 0 to exit.");
            int choice = scanner.nextInt();
            if (choice == 0) {
                done = true;
            } else if (choice == 1) {
                System.out.print("Enter row(1-9)");
                int row = scanner.nextInt();
                System.out.print("Enter col(1-10)");
                int col = scanner.nextInt();
                pickSeatByLocation(seating, row - 1, col - 1);// subtracts from the row and column values to input the
                                                              // proper index
            } else if (choice == 2) {
                System.out.println("Enter the price of the seat: ");
                int price = scanner.nextInt();
                pickSeatByPrice(seating, price);
            } else {
                System.out.println("Invalid Choice. Try again.");
            }
            System.out.println("Would you like to purchase another seat? (yes/no)");
            String cont = scanner.next();
            done = cont.equalsIgnoreCase("no");
        }
        scanner.close();

    }
}