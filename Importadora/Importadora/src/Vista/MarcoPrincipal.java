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
        ImageIcon icono=new ImageIcon("img/mundo.jpg");
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
        JMenuBar BarraMenu;
        JMenu MenuCliente;
        JMenu MenuProveedor;
        JMenu MenuConfiguraciones;
        JMenu MenuPedido;
        JMenuItem ModificarClave;
        JMenuItem RegistrarCliente;
        JMenuItem ModificarCliente;
        JMenuItem RegistrarProveedor;
        JMenuItem ModificarProveedor;
        JMenuItem MostrarPedidos;
        public PanelMenu(){
            //***************************************************//
            //      Instanciamos el barra del menu
            //***************************************************//
            BarraMenu=new JMenuBar(); 
            BarraMenu.setBorderPainted(true); 
            //***************************************************//
            //      Instanciamos los Menús
            //***************************************************//
            MenuCliente=new JMenu("Cliente");
            MenuProveedor=new JMenu("Proveedor");
            MenuConfiguraciones=new JMenu("Configuraciones");
            MenuPedido=new JMenu("Pedido");
            //***************************************************//
            //      Instanciamos los MenuItems
            //***************************************************//
            ModificarClave=new JMenuItem("Cambiar Configuracion");
            RegistrarCliente=new JMenuItem("Registrar Cliente");
            ModificarCliente=new JMenuItem("Modificar Cliente");
            RegistrarProveedor=new JMenuItem("Registrar Proveedor");
            ModificarProveedor=new JMenuItem("Modificar Proveedor");
            MostrarPedidos=new JMenuItem("*Daniel ponle el nombre que quieras*");
            //*********************************************************//
            //      Insertamos los MenuItems al menú Configuraciones            
            //*********************************************************//
            MenuConfiguraciones.add(ModificarClave);
            //*********************************************************//
            //      Insetamos los MenuItems al menú Cliente           
            //*********************************************************//            
            MenuCliente.add(RegistrarCliente);
            MenuCliente.add(ModificarCliente);
            //*********************************************************//
            //      Insetamos los MenuItems al menú Proveedor            
            //*********************************************************//            
            MenuProveedor.add(RegistrarProveedor);
            MenuProveedor.add(ModificarProveedor);
            //*********************************************************//
            //      Insetamos los MenuItems al menú Pedido           
            //*********************************************************//           
            MenuPedido.add(MostrarPedidos);
            //*********************************************************//
            //      Insetamos iconos a los MenuItems          
            //*********************************************************//              
            RegistrarCliente.setIcon(new ImageIcon("img/iconoPersona.jpg"));
            ModificarCliente.setIcon(new ImageIcon("img/iconoModificar.jpg"));
            RegistrarProveedor.setIcon(new ImageIcon("img/iconoProveedor.jpg"));
            ModificarProveedor.setIcon(new ImageIcon("img/iconoModificarProveedor.jpg"));
            ModificarClave.setIcon(new ImageIcon("img/iconoConfiguracion.jpg"));
            MostrarPedidos.setIcon(new ImageIcon("img/iconoProducto.jpg"));
            //****************************************************//
            //      Muestra el forumlario de registror cliente     
            //****************************************************//
            RegistrarCliente rp=new RegistrarCliente();
            RegistrarCliente.addActionListener(rp); 
            //****************************************************//
            //      Modifica datos del cliente     
            //****************************************************//
            BuscarCliente bc=new BuscarCliente();
            ModificarCliente.addActionListener(bc);
            //****************************************************//
            //     Insertamos los menús a la barra de menús 
            //****************************************************//
            BarraMenu.add(MenuPedido);
            BarraMenu.add(MenuProveedor);
            BarraMenu.add(MenuCliente);
            BarraMenu.add(MenuConfiguraciones);
            FlowLayout Superior=new FlowLayout(FlowLayout.LEFT);  
            setLayout(Superior);
            add(BarraMenu);
        }
        
}
