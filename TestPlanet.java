	import java.math.*;

/**
 *  Tests Planet's update() method
 */
public class TestPlanet {

    /**
     *  Tests update.
     */
    public static void main(String[] args) {
        Planet p1 = new Planet(1.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        Planet p2 = new Planet(11.0, 1.0, 3.0, 4.0, 5.0, "jupiter.gif");
        
        double force = p1.calcForceExertedBy(p2);

        System.out.println("the force between p1 and p2 is: " + force);
    }

    /**
     *  Checks whether or not two Doubles are equal and prints the result.
     *
     *  @param  expected    Expected double
     *  @param  actual      Double received
     *  @param  label       Label for the 'test' case
     *  @param  eps         Tolerance for the double comparison.
     */
    


    /**
     *  Checks the Planet class to make sure update works.
     */
    
}
