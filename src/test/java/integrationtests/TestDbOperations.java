package integrationtests;

import org.jsmart.zerocode.core.domain.JsonTestCase;
import org.jsmart.zerocode.core.domain.TargetEnv;
import org.junit.Ignore;
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
    @JsonTestCase("integration_tests/dbexecutor/get_parkrunners_using_db_executor.json")
    public void test_getParkRunners_using_DBExecutor() {
    }

    @Ignore("Uncomment the PostGres DB host configs to run this test in the TargetEnv properties file")
    @Test
    @JsonTestCase("sql_db_tests/postgres_db_get_parkrunners_test.json")
    public void test_getParkRunnersFrom_postgresDb() {
    }

}
