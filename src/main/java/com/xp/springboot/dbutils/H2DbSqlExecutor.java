package com.xp.springboot.dbutils;

//import com.google.inject.Inject;
//import com.google.inject.name.Named;
import com.xp.springboot.entity.ParkRunner;
import org.h2.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.util.ClassUtils;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class H2DbSqlExecutor {
    private static final Logger LOGGER = LoggerFactory.getLogger(H2DbSqlExecutor.class);
    public static final String RESULTS_KEY = "rows";

    @Inject
    @Named("db_host_url")
    private String dbHostUrl;

    @Inject
    @Named("db_username")
    private String dbUserName;

    @Inject
    @Named("db_password")
    private String dbPassword;

    public Map<String, List<ParkRunner>> executeSimpleSql(String simpleSql) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        LOGGER.info("DBSqlExecutor: executeSimpleSql :: simpleSql -> {} ", simpleSql);

        List<ParkRunner> parkRunners = getJdbcTemplate().query(simpleSql, new BeanPropertyRowMapper<ParkRunner>(ParkRunner.class));

        Map<String, List<ParkRunner>> resultsMap = new HashMap<>();
        resultsMap.put(RESULTS_KEY, parkRunners);

        return resultsMap;
    }

    public Map<String, List<ParkRunner>> executeSqlWithParam(Map<String, String> sql) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        LOGGER.info("DBSqlExecutor: executeSqlWithParam :: sql with Param -> {}, {} ", sql.get("sqlQuery"), sql.get("paramValue"));

        List<ParkRunner> parkRunners = getJdbcTemplate().query(sql.get("sqlQuery"), new Object[]{sql.get("paramValue")}, new BeanPropertyRowMapper<ParkRunner>(ParkRunner.class));

        Map<String, List<ParkRunner>> resultsMap = new HashMap<>();
        resultsMap.put(RESULTS_KEY, parkRunners);

        return resultsMap;
    }

    private JdbcTemplate getJdbcTemplate() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        final String driverClassName = "org.h2.Driver";

        // Build dataSource & JDBC template from the host properties file
        final Class<?> driverClass = ClassUtils.resolveClassName(driverClassName, this.getClass().getClassLoader());
        final Driver driver = (Driver) ClassUtils.getConstructorIfAvailable(driverClass).newInstance();
        final DataSource dataSource = new SimpleDriverDataSource(driver, dbHostUrl, dbUserName, dbPassword);

        return new JdbcTemplate(dataSource);
    }

}
