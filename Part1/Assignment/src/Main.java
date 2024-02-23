import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore binarySemaphore = new Semaphore(1);
        Random rand = new Random();

        int n = 0;
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter Number of Guest: ");
        n = userInput.nextInt();

        Room room = new Room();
        ArrayList<Guest> guests = createGuests(n, binarySemaphore, room);

        final long startTime = System.currentTimeMillis();
        while(guests.get(0).getUniqueCount() < n)
        {
            int guestChoice = rand.nextInt(n);
            System.out.println();
            System.out.println("Guest " + guestChoice + " Entered");
            guests.get(guestChoice).run();
            System.out.println("Guest " + guestChoice + " Exited");
            System.out.println();
        }
        final long endTime = System.currentTimeMillis();

        for(int i = 0; i < n; i++)
            System.out.println("Guest " + i + " " + guests.get(i).toString());

        System.out.println("Total execution time in seconds: " + (float)(endTime - startTime)/1000);
    }
    public static ArrayList<Guest> createGuests(int n, Semaphore binarySemaphore, Room room){
        ArrayList<Guest> guests = new ArrayList<Guest>();
        for(int i = 0; i < n; i++)
            guests.add(new Guest(binarySemaphore, room, i));
        return guests;
    }
}