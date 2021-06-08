package com.TETOSOFT.JUnitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ PauseTest.class, StopTest.class, UnpauseTest.class })
public class AllTests {

}
