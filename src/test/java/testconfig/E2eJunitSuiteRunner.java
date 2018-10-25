package testconfig;

import org.jsmart.zerocode.core.runner.ZeroCodePackageRunner;
import org.junit.runners.model.InitializationError;

import com.xp.springboot.application.SpringBootMainApplication;

public class E2eJunitSuiteRunner extends ZeroCodePackageRunner {

    static{
    	SpringBootMainApplication.start();
    }

    public E2eJunitSuiteRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }
}
