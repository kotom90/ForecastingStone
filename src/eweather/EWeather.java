package eweather;
import view.GUIMainMenu;
import controller.ControllerForecast;
import controller.ControllerWeatherNow;
import remote.JsonManager;

/**
 *   @ Νικήτογλου Ελευθέριος - std100152@ac.eap.gr
 *   @ Ρούσσου Άννα - std114276@ac.eap.gr   
 *   @ Σιδηρόπουλος Κωνσταντίνος - std114284@ac.eap.gr
 *   @ Τμήμα ΘΕΣ-2 2017-18
 */

public class EWeather {

    
     public static void main(String args[]) 
     {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIMainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                /*καταχώρηση API key και μορφής επιστροφής δεδομένων από την υπηρεσία openweathermap*/
                JsonManager.setApiKey("8128f91440a3e0bcbcbcdb93274e86f0");
                JsonManager.setUnits("metric");
                
                /*Δημιουργία controller για τον καιρό τώρα*/
                ControllerWeatherNow ctrlWn = new ControllerWeatherNow();
                
                /*Εκκαθάριση πίνακα WeatherNow κατά την εκκίνηση*/
                ctrlWn.clearTable();
                
                /*Εισαγωγή νέων δεδομένων από την υπηρεσία με χρήση API call*/
                ctrlWn.insertDataFromJson();
                
                ControllerForecast ctrlFc = new ControllerForecast();
                ctrlFc.clearTable();
                ctrlFc.insertDataFromJson();
                
                /*Δημιουργία και εμφάνιση βασικού μενού*/
                new GUIMainMenu().setVisible(true);
            }
        });
    }
    
   
}
