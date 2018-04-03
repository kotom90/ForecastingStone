package controller;
/*κλάση διαχείρησης του entity WeatherNow*/

import java.util.List;
import javax.persistence.Query;
import model.City;
import model.WeatherNow;
import remote.DbConnector;
import remote.JsonManager;

/**
 *   @ Νικήτογλου Ελευθέριος - std100152@ac.eap.gr
 *   @ Ρούσσου Άννα - std114276@ac.eap.gr   
 *   @ Σιδηρόπουλος Κωνσταντίνος - std114284@ac.eap.gr
 *   @ Τμήμα ΘΕΣ-2 2017-18
 */

public final class ControllerWeatherNow extends Controller
{
    public ControllerWeatherNow()
    {
        super();
    }
    
    // Καθαρίζει τον πίνακα WEATHER_NOW
    public void clearTable()
    {
        clearTbl("WeatherNow.deleteAll");
    }
    
    // Εισαγωγή δεδομένων από JSON στον πίνακα WeatherNow   
    public void insertDataFromJson()
    {
        Query query = em.createNamedQuery("City.findAll");
        List<City> results = query.getResultList();
        
        em.getTransaction().begin();
        for (City c : results)
        {
            WeatherNow newWeatherNow = new JsonManager().fetchWeatherNow(c.getCityId());
            em.persist(newWeatherNow);
        }
        em.getTransaction().commit();
    }
    
    // Ανάκτηση καιρικών συνθηκών για την επιλεγμένη πόλη
    public WeatherNow selectWeatherNowByCityName(String cityName)
    {
        Query q = em.createNamedQuery("WeatherNow.findByCityName");
        q.setParameter("cityName", cityName);
        return (WeatherNow) q.getSingleResult();
    }
    
    // Ανανέωση δεδομένων από JSON στον πίνακα WeatherNow  
    public void updateWeatherNowData()
    {
        clearTable();
        Query query = em.createNamedQuery("City.findAll");
        List<City> results = query.getResultList();
        
        em.getTransaction().begin();
        for (City c : results)
        {
            WeatherNow newWeatherNow = new JsonManager().fetchWeatherNow(c.getCityId());
            em.persist(newWeatherNow);
        }
        em.getTransaction().commit();
    }
}
