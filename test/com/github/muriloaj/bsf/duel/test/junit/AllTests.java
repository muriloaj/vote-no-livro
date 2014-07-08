package com.github.muriloaj.bsf.duel.test.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
			TestBook_TestSetup.class,
			TestBook_TestSuite.class, 
			TestVote_TestSetup.class,
			TestVote_TestSuite.class,
			Test_SuiteBeforeDeploy.class})
public class AllTests {

}
