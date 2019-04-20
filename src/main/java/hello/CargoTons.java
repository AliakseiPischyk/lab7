package hello;

import hello.geometry.VolumeMeters3;

public class CargoTons {
    protected short weight;
    protected VolumeMeters3 volume;

    public CargoTons (final short weightTons,final VolumeMeters3 volume){
        this.weight = weightTons;
        this.volume = new VolumeMeters3(volume);
    }

    public CargoTons(final CargoTons cargo){
        weight = cargo.weight;
        volume = new VolumeMeters3(cargo.volume);
    }

    public short getWeight() {
        return weight;
    }
    public VolumeMeters3 getVolume() {
        return volume;
    }
}
