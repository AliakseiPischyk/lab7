package hello.portManagmentService;

import hello.geometry.VolumeMeters3;
import hello.NegativeDimensionException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WarehouseTest {
    private Warehouse warehouseLowCapacity;
    private Warehouse warehouseMediumCapacity;
    private Warehouse warehouseHighCapacity;
    private VolumeMeters3 volumeLow;
    private VolumeMeters3 volumeMedium;
    private VolumeMeters3 volumeHigh;

    @Before
    public void setUp()throws NegativeDimensionException{
        volumeLow = new VolumeMeters3((short)10,(short)10,(short)10);
        volumeMedium = new VolumeMeters3((short)50,(short)50,(short)50);
        volumeHigh = new VolumeMeters3((short)100,(short)100,(short)100);

        warehouseLowCapacity = new Warehouse(volumeLow);
        warehouseMediumCapacity = new Warehouse(volumeMedium);
        warehouseHighCapacity = new Warehouse(volumeHigh);
    }

    @Test
    public void canStore() {
        assertTrue(warehouseLowCapacity.canStore(volumeLow));
        assertFalse(warehouseLowCapacity.canStore(volumeMedium));
        assertFalse(warehouseLowCapacity.canStore(volumeHigh));

        assertTrue(warehouseMediumCapacity.canStore(volumeLow));
        assertTrue(warehouseMediumCapacity.canStore(volumeMedium));
        assertFalse(warehouseMediumCapacity.canStore(volumeHigh));

        assertTrue(warehouseHighCapacity.canStore(volumeLow));
        assertTrue(warehouseHighCapacity.canStore(volumeMedium));
        assertTrue(warehouseHighCapacity.canStore(volumeHigh));
    }
}