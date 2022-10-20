package library.helper;

import java.sql.*;
import java.util.ArrayList;

public class Connector {
    public final static String connectionString ="jdbc:mysql://localhost:3306/t2203e_library";
    public final static String user = "root";
    public final static String pwd =""; // neu la xamp :"" , mamp :"root"

    Connection conn;

    private static Connector instance;

    private Connector() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(connectionString,user,pwd);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static Connector getInstance(){
        if (instance == null){
            instance = new Connector();
        }
        return instance;
    }
    public Statement getStatement() throws  Exception{
        return  conn.createStatement();
    }
    public ResultSet query(String sql){
        try {


            return getStatement().executeQuery(sql);
        }catch (Exception e){
            return null;
        }
    }

    public boolean executeQuery(String sql){
        try {
            getStatement().execute(sql);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    public PreparedStatement getPreparedStatement(String sql) throws Exception{
        return conn.prepareStatement(sql);
    }

    public boolean execute(String sql, ArrayList parameters) throws Exception {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(sql);
            for (int i = 0; i < parameters.size() ; i++ ){
                if (parameters.get(i) instanceof Integer){
                    preparedStatement.setInt(i+1,(Integer)parameters.get(i));
                }else if (parameters.get(i) instanceof Double){
                    preparedStatement.setDouble(i+1,(Double)parameters.get(i));
                }else {
                    preparedStatement.setString(i+1,(String) parameters.get(i));
                }
            }
            preparedStatement.execute();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}