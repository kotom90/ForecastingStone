package remote;
/*Κλάση δημιουργίας σύνδεσης στη βάση δεδομένων*/

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *   @ Νικήτογλου Ελευθέριος - std100152@ac.eap.gr
 *   @ Ρούσσου Άννα - std114276@ac.eap.gr   
 *   @ Σιδηρόπουλος Κωνσταντίνος - std114284@ac.eap.gr
 *   @ Τμήμα ΘΕΣ-2 2017-18
 */

public final class DbConnector
{
    private static final String PERSISTENCE_UNIT_NAME = "eWeatherPU";
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    //Μηνύματα
    private static final String errDBConn = "Αποτυχία σύνδεσης με τη Βάση Δεδομένων!";
    
    public static void connect()
    {
        if (emf == null)
        {
            try 
            {
                //δημιουργία Entity Manager που θα χρησιμοποιηθεί καθ όλη τη διάρκεια εκτέλεσης της εφαρμογής.
                emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
                em = emf.createEntityManager(); 
            } 
            catch(Exception e) 
            {
                System.out.println(e); 
                JOptionPane.showMessageDialog(null, errDBConn, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static EntityManager getEm()
    {
        return em;
    }
}
