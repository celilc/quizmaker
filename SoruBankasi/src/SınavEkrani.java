
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author casper
 */
public class SınavEkrani extends javax.swing.JDialog {
    
    
     private Connection con = null;
    
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    
    
 SınavIslemleri islemler1 = new SınavIslemleri();
 SoruIslemleri islemler = new SoruIslemleri();
 DefaultTableModel  model;
 DefaultTableModel model1;
    /**
     * Creates new form SınavEkrani
     */
    public SınavEkrani(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        model1 = (DefaultTableModel)sinav_tablosu.getModel();
        model = (DefaultTableModel)soru_tablosu.getModel();
        //islemler1.sınavSil();
        soruGoruntule();
        soruGoruntule1();
       // soruGoruntule1();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        geri = new javax.swing.JButton();
        dersAdi = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        zorlukDerecesi = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        soruTipi = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        ders_adi = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        puan = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        zorluk_derecesi = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        sik4 = new javax.swing.JTextField();
        sik1 = new javax.swing.JTextField();
        sik2 = new javax.swing.JTextField();
        sik3 = new javax.swing.JTextField();
        cevap = new javax.swing.JTextField();
        soru = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        soru_tablosu = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        sinav_tablosu = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        geri.setText("Geri Dön");
        geri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                geriActionPerformed(evt);
            }
        });

        dersAdi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Turkce", "Matematik", "Genel Kultur" }));

        jLabel1.setText("Ders Adı");

        jLabel2.setText("Sınavın Zorluk Derecesi");

        zorlukDerecesi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VİZE", "FİNAL", "QUİZ" }));

        jLabel3.setText("Sınavın Adı");

        jButton1.setText("EKLE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("TÜM SORULAR");

        jLabel7.setText("SINAV SORULARI");

        jButton2.setText("SİL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("RAPOR OLUŞTUR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("SINAV OLUŞTUR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setText("Soru Tipi");

        jLabel9.setText("Ders Adı");

        soruTipi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Çoktan Seçmeli", "Klasik", "Doğru / Yanlış" }));

        jLabel10.setText("Soru");

        ders_adi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Türkçe", "Matematik", "Fizik", "Kimya", "Biyoloji", "Tarih", "Genel Kültür" }));

        jLabel11.setText("Şık 1");

        puan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jLabel12.setText("Şık 2");

        zorluk_derecesi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3" }));

        jLabel13.setText("Şık 3");

        jLabel14.setText("Şık 4");

        jLabel15.setText("Cevap");

        jLabel16.setText("Puan");

        jLabel17.setText("Zorluk Derecesi");

        soru_tablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Soru Tipi", "Ders Adı", "Soru", "Şık 1", "Şık 2", "Şık 3", "Şık 4", "Cevap", "Puan", "Zorluk Derecesi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        soru_tablosu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                soru_tablosuMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(soru_tablosu);

        sinav_tablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Soru Tipi", "Ders Adı", "Soru", "Şık 1", "Şık 2", "Şık 3", "Şık 4", "Cevap", "Puan", "Zorluk Derecesi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        sinav_tablosu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sinav_tablosuMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(sinav_tablosu);

        jButton5.setText("Sınavı Temizle");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1))))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(zorlukDerecesi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dersAdi, 0, 126, Short.MAX_VALUE)
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(186, 186, 186))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel15)
                                                    .addComponent(jLabel16))
                                                .addGap(27, 27, 27))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel8)
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(soru, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(1, 1, 1))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(13, 13, 13)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(ders_adi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(soruTipi, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGap(21, 21, 21)))
                                            .addComponent(cevap, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel13)
                                            .addComponent(jLabel14))
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(sik3)
                                            .addComponent(sik4, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel10))
                                                .addGap(36, 36, 36))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(sik1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sik2, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(zorluk_derecesi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(puan, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(geri, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(808, 808, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane5)
                                .addContainerGap())))
                    .addComponent(jScrollPane4)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(geri, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel8))
                            .addComponent(soruTipi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(ders_adi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(soru, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(sik1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sik2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(sik3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(sik4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(cevap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(puan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(zorluk_derecesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dersAdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(zorlukDerecesi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jButton4)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(29, 29, 29)))
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(124, 124, 124))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void geriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_geriActionPerformed
        // TODO add your handling code here:
        
        GirisEkrani girisEkranı = new GirisEkrani(); 
        setVisible(false);
        girisEkranı.setVisible(true);
        
        
        
        
        
        
        
    }//GEN-LAST:event_geriActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //sınav oluştur butonuna basınca olacaklar...
        
              if(dersAdi.getSelectedItem()=="Matematik" ){
               
               
               if(zorlukDerecesi.getSelectedItem()=="1"){
       
                              islemler1.mat1();
  
                }
               else if(zorlukDerecesi.getSelectedItem()=="2"){
       
                              islemler1.mat2();
  
                }
               else if(zorlukDerecesi.getSelectedItem()=="3"){
       
                              islemler1.mat3();
  
                }
           }
              else if(dersAdi.getSelectedItem()=="Turkce"){
                  if(zorlukDerecesi.getSelectedItem()=="1"){
       
                              islemler1.turk1();
  
                }
                   else if(zorlukDerecesi.getSelectedItem()=="2"){
       
                              islemler1.turk2();
  
                }
               else if(zorlukDerecesi.getSelectedItem()=="3"){
       
                              islemler1.turk3();
  
                }
              }
              else if(dersAdi.getSelectedItem()=="Genel Kultur"){
                  if(zorlukDerecesi.getSelectedItem()=="1"){
       
                              islemler1.genel1();
  
                }
                   else if(zorlukDerecesi.getSelectedItem()=="2"){
       
                              islemler1.genel2();
  
                }
               else if(zorlukDerecesi.getSelectedItem()=="3"){
       
                              islemler1.genel3();
  
                }
              }
                 soruGoruntule1();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void soru_tablosuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_soru_tablosuMouseClicked

        //tabloya tıklayınca verileri text alanlarına aktarılmasını sağladık...
        int selectedrow = soru_tablosu.getSelectedRow();
        soruTipi.setSelectedItem(model.getValueAt(selectedrow, 1).toString());
        ders_adi.setSelectedItem(model.getValueAt(selectedrow, 2).toString());
        soru.setText(model.getValueAt(selectedrow, 3).toString());
        sik1.setText(model.getValueAt(selectedrow, 4).toString());
        sik2.setText(model.getValueAt(selectedrow, 5).toString());
        sik3.setText(model.getValueAt(selectedrow, 6).toString());
        sik4.setText(model.getValueAt(selectedrow, 7).toString());
        cevap.setText(model.getValueAt(selectedrow, 8).toString());
        puan.setSelectedItem(model.getValueAt(selectedrow, 9).toString());
        zorluk_derecesi.setSelectedItem(model.getValueAt(selectedrow, 10).toString());

    }//GEN-LAST:event_soru_tablosuMouseClicked

    private void sinav_tablosuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sinav_tablosuMouseClicked
/*
        int selectedrow = soru_tablosu.getSelectedRow();
        soruTipi.setSelectedItem(model.getValueAt(selectedrow, 1).toString());
        ders_adi.setSelectedItem(model.getValueAt(selectedrow, 2).toString());
        soru.setText(model.getValueAt(selectedrow, 3).toString());
        sik1.setText(model.getValueAt(selectedrow, 4).toString());
        sik2.setText(model.getValueAt(selectedrow, 5).toString());
        sik3.setText(model.getValueAt(selectedrow, 6).toString());
        sik4.setText(model.getValueAt(selectedrow, 7).toString());
        cevap.setText(model.getValueAt(selectedrow, 8).toString());
        puan.setSelectedItem(model.getValueAt(selectedrow, 9).toString());
        zorluk_derecesi.setSelectedItem(model.getValueAt(selectedrow, 10).toString());
*/

        // TODO add your handling code here:
    }//GEN-LAST:event_sinav_tablosuMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//ekle butonuna basınca olacaklar

  String SoruTipi =soruTipi.getSelectedItem().toString();
  String DersAdi =ders_adi.getSelectedItem().toString();
  String Soru =soru.getText();
  String Sik1 =sik1.getText();
  String Sik2 =sik2.getText();
  String Sik3 =sik3.getText();
  String Sik4 =sik4.getText();
  String Cevap =cevap.getText();
  String Puan = puan.getSelectedItem().toString();
  String ZorlukDerecesi = zorluk_derecesi.getSelectedItem().toString();
  
  islemler1.soruEkle(SoruTipi,DersAdi,Soru,Sik1,Sik2,Sik3,Sik4,Cevap,Puan,ZorlukDerecesi);
  
 soruGoruntule1();
  
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      //sil butonuna basınca olacaklar
      
      
       int selectedrow=sinav_tablosu.getSelectedRow();
     
      
      if(selectedrow == -1 ){
          if(model1.getRowCount()==0){
              // mesaj_alani.setText("soru tablosu şuanda boş...");
          }
          else{
             // mesaj_alani.setText("lütfen silinecek bir soru seçiniz...");
          }
      }
      else{
          int id=(int)model1.getValueAt(selectedrow, 0);
          
          islemler1.soruSil(id);
          
         
         // mesaj_alani.setText("soru başarıyla silindi...");
          
      }
      
      
      soruGoruntule1();
      
      
      
      
      
      
      
      
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed


      islemler1.sınavSil();
      soruGoruntule1();







        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        
        islemler1.raporla();










        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

      public void soruGoruntule(){
          
           model.setRowCount(0); // her zaman once bosaltıyoruz.
        
        ArrayList<Soru> sorular = new ArrayList<Soru>();
        
        sorular = islemler.sorulariGetir();
        
        if(sorular != null){
        
        for(Soru soru : sorular){
            Object[] eklenecek ={soru.getId(),soru.getSoru_tipi(),soru.getDers_adi(),soru.getSoru(),
                soru.getSik1(), soru.getSik2(), soru.getSik3(), soru.getSik4(),soru.getCevap(),
                soru.getPuan(),soru.getZorluk_derecesi()};
            
            
            model.addRow(eklenecek);
        }
        
        }
    }
      
      public void soruGoruntule1(){
          
           model1.setRowCount(0); // her zaman once bosaltıyoruz.
        
        ArrayList<Sinav> sorular = new ArrayList<Sinav>();
        
        sorular = islemler1.sorulariGetir1();
        
        if(sorular != null){
        
        for(Sinav soru : sorular){
            Object[] eklenecek ={soru.getId(),soru.getSoru_tipi(),soru.getDers_adi(),soru.getSoru(),
                soru.getSik1(), soru.getSik2(), soru.getSik3(), soru.getSik4(),soru.getCevap(),
                soru.getPuan(),soru.getZorluk_derecesi()};
            
            
            model1.addRow(eklenecek);
        }
        
        }
    }
      
      
      
      
      
      
      
      
      
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SınavEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SınavEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SınavEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SınavEkrani.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SınavEkrani dialog = new SınavEkrani(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cevap;
    private javax.swing.JComboBox<String> dersAdi;
    private javax.swing.JComboBox<String> ders_adi;
    private javax.swing.JButton geri;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> puan;
    private javax.swing.JTextField sik1;
    private javax.swing.JTextField sik2;
    private javax.swing.JTextField sik3;
    private javax.swing.JTextField sik4;
    private javax.swing.JTable sinav_tablosu;
    private javax.swing.JTextField soru;
    private javax.swing.JComboBox<String> soruTipi;
    private javax.swing.JTable soru_tablosu;
    private javax.swing.JComboBox<String> zorlukDerecesi;
    private javax.swing.JComboBox<String> zorluk_derecesi;
    // End of variables declaration//GEN-END:variables
}
