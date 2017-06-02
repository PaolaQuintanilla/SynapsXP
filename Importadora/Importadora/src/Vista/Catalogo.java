/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Validador;
import Modelo.ConectorBD;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrea
 */
public class Catalogo extends JFrame implements Action {

    public Catalogo() {

    }
    
    JLabel JLproducto;
    JLabel titulo;
    JLabel id;
    JLabel sub;
    JLabel prod;
    JLabel mar;
    JLabel mod;
    JButton salir;
    JButton agregar;
    JLabel JLcategoria;
    JLabel JLsubcategoria;
    JLabel JLmodelo;
    JLabel JLmarca;
    JTextField JTproducto;
    JTextField JTsubcategoria;
    JTextField JTmodelo;      
    JTextField JTcategoria;
    JTextField JTmarca;
    Validador val;
    
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
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        val = new Validador();
        //****************************************************//
        //      Definimos el titulo 
        //****************************************************//
        titulo = new JLabel("Catalogo de Productos");
        titulo.setFont((new Font("bodoni mt black", 0, 20)));
        titulo.setBounds(480, 20, 300, 20);
        panel.add(titulo);
        
        //****************************************************//
        //      Las caracteristicas respecto al producto
        //****************************************************//
        id = new JLabel("ID producto");
        id.setBounds(100, 60, 100, 20);
        panel.add(id);
        
        sub = new JLabel("Subcategoria");
        sub.setBounds(200, 60, 100, 20);
        panel.add(sub);
        
        prod = new JLabel("Producto");
        prod.setBounds(300, 60, 100, 20);
        panel.add(prod);
        
        mar = new JLabel("Marca");
        mar.setBounds(400, 60, 100, 20);
        panel.add(mar);
        
        mod = new JLabel("Modelo");
        mod.setBounds(500, 60, 100, 20);
        panel.add(mod);

        //****************************************************//
        //      Boton para salir de la ventana Catalogo 
        //****************************************************//        
        salir = new JButton();
        salir.setText("Salir");
        salir.setBounds(800,500, 100, 50);
        salir.addActionListener(new ActionListener(){public void actionPerformed(java.awt.event.ActionEvent ae2){
            dispose();
        }});
        panel.add(salir);
        //****************************************************//
        //      boton para agregar producto  
        //****************************************************//
        agregar = new JButton();
        agregar.setText("Agregar");
        agregar.setBounds(800,400,100,50);
        panel.add(agregar);
        agregar.addActionListener(new ActionListener(){public void actionPerformed(java.awt.event.ActionEvent ae2){
            //*******************************************************//
            //      Instanciamos la clase ConectorBD
            //*******************************************************//
            ConectorBD cn=new ConectorBD();
            //****************************************************************************************//
            //      Condicional que nos permite saber si los campos de texto se encuentran vacíos
            //****************************************************************************************//
            if(!JTproducto.getText().isEmpty()&&!JTmodelo.getText().isEmpty()&&!JTsubcategoria.getText().isEmpty()&&!JTcategoria.getText().isEmpty()&&!JTmarca.getText().isEmpty()){
                if(!val.validarNombre(JTmodelo)&&!val.validarNombre(JTproducto)&&!val.validarNombre(JTsubcategoria)&&!val.validarNombre(JTmarca)&&!val.validarNombre(JTcategoria)){
                   //*************************************************************//
                   //       Llamamos al metodo quitar espacios
                   //*************************************************************//
                   String n=JTproducto.getText();
                   String nse=val.quitarEspacios(n);
                
                   String c=JTsubcategoria.getText();
                   String cse=val.quitarEspacios(c);
                   
                   String a=JTcategoria.getText();
                   String ase=val.quitarEspacios(a);
                   
                   String d=JTmodelo.getText();
                   String dse=val.quitarEspacios(d);
                   
                   String f=JTmarca.getText();
                   String fse=val.quitarEspacios(f);
               
                   
            try{
             //*******************************************************//
             //      Nos conectamos con la Base de Datos
             //*******************************************************//
             cn.conectar();
             //*****************************************************************************************//
             //      Hacemos un llamado al metodo consulta que nos permite insertar un nuevo producto
             //*****************************************************************************************//
             cn.consulta("insert into categoria(CATEGORIA) values('"+ase.trim()+"')");
             
             ResultSet result = cn.seleccionar("select ID_CATEGORIA from categoria where CATEGORIA='"+ase.trim()+"'");
             String idCat = result.getString("ID_CATEGORIA");
             cn.consulta("insert into subcategoria(ID_CATEGORIA,SUB_CATEGORIA) values('"+idCat+"','"+cse.trim()+"')");
             ResultSet result2 = cn.seleccionar("select ID_SUB_CAT from sub_categoria where SUB_CATEGORIA='"+cse.trim()+"'");
             String idSubCat = result2.getString("ID_SUB_CAT");
             cn.consulta("insert into producto(ID_SUB_CAT,PRODUCTO,MARCA,MODELO) values('"+idSubCat.trim()+"','"+nse.trim()+"','"+fse.trim()+"','"+dse.trim()+"')");
             //*********************************************************************************************//
             //      Si los datos son guardados de forma correcta, los campos del formulario se limpiarán
             //*********************************************************************************************//
             JTproducto.setText(idCat);
             JTmodelo.setText("");
             JTcategoria.setText("");
             JTsubcategoria.setText("");
             JTmarca.setText("");
             
             JOptionPane.showMessageDialog(null, "Se guardó correctamente");
             cn.desconectar();
         }
         catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Ocurrio un error en la conexión");
         }
        }}else{
                JOptionPane.showMessageDialog(null, "Debe rellenar los campos");
                
            }
        
            
            
        }});
        
        JLproducto = new JLabel();
        JLproducto.setText("Producto");
        JLproducto.setBounds(650, 100, 100, 40);
        panel.add(JLproducto);
        
        JLsubcategoria = new JLabel();
        JLsubcategoria.setText("Subcategoria");
        JLsubcategoria.setBounds(650, 160, 100, 40);
        panel.add(JLsubcategoria);
        
        JLcategoria = new JLabel();
        JLcategoria.setText("Categoria");
        JLcategoria.setBounds(650, 220, 100, 40);
        panel.add(JLcategoria);
        
        JLmodelo = new JLabel();
        JLmodelo.setText("Modelo");
        JLmodelo.setBounds(650, 280, 100, 40);
        panel.add(JLmodelo);
        
        JLmarca = new JLabel();
        JLmarca.setText("Marca");
        JLmarca.setBounds(650, 340, 100, 40);
        panel.add(JLmarca);
        
        JTproducto = new JTextField();
        JTproducto.setBounds(800, 100, 150, 40);
        panel.add(JTproducto);
        
        JTsubcategoria = new JTextField();
        JTsubcategoria.setBounds(800, 160, 150, 40);
        panel.add(JTsubcategoria);
        
        JTcategoria = new JTextField();
        JTcategoria.setBounds(800, 220, 150, 40);
        panel.add(JTcategoria);
        
        JTmodelo = new JTextField();
        JTmodelo.setBounds(800, 280, 150, 40);
        panel.add(JTmodelo);
        
        JTmarca = new JTextField();
        JTmarca.setBounds(800, 340, 150, 40);
        panel.add(JTmarca);
        //****************************************************//
        //      Generacion de Tabla y extraccion de datos de la BD 
        //****************************************************//
        
        JTable tabla = new JTable();
        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, new String[]{"IdProducto", "IdSubCategoria", "NombreProducto","Marca", "Modelo"}
        ));
        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/importadora", "root", "");
            PreparedStatement ps;
            ResultSet rs;
            ResultSetMetaData rsm;
            DefaultTableModel dtm;
            ps = cn.prepareStatement("select id_producto,id_sub_cat,producto,marca,modelo from producto");//ps = cn.prepareStatement("select id_producto,id_sub_cat,producto,marca,modelo from producto"); para bd daniel
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
