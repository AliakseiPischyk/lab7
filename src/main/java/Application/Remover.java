package Application;

import java.util.Collection;

public interface Remover {
    <T extends Number> Collection<T> excludeRepeatingElements(Collection<T> collection);
}