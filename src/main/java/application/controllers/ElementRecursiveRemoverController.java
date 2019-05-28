package application.controllers;

import application.buisnessLogic.ElementRecursiveRemover;
import application.buisnessLogic.Remover;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
public class ElementRecursiveRemoverController implements Remover{

    @Autowired
    ElementRecursiveRemover elementRecursiveRemover;

    @RequestMapping(path = "/excludeRepeatingElementsRecursively",
    method = RequestMethod.GET)
    @ResponseBody
    public<T extends Number> List<T> excludeRepeatingElements(@RequestBody Collection<T> collection) {
        return elementRecursiveRemover.excludeRepeatingElements(collection);
    }
}
