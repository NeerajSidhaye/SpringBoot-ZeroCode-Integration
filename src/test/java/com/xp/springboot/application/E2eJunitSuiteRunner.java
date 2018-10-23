package com.xp.springboot.application;

import org.jsmart.zerocode.core.runner.ZeroCodePackageRunner;
import org.junit.runners.model.InitializationError;

public class E2eJunitSuiteRunner extends ZeroCodePackageRunner {

    static{
    	SpringBootMainApplication.start();
    }

    public E2eJunitSuiteRunner(Class<?> klass) throws InitializationError {
        super(klass);
    }
}
