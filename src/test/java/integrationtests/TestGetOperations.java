package integrationtests;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;

import testconfig.E2eJunitRunner;

/**
 * 
 * @author Neeraj Sidhaye
 *
 */

@TargetEnv("application_host.properties")
@RunWith(E2eJunitRunner.class)
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
