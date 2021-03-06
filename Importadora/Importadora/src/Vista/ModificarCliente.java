package Vista;
import Modelo.ConectorBD;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class ModificarCliente extends JPanel implements Action{
    //*****************************************************//
    //          Declaramos los atributos
    //*****************************************************//
    private JFrame jfMarcoBuscar;
    private JPanel jpLaminaBuscar;
    private JLabel lblNIT;
    private JButton btnBuscar;
    private JTextField txtBusqueda;
    private ResultSet resultado;
     
    private JFrame jfMarcoModificado;
    private JPanel jpLaminaModificado; 
    private JLabel lblNombreModificado;
    private JLabel lblCIModificado;
    private JLabel lblDireccionModificado;
    private JLabel lblTelefonoModificado;
    private JLabel lblCelularModificado;
    private JLabel lblCorreoModificado;
    
    private JTextField txtNombreModificado;
    private JTextField txtCIModificado;
    private JTextField txtDireccionModificado;
    private JTextField txtTelefonoModificado;
    private JTextField txtCelularModificado;   
    private JTextField txtCorreoModificado;
    
    private JButton btnRegistrarModificado;
    private JButton btnCancelarModificado;

    
    private String nse;
    private String cse;
    private String dse;
    private String tse;
    private String celse;
    private String cose;

    public ModificarCliente(){
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
        jfMarcoBuscar=new JFrame("Buscar");
        jfMarcoBuscar.setSize(300, 100);
        jfMarcoBuscar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jfMarcoBuscar.setLocationRelativeTo(null);
        jfMarcoBuscar.setVisible(true);
        ImageIcon icono=new ImageIcon("img/iconoCAT.jpg");
        Image img=icono.getImage();
        jfMarcoBuscar.setIconImage(img);

        jpLaminaBuscar=new JPanel();

        lblNIT=new JLabel("NIT:");
        btnBuscar=new JButton("Buscar");
        txtBusqueda=new JTextField(10);
        //********************************************************************//
        //          El campo se encuentra a la escucha de la tecla enter
        //********************************************************************//
        txtBusqueda.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnBuscar.doClick();
                    }   
                }
            });
        //********************************************************************//
        //          El campo se encuentra a la escucha de la tecla enter
        //********************************************************************//
        btnBuscar.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnBuscar.doClick();
                    }   
                }
            });
        //********************************************************************//
        //      Evento que busca el CI del cliente
        //********************************************************************//
        btnBuscar.addActionListener(new ActionListener(){
        
                
        public void actionPerformed(ActionEvent e){
 
            if(!txtBusqueda.getText().isEmpty()){
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
                resultado=buscar.seleccionar("select * from cliente where CI_CLIENTE='"+txtBusqueda.getText()+"'");
                //******************************************************************************************//
                //      Realizamos el recorrido registro por registro hasta encontrar la coincidencia
                //******************************************************************************************//               
                while (resultado.next()){
                //******************************************************************************************//
                //      Almacenamos los datos obtenidos de la BD y las almacenamos en variables
                //******************************************************************************************//
                nombre = resultado.getString("NOMBRE_CLIENTE");
                ci = resultado.getString("CI_CLIENTE");
                direccion = resultado.getString("DIRECCION_CLIENTE");
                telefono = resultado.getString("TELEFONO_CLIENTE");
                celular = resultado.getString("CELULAR_CLIENTE");
                correo = resultado.getString("CORREO_CLIENTE");
                jfMarcoBuscar.setVisible(false);
                if(!nombre.isEmpty()){
                jfMarcoModificado=new JFrame("Modificar información del cliente");
                jfMarcoModificado.setSize(500, 350);
                jfMarcoModificado.setLocationRelativeTo(null);
                jfMarcoModificado.setVisible(true);
                ImageIcon icono=new ImageIcon("img/iconoCAT.jpg");
                Image img=icono.getImage();
                jfMarcoModificado.setIconImage(img);
                //**********************************************************************//
                //      Creamos un panel que nos servirá como contenedor
                //**********************************************************************//
                jpLaminaModificado=new JPanel();
                //**********************************************************************//
                //      Anulamos el Layout por defecto
                //**********************************************************************//
                jpLaminaModificado.setLayout(null);
                //**********************************************************************//
                //      Instanciamos los componentes
                //**********************************************************************//
                lblNombreModificado=new JLabel("Nombre:");
                lblCIModificado=new JLabel("CI:");
                lblDireccionModificado=new JLabel("Dirección:");
                lblTelefonoModificado=new JLabel("Teléfono:");
                lblCelularModificado=new JLabel("Celular:");
                lblCorreoModificado=new JLabel("Correo:");
                                 
                txtNombreModificado=new JTextField(20);
                txtCIModificado=new JTextField(20);
                txtDireccionModificado=new JTextField(20);
                txtTelefonoModificado=new JTextField(20);
                txtCelularModificado=new JTextField(20);
                txtCorreoModificado=new JTextField(20);
                //*********************************************************************//
                //      El campo se encuentra a la escucha de la tecla enter
                //*********************************************************************//
                txtNombreModificado.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnRegistrarModificado.doClick();
                    }   
                }
                });
                //*********************************************************************//
                //      El campo se encuentra a la escucha de la tecla enter
                //*********************************************************************//                
                txtCIModificado.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnRegistrarModificado.doClick();
                    }   
                }
                });
                //*********************************************************************//
                //      El campo se encuentra a la escucha de la tecla enter
                //*********************************************************************//                
                txtDireccionModificado.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnRegistrarModificado.doClick();
                    }   
                }
                });
                //*********************************************************************//
                //      El campo se encuentra a la escucha de la tecla enter
                //*********************************************************************//                
                txtTelefonoModificado.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnRegistrarModificado.doClick();
                    }   
                }
                });
                //*********************************************************************//
                //      El campo se encuentra a la escucha de la tecla enter
                //*********************************************************************//                
                txtCelularModificado.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnRegistrarModificado.doClick();
                    }   
                }
                });
                //*********************************************************************//
                //      El campo se encuentra a la escucha de la tecla enter
                //*********************************************************************//                
               txtCorreoModificado.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnRegistrarModificado.doClick();
                    }   
                }
                });
                      
                btnRegistrarModificado=new JButton("Registrar");
                btnCancelarModificado=new JButton("Cancelar");
                //**********************************************************************//
                //      Estalecemos la posición de los componentes
                //**********************************************************************//
                lblNombreModificado.setBounds(120,60,150,20);
                lblCIModificado.setBounds(120,90,150,20);
                lblDireccionModificado.setBounds(120,120,150,20);
                lblTelefonoModificado.setBounds(120,150,150,20);
                lblCelularModificado.setBounds(120,180,150,20);
                lblCorreoModificado.setBounds(120, 210, 150, 20);
                                
                txtNombreModificado.setBounds(220,60,150,30);
                txtCIModificado.setBounds(220,90,150,30);
                txtDireccionModificado.setBounds(220,120,150,30);
                txtTelefonoModificado.setBounds(220,150,150,30);
                txtCelularModificado.setBounds(220,180,150,30);
                txtCorreoModificado.setBounds(220, 210, 150, 30);
                
                btnRegistrarModificado.setBounds(250,270,100,30);
                btnCancelarModificado.setBounds(130,270,100,30);
                //**********************************************************************//
                //     Insertamos los componentes al panel
                //**********************************************************************//
                jpLaminaModificado.add(lblNombreModificado);
                jpLaminaModificado.add(lblCIModificado);
                jpLaminaModificado.add(lblDireccionModificado);
                jpLaminaModificado.add(lblTelefonoModificado);
                jpLaminaModificado.add(lblCelularModificado);
                jpLaminaModificado.add(lblCorreoModificado);
                
                jpLaminaModificado.add(txtNombreModificado);
                jpLaminaModificado.add(txtCIModificado);
                jpLaminaModificado.add(txtDireccionModificado);
                jpLaminaModificado.add(txtTelefonoModificado);
                jpLaminaModificado.add(txtCelularModificado);
                jpLaminaModificado.add(txtCorreoModificado);
                
                jpLaminaModificado.add(btnRegistrarModificado);
                jpLaminaModificado.add(btnCancelarModificado);
                //**********************************************************************//
                //      Evento que nos permite cerrar la ventana de registro cliente
                //**********************************************************************//                
                btnCancelarModificado.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent can){
                jfMarcoModificado.dispose();
                }});
                //**********************************************************************//
                //      Evento que cierra el formulario de registro cliente
                //**********************************************************************//   
                btnCancelarModificado.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnCancelarModificado.doClick();
                    }   
                }
                });
                //********************************************************************************//
                //      Obtiene los datos de la BD y los inserta en los campos correspondientes
                //********************************************************************************//             
                txtNombreModificado.setText(nombre);
                txtCIModificado.setText(ci);
                txtDireccionModificado.setText(direccion);
                txtTelefonoModificado.setText(telefono);
                txtCelularModificado.setText(celular);
                txtCorreoModificado.setText(correo);
                //********************************************************************//
                //      El campo se encuentra a la escucha del boton enter
                //********************************************************************//
                btnRegistrarModificado.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnRegistrarModificado.doClick();
                    }   
                }
                });
                //********************************************************************************//
                //      Actualiza la información de los campos modificados
                //********************************************************************************//
                btnRegistrarModificado.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae3){
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
                if(!txtNombreModificado.getText().isEmpty()&&!txtCIModificado.getText().isEmpty()&&!txtDireccionModificado.getText().isEmpty()){
                if(!regMod.validarNombre(txtNombreModificado)&&!regMod.validarDireccion(txtDireccionModificado)&&regMod.validarCorreo(txtCorreoModificado)){
                   //*************************************************************//
                   //       Llamamos al metodo quitar espacios
                   //*************************************************************//                                
                   String nse=regMod.quitarEspacios(txtNombreModificado.getText());           
                   String cse=regMod.quitarEspacios(txtCIModificado.getText());
                   String dse=regMod.quitarEspacios(txtDireccionModificado.getText());
                   String tse=regMod.quitarEspacios(txtTelefonoModificado.getText());
                   String celse=regMod.quitarEspacios(txtCelularModificado.getText());
                   String cose=regMod.quitarEspacios(txtCorreoModificado.getText());
                
            try{
             //*******************************************************//
             //      Nos conectamos con la Base de Datos
             //*******************************************************//
             cn.conectar();
             cn.consulta("update cliente set NOMBRE_CLIENTE='"+nse.trim()+"', CI_CLIENTE='"+cse.trim()+"', DIRECCION_CLIENTE='"+dse.trim()+"', TELEFONO_CLIENTE='"+tse.trim()+"', CELULAR_CLIENTE='"+celse.trim()+"', CORREO_CLIENTE='"+cose.trim()+"' where CI_CLIENTE='"+txtCIModificado.getText()+"'");
             //*********************************************************************************************//
             //      Si los datos son guardados de forma correcta, los campos del formulario se limpiarán
             //*********************************************************************************************//             
             txtNombreModificado.setText("");
             txtCIModificado.setText("");
             txtDireccionModificado.setText("");
             txtTelefonoModificado.setText("");
             txtCelularModificado.setText("");
             txtCorreoModificado.setText("");
             JOptionPane.showMessageDialog(null, "Se guardó correctamente");
             jfMarcoModificado.setVisible(false);
            // cn.desconectar();
         }
         catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Ocurrio un error en la conexión");
         }
        }}else{
                JOptionPane.showMessageDialog(null, "Debe rellenar los campos");
                
            }
        }});
              
                jfMarcoModificado.add(jpLaminaModificado);
                            
                    }else{
                        JOptionPane.showMessageDialog(null, "El cliente no esta registrado en la BD");
                    }
                }
                if(nombre.isEmpty()){
                   
                        JOptionPane.showMessageDialog(null, "El cliente no esta registrado en la BD");
                    }                  
                txtBusqueda.setText("");
                buscar.desconectar();     
             }
             catch(Exception ex){
             JOptionPane.showMessageDialog(null, "Ocurrio un error en la conexión");
            }
            }else{
                JOptionPane.showMessageDialog(null, "Introduzca la información del cliente");
            }                            
        }});
        jpLaminaBuscar.add(lblNIT);
        jpLaminaBuscar.add(txtBusqueda);
        jpLaminaBuscar.add(btnBuscar);
        jfMarcoBuscar.add(jpLaminaBuscar);       
    }
}





        
        
    


