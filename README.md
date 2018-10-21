# Spring-boot, Spring-Data, H2 In-Memory DB application - Integration-testing
This demo project exaplins how [JUnit](https://github.com/junit-team/junit4) and [Zerocode](https://github.com/authorjapps/zerocode) test framework based integration-tests for a "spring-boot, spring-data and H2 in-memory DB" application can make your life easy everyday.

> Keep it simple and easy while doing the integration tests

##### Needed maven dependencies
```xml
<dependency>
    <groupId>org.jsmart</groupId>
    <artifactId>zerocode-rest-bdd</artifactId>
    <version>1.2.x</version> 
</dependency>
```

![Integration_tests_organization](img/project_structure.png)

### Where are the integration tests?
+ The JUnit integration tests are located under-
  + test/java/integrationtests/
 

You can run and debug them individually.
  

### How do they integration tests run in the maven life cycle?
e.g.
> mvn clean install

+ The integration-tests are fired in the `<goal>integration-test</goal>` as configured in the `pom.xml`

```     
  <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-failsafe-plugin</artifactId>
      <executions>
          <execution>
              <goals>
                  <goal>integration-test</goal>
                  <goal>verify</goal>
              </goals>
          </execution>
      </executions>
  </plugin>
```     

```
@TargetEnv("application_host.properties")
@RunWith(E2eJunitRunner.class)
public class TestGetOperations {

}
```

### What does the above @RunWith do?
> @RunWith(E2eJunitRunner.class)

Ans: It starts the spring applications and then fires the tests once by one.
See below how it brings up the application.
```
public class E2eJunitRunner extends ZeroCodeUnitRunner {

    static{
    	SpringBootMainApplication.start();
    }

    public E2eJunitRunner(Class<?> myclass) throws InitializationError {
        super(myclass);
    }
}
```

![Integration_tests_reports](img/testreport.png)

[How do I do integration testing of a spring boot application]: https://github.com/authorjapps/spring-boot-integration-test#spring-boot-integration-test
[How to do integration testing of a spring boot application]: https://github.com/authorjapps/spring-boot-integration-test#spring-boot-integration-test
[Integration testing of a spring boot application]: https://github.com/authorjapps/spring-boot-integration-test#spring-boot-integration-test
[Zerocode testing of a spring boot application]: https://github.com/authorjapps/spring-boot-integration-test#spring-boot-integration-test
[Zerocode JSON testing of a spring boot application]: https://github.com/authorjapps/spring-boot-integration-test#spring-boot-integration-test
[Zerocode testing of a spring application]: https://github.com/authorjapps/spring-boot-integration-test#spring-boot-integration-test
