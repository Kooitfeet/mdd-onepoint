package db;

import java.sql.*;
import java.util.Date;

public class GatlingResultsToDatabase {

    // JDBC URL, username, and password of PostgreSQL server
    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/mdd";
    private static final String JDBC_USER = "onepoint_user";
    private static final String JDBC_PASSWORD = "1234";

    public static Connection connection() throws SQLException, ClassNotFoundException {
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void insertTestData(String scenarioName, String requestName, int requestCount,
                                       int minResponseTime, int maxResponseTime, int meanResponseTime, String status) throws SQLException, ClassNotFoundException {
        // SQL query to insert data into the test_results table
        Connection connection = connection();

        String insertQuery = "INSERT INTO table_onepoint (scenario_name, request_name, request_count, min_response_time, max_response_time, mean_response_time, status) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setString(1, scenarioName);
            preparedStatement.setString(2, requestName);
            preparedStatement.setInt(3, requestCount);
            preparedStatement.setInt(4, minResponseTime);
            preparedStatement.setInt(5, maxResponseTime);
            preparedStatement.setInt(6, meanResponseTime);
            preparedStatement.setString(7, status);

            // Execute the query
            preparedStatement.executeUpdate();
        }

        connection.close();
    }



    public static void insertTestData(Timestamp timestamp, String fetch, int code_http, String step) throws SQLException, ClassNotFoundException {
        // SQL query to insert data into the test_results table
        Connection connection = connection();

        String insertQuery = "INSERT INTO table_onepoint (\"timestamp\", \"fetchs\", code_http, step) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setTimestamp(1, timestamp);
            preparedStatement.setString(2, fetch);
            preparedStatement.setInt(3, code_http);
            preparedStatement.setString(4, step);

            // Execute the query
            preparedStatement.executeUpdate();
        }

        connection.close();
    }

}