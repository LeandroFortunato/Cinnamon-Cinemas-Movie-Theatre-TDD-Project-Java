import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)

public class SeatingPlanTest {
    private String[] input;
    private String[] expectedOutput;
    private SeatingPlan newSeatingPlan ;

    public SeatingPlanTest(Object[] pInput, Object[] pExpectedOutput) {
        this.input = Arrays.asList(pInput).toArray(new String[pInput.length]);
        this.expectedOutput = Arrays.asList(pExpectedOutput).toArray(new String[pExpectedOutput.length]);;
    }

    @Parameterized.Parameters
    public static Collection PurchasesNotSequentialWithDifferentNumberOfAvailableSeatsEachTime() {

        return Arrays.asList(new Object[][][] {

                {new Object [] {  "7", // Available number of seats at that moment (integer)
                                   "2" ,  //Number of tickets that are being purchased (integer)
                                   "3", // Maximum number of seats that can be purchased on a single sale
                                   "3",  // Number of rows (first one will always be A)
                                   "5"}, // // Number of seats in a row

                 new Object[] {"B4","B5"}}, //Expected seats to be provided by the cinema (string array)}*/

                {new Object [] {  "15", "3" ,"3","3","5"},
                        new Object[] {"A1", "A2", "A3"}},

                {new Object [] {  "1", "1" ,"3","3","5"},
                        new Object[] {"C5"}},

                {new Object [] {  "9", "2" ,"3","3","5"},
                        new Object[] {"B2","B3"}},

                {new Object [] {  "2", "3" ,"3","3","5"},
                        new Object[] {}},

                {new Object [] {  "9", "3" ,"3","3","5"},
                        new Object[] {"B2","B3","B4"}},

                // here increasing maximum of sales permission to 5 seats

                {new Object [] {  "12", "4" ,"5","3","5"},
                        new Object[] {"A4","A5", "B1", "B2"}},

                // Now in a bigger cinema with 9 rows and 10 seats on each row

                {new Object [] {  "50", "4" ,"5","9","10"},
                        new Object[] {"E1", "E2", "E3", "E4"}},

                // Now in a bigger cinema with 15 rows and 7 seats on each row

                {new Object [] {  "43", "4" ,"5","15","7"},
                        new Object[] {"I7", "J1", "J2", "J3"}},

                // The same as before, but just 4 seats left

                {new Object [] {  "4", "4" ,"5","15","7"},
                        new Object[] {"O4", "O5", "O6", "O7"}},  // row O ("ou")

                // The same as before, but now just 3 seats left (1 less, not enough)

                {new Object [] {  "3", "4" ,"5","15","7"},
                        new Object[] {}},  // row O ("ou")

        });
    }

    @Test
    public void CheckIfMaximumNumberOfSeatsIsNotExceededAndIfAfterPurchaseRightSeatsAreReturned() {


        // ------------------- Arrange object  -----------------------------------
        newSeatingPlan = new SeatingPlan(Integer.parseInt(this.input[0]),
                                        Integer.parseInt(this.input[3]),
                                        Integer.parseInt(this.input[4]));

// ------------------- Act-----------------------------------------
        System.out.println("Expected: " +   Arrays.toString(this.expectedOutput));
        ArrayList<String> result = newSeatingPlan.buyTickets(Integer.parseInt(this.input[1]));
        System.out.println("Got: " +  result);

// ------------------- Assert -----------------------------------------

        assertEquals(String.join("",this.expectedOutput),String.join("",result));

        assertTrue(Integer.parseInt(this.input[2])>=Integer.parseInt(this.input[1])); //Max.sale permission

    }
}
