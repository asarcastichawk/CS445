package org.huzair.unit_test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({CustomerTest.class, DeliveryTest.class, FarmersTest.class, ManagerTest.class, SearchTest.class,RESTManagerTest.class,RESTFarmerTest.class, ValidationTest.class})

public class AllTests {

}
