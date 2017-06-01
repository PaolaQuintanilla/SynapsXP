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
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLocationRelativeTo(null);
        ImageIcon icono=new ImageIcon("img/linux.jpg");
        Image img=icono.getImage();
        setIconImage(img);
        FondoLogin FondoDePantalla=new FondoLogin();
        add(FondoDePantalla);     
    }
    public void ocultarLogin(){
        setVisible(false);
    }
    private class FondoLogin extends JPanel{
        private JTextField campoNombre;
        private JPasswordField campoClave;
        private JLabel etiquetaNombre,etiquetaClave;
        private JButton iniciarSesion,salir;
        private Image imagenFondo;
        
        public FondoLogin(){
            //***************************************************************//
            //     Instanceamos los componentes
            //***************************************************************//
            campoNombre=new JTextField(20);
            campoClave=new JPasswordField(20);
            etiquetaNombre=new JLabel("Nombre");
            etiquetaClave=new JLabel("Contraseña");
            salir=new JButton("Salir");
            iniciarSesion=new JButton("Iniciar Sesión");
            //*****************************************************************//
            //     Establecemos el tipo de fuente, estilo y tamaño de letra
            //*****************************************************************//
            etiquetaNombre.setFont(new Font("Cambria", 1, 18));
            etiquetaClave.setFont(new Font("Cambria", 1, 18));
            campoNombre.setFont(new Font("Cambria", 1, 18));
            campoClave.setFont(new Font("Cambria", 1, 18));
            iniciarSesion.setFont(new Font("Cambria", 1, 18));
            salir.setFont(new Font("Cambria", 1, 18));
            //**************************************//
            //     Anulamos el Layout por defecto
            //**************************************//
            setLayout(null);
            //**************************************************//
            //     Estalecemos la posición de los componentes
            //**************************************************//
            salir.setBounds(250, 20, 120, 30);
            etiquetaNombre.setBounds(50, 330, 100, 30);
            campoNombre.setBounds(170, 330, 200, 30);
            etiquetaClave.setBounds(50, 380, 100, 30);
            campoClave.setBounds(170, 380, 200, 30);
            iniciarSesion.setBounds(50, 430, 320, 30);
            //**************************//
            //     Establecemos Color   
            //**************************//
            campoNombre.setBackground(new Color(0, 0, 51));
            campoNombre.setForeground(new Color(255, 255, 255));
            campoClave.setBackground(new Color(0, 0, 51));
            campoClave.setForeground(new Color(255, 255, 255));
            etiquetaNombre.setForeground(new Color(255, 255, 255));
            etiquetaClave.setForeground(new Color(255, 255, 255));
            iniciarSesion.setBackground(new Color(0, 0, 51));
            salir.setBackground(new Color(0, 0, 51));
            iniciarSesion.setForeground(new Color(255, 255, 255));
            salir.setForeground(new Color(255, 255, 255));
            //*********************************************************************************//
            //     Quitamos el foco al botón salir y este foco pasa al siguiente componente
            //*********************************************************************************//
            salir.setFocusable(false);
            //*************************************************//
            //     Evento que permite salir de la aplicación
            //*************************************************//
            salir.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.exit(0);
                }
            });
            //**************************************************************//
            //     Evento que permite escuchar si el usuario presiona enter
            //**************************************************************//
            campoNombre.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        iniciarSesion.doClick();
                    }   
                }
            });
            //**************************************************************//
            //     Evento que permite escuchar si el usuario presiona enter
            //**************************************************************//            
            campoClave.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        iniciarSesion.doClick();
                    }   
                }
            });
            //**************************************************************//
            //     Evento que permite escuchar si el usuario presiona enter
            //**************************************************************//            
            iniciarSesion.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        iniciarSesion.doClick();
                    }   
                }
            });
            //*****************************************************************//
            //     Evento que permite validar nombre de usuario y contraseña
            //*****************************************************************//              
            iniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
                ConectorBD log=new ConectorBD();
                log.conectar();
                ResultSet consulta=log.seleccionar("select passwordUsuario from usuario where nombreUsuario='admin'");
                try {
                    while(consulta.next()){
                        String passwd=consulta.getString("passwordUsuario");
                        String campo=new String(campoClave.getPassword());
                        if(passwd.equals(campo)&&campoNombre.getText().equals("admin")){
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
            add(salir);
            add(etiquetaNombre);
            add(etiquetaClave);
            add(campoNombre);
            add(campoClave);
            add(iniciarSesion);            
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
