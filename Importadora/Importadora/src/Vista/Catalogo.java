/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrea
 */
public class Catalogo extends JFrame implements Action {

    public Catalogo() {

    }

    @Override
    public Object getValue(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putValue(String key, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ev) {
       
        //****************************************************//
        //      Definimos los parametros de la ventana catalogo
        //****************************************************//
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //****************************************************//
        //      Definimos el titulo 
        //****************************************************//
        JLabel titulo = new JLabel("Productos en Almacen");
        titulo.setFont((new Font("bodoni mt black", 0, 20)));
        titulo.setBounds(500, 20, 300, 20);
        panel.add(titulo);
        
        //****************************************************//
        //      Las caracteristicas respecto al producto
        //****************************************************//
        JLabel id = new JLabel("ID producto");
        id.setBounds(100, 60, 100, 20);
        panel.add(id);
        JLabel sub = new JLabel("Subcategoria");
        sub.setBounds(280, 60, 100, 20);//sub.setBounds(200, 60, 100, 20);para bd daniel
        panel.add(sub);
        JLabel prod = new JLabel("Producto");
        prod.setBounds(450, 60, 100, 20);//prod.setBounds(300, 60, 100, 20);para bd daniel
        panel.add(prod);
//        JLabel mar = new JLabel("Marca");
//        mar.setBounds(400, 60, 100, 20);
//        panel.add(mar);
//        JLabel mod = new JLabel("Modelo");
//        mod.setBounds(500, 60, 100, 20);
//        panel.add(mod);

        //****************************************************//
        //      Nos permite salir de la ventana Catalogo 
        //****************************************************//        
        JButton salir = new JButton();
        salir.setText("Aceptar");
        salir.setBounds(900, 600, 100, 50);
         salir.addActionListener(new ActionListener(){public void actionPerformed(java.awt.event.ActionEvent ae2){
            dispose();
        }});
        panel.add(salir);
        //****************************************************//
        //      Generacion de Tabla y extraccion de datos de la BD 
        //****************************************************//
        JTable tabla = new JTable();
        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, new String[]{"IdProducto", "IdSubCategoria", "NombreProducto"/*, "Marca", "Modelo" para bd daniel*/}
        ));
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/importadora", "root", "");
            PreparedStatement ps;
            ResultSet rs;
            ResultSetMetaData rsm;
            DefaultTableModel dtm;
            ps = cn.prepareStatement("select id_producto,is_sub_cat,producto from producto");//ps = cn.prepareStatement("select id_producto,id_sub_cat,producto,marca,modelo from producto"); para bd daniel
            rs = ps.executeQuery();
            rsm = rs.getMetaData();
            ArrayList<Object[]> data = new ArrayList<>();
            while (rs.next()) {
                Object[] rows = new Object[rsm.getColumnCount()];
                for (int i = 0; i < rows.length; i++) {
                    rows[i] = rs.getObject(i + 1);
                }
                data.add(rows);
            }
            dtm = (DefaultTableModel) tabla.getModel();
            for (int i = 0; i < data.size(); i++) {
                dtm.addRow(data.get(i));
            }
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        } 
        panel.add(tabla);
        tabla.setBounds(100, 90, 500, 550);
        add(panel);

    }

}
