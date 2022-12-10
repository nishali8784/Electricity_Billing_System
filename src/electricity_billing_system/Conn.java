package electricity_billing_system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    Conn() {
        //For registring mysqldriver
        //Class.forName("com.mysql.cj.jdbc.driver");..........Automatically done
        try {
            c = DriverManager.getConnection("jdbc:mysql:///ebs", "root", "19JaiAmba@#46");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
