package Vista;
import Modelo.ConectorBD;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class BuscarCliente extends JPanel implements Action{
    private JFrame mB;
    private JPanel lB;
    private JLabel etiqueta1;
    private JButton botonBuscar;
    private JTextField campoBusqueda;
    private ResultSet resultado;
     
    private JFrame jframeMod;
    private JPanel jpanelMod; 
    private JLabel nombreMod;
    private JLabel ciMod;
    private JLabel direccionMod;
    private JLabel telefonoMod;
    private JLabel celularMod;
    private JLabel correoMod;
    private JTextField cNombreMod;
    private JTextField cCIMod;
    private JTextField cDireccionMod;
    private JTextField cTelefonoMod;
    private JTextField cCelularMod;   
    private JTextField cCorreoMod;
    private JButton registrarMod;
    private JButton cancelarMod;
    
    private JLabel cnombreMod;
    private JLabel cciMod;
    private JLabel cdireccionMod;
    private JLabel ctelefonoMod;
    private JLabel ccelularMod;
    private JLabel ccorreoMod;
    private JTextField ccNombreMod;
    private JTextField ccCIMod;
    private JTextField ccDireccionMod;
    private JTextField ccTelefonoMod;
    private JTextField ccCelularMod;   
    private JTextField ccCorreoMod;
    
    private String nse;
    private String cse;
    private String dse;
    private String tse;
    private String celse;
    private String cose;

    public BuscarCliente(){
    
    }
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
        mB=new JFrame("Buscar");
        mB.setSize(300, 100);
        mB.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        mB.setLocationRelativeTo(null);
        mB.setVisible(true);

        lB=new JPanel();

        etiqueta1=new JLabel("NIT:");
        botonBuscar=new JButton("Buscar");
        campoBusqueda=new JTextField(10);
        botonBuscar.addActionListener(new ActionListener(){      
        public void actionPerformed(ActionEvent e){
 
            if(!campoBusqueda.getText().isEmpty()){
            try{
                ConectorBD buscar=new ConectorBD(); 
                buscar.conectar(); 
                String nombre="";
                String ci="";
                String direccion="";
                String telefono="";
                String celular="";
                String correo="";
                //******************************************************************************************//
                //      El metodo seleccionar nos permite recuperar un registro completo de la BD
                //      siempre y cuando exista el usuario
                //******************************************************************************************//
                resultado=buscar.seleccionar("select * from cliente where ci='"+campoBusqueda.getText()+"'");
                //******************************************************************************************//
                //      Realizamos el recorrido registro por registro hasta encontrar la coincidencia
                //******************************************************************************************//               
                while (resultado.next()){
                //******************************************************************************************//
                //      Almacenamos los datos obtenidos de la BD y las almacenamos en variables
                //******************************************************************************************//
                nombre = resultado.getString("nombre");
                ci = resultado.getString("ci");
                direccion = resultado.getString("direccion");
                telefono = resultado.getString("telefono");
                celular = resultado.getString("celular");
                correo = resultado.getString("correo");
                mB.setVisible(false);
                if(!nombre.isEmpty()){
                jframeMod=new JFrame("Modificar información del cliente");
                jframeMod.setSize(500, 350);
                jframeMod.setLocationRelativeTo(null);
                jframeMod.setVisible(true);
                //**********************************************************************//
                //      Creamos un panel que nos servirá como contenedor
                //**********************************************************************//
                jpanelMod=new JPanel();
                //**********************************************************************//
                //      Anulamos el Layout por defecto
                //**********************************************************************//
                jpanelMod.setLayout(null);
                //**********************************************************************//
                //      Instanciamos los componentes
                //**********************************************************************//
                nombreMod=new JLabel("Nombre:");
                ciMod=new JLabel("CI:");
                direccionMod=new JLabel("Dirección:");
                telefonoMod=new JLabel("Teléfono:");
                celularMod=new JLabel("Celular:");
                correoMod=new JLabel("Correo:");
                                 
                cNombreMod=new JTextField(20);
                cCIMod=new JTextField(20);
                cDireccionMod=new JTextField(20);
                cTelefonoMod=new JTextField(20);
                cCelularMod=new JTextField(20);
                cCorreoMod=new JTextField(20);
                
                registrarMod=new JButton("Registrar");
                cancelarMod=new JButton("Cancelar");
                //**********************************************************************//
                //      Estalecemos la posición de los componentes
                //**********************************************************************//
                nombreMod.setBounds(120,60,150,20);
                ciMod.setBounds(120,90,150,20);
                direccionMod.setBounds(120,120,150,20);
                telefonoMod.setBounds(120,150,150,20);
                celularMod.setBounds(120,180,150,20);
                correoMod.setBounds(120, 210, 150, 20);
                                
                cNombreMod.setBounds(220,60,150,30);
                cCIMod.setBounds(220,90,150,30);
                cDireccionMod.setBounds(220,120,150,30);
                cTelefonoMod.setBounds(220,150,150,30);
                cCelularMod.setBounds(220,180,150,30);
                cCorreoMod.setBounds(220, 210, 150, 30);
                
                registrarMod.setBounds(250,270,100,30);
                cancelarMod.setBounds(130,270,100,30);
                //**********************************************************************//
                //     Insertamos los componentes al panel
                //**********************************************************************//
                jpanelMod.add(nombreMod);
                jpanelMod.add(ciMod);
                jpanelMod.add(direccionMod);
                jpanelMod.add(telefonoMod);
                jpanelMod.add(celularMod);
                jpanelMod.add(correoMod);
                
                jpanelMod.add(cNombreMod);
                jpanelMod.add(cCIMod);
                jpanelMod.add(cDireccionMod);
                jpanelMod.add(cTelefonoMod);
                jpanelMod.add(cCelularMod);
                jpanelMod.add(cCorreoMod);
                
                jpanelMod.add(registrarMod);
                jpanelMod.add(cancelarMod);
                //**********************************************************************//
                //      Evento que nos permite cerrar la ventana de registro cliente
                //**********************************************************************//                
                cancelarMod.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent can){
                jframeMod.dispose();
                }});
                //********************************************************************************//
                //      Obtiene los datos de la BD y los inserta en los campos correspondientes
                //********************************************************************************//             
                cNombreMod.setText(nombre);
                cCIMod.setText(ci);
                cDireccionMod.setText(direccion);
                cTelefonoMod.setText(telefono);
                cCelularMod.setText(celular);
                cCorreoMod.setText(correo);

                //********************************************************************************//
                //      Actualiza la información de los campos modificados
                //********************************************************************************//                
                registrarMod.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae3){
                //*******************************************************//
                //      Instanciamos la clase ConectorBD
                //*******************************************************//
                ConectorBD cn=new ConectorBD();
                //*******************************************************//
                //      Instanciamos la clase Registrar cliente
                //*******************************************************//
                RegistrarCliente regMod=new RegistrarCliente();
                //****************************************************************************************//
                //      Condicional que nos permite saber si los campos de texto se encuentran vacíos
                //****************************************************************************************//
                if(!cNombreMod.getText().isEmpty()&&!cCIMod.getText().isEmpty()&&!cDireccionMod.getText().isEmpty()){
                if(!regMod.validarNombre(cNombreMod)&&!regMod.validarDireccion(cDireccionMod)&&regMod.validarCorreo(cCorreoMod)){
                   //*************************************************************//
                   //       Llamamos al metodo quitar espacios
                   //*************************************************************//                                
                   String nse=regMod.quitarEspacios(cNombreMod.getText());           
                   String cse=regMod.quitarEspacios(cCIMod.getText());
                   String dse=regMod.quitarEspacios(cDireccionMod.getText());
                   String tse=regMod.quitarEspacios(cTelefonoMod.getText());
                   String celse=regMod.quitarEspacios(cCelularMod.getText());
                   String cose=regMod.quitarEspacios(cCorreoMod.getText());
                
            try{
             //*******************************************************//
             //      Nos conectamos con la Base de Datos
             //*******************************************************//
             cn.conectar();
             cn.consulta("update cliente set nombre='"+nse.trim()+"', ci='"+cse.trim()+"', direccion='"+dse.trim()+"', telefono='"+tse.trim()+"', celular='"+celse.trim()+"', correo='"+cose.trim()+"' where ci='"+cCIMod.getText()+"'");
             //*********************************************************************************************//
             //      Si los datos son guardados de forma correcta, los campos del formulario se limpiarán
             //*********************************************************************************************//             
             cNombreMod.setText("");
             cCIMod.setText("");
             cDireccionMod.setText("");
             cTelefonoMod.setText("");
             cCelularMod.setText("");
             cCorreoMod.setText("");
             JOptionPane.showMessageDialog(null, "Se guardó correctamente");
             jframeMod.setVisible(false);
            // cn.desconectar();
         }
         catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Ocurrio un error en la conexión");
         }
        }}else{
                JOptionPane.showMessageDialog(null, "Debe rellenar los campos");
                
            }
        }});
              
                jframeMod.add(jpanelMod);
                            
                    }else{
                        JOptionPane.showMessageDialog(null, "El cliente no esta registrado en la BD");
                    }
                }
                if(nombre.isEmpty()){
                   
                        JOptionPane.showMessageDialog(null, "El cliente no esta registrado en la BD");
                    }                  
                campoBusqueda.setText("");
                buscar.desconectar();     
             }
             catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Ocurrio un error en la conexión");
            }
            }else{
                JOptionPane.showMessageDialog(null, "Introduzca la información del cliente");
            }                            
        }});
        lB.add(etiqueta1);
        lB.add(campoBusqueda);
        lB.add(botonBuscar);
        mB.add(lB);       
    }
}





        
        
    


