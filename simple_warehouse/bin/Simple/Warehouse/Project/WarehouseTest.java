package Simple.Warehouse.Project;

import static org.junit.Assert.*;

import org.junit.Test;

class WarehouseTest {

private Warehouse warehouse;

@Test

void setUp() {

warehouse = new Warehouse(); // initializing a 5x5 warehouse for tests

}

@Test

void testStoreValidProduct() { //Test case to store valid product

assertTrue(warehouse.store(1, 1, 2, 2, 'A'));

}

@Test

void testStoreProductOutsideBoundary() { //Test case to store product outside boundary 

assertFalse(warehouse.store(4, 4, 2, 2, 'A'));

}

@Test

void testStoreProductInOccupiedSpace() { //Test case to check is space is occupied

warehouse.store(1, 1, 2, 2, 'A');

assertFalse(warehouse.store(1, 1, 2, 2, 'B'));

}

@Test

void testRemoveExistingProduct() { //Test case to remove existing product

warehouse.store(1, 1, 2, 2, 'A');

assertTrue(warehouse.remove(1, 1));

}

@Test

void testRemoveNonExistingProduct() { //Test case to remove non existing product

assertFalse(warehouse.remove(1, 1));

}

}