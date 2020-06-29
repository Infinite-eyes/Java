package java.concurrentmodificationexception;

import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 *
 * https://www.cnblogs.com/andy-zhou/p/5339683.html
 */
public class Test {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(2);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2)
                iterator.remove();
            list.remove(integer);
        }

    }

}
