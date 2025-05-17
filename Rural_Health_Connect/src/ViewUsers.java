
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author DalanDhan
 */
public class ViewUsers extends javax.swing.JFrame {

    /**
     * Creates new form ViewUsers
     */
    public ViewUsers() {
          initComponents();
          setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
          setLocationRelativeTo(null);
         try {
         Connect();
         Fetch();
         setupTableClickListener();
    } catch (SQLException ex) {
        Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
     private void setupTableClickListener() {
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mousePressed(java.awt.event.MouseEvent evt) {
            int row = jTable1.rowAtPoint(evt.getPoint());
            int column = jTable1.columnAtPoint(evt.getPoint());

            // Only respond to the delete button column
            if (row >= 0 && column == jTable1.getColumnCount() - 1) {
                String id = jTable1.getValueAt(row, 0).toString();
                String firstname = jTable1.getValueAt(row, 1).toString();

                int confirm = JOptionPane.showConfirmDialog(
                    null,
                    "Delete the account of: " + firstname + "?",
                    "Confirm",
                    JOptionPane.YES_NO_OPTION
                );

                if (confirm != JOptionPane.YES_OPTION) {
                    return;
                }

                try {
                    pst = con.prepareStatement("DELETE FROM users WHERE user_id = ?");
                    pst.setString(1, id);
                    int rowsAffected = pst.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Deleted successfully");
                        Fetch(); // Reload table
                    } else {
                        JOptionPane.showMessageDialog(null, "Delete failed: No matching ID");
                    }
                    
                    Statement stmt = con.createStatement();
                    stmt.execute("SET @new_id = 0");
                    stmt.executeUpdate("UPDATE users SET user_id = (@new_id := @new_id + 1)");
                    stmt.execute("ALTER TABLE users AUTO_INCREMENT = 1");
                    
                    Fetch();
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage());
                }
            }
        }
    });
}
    
    
    
    
    
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
            Logger.getLogger(AdminPatientDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            private void Fetch(){
        try {
            int q;
            pst = con.prepareStatement("SELECT * FROM users");
            rs = pst.executeQuery();
            ResultSetMetaData rss = rs.getMetaData();
            q = rss.getColumnCount();
            
            DefaultTableModel df = (DefaultTableModel)jTable1.getModel();
            df.setRowCount(0);
            while(rs.next()){
                Vector v2 = new Vector();
                for (int a=1; a<=q; a++){
                    v2.add(rs.getString("user_id"));
                    v2.add(rs.getString("fullname"));
                    v2.add(rs.getString("usertype"));
                    v2.add("Delete");
                    
                }
                df.addRow(v2);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "User", "Role", "Action"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(5);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 347, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ViewUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewUsers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewUsers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    void SetLocationRelativeTo(Object object) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
}}
