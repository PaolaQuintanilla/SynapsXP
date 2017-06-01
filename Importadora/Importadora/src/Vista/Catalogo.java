/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import modelo.ConexionBD;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;

/**
 *
 * @author Andrea
 */
public class Catalogo extends JFrame implements Action {

    public Catalogo() {
        /*
        **
        */
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel titulo = new JLabel("Productos en Almacen");
        titulo.setFont((new Font("bodoni mt black", 0, 20)));
        titulo.setBounds(500, 20, 300, 20);
        panel.add(titulo);

        JLabel nombre = new JLabel("Productos");
        nombre.setBounds(100, 60, 100, 20);
        panel.add(nombre);
        /*
        **creacion de un Jlist para mostrar los productos
        */
        JList productos = new JList();
        DefaultListModel<String> list = new DefaultListModel<>();
        /*
        **Agrega los productos que se encuentran en la base de datos
        */
        list.add(0, "Auto");
        list.add(0, "auto2");
        list.add(0, "camion");
        list.add(1, "moto");
        
        
        productos.setModel(list);
        productos.setSize(150, 80);       
        panel.add(productos);

        JScrollPane barraDesplazamiento = new JScrollPane(productos);
        barraDesplazamiento.setBounds(100,100,300,40);
        panel.add(barraDesplazamiento);
        
        add(panel);
    }

    @Override
    public Object getValue(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putValue(String string, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

