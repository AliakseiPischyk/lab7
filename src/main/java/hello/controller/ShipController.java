package hello.controller;

import hello.CargoTons;
import hello.geometry.SquareMeters;
import hello.geometry.VolumeMeters3;
import hello.NegativeDimensionException;
import hello.portManagmentService.PortsDatabase;
import hello.Ship;
import hello.shipManagementService.ShipManager;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ShipController {

    PortsDatabase portsDatabase;

    @RequestMapping( value = "/provideDock",
            params = {"shipLen",
                    "shipWidth",
                    "cargoTons",
                    "cargoLen",
                    "cargoWidth",
                    "cargoHeight"},
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
        public String findDockForShip(@RequestParam Map<String,String> params) {
        JSONObject response = new JSONObject();

        try{
            final Ship ship = new Ship( new SquareMeters((Integer.valueOf(params.get("shipLen")).shortValue()) ,
                                            Integer.valueOf(params.get("shipWidth")).shortValue()),
                                        new CargoTons(Integer.valueOf(params.get("cargoTons")).shortValue(),
                                            new VolumeMeters3(Integer.valueOf(params.get("cargoLen")).shortValue(),
                                                    Integer.valueOf(params.get("cargoWidth")).shortValue(),
                                                    Integer.valueOf(params.get("cargoHeight")).shortValue())));

            if (ShipManager.canFindPlaceForMooring(portsDatabase, ship)) {
                response = ShipManager.answerWhereShipCanMoore(portsDatabase,ship);
            }else{
                try {
                    response.append("reason", ShipManager.explainReasonWhyCantMoore(portsDatabase,ship));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        return response.toString();
        }catch (final NegativeDimensionException e){
            return response.toString();
        }
    }

}