package hello;

import hello.geometry.SquareMeters;

public class Ship {
    private SquareMeters square;
    private CargoTons cargo;

    public Ship(final SquareMeters square,final CargoTons cargo)throws NegativeDimensionException{
        this.square = new SquareMeters(square);
        this.cargo = new CargoTons(cargo);
    }

    public CargoTons getCargo(){
        return cargo;
    }

    public SquareMeters getSquare() {
        return square;
    }
}
