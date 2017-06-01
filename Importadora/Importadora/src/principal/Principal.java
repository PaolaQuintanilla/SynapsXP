
package principal;
import Vista.Login;
import Vista.MarcoPrincipal;
public class Principal {

    
    public static void main(String[] args) {
        //*******************************************************************************************************//
        //      Hacemos uso de la libreria javax.swing.UIManager para darle estilo a nuestra aplicación
        //*******************************************************************************************************//
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MarcoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MarcoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MarcoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MarcoPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //***********************************************************//
        //      Instanciamos la clase Login y la hacemos visible
        //***********************************************************//
        Login Inicio=new Login();
        Inicio.setVisible(true);
        
    }
    
}
