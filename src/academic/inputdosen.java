/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package academic;

/**
 *
 * @author ALING
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class inputdosen extends javax.swing.JFrame {
private final DefaultTableModel model;
static Connection conn = null;
static Statement stmt = null;
static String iddosen, pass, nama, sql, cmd, tlahir, tgll, contact, email,gender;
static ResultSet rs;

    /**
     * Creates new form inputdosen
     */
    public inputdosen() {
        initComponents();
        model = new DefaultTableModel();
        datadosen.setModel(model);
        model.addColumn("ID");
        model.addColumn("NAMA");
        model.addColumn("PASS");
        model.addColumn("Tempat Lahir");
        model.addColumn("Tanggal Lahir");
        model.addColumn("Gender");
        model.addColumn("Contact");
        model.addColumn("Email");
        try{
                    jComboBox1.removeAllItems();
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tugas","root", "ABC");
            stmt  = conn.createStatement();
            cmd = "SELECT * FROM combo";
            rs = stmt.executeQuery(cmd);  
            while(rs.next()){
                  jComboBox1.addItem(rs.getString("gender"));
            }rs.last();
            rs.getRow();
            rs.first();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        loadData();
    }
    public final void loadData(){
        model.getDataVector().removeAllElements();
    model.fireTableDataChanged();
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost/tugas","root", "ABC");
            stmt  = conn.createStatement();
            cmd = "SELECT * FROM dosen order by iddosen";
            rs = stmt.executeQuery(cmd);
            while(rs.next()){
                iddosen= rs.getString("iddosen");
                nama = rs.getString("nama");
                pass = rs.getString("pass");
                tlahir = rs.getString("tlahir");
                tgll = rs.getString("tgll");
                contact = rs.getString("contact");
                email = rs.getString("email");
                gender = rs.getString("gender");
                model.addRow(new Object[]{iddosen, nama, pass,tlahir,tgll,gender,contact,email});
}rs.close();
        }catch (SQLException e){
    JOptionPane.showMessageDialog(null,"Terjadi ERROR");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        datadosen = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("DATA DOSEN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, -1, -1));

        jLabel2.setText("ID");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel3.setText("Nama");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 258, -1, -1));

        jLabel4.setText("Pass");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 296, -1, -1));

        jLabel5.setText("Tempat Lahir");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 337, -1, -1));

        jLabel6.setText("Tanggal Lahir");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 372, -1, -1));

        jLabel7.setText("Contact");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 448, -1, -1));

        jLabel8.setText("Email");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 486, -1, -1));

        jButton1.setText("INPUT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 521, -1, -1));

        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 521, -1, -1));

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 521, -1, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 217, 364, -1));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 255, 364, -1));
        getContentPane().add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 293, 364, -1));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 331, 364, -1));
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 360, -1));
        getContentPane().add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 445, 364, -1));
        getContentPane().add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 483, 364, -1));

        jButton4.setText("BACK");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 521, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 407, -1, -1));

        jLabel9.setText("Gender");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, -1, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\ALING\\Pictures\\uph.jpg")); // NOI18N
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 11, -1, -1));

        jInternalFrame2.setVisible(true);

        datadosen.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(datadosen);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jInternalFrame2, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 160, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
iddosen = jTextField1.getText();
nama = jTextField2.getText();
pass = jTextField3.getText();
tlahir= jTextField4.getText();
tgll = jTextField5.getText();
gender = (String) jComboBox1.getSelectedItem();
contact= jTextField6.getText();
email = jTextField7.getText();
cmd = "INSERT INTO dosen VALUES(?,?,?,?,?,?,?,?)";
try{
conn = DriverManager.getConnection("jdbc:mysql://localhost/tugas","root", "ABC");
 PreparedStatement ps = conn.prepareStatement(cmd);
        ps.setString(1,iddosen);
        ps.setString(2,nama);
        ps.setString(3,pass);
        ps.setString(4,tlahir);
        ps.setString(5,tgll);
        ps.setString(6,contact);
        ps.setString(7,email);
        ps.setString(8,gender);
        ps.executeUpdate();
        ps.close();
}catch (SQLException e){
    }finally {
    loadData();
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    jTextField7.setText("");
}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
try{
iddosen = jTextField1.getText();
nama = jTextField2.getText();
pass = jTextField3.getText();
tlahir= jTextField4.getText();
tgll = jTextField5.getText();
gender = (String) jComboBox1.getSelectedItem();
contact= jTextField6.getText();
email = jTextField7.getText();
conn = DriverManager.getConnection("jdbc:mysql://localhost/tugas","root", "ABC");
cmd = "UPDATE dosen SET nama = ?,pass = ? tlahir = ?,tgll = ?,gender = ?, contact = ?,email = ? WHERE iddosen = ?";
PreparedStatement ps = conn.prepareStatement(cmd);
        ps.setString(1,nama);
        ps.setString(2,pass);
        ps.setString(3,tlahir);
        ps.setString(4,tgll);
        ps.setString(5,contact);
        ps.setString(6,email);
        ps.setString(7,gender);
        ps.setString(8,iddosen);
        ps.executeUpdate();
        ps.close();
}catch (SQLException e){
    System.out.println("Terjadi Error");
}finally {
    loadData();
    jTextField1.setText("");
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    jTextField7.setText("");
}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
try{
iddosen = jTextField1.getText();
conn = DriverManager.getConnection("jdbc:mysql://localhost/tugas","root", "ABC");
cmd = "DELETE FROM dosen WHERE iddosen = ?";
PreparedStatement ps = conn.prepareStatement(cmd);
   ps.setString(1,iddosen);
   ps.executeUpdate();
        ps.close();
}catch (SQLException e){
    System.out.println("Terjadi Error");
}finally {
    loadData();
   jTextField1.setText("");
}
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 this.setVisible(false);
        new input().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(inputdosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(inputdosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(inputdosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(inputdosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
     
            ;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable datadosen;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
