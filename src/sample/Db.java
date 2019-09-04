package sample;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Db{
    public class TestTable{
    public int id;
    public String testField;
    }
    private final String url = "jdbc:postgresql://localhost/postgres";
    private final String user = "postgres";
    private final String password = "1";
    Connection conn;
    ResultSet rs = null;

    public void establishConnect () {
        conn = null;
        try {
            conn = DriverManager.getConnection (url, user, password);
            System.out.println ("Connected to the PostgreSQL server successfully.");
        } catch(SQLException e) {
            System.out.println (e.getMessage ());
        }
    }

    public ResultSet request (String query) {
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement ();
            rs = st.executeQuery (query);

            conn.close ();
        } catch(SQLException e) {
            System.out.println (e.getMessage ());
        }
        return rs;
    }

    public ArrayList<TestTable> getTestTableContent(ResultSet rs){
        ArrayList<TestTable> lst = new ArrayList();
            try {
                while (rs.next ()) {
                    TestTable t = new TestTable ();
                    t.id = Integer.parseInt (rs.getString ("id"));
                    t.testField = rs.getString ("testfield");
                    lst.add (t);
                }
            }
         catch(SQLException ex){
                    Logger.getLogger(ex.getMessage ());
                }
        return lst;
    }
}

