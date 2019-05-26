package Application;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ElementRecursiveRemover implements Remover{

    @RequestMapping(value = "/excludeRepeatingElementsRecursively",
    method = RequestMethod.GET)
    @ResponseBody
    public<T extends Number> List<T> excludeRepeatingElements(@RequestBody Collection<T> collection) {

        return collection
                .stream()
                .distinct()
                .collect
                        (Collectors.
                                toList());
    }
}
