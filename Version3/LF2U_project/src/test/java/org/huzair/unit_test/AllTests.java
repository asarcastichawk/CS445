package org.huzair.unit_test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({DeliveryTest.class, CustomerTest.class, FarmersTest.class, ManagerTest.class, RESTManagerTest.class,
		SearchTest.class, ValidationTest.class })
public class AllTests {

}
