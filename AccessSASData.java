
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement; 
public class AccessSASData {
    public static void main(String[] args) throws Exception {
        Connection connection;
        Statement statement;
        String qryString="Select * from mysaslib"+args[0];
        ResultSet result;
        String name;
        String Sex;
        float Age;
        float Height;
        float Weight;
        try{
     Class.forName("Com.sas.rio.MVADriver")
     String user="username";
     String password="password";
     connection=DriverManager.getConnection("jdbc:sasiom://hostname:8591?libref=mysaslib 'L:\foldername", user, password);
      System.out.println("The connection details are :"+connection);
       statement=connection.createStatement();
       result=statement.executeQuery(qryString);
       while(result.next()){
           /* in place of column index column labels can also be used*/
           name=result.getString(1);
           Sex=result.getString(2);
           Age=result.getFloat(3);
           Height=result.getFloat(4);
           Weight=result.getFloat(5);
           /* Process the result*/

       }
       statement.close();
       connection.close();
        } catch (Exception e){
            //Process the exception
            System.out.println("error"+ e);
        }
        System.out.println("Hello, World!");
    }
}