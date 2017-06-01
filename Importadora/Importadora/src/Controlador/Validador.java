package Controlador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Validador {
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
    public String quitarEspacios(String p){
        String se=" ";
        int contador=0;
        String sTexto=p; 
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
    //      Metodo para validar correo
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
