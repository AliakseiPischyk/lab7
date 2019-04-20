package hello.shipManagementService;

import hello.Ship;
import hello.geometry.VolumeMeters3;
import hello.portManagmentService.Dock;
import hello.portManagmentService.Port;
import hello.portManagmentService.PortsDatabase;
import hello.portManagmentService.Warehouse;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class ShipManager {
    public static boolean canFindPlaceForMooring(final PortsDatabase portsDatabase, final Ship ship) {
        final List<Port> ports = portsDatabase.getPorts();
        for (final Port port : ports) {
            final Warehouse warehouse = port.getWarehouse();
            if (warehouse.canStore(ship.getCargo().getVolume())) {
                final List<Dock> docks = port.getDocks();
                for (final Dock dock : docks) {
                    if (dock.isFree()) {
                        if (dock.hasEnoughSpaceFor(ship)) {
                            return true;
                        }
                    }

                }
            }
        }
        return false;
    }

    public static JSONObject answerWhereShipCanMoore(final PortsDatabase portsDatabase, final Ship ship) {
        JSONObject responce = new JSONObject();
        List<Port> ports = portsDatabase.getPorts();
        for (Port port : ports) {
            Warehouse warehouse = port.getWarehouse();
            if (warehouse.canStore(ship.getCargo().getVolume())) {
                List<Dock> docks = port.getDocks();
                for (Dock dock : docks) {
                    if (dock.isFree()) {
                        if (dock.hasEnoughSpaceFor(ship)) {
                            try {
                                responce.put(Dock.class.getSimpleName(), docks.indexOf(dock));
                                responce.put(Port.class.getSimpleName(), ports.indexOf(port));
                            } catch (final JSONException e) {
                            }

                            return responce;
                        }
                    }

                }
            }
        }
        return responce;
    }

    public static String explainReasonWhyCantMoore(final PortsDatabase portsDatabase, final Ship ship) {
        StringBuilder response = new StringBuilder();
        final List<Port> ports = portsDatabase.getPorts();
        final VolumeMeters3 shipCargo = ship.getCargo().getVolume();
        int amountOfWarehouseWhichCanStoreShipCargo = 0;
        int amountOfPortsWhichShipCanMooreTo = 0;
        for (final Port port : ports) {
            if (port.getWarehouse().canStore(shipCargo)) {//case when total warehouse capacity is less then ship cargo is not considered
                amountOfWarehouseWhichCanStoreShipCargo++;
                final List<Dock> docks = port.getDocks();
                for (final Dock dock : docks) {
                    if (dock.hasEnoughSpaceFor(ship)) {
                        amountOfPortsWhichShipCanMooreTo++;
                        break;
                    }
                }
            }
        }
        if (true) {//gonna add logic
            response.append("Because");
        }
        return response.toString();
    }
}
