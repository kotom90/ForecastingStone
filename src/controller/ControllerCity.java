package controller;
/*κλάση διαχείρησης του entity City*/

import model.City;

/**
 *   @ Νικήτογλου Ελευθέριος - std100152@ac.eap.gr
 *   @ Ρούσσου Άννα - std114276@ac.eap.gr   
 *   @ Σιδηρόπουλος Κωνσταντίνος - std114284@ac.eap.gr
 *   @ Τμήμα ΘΕΣ-2 2017-18
 */

public class ControllerCity extends Controller
{
    public ControllerCity()
    {
        super();
    }
    
    /*Εύρεση πόλης με το αντίστοιχο Id*/
    public City findCityByCityId(int cityId)
    {
        return em.find(City.class, cityId);
    }
    
    @Override
    public void clearTable()
    {
        clearTbl("City.deleteAll");
    }
}
