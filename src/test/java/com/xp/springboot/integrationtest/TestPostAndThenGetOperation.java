package com.xp.springboot.integrationtest;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("application_host.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class TestPostAndThenGetOperation {

	@Test
    @JsonTestCase("integration_tests/get/get_new_parkrunner_by_parkrunid_test.json")
    public void test_registerParkRunnerAndThenFetchDetaillsOfNewRunner() throws Exception {
    }
	
}
