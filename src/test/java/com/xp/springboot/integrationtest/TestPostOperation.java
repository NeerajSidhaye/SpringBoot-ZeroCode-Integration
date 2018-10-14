package com.xp.springboot.integrationtest;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.xp.springboot.application.E2eJunitRunner;

@TargetEnv("application_host.properties")
@RunWith(E2eJunitRunner.class)
public class TestPostOperation {

	@Test
    @JsonTestCase("integration_tests/post/post_register_at_parkrun.json")
    public void test_postRegistrationAtParkRun() throws Exception {
    }
	
}
