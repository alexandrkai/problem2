/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2;

import java.util.Comparator;

/**
 *
 * @author Александр
 */
public class OrderComparator implements Comparator<Order>{

    @Override
    public int compare(Order o1, Order o2) {
        int c;
            c = o1.NameClient.compareTo(o2.NameClient);
            if (c == 0) c = o1.TypeBumaga.compareTo(o2.TypeBumaga);
            return c;
    }
}

