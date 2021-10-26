import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

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

                 new Object[] {"B4","B5"}} //Expected seats to be provided by the cinema (string array)}*/



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

    }
}
