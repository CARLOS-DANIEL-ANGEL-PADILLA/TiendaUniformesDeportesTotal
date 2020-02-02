/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import Conectar.Conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author CARLOS
 */
public class Semanal extends javax.swing.JInternalFrame {

    DefaultTableModel model;
    /**
     * Creates new form Semanal
     */
    public Semanal() {
        initComponents();
        cargar("");
        total();
    }
    
    void cargar (String valor){
        try{//                   0         1         2        3          4           5          6                 7                 8   
            String [] titulos={"ID","COD. BOLETA","CODIGO","FECHA/HORA","DESCR.","CANTIDAD",   "PRECIO UNI.", "IMPORTE"};
            String [] registros=new String[8];
            model=new DefaultTableModel(null, titulos);
                                                                //2              3            4          5                  6            7        8            9                 
            String cons = "SELECT * FROM semanal WHERE CONCAT (`id_sem`, `codboleta_sem`, `cod_sem`, `horafecha_sem`, `desc_sem`, `cant_sem`, `preu_sem`, `total_sem`) LIKE '%"+valor+"%'";
            
            Statement st= cn.createStatement();
            ResultSet rs = st.executeQuery(cons);
            
            while(rs.next()){
                registros[0]=rs.getString(2);
                registros[1]=rs.getString(5);
                registros[2]=rs.getString(3);
                registros[3]=rs.getString(4);
                registros[4]=rs.getString(6);
                registros[5]=rs.getString(7);//cantidad
                registros[6]=rs.getString(8);
                registros[7]=rs.getString(9);//total
                
                model.addRow(registros);
            }
            
            tbSemanal.setModel(model);
           
            //tbConsultas.getColumnModel().getColumn(0).setPreferredWidth(100);
            //tbConsultas.getColumnModel().getColumn(1).setPreferredWidth(90);
            //tbConsultas.getColumnModel().getColumn(3).setPreferredWidth(300);
            //tbConsultas.getColumnModel().getColumn(4).setPreferredWidth(100);
            //tbConsultas.getColumnModel().getColumn(5).setPreferredWidth(100);
            //tbConsultas.getColumnModel().getColumn(6).setPreferredWidth(100);
            
        }catch(Exception e){
            //System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Metodo Cargar Registro "+e);
        }
    }
    
    void total(){
        String can;
        String pre;
        double precio;
        int cantidad;
        double imp=0.0;
        double total=0;
        
        for(int i=0; i<tbSemanal.getRowCount(); i++){
            can=tbSemanal.getValueAt(i, 5).toString();
            pre=tbSemanal.getValueAt(i, 7).toString();
            precio=Double.parseDouble((pre));
            cantidad=Integer.parseInt(can);
            imp=precio*cantidad;
            total=total+imp;
            
            //tbDiaria.setValueAt("$"+ Math.rint(imp), i, 9);
        }
        
        txtTotal.setText("$"+Math.rint(total));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSemanal = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnSalir = new javax.swing.JButton();
        btnFinalizar = new javax.swing.JButton();
        txtTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);

        tbSemanal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbSemanal);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 761, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(8, 8, 8)
                    .addComponent(jScrollPane1)
                    .addGap(8, 8, 8)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(23, 23, 23)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );

        btnSalir.setText("Salir");

        btnFinalizar.setText("Finalizar");

        jLabel1.setText("Total:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(btnSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(btnFinalizar)
                .addGap(107, 107, 107))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalir)
                    .addComponent(btnFinalizar)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbSemanal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
    Conectar cc=new Conectar();
    Connection cn=cc.conexion();
}
