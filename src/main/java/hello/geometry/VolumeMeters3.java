package hello.geometry;

import hello.NegativeDimensionException;

public class VolumeMeters3 {
    protected short heightMeters;
    protected SquareMeters square;

    public VolumeMeters3(final short widthMeters,
                         final short lengthMeters,
                         final short heightMeters)throws NegativeDimensionException {
        square = new SquareMeters(widthMeters,lengthMeters);
        this.heightMeters = heightMeters;
    }

    public VolumeMeters3(final VolumeMeters3 volume){
        heightMeters = volume.heightMeters;
        square = volume.square;
    }

    public int calculate(){
        return heightMeters * square.calculate();
    }

    @Override
    public String toString() {
        return "height: " + heightMeters + " " + square.toString();
    }
}
