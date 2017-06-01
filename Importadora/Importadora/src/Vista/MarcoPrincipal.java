package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class MarcoPrincipal extends JFrame{
    
    
    public MarcoPrincipal(String titulo){
        super(titulo);
        ImageIcon icono=new ImageIcon("img/iconoCAT.jpg");
        Image img=icono.getImage();
        setIconImage(img);
        PanelMenu pm=new PanelMenu();
        pm.setBackground(Color.BLACK);
        
        add(pm);
        BorderLayout Norte=new BorderLayout(50,50);
        setLayout(Norte);
        add(pm,BorderLayout.NORTH);    
    }
}    
    class PanelMenu extends JPanel{
        //**************************************//
        //      Declaramos los atributos
        //**************************************//
        JMenuBar jmbBarraMenu;
        JMenu jmMenuCliente;
        JMenu jmMenuProveedor;
        JMenu jmMenuConfiguraciones;
        JMenu jmMenuPedido;
        JMenu jmMenuCatalogo;
        JMenuItem jmiModificarClave;
        JMenuItem jmiRegistrarCliente;
        JMenuItem jmiModificarCliente;
        JMenuItem jmiRegistrarProveedor;
        JMenuItem jmiModificarProveedor;
        JMenuItem jmiMostrarPedidos;
        JMenuItem jmiMostrarCatalogo;
        public PanelMenu(){
            //***************************************************//
            //      Instanciamos el barra del menu
            //***************************************************//
            jmbBarraMenu=new JMenuBar(); 
            jmbBarraMenu.setBorderPainted(true); 
            //***************************************************//
            //      Instanciamos los Menús
            //***************************************************//
            jmMenuCliente=new JMenu("Cliente");
            jmMenuProveedor=new JMenu("Proveedor");
            jmMenuConfiguraciones=new JMenu("Configuraciones");
            jmMenuPedido=new JMenu("Pedido");
            jmMenuCatalogo=new JMenu("Producto");
            //***************************************************//
            //      Instanciamos los MenuItems
            //***************************************************//
            jmiModificarClave=new JMenuItem("Cambiar Configuración");
            jmiRegistrarCliente=new JMenuItem("Registrar Cliente");
            jmiModificarCliente=new JMenuItem("Modificar Cliente");
            jmiRegistrarProveedor=new JMenuItem("Registrar Proveedor");
            jmiModificarProveedor=new JMenuItem("Modificar Proveedor");
            jmiMostrarPedidos=new JMenuItem("*Daniel ponle el nombre que quieras*");
            jmiMostrarCatalogo=new JMenuItem("Catalogo");
            //*********************************************************//
            //      Insertamos los MenuItems al menú Configuraciones            
            //*********************************************************//
            jmMenuConfiguraciones.add(jmiModificarClave);
            //*********************************************************//
            //      Insertamos los MenuItems al menú Cliente           
            //*********************************************************//            
            jmMenuCliente.add(jmiRegistrarCliente);
            jmMenuCliente.add(jmiModificarCliente);
            //*********************************************************//
            //      Insertamos los MenuItems al menú Proveedor            
            //*********************************************************//            
            jmMenuProveedor.add(jmiRegistrarProveedor);
            jmMenuProveedor.add(jmiModificarProveedor);
            //*********************************************************//
            //      Insertamos los MenuItems al menú Pedido           
            //*********************************************************//           
            jmMenuPedido.add(jmiMostrarPedidos);
            //*********************************************************//
            //      Insertamos los MenuItems al menú Producto           
            //*********************************************************//
            jmMenuCatalogo.add(jmiMostrarCatalogo);
            //*********************************************************//
            //      Insertamos iconos a los MenuItems          
            //*********************************************************//              
            jmiRegistrarCliente.setIcon(new ImageIcon("img/iconoPersona.jpg"));
            jmiModificarCliente.setIcon(new ImageIcon("img/iconoModificar.jpg"));
            jmiRegistrarProveedor.setIcon(new ImageIcon("img/iconoProveedor.jpg"));
            jmiModificarProveedor.setIcon(new ImageIcon("img/iconoModificarProveedor.jpg"));
            jmiModificarClave.setIcon(new ImageIcon("img/iconoConfiguracion.jpg"));
            jmiMostrarPedidos.setIcon(new ImageIcon("img/iconoProducto.jpg"));
            jmiMostrarCatalogo.setIcon(new ImageIcon("img/iconoCatalogo.jpg"));
            //****************************************************//
            //      Muestra el forumlario de registror cliente     
            //****************************************************//
            RegistrarCliente rp=new RegistrarCliente();
            jmiRegistrarCliente.addActionListener(rp); 
            //****************************************************//
            //      Modifica datos del cliente     
            //****************************************************//
            ModificarCliente bc=new ModificarCliente();
            jmiModificarCliente.addActionListener(bc);
            //****************************************************//
            //      Muestra el formulario de registro proveedor
            //****************************************************//
            RegistrarProveedor rpv=new RegistrarProveedor();
            jmiRegistrarProveedor.addActionListener(rpv);
            //****************************************************//
            //      Modifica datos del cliente     
            //****************************************************//
            ModificarProveedor mp=new ModificarProveedor();
            jmiModificarProveedor.addActionListener(mp);
            //****************************************************//
            //      Cambiar configuracion     
            //****************************************************//
            CambiarConfiguracion cfg=new CambiarConfiguracion();
            jmiModificarClave.addActionListener(cfg);
            //****************************************************//
            //      Muestra el catalogo de productos      
            //****************************************************//
            Catalogo ca = new Catalogo();
            jmiMostrarCatalogo.addActionListener(ca);
            //****************************************************//
            //      Insertamos los menús a la barra de menús 
            //****************************************************//
            jmbBarraMenu.add(jmMenuPedido);
            jmbBarraMenu.add(jmMenuProveedor);
            jmbBarraMenu.add(jmMenuCliente);
            jmbBarraMenu.add(jmMenuCatalogo);
            jmbBarraMenu.add(jmMenuConfiguraciones);
            FlowLayout Superior=new FlowLayout(FlowLayout.LEFT);  
            setLayout(Superior);
            add(jmbBarraMenu);
        }        
}
