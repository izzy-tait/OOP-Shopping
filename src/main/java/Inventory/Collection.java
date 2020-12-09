/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import Inventory.Iter;
import java.util.Iterator;

/**
 *
 * @author jonat
 */
interface Collection {
    public Iter createIterator();
}
