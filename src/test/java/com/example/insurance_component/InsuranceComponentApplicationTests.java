package com.example.insurance_component;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataSourceConfigTests {

    @Autowired
    private DataSource dataSource;

    @Test
    void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        assertNotNull(connection, "Connection should not be null");
        assertTrue(connection.isValid(0), "Connection should be valid");
        connection.close();
    }
}
