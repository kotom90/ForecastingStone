package controller;
/*γενική κλάση διαχείρησης των entities*/

import javax.persistence.EntityManager;
import javax.persistence.Query;
import remote.DbConnector;

/**
 *   @ Νικήτογλου Ελευθέριος - std100152@ac.eap.gr
 *   @ Ρούσσου Άννα - std114276@ac.eap.gr   
 *   @ Σιδηρόπουλος Κωνσταντίνος - std114284@ac.eap.gr
 *   @ Τμήμα ΘΕΣ-2 2017-18
 */

public abstract class Controller
{
    //χρησιμοποιούμε static για να έχουμε τον ίδιο entity manager καθ' όλη τη διάρκεια της εκτέλεσης
    protected static EntityManager em;
    
    public Controller()
    {
        if (em == null)
        {
            /*Σύνδεση με τη βάση, δημιουργία entity factory και entity manager*/
            DbConnector.connect();
            em = DbConnector.getEm();
        }
    }
    
    //μέθοδος διαγραφής πίνακα μέσω ενός έτοιμου namedQuery.
    protected void clearTbl(String namedQuery)
    {
        try 
        { 
            em.getTransaction().begin();
            Query query1 = em.createNamedQuery(namedQuery);
            query1.executeUpdate();
            em.getTransaction().commit();
        } 
        catch (Exception e) 
        { 
            em.getTransaction().rollback();
        }  
    }
    
    protected abstract void clearTable();
}


