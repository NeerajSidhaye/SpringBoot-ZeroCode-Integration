package com.xp.springboot.application;

import org.jsmart.zerocode.core.runner.ZeroCodeUnitRunner;
import org.junit.runners.model.InitializationError;

public class E2eJunitRunner extends ZeroCodeUnitRunner {

    static{
    	SpringBootMainApplication.start();
    }

    public E2eJunitRunner(Class<?> myclass) throws InitializationError {
        super(myclass);
    }
}
