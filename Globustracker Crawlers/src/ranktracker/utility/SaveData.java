
package ranktracker.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaveData {

    public static Connection con = null;
    static PreparedStatement ps=null;
    public static void write(int kwid,String sengine,int rank,int bmr,String bml) {
        try {
            if (con==null ){
                Class.forName("com.mysql.jdbc.Driver");
               con = DriverManager.getConnection("jdbc:mysql://173.255.209.86:3306/ranktracker", "root", "brandzter1234!@#$");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        if(ps==null){
         try{
             ps=con.prepareStatement("insert into serpstrackhistory(KeywordID,SearchEngine,Rank,BestMatchRank,BestMatchLink) values(?,?,?,?,?)");
             
         }   catch(Exception e){
             e.printStackTrace();
         }
        }
        try {
            ps.setInt(1, kwid);
            ps.setString(2, sengine);
            ps.setInt(3, rank);
            ps.setInt(4, bmr);
            ps.setString(5, bml);
            
            ps.executeUpdate();
        } catch (SQLException ex) {
           ex.printStackTrace();
            Logger.getLogger(SaveData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
