package com.xp.springboot.dbutils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.util.ClassUtils;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostGresSqlExecutor {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostGresSqlExecutor.class);
    Map<String, List<Map<String, Object>>> dbRecordsMap = new HashMap<>();
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


    public Map<String, List<Map<String, Object>>> executeSimpleSql(String simpleSql) throws IllegalAccessException, InvocationTargetException, InstantiationException {

        LOGGER.info("DB - Executing SQL query: {}", simpleSql);

        List<Map<String, Object>> recordsList = fetchDbRecords(simpleSql);

        // -------------------------------------------------------
        // Put all the fetched rows into nice JSON key and return.
        // -- This make it better to assert SIZE etc in the steps.
        // -- You can choose any key.
        // -------------------------------------------------------
        dbRecordsMap.put(RESULTS_KEY, recordsList);

        return dbRecordsMap;
    }

    private List<Map<String, Object>> fetchDbRecords(String simpleSql) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        return getJdbcTemplate().query(simpleSql, (resultSet, i) -> {
            Map<String, Object> aRowColumnValue = new HashMap<>();

            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int j = 1; j <= columnCount; j++) {
                String columnName = metaData.getColumnName(j);
                Object columnValue = resultSet.getObject(columnName);

                aRowColumnValue.put(columnName, columnValue);
            }

            return aRowColumnValue;
        });
    }

    private JdbcTemplate getJdbcTemplate() throws IllegalAccessException, InvocationTargetException, InstantiationException {
        final String driverClassName = "org.postgresql.Driver";

        // Build dataSource & JDBC template from the host properties file
        final Class<?> driverClass = ClassUtils.resolveClassName(driverClassName, this.getClass().getClassLoader());
        org.postgresql.Driver driver = (org.postgresql.Driver) ClassUtils.getConstructorIfAvailable(driverClass).newInstance();
        final DataSource dataSource = new SimpleDriverDataSource(driver, dbHostUrl, dbUserName, dbPassword);

        return new JdbcTemplate(dataSource);
    }
}
