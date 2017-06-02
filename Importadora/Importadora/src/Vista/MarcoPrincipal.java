package Vista;

import Controlador.ModificarProveedor;
import Controlador.ModificarCliente;
import Modelo.ConectorBD;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MarcoPrincipal extends JFrame{
    //declarando e inicializando variables
    ConectorBD con = new ConectorBD();
    JLabel lblTitulo = new JLabel("REGISTRO DE PEDIDO");
    JLabel lblCi = new JLabel("CI del cliente:");
    JLabel lblCodProducto = new JLabel("Codigo del Producto:");
    JLabel lblCantidad = new JLabel("Cantidad:");
    JLabel lblCliente = new JLabel();
    JLabel lblFecha = new JLabel("Fecha: ");
    JLabel lblFechaLlegada = new JLabel("Fecha de llegada:");
    JLabel lblCostoTotal = new JLabel("Costo Total:");
    JLabel lblCodigo_ = new JLabel("Codigo");
    JLabel lblProducto_ = new JLabel("Producto");
    JLabel lblCantidad_ = new JLabel("Cantidad");
    JLabel lblPU_ = new JLabel("Precio Unitario");
    JLabel lblPP_ = new JLabel("Precio Parcial");
    JTextField txtCi = new JTextField();
    JTextField txtCodProd = new JTextField();
    JTextField txtCantidad = new JTextField();
    JTextField txtCostoTotal = new JTextField("0");
    JTextField txtFechaLlegada = new JTextField();
    JButton btnBuscar = new JButton("Buscar");
    JButton btnAgregar = new JButton("Agregar");
    JButton btnGuardar = new JButton("Guardar");
    JButton btnCancelar = new JButton("Cancelar");
    JPanel pnlPrincipal = new JPanel();
    JPanel pnlPedido = new JPanel();
    
    ArrayList<JLabel[]> lblfila = new ArrayList<>();
    ArrayList<String[]> datos = new ArrayList<>();
    int espacio = 0;
    String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    int id_cliente = 0;
    
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
        inicializarComponentes();
    }
    private void inicializarComponentes(){
        pnlPrincipal.setLayout(null);
        pnlPrincipal.setBounds(20, 0, 500, 500);
        pnlPrincipal.setBackground(new Color(242, 242, 242));
        this.add(pnlPrincipal);
        lblTitulo.setBounds(500, 20, 600, 50);
        lblTitulo.setFont(new Font("Calibri", 1, 40));
        lblCi.setBounds(250, lblTitulo.getLocation().y + lblTitulo.getHeight() + 10, 80, 30);
        lblCi.setFont(new Font("Calibri", 0, 14));
        txtCi.setBounds(lblCi.getLocation().x + lblCi.getWidth() + 10, lblCi.getLocation().y, 100, lblCi.getHeight());
        btnBuscar.setBounds(txtCi.getLocation().x + txtCi.getWidth() + 10, txtCi.getLocation().y, 100, txtCi.getHeight());
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtCi.getText().isEmpty()) {
                    con.conectar();
                    ResultSet query = con.seleccionar("select nombre_cliente as nombre, id_cliente from cliente where ci_cliente = '" + txtCi.getText() + "'");
                    try {
                        if (query != null && query.next()) {
                            lblCliente.setText("Cliente: " + query.getString("nombre"));
                            id_cliente = query.getInt("id_cliente");
                        }
                        else {
                            JOptionPane.showMessageDialog(rootPane, "El cliente no existe en la base de datos", "Atencion!!", JOptionPane.INFORMATION_MESSAGE);
                            txtCi.setText("");
                            txtCi.requestFocus();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(MarcoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    con.desconectar();
                }
                else
                    JOptionPane.showMessageDialog(rootPane, "Por favor complete el campo!", "Atencion!!", JOptionPane.WARNING_MESSAGE);
            }
        });
        pnlPedido.setLayout(null);
        pnlPedido.setBounds(250, lblCi.getLocation().y + lblCi.getHeight() + 20, 1000, 480);
        pnlPedido.setBackground(new Color(248, 248, 248));
        pnlPedido.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        lblCodProducto.setBounds(30, 30, 120, 30);
        lblCodProducto.setFont(new Font("Calibri", 0, 14));
        txtCodProd.setBounds(lblCodProducto.getLocation().x + lblCodProducto.getWidth() + 10, lblCodProducto.getLocation().y, 50, 30);
        lblCantidad.setBounds(lblCodProducto.getLocation().x, lblCodProducto.getLocation().y + lblCodProducto.getHeight() + 10, lblCodProducto.getWidth(), lblCodProducto.getHeight());
        lblCantidad.setFont(new Font("Calibri", 0, 14));
        txtCantidad.setBounds(lblCantidad.getLocation().x + lblCantidad.getWidth() + 10, lblCantidad.getLocation().y, 50, 30);
        btnAgregar.setBounds(txtCodProd.getLocation().x + txtCodProd.getWidth() + 30, txtCodProd.getLocation().y, 200, 70);
        btnAgregar.setFont(new Font("Calibri", 1, 20));
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtCodProd.getText().isEmpty() && !txtCantidad.getText().isEmpty()) {
                    con.conectar();
                    ResultSet query = con.seleccionar("select concat(producto, '-', marca, '-', modelo) as producto, precio from producto as p, detalle as dp where dp.id_producto = p.id_producto and id_det = '"+txtCodProd.getText()+"'");
                    try {
                        if (query != null && query.next()) {
                            float pp = Float.parseFloat(txtCantidad.getText()) * Float.parseFloat(query.getString("precio"));
                            txtCostoTotal.setText(Float.toString(Float.parseFloat(txtCostoTotal.getText()) + pp));
                            String[] row = {txtCodProd.getText(), query.getString("producto"), txtCantidad.getText(), query.getString("precio"), Float.toString(pp)};
                            datos.add(row);
                            MostrarRow(row);
                        }
                        else{
                            JOptionPane.showMessageDialog(rootPane, "El producto no existe en la base de datos!", "Atencion!!", JOptionPane.INFORMATION_MESSAGE);
                            txtCodProd.setText("");
                            txtCodProd.requestFocus();
                        }
                        txtCodProd.setText("");
                        txtCantidad.setText("");
                    } catch (SQLException ex) {
                        Logger.getLogger(MarcoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    con.desconectar();
                }
                else
                    JOptionPane.showMessageDialog(rootPane, "Es necesario completar los campos!", "Atencion!!", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        lblCliente.setBounds(700, 30, 300, 30);
        lblCliente.setFont(new Font("Calibri", 0, 20));
        lblFecha.setText(lblFecha.getText() + date);
        lblFecha.setBounds(lblCliente.getLocation().x, lblCliente.getLocation().y + lblCliente.getHeight() + 10, 250, 30);
        lblFecha.setFont(new Font("Calibri", 0, 14));
        lblFechaLlegada.setBounds(lblFecha.getLocation().x, lblFecha.getLocation().y + lblFecha.getHeight() + 10, 100, 30);
        lblFechaLlegada.setFont(new Font("Calibri", 0, 14));
        txtFechaLlegada.setText(date);
        txtFechaLlegada.setBounds(lblFechaLlegada.getLocation().x + lblFechaLlegada.getWidth() +10, lblFechaLlegada.getLocation().y, 100, 30);
        lblCostoTotal.setBounds(lblFechaLlegada.getLocation().x, lblFechaLlegada.getLocation().y + 50, 80, 30);
        txtCostoTotal.setBounds(lblCostoTotal.getLocation().x + lblCostoTotal.getWidth() + 10, lblCostoTotal.getLocation().y, 150, 30);
        lblCodigo_.setBounds(lblCantidad.getLocation().x, lblCantidad.getLocation().y + 50, 50, 30);
        lblProducto_.setBounds(lblCodigo_.getLocation().x+lblCodigo_.getWidth()+10, lblCantidad.getLocation().y + 50, 200, 30);
        lblCantidad_.setBounds(lblProducto_.getLocation().x+lblProducto_.getWidth()+10, lblCantidad.getLocation().y + 50, 80, 30);
        lblPU_.setBounds(lblCantidad_.getLocation().x+lblCantidad_.getWidth()+10, lblCantidad.getLocation().y + 50, 120, 30);
        lblPP_.setBounds(lblPU_.getLocation().x+lblPU_.getWidth()+10, lblCantidad.getLocation().y + 50, 150, 30);
        lblCodigo_.setFont(new Font("Calibri", 1, 14));
        lblProducto_.setFont(new Font("Calibri", 1, 14));
        lblCantidad_.setFont(new Font("Calibri", 1, 14));
        lblPU_.setFont(new Font("Calibri", 1, 14));
        lblPP_.setFont(new Font("Calibri", 1, 14));
        btnGuardar.setBounds(700, 350, 150, 50);
        btnGuardar.setFont(new Font("Calibri", 0, 20));
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Guardar();
                } catch (SQLException ex) {
                    Logger.getLogger(MarcoPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        
        pnlPrincipal.add(lblTitulo);
        pnlPrincipal.add(lblCi);
        pnlPrincipal.add(txtCi);
        pnlPrincipal.add(btnBuscar);
        pnlPrincipal.add(pnlPedido);
        pnlPedido.add(lblCodProducto);
        pnlPedido.add(txtCodProd);
        pnlPedido.add(lblCantidad);
        pnlPedido.add(txtCantidad);
        pnlPedido.add(btnAgregar);
        pnlPedido.add(lblCliente);
        pnlPedido.add(lblFecha);
        pnlPedido.add(lblFechaLlegada);
        pnlPedido.add(txtFechaLlegada);
        pnlPedido.add(lblCostoTotal);
        pnlPedido.add(txtCostoTotal);
        pnlPedido.add(lblCodigo_);
        pnlPedido.add(lblProducto_);
        pnlPedido.add(lblCantidad_);
        pnlPedido.add(lblPU_);
        pnlPedido.add(lblPP_);
        pnlPedido.add(btnGuardar);
        
        
    }
    private void MostrarRow(String[] row){
        espacio++;
        JLabel[] lblRow = {new JLabel(row[0]), new JLabel(row[1]), new JLabel(row[2]), new JLabel(row[3]), new JLabel(row[4])};
        lblRow[0].setBounds(lblCodigo_.getLocation().x, lblCodigo_.getLocation().y +espacio*40 , lblCodigo_.getWidth(), lblCodigo_.getHeight());
        lblRow[1].setBounds(lblProducto_.getLocation().x, lblProducto_.getLocation().y +espacio*40 , lblProducto_.getWidth(), lblProducto_.getHeight());
        lblRow[2].setBounds(lblCantidad_.getLocation().x, lblCantidad_.getLocation().y +espacio*40 , lblCantidad_.getWidth(), lblCantidad_.getHeight());
        lblRow[3].setBounds(lblPU_.getLocation().x, lblPU_.getLocation().y +espacio*40 , lblPU_.getWidth(), lblPU_.getHeight());
        lblRow[4].setBounds(lblPP_.getLocation().x, lblPP_.getLocation().y +espacio*40 , lblPP_.getWidth(), lblPP_.getHeight());
        lblfila.add(lblRow);
        for (JLabel lbl : lblRow) {
            pnlPedido.add(lbl);
        }
        repaint();
    }
    private void Guardar() throws SQLException{
        if (id_cliente == 0) {
            JOptionPane.showMessageDialog(rootPane, "Por favor seleccione un cliente", "Atencion!!", JOptionPane.INFORMATION_MESSAGE);
            txtCi.requestFocus();
            return;
        }
        con.conectar();
        ResultSet res = con.seleccionar("select MAX(id_pedido) as id from pedido");
        int id_pedido;
        if (res != null && res.next())
            id_pedido = res.getInt("id") + 1;
        else
            id_pedido = 1;
        String query = "insert into pedido values("+id_pedido+", "+id_cliente+", '"+date+"', '"+txtFechaLlegada.getText()+"', "+txtCostoTotal.getText()+", 1);";
        boolean result = con.consulta(query);
        if (result) {
            for (String[] row : datos) {
                result = con.consulta("insert into detalle_pedido values ("+id_pedido+", "+row[0]+", "+row[2]+", "+row[4]+")");
                if (!result) {
                    JOptionPane.showMessageDialog(rootPane, "Error al guardar!", "Atencion!!", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        else
            JOptionPane.showMessageDialog(rootPane, "Error al guardar!", "Atencion!!", JOptionPane.INFORMATION_MESSAGE);
        con.desconectar();
        JOptionPane.showMessageDialog(rootPane, "Se guardo correctamente!!", "Mensaje!!", JOptionPane.INFORMATION_MESSAGE);
        id_cliente = 0;
        txtCi.setText("");
        
        for (JLabel[] lbl : lblfila) {
            for (JLabel jLabel : lbl) {
                pnlPedido.remove(jLabel);
            }
        }
        lblfila.clear();
        datos.clear();
        espacio = 0;
        txtCostoTotal.setText("0");
        lblCliente.setText("");
        
        pnlPedido.repaint();
        txtCi.requestFocus();
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
        JMenu jmMenuCatalogo;
        JMenuItem jmiModificarClave;
        JMenuItem jmiRegistrarCliente;
        JMenuItem jmiModificarCliente;
        JMenuItem jmiRegistrarProveedor;
        JMenuItem jmiModificarProveedor;
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
            jmMenuCatalogo=new JMenu("Producto");
            //***************************************************//
            //      Instanciamos los MenuItems
            //***************************************************//
            jmiModificarClave=new JMenuItem("Cambiar Configuración");
            jmiRegistrarCliente=new JMenuItem("Registrar Cliente");
            jmiModificarCliente=new JMenuItem("Modificar Cliente");
            jmiRegistrarProveedor=new JMenuItem("Registrar Proveedor");
            jmiModificarProveedor=new JMenuItem("Modificar Proveedor");
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
            
            jmbBarraMenu.add(jmMenuProveedor);
            jmbBarraMenu.add(jmMenuCliente);
            jmbBarraMenu.add(jmMenuCatalogo);
            jmbBarraMenu.add(jmMenuConfiguraciones);
            FlowLayout Superior=new FlowLayout(FlowLayout.LEFT);  
            setLayout(Superior);
            add(jmbBarraMenu);
        }        
}
