package testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import unittest.ParkRunResourceTest;
import unittest.ParkRunnerEntityDTOTest;

@RunWith(Suite.class)
@SuiteClasses({ ParkRunResourceTest.class, ParkRunnerEntityDTOTest.class })
public class UnitTestSuite {

}



