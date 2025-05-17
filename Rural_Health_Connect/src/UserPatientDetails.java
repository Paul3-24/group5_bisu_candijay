
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author DalanDhan
 */
public class UserPatientDetails extends javax.swing.JFrame {

    private int selectedPatientId;


    public UserPatientDetails(int id, String name, String middlename, String lastname, String address, String age, String gender, String contact, String civilStatus, String height, String weight, String status, String diagnosis) {
        initComponents();
        this.selectedPatientId = id;
        
        try {
            Connect();
             Gender();
            CivilStatus();
            PatientStatus();

        } catch (SQLException ex) {
            Logger.getLogger(AdminPatientDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        lblFirstName.setText(name);
        lblMiddleName.setText(middlename);
        lblLastName.setText(lastname);
        lblAddress.setText(address);
        lblAge.setText(age);
        lblGender.setText(gender);
        lblContactNo.setText(contact);
        lblCivilStatus.setText(civilStatus);
        lblHeight.setText(height);
        lblWeight.setText(weight);
        lblDiagnosis.setText(diagnosis);
        
        txtFirstName.setText(name);
        txtFirstName.setVisible(false);
       

        txtMiddleName.setText(middlename);
        txtMiddleName.setVisible(false);

        txtLastName.setText(lastname);
        txtLastName.setVisible(false);

        txtAddress.setText(address);
        txtAddress.setVisible(false);

        txtAge.setText(age);
        txtAge.setVisible(false);
    
        lblGender.setText(gender);
        comboboxGender.setVisible(false);

        txtContactNo.setText(contact);
        txtContactNo.setVisible(false);

        lblCivilStatus.setText(civilStatus);
        comboboxCivilStatus.setVisible(false);

        txtHeight.setText(height);
        txtHeight.setVisible(false);

        txtWeight.setText(weight);
        txtWeight.setVisible(false);

        lblPatientStatus.setText(status);
        comboboxPatientStatus.setVisible(false);
        
        txtDiagnosis.setText(diagnosis);
        txtDiagnosis.setVisible(false);
        
        
        
       }
    
        public UserPatientDetails() {
        initComponents();
        
        try {
            Connect();
            
                
        } catch (SQLException ex) {
            Logger.getLogger(Add.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
        txtFirstName.setVisible(false);
        txtMiddleName.setVisible(false);
        txtLastName.setVisible(false);
        txtAddress.setVisible(false);
        txtAge.setVisible(false);
        comboboxGender.setVisible(false);
        txtContactNo.setVisible(false);
        comboboxCivilStatus.setVisible(false);
        txtHeight.setVisible(false);
        txtWeight.setVisible(false);
        comboboxPatientStatus.setVisible(false);
}
        
        public void setSelectedPatientId(int id) {
        this.selectedPatientId = id;
}

        
        
        private void Gender(){
       
        try {
            pst = con.prepareStatement("SELECT Gender FROM comboboxgender");
            rs = pst.executeQuery();
            comboboxGender.removeAllItems();
            while(rs.next()){
                
                comboboxGender.addItem(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminPatientDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
     
      private void CivilStatus(){
       
        try {
            pst = con.prepareStatement("SELECT civilstatus FROM comboboxcivilstatus");
            rs = pst.executeQuery();
            comboboxCivilStatus.removeAllItems();
            while(rs.next()){
                
                comboboxCivilStatus.addItem(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminPatientDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
        
         private void PatientStatus(){
       
        try {
            pst = con.prepareStatement("SELECT patientstatus FROM comboboxpatientstatus");
            rs = pst.executeQuery();
            comboboxPatientStatus.removeAllItems();
            while(rs.next()){
                
                comboboxPatientStatus.addItem(rs.getString(1));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminPatientDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
         
    
        
   PreparedStatement pst;
    ResultSet rs;
    Connection con;
    Statement st;

    private static final String DbName = "ruralcare_connect";
    private static final String DbDriver = "com.mysql.cj.jdbc.Driver";
    private static final String DbUrl = "jdbc:mysql://localhost:3306/"+DbName;
    private static final String DbUsername = "root";
    private static final String DbPassword = "";
    
     //Crete a method for connection
    private void Connect() throws SQLException {
        try {
            Class.forName(DbDriver);
            //Url, Username, Password
            con = DriverManager.getConnection(DbUrl, DbUsername, DbPassword);
            st = con.createStatement();
            if (con != null) {
                System.out.println("Connection succesful");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Panel1 = new javax.swing.JPanel();
        qq = new javax.swing.JLabel();
        qqq = new javax.swing.JLabel();
        a = new javax.swing.JLabel();
        c = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        b = new javax.swing.JLabel();
        g = new javax.swing.JLabel();
        f = new javax.swing.JLabel();
        e = new javax.swing.JLabel();
        qqq1 = new javax.swing.JLabel();
        qqq2 = new javax.swing.JLabel();
        lblFirstName = new javax.swing.JLabel();
        lblMiddleName = new javax.swing.JLabel();
        lblLastName = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblAge = new javax.swing.JLabel();
        lblContactNo = new javax.swing.JLabel();
        lblCivilStatus = new javax.swing.JLabel();
        lblWeight = new javax.swing.JLabel();
        lblHeight = new javax.swing.JLabel();
        lblPatientStatus = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        txtFirstName = new javax.swing.JTextField();
        txtMiddleName = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtAge = new javax.swing.JTextField();
        comboboxGender = new javax.swing.JComboBox<>();
        txtContactNo = new javax.swing.JTextField();
        txtHeight = new javax.swing.JTextField();
        txtWeight = new javax.swing.JTextField();
        comboboxPatientStatus = new javax.swing.JComboBox<>();
        comboboxCivilStatus = new javax.swing.JComboBox<>();
        g1 = new javax.swing.JLabel();
        lblDiagnosis = new javax.swing.JLabel();
        txtDiagnosis = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setPreferredSize(new java.awt.Dimension(389, 25));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setPreferredSize(new java.awt.Dimension(389, 25));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("jLabel1");

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel1.setBackground(new java.awt.Color(153, 204, 255));
        Panel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        qq.setBackground(new java.awt.Color(0, 0, 0));
        qq.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        qq.setForeground(new java.awt.Color(0, 0, 0));
        qq.setText("Address:");
        Panel1.add(qq, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 70, 30));

        qqq.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        qqq.setForeground(new java.awt.Color(0, 0, 0));
        qqq.setText("First Name:");
        Panel1.add(qqq, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 80, 30));

        a.setBackground(new java.awt.Color(0, 0, 0));
        a.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        a.setForeground(new java.awt.Color(0, 0, 0));
        a.setText("Age:");
        Panel1.add(a, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, 30));

        c.setBackground(new java.awt.Color(0, 0, 0));
        c.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        c.setForeground(new java.awt.Color(0, 0, 0));
        c.setText("Contact No. :");
        Panel1.add(c, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, -1, 30));

        d.setBackground(new java.awt.Color(0, 0, 0));
        d.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        d.setForeground(new java.awt.Color(0, 0, 0));
        d.setText("Civil Status:");
        Panel1.add(d, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, -1, 30));

        b.setBackground(new java.awt.Color(0, 0, 0));
        b.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        b.setForeground(new java.awt.Color(0, 0, 0));
        b.setText("Gender:");
        Panel1.add(b, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, 30));

        g.setBackground(new java.awt.Color(0, 0, 0));
        g.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        g.setForeground(new java.awt.Color(0, 0, 0));
        g.setText("   Diagnosis:");
        Panel1.add(g, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 80, 30));

        f.setBackground(new java.awt.Color(0, 0, 0));
        f.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        f.setForeground(new java.awt.Color(0, 0, 0));
        f.setText("Weight:");
        Panel1.add(f, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, -1, 40));

        e.setBackground(new java.awt.Color(0, 0, 0));
        e.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        e.setForeground(new java.awt.Color(0, 0, 0));
        e.setText("Height:");
        Panel1.add(e, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, 30));

        qqq1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        qqq1.setForeground(new java.awt.Color(0, 0, 0));
        qqq1.setText("Middle Name:");
        Panel1.add(qqq1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 30));

        qqq2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        qqq2.setForeground(new java.awt.Color(0, 0, 0));
        qqq2.setText("Last Name:");
        Panel1.add(qqq2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 80, 30));

        lblFirstName.setForeground(new java.awt.Color(0, 0, 0));
        lblFirstName.setText("jLabel1");
        Panel1.add(lblFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 240, -1));

        lblMiddleName.setForeground(new java.awt.Color(0, 0, 0));
        lblMiddleName.setText("jLabel1");
        Panel1.add(lblMiddleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 96, 240, 20));

        lblLastName.setForeground(new java.awt.Color(0, 0, 0));
        lblLastName.setText("jLabel1");
        Panel1.add(lblLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 240, 30));

        lblAddress.setForeground(new java.awt.Color(0, 0, 0));
        lblAddress.setText("jLabel1");
        Panel1.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 240, 30));

        lblGender.setForeground(new java.awt.Color(0, 0, 0));
        lblGender.setText("jLabel1");
        Panel1.add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 240, 30));

        lblAge.setForeground(new java.awt.Color(0, 0, 0));
        lblAge.setText("jLabel1");
        Panel1.add(lblAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 240, 30));

        lblContactNo.setForeground(new java.awt.Color(0, 0, 0));
        lblContactNo.setText("jLabel1");
        Panel1.add(lblContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 240, 30));

        lblCivilStatus.setForeground(new java.awt.Color(0, 0, 0));
        lblCivilStatus.setText("jLabel1");
        Panel1.add(lblCivilStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 56, 240, 20));

        lblWeight.setForeground(new java.awt.Color(0, 0, 0));
        lblWeight.setText("jLabel1");
        Panel1.add(lblWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 240, -1));

        lblHeight.setForeground(new java.awt.Color(0, 0, 0));
        lblHeight.setText("jLabel1");
        Panel1.add(lblHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 86, 240, 30));

        lblPatientStatus.setForeground(new java.awt.Color(0, 0, 0));
        lblPatientStatus.setText("jLabel1");
        Panel1.add(lblPatientStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 240, 30));

        txtLastName.setText("jTextField1");
        txtLastName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLastNameActionPerformed(evt);
            }
        });
        Panel1.add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 250, -1));

        txtFirstName.setText("jTextField1");
        txtFirstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFirstNameActionPerformed(evt);
            }
        });
        Panel1.add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 250, -1));

        txtMiddleName.setText("jTextField1");
        Panel1.add(txtMiddleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 250, -1));

        txtAddress.setText("jTextField1");
        Panel1.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 250, -1));

        txtAge.setText("jTextField1");
        Panel1.add(txtAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 250, -1));

        comboboxGender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxGenderActionPerformed(evt);
            }
        });
        Panel1.add(comboboxGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 250, -1));

        txtContactNo.setText("jTextField1");
        txtContactNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactNoActionPerformed(evt);
            }
        });
        Panel1.add(txtContactNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 250, -1));

        txtHeight.setText("jTextField1");
        Panel1.add(txtHeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 240, -1));

        txtWeight.setText("jTextField1");
        txtWeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtWeightActionPerformed(evt);
            }
        });
        Panel1.add(txtWeight, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 140, 240, -1));

        comboboxPatientStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxPatientStatusActionPerformed(evt);
            }
        });
        Panel1.add(comboboxPatientStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, 240, -1));

        comboboxCivilStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxCivilStatusActionPerformed(evt);
            }
        });
        Panel1.add(comboboxCivilStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 240, -1));

        g1.setBackground(new java.awt.Color(0, 0, 0));
        g1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        g1.setForeground(new java.awt.Color(0, 0, 0));
        g1.setText("Patient's Status:");
        Panel1.add(g1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, 30));

        lblDiagnosis.setForeground(new java.awt.Color(0, 0, 0));
        lblDiagnosis.setText("jLabel1");
        Panel1.add(lblDiagnosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 226, 240, 20));

        txtDiagnosis.setText("jTextField1");
        Panel1.add(txtDiagnosis, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 240, -1));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("PATIENT DETAILS");
        Panel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 170, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtFirstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFirstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFirstNameActionPerformed

    private void txtLastNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLastNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLastNameActionPerformed

    private void txtContactNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactNoActionPerformed

    private void comboboxGenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxGenderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxGenderActionPerformed

    private void comboboxPatientStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxPatientStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxPatientStatusActionPerformed

    private void txtWeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtWeightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtWeightActionPerformed

    private void comboboxCivilStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxCivilStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboboxCivilStatusActionPerformed

    public static void main(String args[]) {
       
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminPatientDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel1;
    private javax.swing.JLabel a;
    private javax.swing.JLabel b;
    private javax.swing.JLabel c;
    private javax.swing.JComboBox<String> comboboxCivilStatus;
    private javax.swing.JComboBox<String> comboboxGender;
    private javax.swing.JComboBox<String> comboboxPatientStatus;
    private javax.swing.JLabel d;
    private javax.swing.JLabel e;
    private javax.swing.JLabel f;
    private javax.swing.JLabel g;
    private javax.swing.JLabel g1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblCivilStatus;
    private javax.swing.JLabel lblContactNo;
    private javax.swing.JLabel lblDiagnosis;
    private javax.swing.JLabel lblFirstName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblHeight;
    private javax.swing.JLabel lblLastName;
    private javax.swing.JLabel lblMiddleName;
    private javax.swing.JLabel lblPatientStatus;
    private javax.swing.JLabel lblWeight;
    private javax.swing.JLabel qq;
    private javax.swing.JLabel qqq;
    private javax.swing.JLabel qqq1;
    private javax.swing.JLabel qqq2;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtContactNo;
    private javax.swing.JTextField txtDiagnosis;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtHeight;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtMiddleName;
    private javax.swing.JTextField txtWeight;
    // End of variables declaration//GEN-END:variables
}