package tools;

import java.util.Comparator;
import java.util.List;

public class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {

    @Override
    public int compare(List<T> o1, List<T> o2) {
        int c = o1.get(2).compareTo(o2.get(2));
            if (c != 0) {
                return c;
            }

        return Integer.compare(o1.size(), o2.size());
    }

}
