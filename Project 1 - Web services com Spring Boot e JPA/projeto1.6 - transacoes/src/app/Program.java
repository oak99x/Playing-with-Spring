package app;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
import db.DbException;
import db.DbIntegrityException;


public class Program {

    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        try{
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();
           
            int rows1 = st.executeUpdate("update seller set BaseSalary = 2090 where DepartmentId = 1");

            // if( 1 < 2){
            //     throw new SQLException("Fake errooo");
            // }

            int rows2 = st.executeUpdate("update seller set BaseSalary = 3090 where DepartmentId = 2");

            conn.commit();

            System.out.println("Rows 1 : " + rows1);
            System.out.println("Rows 2 : " + rows2);
        }
        catch(SQLException e){
           try {
            conn.rollback();
            throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
        } catch (SQLException e1) {
            throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
        }
        }
        finally{
            DB.closeStatement(st);
            DB.closeConnection();

        }
    }
    
}
