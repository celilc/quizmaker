
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public class SınavIslemleri  {
    
    
    
    
    
     private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    
    public SınavIslemleri(){
         String url = "jdbc:mysql://" + DataBase.host + ":" + DataBase.port + "/" + DataBase.db_ismi+ "?useUnicode=true&characterEncoding=utf8";
        
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver Bulunamadı....");
        }
        
        
        try {
            con = DriverManager.getConnection(url, DataBase.kullanici_adi, DataBase.parola);
            System.out.println("Bağlantı Başarılı...");
            
            
        } catch (SQLException ex) {
            System.out.println("Bağlantı Başarısız...");
            //ex.printStackTrace();
        }
    }
    
    
   public void soruEkle(String SoruTipi,String DersAdi, String Soru, String Sik1, String Sik2, String Sik3, String Sik4, String Cevap, String Puan, String ZorlukDerecesi){
        
        
        String sorgu= "Insert Into sınavislemleri(SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi) VALUES (?,?,?,?,?,?,?,?,?,?) ";
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
            preparedStatement.setString(1, SoruTipi);
            preparedStatement.setString(2, DersAdi);
            preparedStatement.setString(3, Soru);
            preparedStatement.setString(4, Sik1);
            preparedStatement.setString(5, Sik2);
            preparedStatement.setString(6, Sik3);
            preparedStatement.setString(7, Sik4);
            preparedStatement.setString(8, Cevap);
            preparedStatement.setString(9, Puan);
            preparedStatement.setString(10,ZorlukDerecesi);
            
            preparedStatement.executeUpdate();
           
        } catch (SQLException ex) {
            Logger.getLogger(SoruIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    
    
    
    
    }
    
    
    
    public ArrayList<Soru> sorulariGetir(){
        
        ArrayList<Soru> cikti = new ArrayList<Soru>();
        
        try {
            statement = con.createStatement();
            String sorgu = "Select * From sınavislemleri";
            
            ResultSet rs = statement.executeQuery(sorgu);
             
            while(rs.next()){
                int id= rs.getInt("id");
                String SoruTipi= rs.getString("SoruTipi");
                String DersAdi= rs.getString("DersAdi");
                String Soru= rs.getString("Soru");
                String Sik1= rs.getString("Sik1");
                String Sik2= rs.getString("Sik2");
                String Sik3= rs.getString("Sik3");
                String Sik4= rs.getString("Sik4");
                String Cevap= rs.getString("Cevap");
                int Puan= rs.getInt("Puan");
                int ZorlukDerecesi= rs.getInt("ZorlukDerecesi");
                
                cikti.add(new Soru(id, DersAdi, SoruTipi, Soru, Sik1, Sik2, Sik3, Sik4, Cevap, ZorlukDerecesi, Puan));
                
                
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(SoruIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    }
    
    
     public void soruSil(int id){
        
        String sorgu = "Delete from sınavislemleri where id=?";
        
        
        try {
            preparedStatement = con.prepareStatement(sorgu);
             preparedStatement.setInt(1, id);  
             preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SoruIslemleri.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
    }
     public void raporla(){
         try{

InputStream in=new FileInputStream(new File("C:\\Users\\casper\\Desktop\\SoruBankasi\\src\\report3.jrxml"));
JasperDesign jd = JRXmlLoader.load(in);
String sql= "select * from sınavislemleri";
JRDesignQuery newQuery = new JRDesignQuery();
newQuery.setText(sql);
jd.setQuery(newQuery);
JasperReport jr = JasperCompileManager.compileReport(jd);
HashMap para=new HashMap();
JasperPrint j = JasperFillManager.fillReport(jr,para,con);
JasperViewer.viewReport(j, false);
OutputStream os= new FileOutputStream(new File("D:\\raporlama.pdf"));
JasperExportManager.exportReportToPdfStream(j,os);

 JOptionPane.showMessageDialog(null, "Merhaba, sınavınız D diskinin altına başarıyla oluşturuldu...");

}catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
}
     }
     public void mat1(){
         
         
      String sorgu="Insert INTO sınavislemleri(ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi) SELECT ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi FROM soruislemleri where DersAdi='Matematik' and ZorlukDerecesi=1";
         try {
                       preparedStatement = con.prepareStatement(sorgu);
                         preparedStatement.executeUpdate();
          
                   } catch (SQLException ex) {
                       Logger.getLogger(SınavEkrani.class.getName()).log(Level.SEVERE, null, ex);
                   }  
     }
     public void mat2(){
         String sorgu="Insert INTO sınavislemleri(ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi) SELECT ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi FROM soruislemleri where DersAdi='Matematik' and ZorlukDerecesi=2";
         try {
                       preparedStatement = con.prepareStatement(sorgu);
                         preparedStatement.executeUpdate();
          
                   } catch (SQLException ex) {
                       Logger.getLogger(SınavEkrani.class.getName()).log(Level.SEVERE, null, ex);
                   }  
         
     }
     public void mat3(){
         String sorgu="Insert INTO sınavislemleri(ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi) SELECT ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi FROM soruislemleri where DersAdi='Matematik' and ZorlukDerecesi=3";
         try {
                       preparedStatement = con.prepareStatement(sorgu);
                         preparedStatement.executeUpdate();
          
                   } catch (SQLException ex) {
                       Logger.getLogger(SınavEkrani.class.getName()).log(Level.SEVERE, null, ex);
                   }  
     }
     public void turk1(){
         
         
      String sorgu="Insert INTO sınavislemleri(ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi) SELECT ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi FROM soruislemleri where DersAdi='Turkce' and ZorlukDerecesi=1";
         try {
                       preparedStatement = con.prepareStatement(sorgu);
                         preparedStatement.executeUpdate();
          
                   } catch (SQLException ex) {
                       Logger.getLogger(SınavEkrani.class.getName()).log(Level.SEVERE, null, ex);
                   }  
     }
     public void turk2(){
         
         
      String sorgu="Insert INTO sınavislemleri(ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi) SELECT ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi FROM soruislemleri where DersAdi='Turkce' and ZorlukDerecesi=2";
         try {
                       preparedStatement = con.prepareStatement(sorgu);
                         preparedStatement.executeUpdate();
          
                   } catch (SQLException ex) {
                       Logger.getLogger(SınavEkrani.class.getName()).log(Level.SEVERE, null, ex);
                   }  
     }
     public void turk3(){
         
         
      String sorgu="Insert INTO sınavislemleri(ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi) SELECT ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi FROM soruislemleri where DersAdi='Turkce' and ZorlukDerecesi=3";
         try {
                       preparedStatement = con.prepareStatement(sorgu);
                         preparedStatement.executeUpdate();
          
                   } catch (SQLException ex) {
                       Logger.getLogger(SınavEkrani.class.getName()).log(Level.SEVERE, null, ex);
                   }  
     }
     public void genel1(){
         
         
      String sorgu="Insert INTO sınavislemleri(ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi) SELECT ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi FROM soruislemleri where DersAdi='Genel Kultur' and ZorlukDerecesi=1";
         try {
                       preparedStatement = con.prepareStatement(sorgu);
                         preparedStatement.executeUpdate();
          
                   } catch (SQLException ex) {
                       Logger.getLogger(SınavEkrani.class.getName()).log(Level.SEVERE, null, ex);
                   }  
     }
     public void genel2(){
         
         
      String sorgu="Insert INTO sınavislemleri(ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi) SELECT ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi FROM soruislemleri where DersAdi='Genel Kultur' and ZorlukDerecesi=2";
         try {
                       preparedStatement = con.prepareStatement(sorgu);
                         preparedStatement.executeUpdate();
          
                   } catch (SQLException ex) {
                       Logger.getLogger(SınavEkrani.class.getName()).log(Level.SEVERE, null, ex);
                   }  
     }
     public void genel3(){
         
         
      String sorgu="Insert INTO sınavislemleri(ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi) SELECT ID,SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi FROM soruislemleri where DersAdi='Genel Kultur' and ZorlukDerecesi=3";
         try {
                       preparedStatement = con.prepareStatement(sorgu);
                         preparedStatement.executeUpdate();
          
                   } catch (SQLException ex) {
                       Logger.getLogger(SınavEkrani.class.getName()).log(Level.SEVERE, null, ex);
                   }  
     }
     
     
     public void sınavSil(){
         
         String sorgu ="Delete from sınavislemleri";
                 
         try {
             preparedStatement = con.prepareStatement(sorgu);
             preparedStatement.executeUpdate();
         } catch (SQLException ex) {
             Logger.getLogger(SınavIslemleri.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         
     }
     
     
     
     
     
     
     
     public ArrayList<Sinav> sorulariGetir1(){
        
        ArrayList<Sinav> cikti = new ArrayList<Sinav>();
        
        try {
            statement = con.createStatement();
            String sorgu = "Select * From sınavislemleri";
            
            ResultSet rs = statement.executeQuery(sorgu);
             
            while(rs.next()){
                int id= rs.getInt("id");
                String SoruTipi= rs.getString("SoruTipi");
                String DersAdi= rs.getString("DersAdi");
                String Soru= rs.getString("Soru");
                String Sik1= rs.getString("Sik1");
                String Sik2= rs.getString("Sik2");
                String Sik3= rs.getString("Sik3");
                String Sik4= rs.getString("Sik4");
                String Cevap= rs.getString("Cevap");
                int Puan= rs.getInt("Puan");
                int ZorlukDerecesi= rs.getInt("ZorlukDerecesi");
                
                cikti.add(new Sinav(id, DersAdi, SoruTipi, Soru, Sik1, Sik2, Sik3, Sik4, Cevap, ZorlukDerecesi, Puan));
                
                
            }
            return cikti;
            
        } catch (SQLException ex) {
            Logger.getLogger(SoruIslemleri.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
        
        
    } 
    
    
    
       
    
    
    
    }
    
    
    
    
    

