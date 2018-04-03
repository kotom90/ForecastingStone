package controller;
/*κλάση διαχείρησης του entity WeatherDesc*/

import model.WeatherDesc;

/**
 *   @ Νικήτογλου Ελευθέριος - std100152@ac.eap.gr
 *   @ Ρούσσου Άννα - std114276@ac.eap.gr   
 *   @ Σιδηρόπουλος Κωνσταντίνος - std114284@ac.eap.gr
 *   @ Τμήμα ΘΕΣ-2 2017-18
 */

public class ControllerWeatherDesc extends Controller
{
    public ControllerWeatherDesc()
    {
        super();
    }
    
    /*Εύρεση περιγραφής με το αντίστοιχο Id*/
    public WeatherDesc findWeatherDescById(int weatherDescId)
    {
        return em.find(WeatherDesc.class, weatherDescId);
    }
    
    @Override
    public void clearTable()
    {
        clearTbl("WeatherDesc.deleteAll");
    }
}
