package DAO;

//Class chính để connect đến DB mà không cần lưu trữ quá nhiều name + pass

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConnectDB {
    String user = "root";
    String pass = "Vothiyennhi123";
    String name_db = "quanlythianhvan";
    String url = "";
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;

    ConnectDB() throws SQLException {
        if (conn == null) {
            try {
                Class.forName("org.gjt.mm.mysql.Driver");
                url = "jdbc:mysql://localhost:3306/"+name_db+"?autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8";
                conn = DriverManager.getConnection(url, user, pass);                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Lỗi connect đến sql");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Lỗi connect đến sql");
            }
        }
    }

    public ArrayList loaddatafromtable(String table) {
        ArrayList array = new ArrayList();        
        try {
            String qry = "select * from `"+table+"`";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            ResultSetMetaData rsmeta = rs.getMetaData();
            int column = rsmeta.getColumnCount();
            while (rs.next()) {               
                ArrayList object_in_DB = new ArrayList();
                for(int i=0; i<column; i++){
                    object_in_DB.add(rs.getString(i+1));                                
                }
                array.add(object_in_DB);
            }
            close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi load ở DAO");
        }
        return array;
    }

    public boolean Insert(String table, String insert)
    {
        try{
            String qry = "INSERT INTO `"+table+"` Values ("+insert+");";     
            System.out.println("Query:"+qry);
            st = conn.createStatement();
            int result2 = st.executeUpdate(qry);
            //close();
            return true;
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Lỗi insert ở DAO");
            return false;
        }
    }
    
    public int count_in_DB(String table)
    {
        int temp = 0;
        try{
            String qry = "Select * from `"+table+"` ";
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            rs.last();
            temp = rs.getRow();
            close();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi count ở DAO");
            return -1;
        }
        return temp;
    }
    
    public int count_in_DB_with_condition(String table, String condition){
        int temp = 0;
        try{
            String qry = "Select * from `"+table+"` where "+condition;
            st = conn.createStatement();
            rs = st.executeQuery(qry);
            rs.last();
            temp = rs.getRow();
            close();            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi count ở DAO");
            return -1;
        }
        return temp;
    }
    
    public boolean Update(String table, String update, String condition)
    {   
        String qry = "UPDATE `"+table+"` SET "+update+" WHERE "+condition+";";
        try {
            System.out.println(qry);
            st = conn.createStatement();
            int result = st.executeUpdate(qry);
            close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi update ở DAO");
            return false;
        }
        
        return true;
    }
    
    public boolean Delete(String table, String condition)
    {
        String qry = "DELETE FROM `"+table+"` where "+condition+ ";";
        try {
            st = conn.createStatement();
            int result = st.executeUpdate(qry);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi delete ở DAO");
            return false;
        }
        return true;
    }

    public ArrayList write_statement_select(String query){        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            ArrayList result = new ArrayList();
            ResultSetMetaData rsmeta = rs.getMetaData();
            int column = rsmeta.getColumnCount();
            while (rs.next()) {      
                for(int i=0;i<column;i++)
                    result.add(rs.getString(i+1));
            }
            close();
            return result;
        } catch (SQLException ex) {
            return null;
        }
    }
    void close() {
        try {
            rs.close();
            st.close();
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi đóng ở DAO");
        }

    }
}
