package Vista;

import Modelo.ConectorBD;
import Controlador.Validador;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistrarProveedor extends JPanel implements Action{
    //*****************************************************//
    //          Declaramos los atributos
    //*****************************************************//
    private JFrame jfMarco;
    private JPanel jpLamina;
    private JLabel lblTitulo;
    private JLabel lblNombre;
    private JLabel lblCI;
    private JLabel lblPais;
    private JLabel lblCuenta;
    private JLabel lblTelefono;
    private JLabel lblCorreo;
    
    private JTextField txtNombre;
    private JTextField txtCI;
    private JTextField txtPais;
    private JTextField txtCuenta;
    private JTextField txtTelefono;   
    private JTextField txtCorreo;
    
    private JButton btnRegistrar;
    private JButton btnCancelar;
    @Override
    public Object getValue(String string) {
        return null;
    }
    @Override
    public void putValue(String string, Object o) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        //*******************************************************//
        //     Creamos el formulario de registro cliente
        //*******************************************************//
        jfMarco=new JFrame();
        jfMarco.setSize(500, 350);
        jfMarco.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jfMarco.setLocationRelativeTo(null);
        jfMarco.setVisible(true);
        ImageIcon icono=new ImageIcon("img/iconoCAT.jpg");
        Image img=icono.getImage();
        jfMarco.setIconImage(img);
        //*******************************************************//
        //      Creamos un panel que nos servirá como contenedor
        //*******************************************************//
        jpLamina=new JPanel();
        //**************************************//
        //     Anulamos el Layout por defecto
        //**************************************//
        jpLamina.setLayout(null);
        //*******************************************************//
        //     Instanciamos los componentes
        //*******************************************************//
        lblTitulo=new JLabel("Registro de Proveedores"); 
        lblNombre=new JLabel("Nombre:");       
        lblCI=new JLabel("CI/NIT:");      
        lblPais=new JLabel("Pais:"); 
        lblCuenta=new JLabel("Nro. de cuenta:");
        lblTelefono=new JLabel("Teléfono:");            
        lblCorreo=new JLabel("Correo:");
        
        txtNombre=new JTextField(20);
        txtCI=new JTextField(20);
        txtPais=new JTextField(20);
        txtCuenta=new JTextField(20);
        txtTelefono=new JTextField(20);
        txtCorreo=new JTextField(20);
        
        btnCancelar=new JButton("Cancelar");
        btnRegistrar=new JButton("Registrar");
        //**************************************//
        //     Anulamos el Layout por defecto
        //**************************************//
        setLayout(null);
        //*******************************************************//
        //     Estalecemos la posición de los componentes
        //*******************************************************//
        lblTitulo.setBounds(200,20,150,30);
        lblNombre.setBounds(120,60,150,30);
        lblCI.setBounds(120,90,150,30);
        lblPais.setBounds(120,120,150,30);
        lblCuenta.setBounds(120,150,150,30);
        lblTelefono.setBounds(120,180,150,30);
        lblCorreo.setBounds(120,210,150,30);
        
        txtNombre.setBounds(220,60,150,30);
        txtCI.setBounds(220,90,150,30);
        txtPais.setBounds(220,120,150,30);
        txtCuenta.setBounds(220,150,150,30);
        txtTelefono.setBounds(220,180,150,30);
        txtCorreo.setBounds(220,210,150,30);
        
        btnCancelar.setBounds(130,270,100,30);
        btnRegistrar.setBounds(250,270,100,30);
        //*******************************************************//
        //      Insertamos los componentes al panel
        //*******************************************************//
        jpLamina.add(lblTitulo);
        jpLamina.add(lblNombre);
        jpLamina.add(lblCI);
        jpLamina.add(lblPais);
        jpLamina.add(lblCuenta);
        jpLamina.add(lblTelefono);
        jpLamina.add(lblCorreo);
        
        jpLamina.add(txtNombre);
        jpLamina.add(txtCI);
        jpLamina.add(txtPais);
        jpLamina.add(txtCuenta);
        jpLamina.add(txtTelefono);
        jpLamina.add(txtCorreo);
        
        jpLamina.add(btnCancelar);    
        //**********************************************************************//
        //      Evento que nos permite cerrar la ventana de registro cliente
        //**********************************************************************//
        btnCancelar.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae2){
            jfMarco.dispose();
        }});
        //*******************************************************//
        //      Evento que nos permite registrar un cliente
        //*******************************************************//
        btnRegistrar.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae3){
            //*******************************************************//
            //      Instanciamos la clase ConectorBD
            //*******************************************************//
            ConectorBD cn=new ConectorBD();
            //*******************************************************//
            //      Instanciamos la clase Validador
            //*******************************************************//
            Validador valProveedor=new Validador();
            //****************************************************************************************//
            //      Condicional que nos permite saber si los campos de texto se encuentran vacíos
            //****************************************************************************************//
            if(!txtNombre.getText().isEmpty()&&!txtCI.getText().isEmpty()&&!txtPais.getText().isEmpty()&&!txtCuenta.getText().isEmpty()){
                if(!valProveedor.validarNombre(txtNombre)&&!valProveedor.validarDireccion(txtPais)&&!valProveedor.validarDireccion(txtCuenta)&&valProveedor.validarCorreo(txtCorreo)){
                   //*************************************************************//
                   //       Llamamos al metodo quitar espacios
                   //*************************************************************//
                   String n=txtNombre.getText();
                   String nse=valProveedor.quitarEspacios(n);
                
                   String c=txtCI.getText();
                   String cse=valProveedor.quitarEspacios(c);
                
                   String d=txtPais.getText();
                   String dse=valProveedor.quitarEspacios(d);
                   
                   String cu=txtCuenta.getText();
                   String cue=valProveedor.quitarEspacios(cu);
               
                   String t=txtTelefono.getText();
                   String tse=valProveedor.quitarEspacios(t);

                   String co=txtCorreo.getText();
                   String cose=valProveedor.quitarEspacios(co);
                
            try{
             //*******************************************************//
             //      Nos conectamos con la Base de Datos
             //*******************************************************//
             cn.conectar();
             //*****************************************************************************************//
             //      Hacemos un llamado al metodo consulta que nos permite insertar un nuevo cliente
             //*****************************************************************************************//
             cn.consulta("insert into proveedor(NOMBREP,CIP,PAISP,CUENTAP,TELEFONOP,CORREOP) values('"+nse.trim()+"','"+cse.trim()+"','"+dse.trim()+"','"+cue.trim()+"','"+tse.trim()+"','"+cose.trim()+"')");
             //*********************************************************************************************//
             //      Si los datos son guardados de forma correcta, los campos del formulario se limpiarán
             //*********************************************************************************************//
             txtNombre.setText("");
             txtCI.setText("");
             txtPais.setText("");
             txtCuenta.setText("");
             txtTelefono.setText("");
             txtCorreo.setText("");
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
        //****************************************************************************//
        //          El campo se encuentra a la escucha de la tecla enter
        //****************************************************************************//
        txtNombre.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnRegistrar.doClick();
                    }   
                }
        });
        //****************************************************************************//
        //          El campo se encuentra a la escucha de la tecla enter
        //****************************************************************************//
        txtCI.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                       btnRegistrar.doClick();
                    }   
                }
        });
        //****************************************************************************//
        //          El campo se encuentra a la escucha de la tecla enter
        //****************************************************************************//
        txtPais.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnRegistrar.doClick();
                    }   
                }
        });
                //****************************************************************************//
        //          El campo se encuentra a la escucha de la tecla enter
        //****************************************************************************//
        txtCuenta.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnRegistrar.doClick();
                    }   
                }
        });
        //****************************************************************************//
        //          El campo se encuentra a la escucha de la tecla enter
        //****************************************************************************//
        txtTelefono.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnRegistrar.doClick();
                    }   
                }
        });
        //****************************************************************************//
        //          El campo se encuentra a la escucha de la tecla enter
        //****************************************************************************//
        txtCorreo.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnRegistrar.doClick();
                    }   
                }
        });
        //****************************************************************************//
        //          El botón se encuentra a la escucha de la tecla enter
        //****************************************************************************//
        btnRegistrar.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnRegistrar.doClick();
                    }   
                }
        });
        //****************************************************************************//
        //          Evento que cierra el formulario de registro cliente
        //****************************************************************************//
        btnCancelar.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnCancelar.doClick();
                    }   
                }
        });

        //*******************************************************//
        //      Insertamos el boton registrar a nuestra lamina
        //*******************************************************//
        jpLamina.add(btnRegistrar);
        //*******************************************************//
        //      Insertamos el panel dentro de nuestro marco
        //*******************************************************//
        jfMarco.add(jpLamina);     
        }
}
    
