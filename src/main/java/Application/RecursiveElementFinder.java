package Application;

import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Iterator;

@RestController
public class RecursiveElementFinder {

    private <T extends Number> T find(final Collection<T> collection, final int index, int startPos, Iterator<T> iterator) {
        iterator.next();
        return index == startPos ? iterator.next() : find(collection, index, ++startPos, iterator);
    }

    @RequestMapping(value = "/findElementRecursively/{index}",
            method = RequestMethod.GET)
    @ResponseBody
    public <T extends Number> T find( @RequestBody Collection<T> collection,@PathVariable("index") int index) {
        return index >= collection.size() ? null : find(collection, --index, 0, collection.iterator());
    }

}