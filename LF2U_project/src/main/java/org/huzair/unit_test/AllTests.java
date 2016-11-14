package org.huzair.unit_test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FarmersTest.class,CustomerTest.class,ManagerTest.class,
	DeliveryTest.class,SearchTest.class })
public class AllTests {

}
