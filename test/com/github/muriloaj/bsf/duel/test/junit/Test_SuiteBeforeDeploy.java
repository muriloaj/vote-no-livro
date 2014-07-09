package com.github.muriloaj.bsf.duel.test.junit;

import org.junit.Test;

import com.github.muriloaj.bsf.duel.test.TST_Book;
import com.github.muriloaj.bsf.duel.test.TST_General;

/**
 * Reset DB Tables and populate with initial value
 * @author Murilo
 *
 */
public class Test_SuiteBeforeDeploy {

	@Test
	public void resetAllDataBase() {
		
		TST_General.reset_tables();
		TST_Book.populateUsingRealBook();
	}

}
