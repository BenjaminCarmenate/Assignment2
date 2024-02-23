import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n = 0;
        Scanner userInput = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Enter Number of Guest: ");
        n = userInput.nextInt();

        Room room = new Room();
        ArrayList<Guest> guests = createGuests(n, room);

        final long startTime = System.currentTimeMillis();
        for(int i = 0; i < n; i++)
        {
            guests.get(i).run();
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Total execution time in seconds: " + (float)(endTime - startTime)/1000);
    }
    public static ArrayList<Guest> createGuests(int n, Room room){
        ArrayList<Guest> guests = new ArrayList<Guest>();
        for(int i = 0; i < n; i++)
            guests.add(new Guest(i, room));
        return guests;
    }
}