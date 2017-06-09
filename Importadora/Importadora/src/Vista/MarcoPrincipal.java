package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
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
        JMenu jmMenuFactura;
        
        JMenuItem jmiModificarClave;
        JMenuItem jmiRegistrarCliente;
        JMenuItem jmiModificarCliente;
        JMenuItem jmiRegistrarProveedor;
        JMenuItem jmiModificarProveedor;
        JMenuItem jmiMostrarPedidos;
        JMenuItem jmiFactura;
        
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
            jmMenuFactura= new JMenu("Factura");
            
            //***************************************************//
            //      Instanciamos los MenuItems
            //***************************************************//
            jmiModificarClave=new JMenuItem("Cambiar Configuración");
            jmiRegistrarCliente=new JMenuItem("Registrar Cliente");
            jmiModificarCliente=new JMenuItem("Modificar Cliente");
            jmiRegistrarProveedor=new JMenuItem("Registrar Proveedor");
            jmiModificarProveedor=new JMenuItem("Modificar Proveedor");
            jmiMostrarPedidos=new JMenuItem("*Daniel ponle el nombre que quieras*");
            jmiFactura=new JMenuItem("Factura");
            //*********************************************************//
            //      Insertamos los MenuItems al menú Configuraciones            
            //*********************************************************//
            jmMenuConfiguraciones.add(jmiModificarClave);
            //*********************************************************//
            //      Insetamos los MenuItems al menú Cliente           
            //*********************************************************//            
            jmMenuCliente.add(jmiRegistrarCliente);
            jmMenuCliente.add(jmiModificarCliente);
            //*********************************************************//
            //      Insetamos los MenuItems al menú Proveedor            
            //*********************************************************//            
            jmMenuProveedor.add(jmiRegistrarProveedor);
            jmMenuProveedor.add(jmiModificarProveedor);
            //*********************************************************//
            //      Insetamos los MenuItems al menú Pedido           
            //*********************************************************//           
            jmMenuPedido.add(jmiMostrarPedidos);
            
            //*********************************************************//
            //      Insetamos los MenuItems al menú Factura           
            //*********************************************************//   
            
            jmMenuFactura.add(jmiFactura);
            
            
            //*********************************************************//
            //      Insetamos iconos a los MenuItems          
            //*********************************************************//              
            jmiRegistrarCliente.setIcon(new ImageIcon("img/iconoPersona.jpg"));
            jmiModificarCliente.setIcon(new ImageIcon("img/iconoModificar.jpg"));
            jmiRegistrarProveedor.setIcon(new ImageIcon("img/iconoProveedor.jpg"));
            jmiModificarProveedor.setIcon(new ImageIcon("img/iconoModificarProveedor.jpg"));
            jmiModificarClave.setIcon(new ImageIcon("img/iconoConfiguracion.jpg"));
            jmiMostrarPedidos.setIcon(new ImageIcon("img/iconoProducto.jpg"));
            jmiFactura.setIcon(new ImageIcon("img/iconoFactura.jpg"));
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
            //      Muestra el formulario de la factura
            //****************************************************//
            Factura fac=new Factura();
            jmiFactura.addActionListener((ActionListener) fac);
            
            //****************************************************//
            //      Cambiar configuracion     
            //****************************************************//
            CambiarConfiguracion cfg=new CambiarConfiguracion();
            jmiModificarClave.addActionListener(cfg);
            //****************************************************//
            //      Insertamos los menús a la barra de menús 
            //****************************************************//
            jmbBarraMenu.add(jmMenuPedido);
            jmbBarraMenu.add(jmMenuProveedor);
            jmbBarraMenu.add(jmMenuCliente);
            jmbBarraMenu.add(jmMenuConfiguraciones);
            jmbBarraMenu.add(jmMenuFactura);
            FlowLayout Superior=new FlowLayout(FlowLayout.LEFT);  
            setLayout(Superior);
            add(jmbBarraMenu);
        }
        
}
