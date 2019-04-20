package hello.portManagmentService;

import hello.geometry.VolumeMeters3;

public class Warehouse {
    private VolumeMeters3 volume;

    public Warehouse(final VolumeMeters3 volume){
        this.volume = volume;
    }
    protected void changeCapacity(final VolumeMeters3 newVolume){
        this.volume = new VolumeMeters3(newVolume);
    }
    public VolumeMeters3 getVolume(){
        return volume;
    }
    public boolean canStore(final VolumeMeters3 volume){
        return this.volume.calculate() >= volume.calculate(); //stupid logic
    }
}
