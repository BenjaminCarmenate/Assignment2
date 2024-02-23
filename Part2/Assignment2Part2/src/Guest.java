public class Guest extends Thread{
    int guestId;
    Room room;
    public void run(){
        room.enterRoom( this.guestId);
    }
    public Guest(int guestId, Room room)
    {
        this.guestId = guestId;
        this.room = room;
    }



}
