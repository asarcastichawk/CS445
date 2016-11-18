package org.huzair.unit_test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ManagerTest.class, RESTManagerTest.class,
	DeliveryTest.class,SearchTest.class, ValidationTest.class,CustomerTest.class,FarmersTest.class})
public class AllTests {

}
