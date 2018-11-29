package integrationtests;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Test;
import org.junit.runner.RunWith;
import testconfig.E2eJunitRunner;

/**
 * @author Neeraj Sidhaye
 */

@TargetEnv("application_host.properties")
@RunWith(E2eJunitRunner.class)
public class TestDbOperations {

    @Test
    @JsonTestCase("integration_tests/get/dbexecutor/get_parkrunners_using_db_executor.json")
    public void test_getParkRunners_using_DBExecutor() {
    }
}
