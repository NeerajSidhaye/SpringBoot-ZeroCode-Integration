package com.xp.springboot.integrationtest.crudtests;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.xp.springboot.application.E2eJunitRunner;

@TargetEnv("application_host.properties")
@RunWith(E2eJunitRunner.class)
public class TestPatchOperation {
	
	@Test
    @JsonTestCase("integration_tests/patch/patch_parkrunner_by_id.json")
    public void test_partialUpdateParkRunnerProfile() throws Exception {
    }
	

}
