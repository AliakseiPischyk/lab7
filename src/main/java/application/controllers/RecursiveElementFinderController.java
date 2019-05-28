package application.controllers;

import application.buisnessLogic.RecursiveElementFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class RecursiveElementFinderController {

    @Autowired
    RecursiveElementFinder recursiveElementFinder;

    @RequestMapping(path = "/findElementRecursively/{index}",
            method = RequestMethod.GET)
    @ResponseBody
    public <T extends Number> T find(@RequestBody Collection<T> collection, @PathVariable("index") int index) {
        return recursiveElementFinder.find(collection, index);
    }

}