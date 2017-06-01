package Vista;
import Modelo.ConectorBD;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComponent;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


public class Login extends JFrame{
    public Login(){
        //***********************************************//
        //      Creamos el frame para el login
        //***********************************************//
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        ImageIcon icono=new ImageIcon("img/iconoCAT.jpg");
        Image img=icono.getImage();
        setIconImage(img);
        FondoLogin FondoDePantalla=new FondoLogin();
        add(FondoDePantalla);     
    }
    public void ocultarLogin(){
        setVisible(false);
    }
    private class FondoLogin extends JPanel{
        //*******************************************************************//
        //      Declaramos los atributos
        //*******************************************************************//
        private JTextField txtNombre;
        private JPasswordField txtClave;
        private JLabel lblNombre,lblClave;
        private JButton btnIniciarSesion,btnSalir;
        private Image imagenFondo;
        
        public FondoLogin(){
            //***************************************************************//
            //     Instanceamos los componentes
            //***************************************************************//
            txtNombre=new JTextField(20);
            txtClave=new JPasswordField(20);
            lblNombre=new JLabel("Nombre");
            lblClave=new JLabel("Contraseña");
            btnSalir=new JButton("Salir");
            btnIniciarSesion=new JButton("Iniciar Sesión");
            //*****************************************************************//
            //     Establecemos el tipo de fuente, estilo y tamaño de letra
            //*****************************************************************//
            lblNombre.setFont(new Font("Cambria", 1, 18));
            lblClave.setFont(new Font("Cambria", 1, 18));
            txtNombre.setFont(new Font("Cambria", 1, 18));
            txtClave.setFont(new Font("Cambria", 1, 18));
            btnIniciarSesion.setFont(new Font("Cambria", 1, 18));
            btnSalir.setFont(new Font("Cambria", 1, 18));
            //**************************************//
            //     Anulamos el Layout por defecto
            //**************************************//
            setLayout(null);
            //**************************************************//
            //     Estalecemos la posición de los componentes
            //**************************************************//
            btnSalir.setBounds(250, 20, 120, 30);
            lblNombre.setBounds(50, 330, 100, 30);
            txtNombre.setBounds(170, 330, 200, 30);
            lblClave.setBounds(50, 380, 100, 30);
            txtClave.setBounds(170, 380, 200, 30);
            btnIniciarSesion.setBounds(50, 430, 320, 30);
            //**************************//
            //     Establecemos Color   
            //**************************//
            txtNombre.setBackground(new Color(0, 0, 51));
            txtNombre.setForeground(new Color(255, 255, 255));
            txtClave.setBackground(new Color(0, 0, 51));
            txtClave.setForeground(new Color(255, 255, 255));
            lblNombre.setForeground(new Color(255, 255, 255));
            lblClave.setForeground(new Color(255, 255, 255));
            btnIniciarSesion.setBackground(new Color(0, 0, 51));
            btnSalir.setBackground(new Color(0, 0, 51));
            btnIniciarSesion.setForeground(new Color(255, 255, 255));
            btnSalir.setForeground(new Color(255, 255, 255));
            //*********************************************************************************//
            //     Quitamos el foco al botón salir y este foco pasa al siguiente componente
            //*********************************************************************************//
            btnSalir.setFocusable(false);
            //*************************************************//
            //     Evento que permite salir de la aplicación
            //*************************************************//
            btnSalir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.exit(0);
                }
            });
            //**************************************************************//
            //     Evento que permite escuchar si el usuario presiona enter
            //**************************************************************//
            txtNombre.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnIniciarSesion.doClick();
                    }   
                }
            });
            //**************************************************************//
            //     Evento que permite escuchar si el usuario presiona enter
            //**************************************************************//            
            txtClave.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnIniciarSesion.doClick();
                    }   
                }
            });
            //**************************************************************//
            //     Evento que permite escuchar si el usuario presiona enter
            //**************************************************************//            
            btnIniciarSesion.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnIniciarSesion.doClick();
                    }   
                }
            });
            //*****************************************************************//
            //     Evento que permite validar nombre de usuario y contraseña
            //*****************************************************************//              
            btnIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
                ConectorBD log=new ConectorBD();
                log.conectar();
                ResultSet consulta=log.seleccionar("select CONTRASENIA from usuario where NOMBRE_USUARIO='admin'");
                try {
                    while(consulta.next()){
                        String passwd=consulta.getString("CONTRASENIA");
                        String campo=new String(txtClave.getPassword());
                        if(passwd.equals(campo)&&txtNombre.getText().equals("admin")){
                            MarcoPrincipal mp=new MarcoPrincipal("Importadora Synaps");              
                            mp.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            mp.setVisible(true);
                            ocultarLogin();
                            
                        }else{
                            JOptionPane.showMessageDialog(null, "El nombre se usuario o contraseña son incorrectos");
                        }     
                    }} catch (SQLException ex) {
                    Logger.getLogger(FondoLogin.class.getName()).log(Level.SEVERE, null, ex);
                }
               }
            });
            //***************************************************//
            //     Insertamos los componentes a nuestra lamina
            //***************************************************//           
            add(btnSalir);
            add(lblNombre);
            add(lblClave);
            add(txtNombre);
            add(txtClave);
            add(btnIniciarSesion);            
        }
        //***********************************************************//
        //      Metodo que nos permite insertar la imagen de fondo
        //***********************************************************//
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            
            try {
                imagenFondo=ImageIO.read(new File("img/fondo3.jpg"));                
            }catch(IOException ex) {
                System.out.println("No se pudo encontrar la imagen");
            }
            g.drawImage(imagenFondo, 0 , 0 , null);
            
        }
    }  
}
