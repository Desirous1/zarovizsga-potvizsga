package hu.nive.ujratervezes.zarovizsga.peoplesql;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {
    private DataSource dataSource;

    public PeopleDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt = conn.prepareStatement("SELECT ip_address FROM people WHERE first_name = ? && last_name = ?");
        ) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            return finIp(stmt);
        } catch (SQLException se) {
            throw new IllegalStateException("Can not query 1", se);
        }
    }

    private String finIp(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String ipAddress = rs.getString("ip_address");
                return ipAddress;
            }
        } catch (SQLException se) {
            throw new IllegalStateException("Can not query 2", se);
        }
        return null;
    }
}
