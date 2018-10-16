package com.xp.springboot.integrationtest;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@TargetEnv("application_host.properties")
@RunWith(ZeroCodeUnitRunner.class)
public class TestGetOperations {

    @Test
    @JsonTestCase("integration_tests/get/get_all_parkrunners.json")
    public void test_getAllParkRunners() throws Exception {
    }
	
    @Test
    @JsonTestCase("integration_tests/get/get_parkRun_by_id.json")
    public void test_getParkRunnerWithValidAndInvalidParkRunId(){
    	
    }
    
}
