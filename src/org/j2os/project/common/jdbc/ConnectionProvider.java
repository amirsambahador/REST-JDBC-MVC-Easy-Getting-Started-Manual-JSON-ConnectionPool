package org.j2os.project.common.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class ConnectionProvider {
    public static final int ORACLE_XE = 1;
    public static final int ORACLE_ORCL = 2;
    private static final BasicDataSource XE_DATA_SOURCE = new BasicDataSource();
    private static final BasicDataSource ORCL_DATA_SOURCE = new BasicDataSource();

    static {
        XE_DATA_SOURCE.setUsername("amirsam");
        XE_DATA_SOURCE.setPassword("myjava123");
        XE_DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        XE_DATA_SOURCE.setMaxTotal(10);
        XE_DATA_SOURCE.setUrl("jdbc:oracle:thin:@localhost:1521/xepdb1");

        ORCL_DATA_SOURCE.setUsername("amirsam");
        ORCL_DATA_SOURCE.setPassword("myjava123");
        ORCL_DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ORCL_DATA_SOURCE.setMaxTotal(10);
        ORCL_DATA_SOURCE.setUrl("jdbc:oracle:thin:@localhost:1521/orcl");
    }

    private ConnectionProvider() {
    }

    public static Connection getConnection(int dbName) throws Exception {
        switch (dbName) {
            case 1:
                return XE_DATA_SOURCE.getConnection();
            default:
                return ORCL_DATA_SOURCE.getConnection();
        }
    }
}
