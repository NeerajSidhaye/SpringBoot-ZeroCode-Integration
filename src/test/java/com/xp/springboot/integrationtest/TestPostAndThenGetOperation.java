package com.xp.springboot.integrationtest;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.xp.springboot.application.E2eJunitRunner;

@TargetEnv("application_host.properties")
@RunWith(E2eJunitRunner.class)
public class TestPostAndThenGetOperation {

	@Test
    @JsonTestCase("integration_tests/get/get_new_parkrunner_by_parkrunid_test.json")
    public void test_registerParkRunnerAndThenFetchDetaillsOfNewRunner() throws Exception {
    }
	
}
