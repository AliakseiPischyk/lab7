package hello.portManagmentService;

import hello.geometry.VolumeMeters3;
import hello.id_s.ID_s;
import hello.NegativeDimensionException;

import java.util.LinkedList;
import java.util.List;

public class Port {
    private Integer ID;
    private List<Dock> docks = new LinkedList<>();
    private Warehouse warehouse;


    public Port(final Warehouse warehouse, final List<Dock> docks)throws NegativeDimensionException{
        this.ID = ID_s.generate();
        this.warehouse = warehouse;
        this.docks.addAll(docks);
    }

    public void attachDock(final Dock dock){
        docks.add(dock);
    }

    public void changeWarehouseCapacity(final VolumeMeters3 newVolumeMeters3Meters3){
        warehouse.changeCapacity(newVolumeMeters3Meters3);
    }

    public Integer getID(){
        return ID;
    }

    public Warehouse getWarehouse(){
        return this.warehouse;
    }

    public List<Dock> getDocks() {
        return docks;
    }

    String getDocksInfo(){
        StringBuilder docksInfo = new StringBuilder();
        int index=1;
        for (Dock dock : docks){
            docksInfo.append(index++);
            docksInfo.append(")");
            docksInfo.append(dock.toString());
        }
        return docksInfo.toString();
    }

    @Override
    public String toString() {

        return "Port id: " + this.ID + "\n" + "Docks info: " + this.getDocksInfo() + "\n" + "Warehouse info: " + this.warehouse.getVolume().toString();
    }
}
