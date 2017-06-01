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
public class ModificarProveedor extends JPanel implements Action{
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
    private JLabel lblPaisModificado;
    private JLabel lblCuentaModificado;
    private JLabel lblTelefonoModificado;
    private JLabel lblCorreoModificado;
    
    private JTextField txtNombreModificado;
    private JTextField txtCIModificado;
    private JTextField txtPaisModificado;
    private JTextField txtCuentaModificado;
    private JTextField txtTelefonoModificado;  
    private JTextField txtCorreoModificado;
    
    private JButton btnRegistrarModificado;
    private JButton btnCancelarModificado;
        
    private String nse;
    private String cse;
    private String dse;
    private String tse;
    private String celse;
    private String cose;

    public ModificarProveedor(){
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
        //**********************************************//
        //          Creamos un Marco
        //**********************************************//
        jfMarcoBuscar=new JFrame("Buscar");
        jfMarcoBuscar.setSize(300, 100);
        jfMarcoBuscar.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jfMarcoBuscar.setLocationRelativeTo(null);
        jfMarcoBuscar.setVisible(true);
        //***********************************************//
        //           Insertamos un icono al marco
        //***********************************************//
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
                String pais="";
                String cuenta="";
                String telefono="";
                String correo="";
                //******************************************************************************************//
                //      El metodo seleccionar nos permite recuperar un registro completo de la BD
                //      siempre y cuando exista el usuario
                //******************************************************************************************//
                resultado=buscar.seleccionar("select * from proveedor where CIP='"+txtBusqueda.getText()+"'");
                //******************************************************************************************//
                //      Realizamos el recorrido registro por registro hasta encontrar la coincidencia
                //******************************************************************************************//               
                while (resultado.next()){
                //******************************************************************************************//
                //      Almacenamos los datos obtenidos de la BD y las almacenamos en variables
                //******************************************************************************************//
                nombre = resultado.getString("NOMBREP");
                ci = resultado.getString("CIP");
                pais = resultado.getString("PAISP");
                cuenta = resultado.getString("CUENTAP");
                telefono = resultado.getString("TELEFONOP");
                correo = resultado.getString("CORREOP");
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
                lblPaisModificado=new JLabel("Pais:");
                lblCuentaModificado=new JLabel("Nro. de cuenta:");
                lblTelefonoModificado=new JLabel("Teléfono:");
                lblCorreoModificado=new JLabel("Correo:");
                                 
                txtNombreModificado=new JTextField(20);
                txtCIModificado=new JTextField(20);
                txtPaisModificado=new JTextField(20);
                txtCuentaModificado=new JTextField(20);
                txtTelefonoModificado=new JTextField(20);
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
                txtPaisModificado.addKeyListener(new KeyAdapter() {
                public void keyPressed(KeyEvent e){
                    if(KeyEvent.VK_ENTER==e.getKeyCode()){
                        btnRegistrarModificado.doClick();
                    }   
                }
                });
                //*********************************************************************//
                //      El campo se encuentra a la escucha de la tecla enter
                //*********************************************************************//                
                txtCuentaModificado.addKeyListener(new KeyAdapter() {
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
                lblNombreModificado.setBounds(120,60,150,30);
                lblCIModificado.setBounds(120,90,150,30);
                lblPaisModificado.setBounds(120,120,150,30);
                lblCuentaModificado.setBounds(120,150,150,30);
                lblTelefonoModificado.setBounds(120,180,150,30);
                lblCorreoModificado.setBounds(120, 210, 150, 30);
                                
                txtNombreModificado.setBounds(220,60,150,30);
                txtCIModificado.setBounds(220,90,150,30);
                txtPaisModificado.setBounds(220,120,150,30);
                txtCuentaModificado.setBounds(220,150,150,30);
                txtTelefonoModificado.setBounds(220,180,150,30);
                txtCorreoModificado.setBounds(220, 210, 150, 30);
                
                btnRegistrarModificado.setBounds(250,270,100,30);
                btnCancelarModificado.setBounds(130,270,100,30);
                //**********************************************************************//
                //     Insertamos los componentes al panel
                //**********************************************************************//
                jpLaminaModificado.add(lblNombreModificado);
                jpLaminaModificado.add(lblCIModificado);
                jpLaminaModificado.add(lblPaisModificado);
                jpLaminaModificado.add(lblCuentaModificado);
                jpLaminaModificado.add(lblTelefonoModificado);
                jpLaminaModificado.add(lblCorreoModificado);
                
                jpLaminaModificado.add(txtNombreModificado);
                jpLaminaModificado.add(txtCIModificado);
                jpLaminaModificado.add(txtPaisModificado);
                jpLaminaModificado.add(txtCuentaModificado);
                jpLaminaModificado.add(txtTelefonoModificado);
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
                txtPaisModificado.setText(pais);
                txtCuentaModificado.setText(cuenta);
                txtTelefonoModificado.setText(telefono);
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
                if(!txtNombreModificado.getText().isEmpty()&&!txtCIModificado.getText().isEmpty()&&!txtPaisModificado.getText().isEmpty()){
                if(!regMod.validarNombre(txtNombreModificado)&&!regMod.validarDireccion(txtPaisModificado)&&regMod.validarCorreo(txtCorreoModificado)){
                   //*************************************************************//
                   //       Llamamos al metodo quitar espacios
                   //*************************************************************//                                
                   String nse=regMod.quitarEspacios(txtNombreModificado.getText());           
                   String cse=regMod.quitarEspacios(txtCIModificado.getText());
                   String dse=regMod.quitarEspacios(txtPaisModificado.getText());
                   String cue=regMod.quitarEspacios(txtCuentaModificado.getText());
                   String tse=regMod.quitarEspacios(txtTelefonoModificado.getText());
                   String cose=regMod.quitarEspacios(txtCorreoModificado.getText());
                
            try{
             //*******************************************************//
             //      Nos conectamos con la Base de Datos
             //*******************************************************//
             cn.conectar();
             cn.consulta("update proveedor set NOMBREP='"+nse.trim()+"', CIP='"+cse.trim()+"', PAISP='"+dse.trim()+"', CUENTAP='"+cue.trim()+"', TELEFONOP='"+tse.trim()+"', CORREOP='"+cose.trim()+"' where CIP='"+txtCIModificado.getText()+"'");
             //*********************************************************************************************//
             //      Si los datos son guardados de forma correcta, los campos del formulario se limpiarán
             //*********************************************************************************************//             
             txtNombreModificado.setText("");
             txtCIModificado.setText("");
             txtPaisModificado.setText("");
             txtCuentaModificado.setText("");
             txtTelefonoModificado.setText("");
             txtCorreoModificado.setText("");
             JOptionPane.showMessageDialog(null, "Se guardó correctamente");
             jfMarcoModificado.setVisible(false);
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
        //        Insertamos el panel en el marco
        //*******************************************************//
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

