package application.buisnessLogic;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Component
public class ElementRemover {
    private <T extends Number> Collection<T> excludeRepeatingElements(Collection<T> collection, Iterator<T> iterator) {
        final T nextValue = iterator.next();
        collection.removeAll(new ArrayList<T>() {{
            add(nextValue);
        }});
        collection.add(nextValue);
        return iterator.hasNext() ? excludeRepeatingElements(collection, iterator) : collection;
    }

    public <T extends Number> Collection<T> excludeRepeatingElements( Collection<T> collection) {
        List<T> list = new ArrayList<T>() {{
            addAll(collection);
        }};
        return excludeRepeatingElements(list, collection.iterator());
    }
}
