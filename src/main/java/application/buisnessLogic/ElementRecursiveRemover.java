package application.buisnessLogic;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ElementRecursiveRemover {
    public<T extends Number> List<T> excludeRepeatingElements(Collection<T> collection) {

        return collection
                .stream()
                .distinct()
                .collect
                        (Collectors.
                                toList());
    }
}
