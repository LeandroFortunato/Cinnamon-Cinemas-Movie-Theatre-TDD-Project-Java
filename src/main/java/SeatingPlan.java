import java.util.ArrayList;

public class SeatingPlan {
    public ArrayList<String> availableSeats = new ArrayList();
    public ArrayList<String> allPurchasedSeats = new ArrayList();
    public String rowLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public int delimiterNumberOfRows; // will define number of letter A to ...
    public int delimiterSeatsPerRow;
    public int numberOfAvailableSeatsRightNow;


    public SeatingPlan(int pNumberOfAvailableSeatsRightNow, int pNumberOfRows, int pSeatsPerRow) {
        this.numberOfAvailableSeatsRightNow = pNumberOfAvailableSeatsRightNow;
        this.delimiterNumberOfRows = pNumberOfRows;
        this.delimiterSeatsPerRow = pSeatsPerRow;

        System.out.println("Seating plan: ");
        System.out.println("---------------------------------------------");

        for (String letter: rowLetters.substring(0,this.delimiterNumberOfRows).split("")){
            for (int i = 1 ; i < this.delimiterSeatsPerRow+1 ;i++ ){
                this.availableSeats.add(letter+i);
            }
            //// no change with array here. Just formatting to print /////////
            System.out.println("Row ("+letter+")--> "+
                                        (this.availableSeats.subList
                                        (this.availableSeats.size()-this.delimiterSeatsPerRow,
                                         this.availableSeats.size())));
            ///////////////////////////////////////////////////////////////////
        }
        System.out.println("---------------------------------------------");

        this.availableSeats = new ArrayList<String>
                (this.availableSeats.subList(this.availableSeats.size()-pNumberOfAvailableSeatsRightNow,
                                             this.availableSeats.size())); // drop ones already sold

        System.out.println("Available seats for purchase at this moment: "+availableSeats);

    }

    public ArrayList<String> buyTickets (int numberOfTickets) {

        ArrayList<String> newPurchaseSeats = new ArrayList<String>(){};

        if (numberOfTickets > this.availableSeats.size()) {
            return newPurchaseSeats;
        } else {
            newPurchaseSeats = new ArrayList<String>(this.availableSeats.subList(0, numberOfTickets));
            this.availableSeats = new ArrayList<String>(this.availableSeats.subList(numberOfTickets,
                    this.availableSeats.size()));
            this.allPurchasedSeats.addAll(newPurchaseSeats);

            return newPurchaseSeats;
        }
    }
/*
    public ArrayList<String> getAvailableSeats () {
        return this.availableSeats;}*/

}
