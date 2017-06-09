package Vista;

import Modelo.ConectorBD;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistrarCliente extends JPanel implements Action{
    //*****************************************************//
    //          Declaramos los atributos
    //*****************************************************//
    private JFrame jfMarco;
    private JPanel jpPanel;
    private JLabel lblTitulo;
    private JLabel lblNombre;
    private JLabel lblCI;
    private JLabel lblDireccion;
    private JLabel lblTelefono;
    private JLabel lblCelular;
    private JLabel lblCorreo;
    private JTextField txtNombre;
    private JTextField txtCI;
    private JTextField txtDireccion;
    private JTextField txtTelefono;
    private JTextField txtCelular;   
    private JTextField txtCorreo;
    private JButton btnRegistrar;
    private JButton btnCancelar;
    private Image imagenFondo;
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
        //***********************************************//
        //           Insertamos un icono al marco
        //***********************************************//
        ImageIcon icono=new ImageIcon("img/iconoCAT.jpg");
        Image img=icono.getImage();
        jfMarco.setIconImage(img);
        //*******************************************************//
        //      Creamos un panel que nos servirá como contenedor
        //*******************************************************//
        jpPanel=new JPanel();
        //**************************************//
        //     Anulamos el Layout por defecto
        //**************************************//
        jpPanel.setLayout(null);
        //*******************************************************//
        //     Instanciamos los componentes
        //*******************************************************//
        lblTitulo=new JLabel("Registro de clientes"); 
        lblNombre=new JLabel("Nombre:");       
        lblCI=new JLabel("CI/NIT:");      
        lblDireccion=new JLabel("Dirección:");     
        lblTelefono=new JLabel("Teléfono:");       
        lblCelular=new JLabel("Celular:");      
        lblCorreo=new JLabel("Correo:");
        
        txtNombre=new JTextField(20);
        txtCI=new JTextField(20);
        txtDireccion=new JTextField(20);
        txtTelefono=new JTextField(20);
        txtCelular=new JTextField(20);
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
        lblTitulo.setBounds(200,20,150,20);
        lblNombre.setBounds(120,60,150,30);
        lblCI.setBounds(120,90,150,30);
        lblDireccion.setBounds(120,120,150,30);
        lblTelefono.setBounds(120,150,150,30);
        lblCelular.setBounds(120,180,150,30);
        lblCorreo.setBounds(120, 210, 150, 30);
        
        txtNombre.setBounds(220,60,150,30);
        txtCI.setBounds(220,90,150,30);
        txtDireccion.setBounds(220,120,150,30);
        txtTelefono.setBounds(220,150,150,30);
        txtCelular.setBounds(220,180,150,30);
        txtCorreo.setBounds(220, 210, 150, 30);
        
        btnCancelar.setBounds(130,270,100,30);
        btnRegistrar.setBounds(250,270,100,30);
        //*******************************************************//
        //      Insertamos los componentes al panel
        //*******************************************************//
        jpPanel.add(lblTitulo);
        jpPanel.add(lblNombre);
        jpPanel.add(lblCI);
        jpPanel.add(lblDireccion);
        jpPanel.add(lblTelefono);
        jpPanel.add(lblCelular);
        jpPanel.add(lblCorreo);
        
        jpPanel.add(txtNombre);
        jpPanel.add(txtCI);
        jpPanel.add(txtDireccion);
        jpPanel.add(txtTelefono);
        jpPanel.add(txtCelular);
        jpPanel.add(txtCorreo);
        
        jpPanel.add(btnCancelar);    
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
            //****************************************************************************************//
            //      Condicional que nos permite saber si los campos de texto se encuentran vacíos
            //****************************************************************************************//
            if(!txtNombre.getText().isEmpty()&&!txtCI.getText().isEmpty()&&!txtDireccion.getText().isEmpty()){
                if(!validarNombre(txtNombre)&&!validarDireccion(txtDireccion)&&validarCorreo(txtCorreo)){
                   //*************************************************************//
                   //       Llamamos al metodo quitar espacios
                   //*************************************************************//
                   String n=txtNombre.getText();
                   String nse=quitarEspacios(n);
                
                   String c=txtCI.getText();
                   String cse=quitarEspacios(c);
                
                   String d=txtDireccion.getText();
                   String dse=quitarEspacios(d);
               
                   String t=txtTelefono.getText();
                   String tse=quitarEspacios(t);
                
                   String cel=txtCelular.getText();
                   String celse=quitarEspacios(cel);
                
                   String co=txtCorreo.getText();
                   String cose=quitarEspacios(co);
                
            try{
             //*******************************************************//
             //      Nos conectamos con la Base de Datos
             //*******************************************************//
             cn.conectar();
             //*****************************************************************************************//
             //      Hacemos un llamado al metodo consulta que nos permite insertar un nuevo cliente
             //*****************************************************************************************//
             cn.consulta("insert into cliente(NOMBRE_CLIENTE,CI_CLIENTE,DIRECCION_CLIENTE,TELEFONO_CLIENTE,CELULAR_CLIENTE,CORREO_CLIENTE) values('"+nse.trim()+"','"+cse.trim()+"','"+dse.trim()+"','"+tse.trim()+"','"+celse.trim()+"','"+cose.trim()+"')");
             //*********************************************************************************************//
             //      Si los datos son guardados de forma correcta, los campos del formulario se limpiarán
             //*********************************************************************************************//
             txtNombre.setText("");
             txtCI.setText("");
             txtDireccion.setText("");
             txtTelefono.setText("");
             txtCelular.setText("");
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
        txtDireccion.addKeyListener(new KeyAdapter() {
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
        txtCelular.addKeyListener(new KeyAdapter() {
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
        jpPanel.add(btnRegistrar);
        //*******************************************************//
        //      Insertamos el panel dentro de nuestro marco
        //*******************************************************//
        jfMarco.add(jpPanel);     
        }

    //*******************************************************//
    //      Metodo para validar nombre
    //*******************************************************//
    public boolean validarNombre(JTextField n){
        JTextField x=new JTextField();
        String nom=n.getText();
        String caracteres="0123456789.:,<>{}[]|'=_-!@#$%^&*()/*-+";
        for(int i=0;i<nom.length();i++){
           for(int j=0;j<caracteres.length();j++){
                if(nom.charAt(i)==caracteres.charAt(j)){            
                        x.setText("");
                        JOptionPane.showMessageDialog(null, "Nombre no es valido");
                        return true;
                    
                }
           }
           
        }
        return false;
    }
    //*******************************************************//
    //      Metodo para validar dirección
    //*******************************************************//
    public boolean validarDireccion(JTextField n){
        JTextField x=new JTextField();
        String dir=n.getText();
        String caracteres=";'[]{}:,<>'=_-!@$%^&*()/*-+";
        for(int i=0;i<dir.length();i++){
           for(int j=0;j<caracteres.length();j++){
                if(dir.charAt(i)==caracteres.charAt(j)){            
                        x.setText("");
                        JOptionPane.showMessageDialog(null, "El nombre de la dirección es invalido");
                        return true;
                    
                }
           }
        }
        return false;
    }
    //*******************************************************//
    //     Metodo para quitar espacios
    //*******************************************************//
    public String quitarEspacios(String w){
        String se=" ";
        int contador=0;
        String sTexto=w; 
        for (int x=0; x < sTexto.length(); x++) {    
            if (sTexto.charAt(x)!=' '){
                se+=sTexto.charAt(x);
                contador=0;
            }else{
                contador++;
                if(contador<2){
                se+=sTexto.charAt(x);
                }
            }
        }
        return se;
     }
    //*******************************************************//
    //      metodo para validar correo
    //*******************************************************//
    public boolean validarCorreo(JTextField correo){
        String email=correo.getText();
        Pattern pattern = Pattern
                .compile("^[_a-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher mather = pattern.matcher(email);
 
        if (mather.find() == true) {
            return  true;
        } else { 
            JOptionPane.showMessageDialog(null, "El correo es invalido");
            return  false;
        }
    }
}
    
