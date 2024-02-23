public class Room {
    private Boolean cupCake;
    public Room(){
        this.cupCake = true;
    }

    public Boolean getCupCake(){
        return this.cupCake;
    }

    public void eatCupCake(Guest guest){

        if(this.cupCake && !guest.getAteCupcake())
        {
            System.out.println("WooHoo I ate a cupcake");
            guest.eatCupcake();
        }

        this.cupCake = false;
    }

    public void replaceCupCake(Guest guest, int guestID){
        System.out.println("I see no cupcake");
        if(!this.cupCake)
        {
            if(guestID == 0) {
                System.out.println("ARGH NO CUPCAKE");
                System.out.println("I am the leader and I replaced the cupcake");
                this.cupCake = true;
                guest.incrementUniqueCount();
            }
            else{
                System.out.println("ARGH NO CUPCAKE");
            }
        }

    }

}
