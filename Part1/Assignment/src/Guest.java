import java.util.concurrent.Semaphore;

public class Guest extends Thread{
    private Boolean ateCupcake;
    private int uniqueCount;
    private Semaphore semaphore;
    private Room room;
    private int guestID;

    public Guest(Semaphore semaphore, Room room, int guestID){
        this.ateCupcake = false;
        this.uniqueCount = 0;
        this.semaphore = semaphore;
        this.room = room;
        this.guestID = guestID;
    }

    public void run(){
        try{
            semaphore.acquire();
            if(room.getCupCake() && !this.ateCupcake) {
                room.eatCupCake(this);
            }
            else if(!room.getCupCake() && guestID == 0){
                room.replaceCupCake(this, guestID);
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            semaphore.release();
        }
    }

    public Boolean getAteCupcake() {
        return ateCupcake;
    }


    public void eatCupcake(){
        if(!this.ateCupcake) {
            System.out.println("That was my first time eating the cupcake it was great");
        }
        else
        {
            System.out.println("Too many cupcakes my health is deteriorating");
        }

        this.ateCupcake= true;
    }
    public String toString(){
        if(this.ateCupcake)
            return  "Ate Cupcake";
        else
            return  "Did Not Eat Cupcake";
    }
    public void incrementUniqueCount(){
        this.uniqueCount++;
    }

    public int getUniqueCount(){
        return this.uniqueCount;
    }
}
