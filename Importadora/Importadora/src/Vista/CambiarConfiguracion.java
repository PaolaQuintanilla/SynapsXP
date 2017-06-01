package Vista;

import Modelo.ConectorBD;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CambiarConfiguracion extends JPanel implements Action{
    //*****************************************************//
    //          Declaramos los atributos
    //*****************************************************//
    private JFrame marcoConfiguracion;
    private JPanel laminaConfiguracion;
    private JLabel lblContraseniaAntigua;
    private JLabel lblContraseniaNueva1;
    private JLabel lblContraseniaNueva2;
    private JPasswordField txtContraseniaAntigua;
    private JPasswordField txtContraseniaNueva1;
    private JPasswordField txtContraseniaNueva2;
    private JButton btnAceptar;
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
                //**********************************************//
                //          Creamos un marco
                //**********************************************//
               marcoConfiguracion=new JFrame();
               marcoConfiguracion.setVisible(true);
               marcoConfiguracion.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
               marcoConfiguracion.setSize(350, 350);
               marcoConfiguracion.setLocationRelativeTo(null);
               //***********************************************//
               //           Insertamos un icono al marco
               //***********************************************//
               ImageIcon icono=new ImageIcon("img/iconoCAT.jpg");
               Image img=icono.getImage();
               marcoConfiguracion.setIconImage(img);  
               //*******************************************************//
               //     Creamos un panel que nos servirá de contenedor
               //*******************************************************//
               laminaConfiguracion=new JPanel();
               //*******************************************************//
               //     Instanciamos los componentes
               //*******************************************************//
               lblContraseniaAntigua=new JLabel("Introduzca la contraseña actual");
               lblContraseniaNueva1=new JLabel("Introduzca la nueva contraseña");
               lblContraseniaNueva2=new JLabel("Introduzca la nueva contraseña");
               
               txtContraseniaAntigua=new JPasswordField(20);
               txtContraseniaNueva1=new JPasswordField(20);
               txtContraseniaNueva2=new JPasswordField(20);
               
               btnAceptar=new JButton("Aceptar");
               btnCancelar=new JButton("Cancelar");
               //**************************************//
               //     Anulamos el Layout por defecto
               //**************************************//
               laminaConfiguracion.setLayout(null);
               //*******************************************************//
               //     Estalecemos la posición de los componentes
               //*******************************************************//
               lblContraseniaAntigua.setBounds(50, 50, 230, 30);
               lblContraseniaNueva1.setBounds(50, 110, 230, 30);
               lblContraseniaNueva2.setBounds(50, 170, 230, 30);
               txtContraseniaAntigua.setBounds(50, 80, 230, 30);
               txtContraseniaNueva1.setBounds(50, 140, 230, 30);
               txtContraseniaNueva2.setBounds(50, 200, 230, 30);
               btnCancelar.setBounds(50, 250, 100, 30);
               btnAceptar.setBounds(180, 250, 100, 30);
               //*******************************************************//
               //      Insertamos los componentes al panel
               //*******************************************************//
               laminaConfiguracion.add(lblContraseniaAntigua);
               laminaConfiguracion.add(lblContraseniaNueva1);
               laminaConfiguracion.add(lblContraseniaNueva2);
               
               laminaConfiguracion.add(txtContraseniaAntigua);
               laminaConfiguracion.add(txtContraseniaNueva1);
               laminaConfiguracion.add(txtContraseniaNueva2);
               
               laminaConfiguracion.add(btnCancelar);
               laminaConfiguracion.add(btnAceptar);
               
               marcoConfiguracion.add(laminaConfiguracion);
               
               //**********************************************************************//
               //      Evento que nos permite cerrar el marco de configuraciones
               //**********************************************************************//
               btnCancelar.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent ae) {
                       marcoConfiguracion.dispose();
                   }
               });
               //*************************************************************************//
               //       El campo contraseña antigua esta a la escucha de la tecla enter
               //*************************************************************************//
               txtContraseniaAntigua.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e){
                        if(KeyEvent.VK_ENTER==e.getKeyCode()){
                             btnAceptar.doClick();
                        }   
                    }
                 });
               //**********************************************************************//
               //       El campo contraseña nueva1 esta a la escucha de la tecla enter
               //**********************************************************************//
               txtContraseniaNueva1.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e){
                        if(KeyEvent.VK_ENTER==e.getKeyCode()){
                             btnAceptar.doClick();
                        }   
                    }
                 });
               //**********************************************************************//
               //      El campo contraseña nueva2 esta a la escucha de la tecla enter  
               //**********************************************************************//
               txtContraseniaNueva2.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e){
                        if(KeyEvent.VK_ENTER==e.getKeyCode()){
                             btnAceptar.doClick();
                        }   
                    }
                 });
               //**********************************************************************//
               //       Botón cancelar esta a la escucha de la tecla enter
               //**********************************************************************//
               btnCancelar.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e){
                        if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        marcoConfiguracion.dispose();
                        }   
                    }
                });
               //**********************************************************************//
               //       Botón aceptar esta a la escucha de la tecla enter
               //**********************************************************************//
               btnAceptar.addKeyListener(new KeyAdapter() {
                    public void keyPressed(KeyEvent e){
                        if(KeyEvent.VK_ENTER==e.getKeyCode()){
                             btnAceptar.doClick();
                        }   
                    }
                 });
               //********************************************************************************//
               //           Evento que nos permite cambiar de contraseña
               //********************************************************************************//
                btnAceptar.addActionListener(new ActionListener() {
                   @Override
                   public void actionPerformed(ActionEvent ae) {
                       ConectorBD cnxCambioContrasenia=new ConectorBD();
                       cnxCambioContrasenia.conectar();
                       String passwordAntiguo=new String(txtContraseniaAntigua.getPassword());
                       String passwordNuevo1=new String(txtContraseniaNueva1.getPassword());
                       String passwordNuevo2=new String(txtContraseniaNueva2.getPassword());
                       ResultSet resultado=cnxCambioContrasenia.seleccionar("select CONTRASENIA from usuario where NOMBRE_USUARIO='admin'");
                       try{
                                while(resultado.next()){
                                String passwd=resultado.getString("CONTRASENIA");
                                if(passwd.equals(passwordAntiguo)){
                                    if(passwordNuevo1.equals(passwordNuevo2)){
                                        cnxCambioContrasenia.consulta("update usuario set CONTRASENIA='"+passwordNuevo1+"' where CONTRASENIA='"+passwordAntiguo+"'");
                                        txtContraseniaAntigua.setText("");
                                        txtContraseniaNueva1.setText("");
                                        txtContraseniaNueva2.setText("");
                                        JOptionPane.showMessageDialog(null, "La contraseña se ha actualizado correctamente");
                                        marcoConfiguracion.dispose();
                                        System.exit(0);
                                    }
                                }else{
                                        JOptionPane.showMessageDialog(null, "La contraseña actual es incorrecta");
                                     }     
                                }
                       }catch(SQLException ex) {
                                    JOptionPane.showMessageDialog(null, "Ocurrio un error en la conexión con la BD");
                                    }            
                   }
               });              
    }
}
