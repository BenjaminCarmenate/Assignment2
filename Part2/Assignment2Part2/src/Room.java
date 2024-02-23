import java.util.concurrent.locks.ReentrantLock;

public class Room {
    ReentrantLock lock;
    Room(){
        lock = new ReentrantLock();
    }

    public void enterRoom(int guestId){
        lock.lock();
        try{
            System.out.println("Guest " + guestId + " is in the vase room");
        }finally {
            lock.unlock();
            System.out.println("Guest " + guestId + " left the vase room");
        }
    }
}
