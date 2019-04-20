package hello.portManagmentService;

import hello.geometry.SquareMeters;
import hello.NegativeDimensionException;
import hello.Ship;

import java.util.Random;

public class Dock {
    private boolean isFree;
    private SquareMeters square;

    public Dock()throws NegativeDimensionException {
        isFree = true;
        Random random = new Random();
        square = new SquareMeters((short)(random.nextInt(50)+10),(short)(random.nextInt(50)+10));
    }

    @Override
    public String toString() {
        String dockIsFreeOrNotAnswer = "free";
        if (!this.isFree){
            dockIsFreeOrNotAnswer = "occupied";
        }
        return "Dock is " + dockIsFreeOrNotAnswer + " " + square.toString();
    }

    public boolean hasEnoughSpaceFor(Ship ship) {
        return square.calculate() > ship.getSquare().calculate();//stupid logic
    }

    public boolean isFree() {
        return this.isFree;
    }
}
