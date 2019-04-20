package hello.geometry;

import hello.NegativeDimensionException;

public class SquareMeters {
    protected short lengthMeters;
    protected short widthMeters;

    public SquareMeters(final short widthMeters, final short lengthMeters) throws NegativeDimensionException {
        if (widthMeters <= 0 || lengthMeters <= 0){
            throw new NegativeDimensionException();
        }else{
            this.lengthMeters = lengthMeters;
            this.widthMeters = widthMeters;
        }
    }
    public SquareMeters(final SquareMeters sqare){
        this.widthMeters = sqare.widthMeters;
        this.lengthMeters = sqare.lengthMeters;
    }

    public int calculate(){
        return lengthMeters * widthMeters;
    }

    @Override
    public String toString() {
        return "length: " + lengthMeters + " width: " + widthMeters;
    }
}
