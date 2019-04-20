package hello.geometry;

import hello.NegativeDimensionException;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareMetersTest {
    private SquareMeters squareMeters1;
    private SquareMeters squareMeters2;
    private SquareMeters squareMeters3;

    @Test(expected = NegativeDimensionException.class)
    public void NegativeSquareMeters() throws NegativeDimensionException {

        squareMeters1 = new SquareMeters((short)-1,(short)-1);


    }
    @Test
    public void calculate() {
        try{
           squareMeters1 = new SquareMeters((short)5,(short)5);
           squareMeters2 = new SquareMeters((short)50,(short)50);
           squareMeters3 = new SquareMeters((short)100,(short)100);

        }catch (final NegativeDimensionException e){}
        assertEquals(25,squareMeters1.calculate());
        assertEquals(2500,squareMeters2.calculate());
        assertEquals(10000,squareMeters3.calculate());
    }

}