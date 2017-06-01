package Vista;

import Modelo.ConectorBD;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Action;
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
    private JFrame jf;
    private JPanel jp;
    private JLabel titulo;
    private JLabel nombre;
    private JLabel ci;
    private JLabel direccion;
    private JLabel telefono;
    private JLabel celular;
    private JLabel correo;
    private JTextField cNombre;
    private JTextField cCI;
    private JTextField cDireccion;
    private JTextField cTelefono;
    private JTextField cCelular;   
    private JTextField cCorreo;
    private JButton registrar;
    private JButton cancelar;
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
        jf=new JFrame();
        jf.setSize(500, 350);
        jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        //*******************************************************//
        //      Creamos un panel que nos servirá como contenedor
        //*******************************************************//
        jp=new JPanel();
        //**************************************//
        //     Anulamos el Layout por defecto
        //**************************************//
        jp.setLayout(null);
        //*******************************************************//
        //     Instanciamos los componentes
        //*******************************************************//
        titulo=new JLabel("Registro de clientes"); 
        nombre=new JLabel("Nombre:");       
        ci=new JLabel("CI/NIT:");      
        direccion=new JLabel("Dirección:");     
        telefono=new JLabel("Teléfono:");       
        celular=new JLabel("Celular:");      
        correo=new JLabel("Correo:");
        
        cNombre=new JTextField(20);
        cCI=new JTextField(20);
        cDireccion=new JTextField(20);
        cTelefono=new JTextField(20);
        cCelular=new JTextField(20);
        cCorreo=new JTextField(20);
        
        cancelar=new JButton("Cancelar");
        registrar=new JButton("Registrar");
        //**************************************//
        //     Anulamos el Layout por defecto
        //**************************************//
        setLayout(null);
        //*******************************************************//
        //     Estalecemos la posición de los componentes
        //*******************************************************//
        titulo.setBounds(200,20,150,20);
        nombre.setBounds(120,60,150,20);
        ci.setBounds(120,90,150,20);
        direccion.setBounds(120,120,150,20);
        telefono.setBounds(120,150,150,20);
        celular.setBounds(120,180,150,20);
        correo.setBounds(120, 210, 150, 20);
        
        cNombre.setBounds(220,60,150,30);
        cCI.setBounds(220,90,150,30);
        cDireccion.setBounds(220,120,150,30);
        cTelefono.setBounds(220,150,150,30);
        cCelular.setBounds(220,180,150,30);
        cCorreo.setBounds(220, 210, 150, 30);
        
        cancelar.setBounds(130,270,100,30);
        registrar.setBounds(250,270,100,30);
        //*******************************************************//
        //      Insertamos los componentes al panel
        //*******************************************************//
        jp.add(titulo);
        jp.add(nombre);
        jp.add(ci);
        jp.add(direccion);
        jp.add(telefono);
        jp.add(celular);
        jp.add(correo);
        
        jp.add(cNombre);
        jp.add(cCI);
        jp.add(cDireccion);
        jp.add(cTelefono);
        jp.add(cCelular);
        jp.add(cCorreo);
        
        jp.add(cancelar);    
        //**********************************************************************//
        //      Evento que nos permite cerrar la ventana de registro cliente
        //**********************************************************************//
        cancelar.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae2){
            jf.dispose();
        }});
        //*******************************************************//
        //      Evento que nos permite registrar un cliente
        //*******************************************************//
        registrar.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae3){
            //*******************************************************//
            //      Instanciamos la clase ConectorBD
            //*******************************************************//
            ConectorBD cn=new ConectorBD();
            //****************************************************************************************//
            //      Condicional que nos permite saber si los campos de texto se encuentran vacíos
            //****************************************************************************************//
            if(!cNombre.getText().isEmpty()&&!cCI.getText().isEmpty()&&!cDireccion.getText().isEmpty()){
                if(!validarNombre(cNombre)&&!validarDireccion(cDireccion)&&validarCorreo(cCorreo)){
                   //*************************************************************//
                   //       Llamamos al metodo quitar espacios
                   //*************************************************************//
                   String n=cNombre.getText();
                   String nse=quitarEspacios(n);
                
                   String c=cCI.getText();
                   String cse=quitarEspacios(c);
                
                   String d=cDireccion.getText();
                   String dse=quitarEspacios(d);
               
                   String t=cTelefono.getText();
                   String tse=quitarEspacios(t);
                
                   String cel=cCelular.getText();
                   String celse=quitarEspacios(cel);
                
                   String co=cCorreo.getText();
                   String cose=quitarEspacios(co);
                
            try{
             //*******************************************************//
             //      Nos conectamos con la Base de Datos
             //*******************************************************//
             cn.conectar();
             //*****************************************************************************************//
             //      Hacemos un llamado al metodo consulta que nos permite insertar un nuevo cliente
             //*****************************************************************************************//
             cn.consulta("insert into cliente(nombre,ci,direccion,telefono,celular,correo) values('"+nse.trim()+"','"+cse.trim()+"','"+dse.trim()+"','"+tse.trim()+"','"+celse.trim()+"','"+cose.trim()+"')");
             //*********************************************************************************************//
             //      Si los datos son guardados de forma correcta, los campos del formulario se limpiarán
             //*********************************************************************************************//
             cNombre.setText("");
             cCI.setText("");
             cDireccion.setText("");
             cTelefono.setText("");
             cCelular.setText("");
             cCorreo.setText("");
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
        //*******************************************************//
        //      Insertamos el boton registrar a nuestra lamina
        //*******************************************************//
        jp.add(registrar);
        //*******************************************************//
        //      Insertamos el panel dentro de nuestro marco
        //*******************************************************//
        jf.add(jp); 
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
    
