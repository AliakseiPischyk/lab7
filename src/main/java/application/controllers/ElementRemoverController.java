package application.controllers;


import application.buisnessLogic.ElementRemover;
import application.buisnessLogic.Remover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ElementRemoverController implements Remover {

    @Autowired
    ElementRemover elementRemover;

    @Override
    @RequestMapping(path = "/excludeRepeatingElements",
            method = RequestMethod.GET)
    @ResponseBody
    public <T extends Number> Collection<T> excludeRepeatingElements(@RequestBody Collection<T> collection) {
        return elementRemover.excludeRepeatingElements(collection);
    }
}