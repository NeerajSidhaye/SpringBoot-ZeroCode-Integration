package testconfig;

import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.runners.model.InitializationError;

import com.xp.springboot.application.SpringBootMainApplication;

public class E2eJunitRunner extends ZeroCodeUnitRunner {

    static{
    	SpringBootMainApplication.start();
    }

    public E2eJunitRunner(Class<?> myclass) throws InitializationError {
        super(myclass);
    }
}
