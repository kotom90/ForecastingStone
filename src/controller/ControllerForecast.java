package controller;
/*κλάση διαχείρησης του entity Forecast*/

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import model.City;
import model.Forecast;
import remote.JsonManager;

/**
 *   @ Νικήτογλου Ελευθέριος - std100152@ac.eap.gr
 *   @ Ρούσσου Άννα - std114276@ac.eap.gr   
 *   @ Σιδηρόπουλος Κωνσταντίνος - std114284@ac.eap.gr
 *   @ Τμήμα ΘΕΣ-2 2017-18
 */

public class ControllerForecast extends Controller
{
    public ControllerForecast()
    {
        super();
    }
    
    // Καθαρίζει τον πίνακα FORECASTS
    @Override
    public void clearTable()
    {
        clearTbl("Forecast.deleteAll");
    }
    
    // Αποθήκευση δεδομένων από JSON στον πίνακα Forecasts
    public void insertDataFromJson()
    {
        Query query = em.createNamedQuery("City.findAll");
        List<City> results = query.getResultList();
        
        for (City c : results)
        {
            List<Forecast> newForecasts = new JsonManager().fetchForecasts(c.getCityId());
            em.getTransaction().begin();
            for(Forecast forecast : newForecasts)
                em.persist(forecast);
            em.getTransaction().commit();    
        }
    }

    public List<Forecast> selectNext24hForecasts(String cityName, int forecastCount)
    {
        Calendar ca = Calendar.getInstance();
        Query q = em.createNamedQuery("Forecast.FindByCityNameDateNow");
        q.setParameter("cityName", cityName);
        q.setParameter("dt", ca.getTime());
        return q.setMaxResults(forecastCount).getResultList();
    }
    
    public List<Forecast> select11NextDayForecasts(String cityName)
    {
        ArrayList<Forecast> forecasts = new ArrayList<Forecast>();
        
        /*Ανάκτηση της πρόβλεψης του επομένου τριώρου από τώρα και εισαγωγή στη λίστα*/
        Forecast firstForecast = selectNext24hForecasts(cityName, 1).get(0);
        forecasts.add(firstForecast);

        Query q1 = em.createNamedQuery("Forecast.FindByCityName11");
        q1.setParameter("cityName", cityName);
        long aDayInMs = 60*60*24*1000;
        /*Διαίρεση σε ακέραιες ημέρες και πρόσθεση μιας ημέρας*/
        Date dt = new Date(((firstForecast.getForecastPK().getDt().getTime() / aDayInMs) * aDayInMs) + aDayInMs);
        q1.setParameter("dt", dt);
        
        /*Ανάκτηση 4ων προβλέψεων ξεκινώντας από το αμέσως επόμενη μέρα της πρώτης πρόβλεψης*/
        List<Forecast> fcsts = q1.setMaxResults(4).getResultList();
        
        /*Προσθήκη των 4ων προβλέψεων στη λίστα*/
        for(Forecast f : fcsts)
            forecasts.add(f);
        
        /*Επιστροφή των 5 προβλέψεων*/
        return forecasts;
    }
    
    /*Επιστρέφει την πρόβλεψη με τη μεγαλύτερη θερμοκρασία για την επιλεγμένη πόλη*/
    public Forecast selectForecastMaxTempByCityName(String cityName)
    {
        Query q = em.createNamedQuery("Forecast.FindMaxTempByCity");
        q.setParameter("cityName", cityName);
        return (Forecast)q.getSingleResult();
    }
    
    /*Επιστρέφει την πρόβλεψη με την ελάχιστη θερμοκρασία για την επιλεγμένη πόλη*/
    public Forecast selectForecastMinTempByCityName(String cityName)
    {
        Query q = em.createNamedQuery("Forecast.FindMinTempByCity");
        q.setParameter("cityName", cityName);
        return (Forecast)q.getSingleResult();
    }
    
    /*Επιστρέφει μια λίστα μέγιστων θερμοκρασιών για κάθε πόλη ταξινομημένη ανά ονομασία πόλης*/
    public List<Double> selectForecastsMaxTempAllCities()
    {
        Query q = em.createNamedQuery("Forecast.FindMaxTempAllCities");
        return q.getResultList();
    }

    /*Επιστρέφει μια λίστα ελάχιστων θερμοκρασιών για κάθε πόλη ταξινομημένη ανά ονομασία πόλης*/
    public List<Double> selectForecastsMinTempAllCities()
    {
        Query q = em.createNamedQuery("Forecast.FindMinTempAllCities");
        return q.getResultList();
    }
    
    /*Επιστρέφει μια λίστα μέσων θερμοκρασιών για κάθε πόλη ταξινομημένη ανά ονομασία πόλης*/
    public List<Double> selectForecastsAvgTempAllCities()
    {
        Query q = em.createNamedQuery("Forecast.FindAvgTempAllCities");
        return q.getResultList();
    }
    
    /*Επιστρέφει μια λίστα προβλέψεων για κάθε πόλη ταξινομημένη ανά ονομασία πόλης*/
    public List<Forecast> selectForecastsByCityName()
    {
        Query q =em.createNamedQuery("Forecast.FindByCityName");
        return q.getResultList();
    }
    
    public void updateAndKeepForecastData()
    {
        Query query = em.createNamedQuery("City.findAll");
        List<City> results = query.getResultList();
        
        for (City c : results)
        {
            List<Forecast> newForecasts = new JsonManager().fetchForecasts(c.getCityId());
            em.getTransaction().begin();
            for(Forecast newForecast : newForecasts)
            {
                em.detach(newForecast);
                em.merge(newForecast);
            }
            em.getTransaction().commit();    
        }
    }
}
