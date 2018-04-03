/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *   @ Νικήτογλου Ελευθέριος - std100152@ac.eap.gr
 *   @ Ρούσσου Άννα - std114276@ac.eap.gr   
 *   @ Σιδηρόπουλος Κωνσταντίνος - std114284@ac.eap.gr
 *   @ Τμήμα ΘΕΣ-2 2017-18
 */

@Entity
@Table(name = "FORECAST")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Forecast.findAll", query = "SELECT f FROM Forecast f")
    , @NamedQuery(name = "Forecast.findByMaintemp", query = "SELECT f FROM Forecast f WHERE f.maintemp = :maintemp")
    , @NamedQuery(name = "Forecast.findByCloudsall", query = "SELECT f FROM Forecast f WHERE f.cloudsall = :cloudsall")
    , @NamedQuery(name = "Forecast.findByWindspeed", query = "SELECT f FROM Forecast f WHERE f.windspeed = :windspeed")
    , @NamedQuery(name = "Forecast.findByDt", query = "SELECT f FROM Forecast f WHERE f.forecastPK.dt = :dt")
    , @NamedQuery(name = "Forecast.findByCityId", query = "SELECT f FROM Forecast f WHERE f.forecastPK.cityId = :cityId")
    , @NamedQuery(name = "Forecast.findByRain", query = "SELECT f FROM Forecast f WHERE f.rain = :rain")
    , @NamedQuery(name = "Forecast.findBySnow", query = "SELECT f FROM Forecast f WHERE f.snow = :snow")
    , @NamedQuery(name = "Forecast.findByIcon", query = "SELECT f FROM Forecast f WHERE f.icon = :icon")
        //custom queries
        
// Διαγραφή στοιχείων του πίνακα Forecast
    , @NamedQuery(name = "Forecast.deleteAll", query = "DELETE  FROM Forecast ")
//Εύρεση πρόβλεψης για συγκεκριμένη πόλή με βάση την ημερομηνία
    , @NamedQuery(name = "Forecast.FindByCityNameDateNow",query ="SELECT f FROM Forecast f WHERE f.city.cityName = :cityName AND f.forecastPK.dt >= :dt ORDER BY f.forecastPK.dt")
//Εύρεση της πρόβλεψης των 11πμ ή των 12πμ για όλες τις πόλεις      
    , @NamedQuery(name = "Forecast.FindByCityName11",query ="SELECT f FROM Forecast f WHERE f.city.cityName = :cityName AND (FUNC('HOUR',f.forecastPK.dt) = 11 OR FUNC('HOUR',f.forecastPK.dt) = 12) AND f.forecastPK.dt >= :dt ORDER BY f.forecastPK.dt")
//Εύρεση πρόβλεψης με βάση τη μέγιστη θερμοκρασία 5 ημερών για μία συγκεκριμένη πόλη 
    , @NamedQuery(name = "Forecast.FindMaxTempByCity",query="SELECT f FROM Forecast f WHERE f.maintemp = (SELECT MAX(fo.maintemp) FROM Forecast fo WHERE fo.city.cityName = :cityName) AND f.city.cityName = :cityName")
//Εύρεση πρόβλεψης με βάση την ελάχιστη θερμοκρασία 5 ημερών για μία συγκεκριμένη πόλη     
    , @NamedQuery(name = "Forecast.FindMinTempByCity",query="SELECT f FROM Forecast f WHERE f.maintemp = (SELECT MIN(fo.maintemp) FROM Forecast fo WHERE fo.city.cityName = :cityName) AND f.city.cityName = :cityName")
//Εύρεση μέγιστης θερμοκρασίας για κάθε μιά πολή ξεχωριστά , σε αλφαβητική σειρά  
    , @NamedQuery(name = "Forecast.FindMaxTempAllCities",query="SELECT MAX(f.maintemp) FROM Forecast f GROUP BY f.city.cityName ORDER BY f.city.cityName " )
//Εύρεση ελάχιστης θερμοκρασίας για κάθε μιά πολή ξεχωριστά , σε αλφαβητική σειρά      
    , @NamedQuery(name = "Forecast.FindMinTempAllCities",query="SELECT MIN(f.maintemp) FROM Forecast f GROUP BY f.city.cityName ORDER BY f.city.cityName ")
//Εύρεση μέσης θερμοκρασίας για κάθε μιά πολή ξεχωριστά , σε αλφαβητική σειρά      
    , @NamedQuery(name = "Forecast.FindAvgTempAllCities",query="SELECT AVG(f.maintemp) FROM Forecast f GROUP BY f.city.cityName ORDER BY f.city.cityName " )
//Εύρεση ονομάτος πόλης αλφαβητικά     
    , @NamedQuery(name = "Forecast.FindByCityName",query="SELECT DISTINCT f.city.cityName FROM Forecast f ORDER BY f.city.cityName")
})



public class Forecast implements Serializable
{

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ForecastPK forecastPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MAINTEMP")
    private Double maintemp;
    @Column(name = "CLOUDSALL")
    private Double cloudsall;
    @Column(name = "WINDSPEED")
    private Double windspeed;
    @Column(name = "RAIN")
    private Double rain;
    @Column(name = "SNOW")
    private Double snow;
    @Column(name = "ICON")
    private String icon;
    @JoinColumn(name = "CITY_ID", referencedColumnName = "CITY_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private City city;
    @JoinColumn(name = "WEATHER_DESC_ID", referencedColumnName = "WEATHER_DESC_ID")
    @ManyToOne(optional = false)
    private WeatherDesc weatherDescId;

    public Forecast()
    {
    }

    public Forecast(ForecastPK forecastPK)
    {
        this.forecastPK = forecastPK;
    }

    public Forecast(Date dt, int cityId)
    {
        this.forecastPK = new ForecastPK(dt, cityId);
    }

    public ForecastPK getForecastPK()
    {
        return forecastPK;
    }

    public void setForecastPK(ForecastPK forecastPK)
    {
        this.forecastPK = forecastPK;
    }

    public Double getMaintemp()
    {
        return maintemp;
    }

    public void setMaintemp(Double maintemp)
    {
        this.maintemp = maintemp;
    }

    public Double getCloudsall()
    {
        return cloudsall;
    }

    public void setCloudsall(Double cloudsall)
    {
        this.cloudsall = cloudsall;
    }

    public Double getWindspeed()
    {
        return windspeed;
    }

    public void setWindspeed(Double windspeed)
    {
        this.windspeed = windspeed;
    }

    public Double getRain()
    {
        return rain;
    }

    public void setRain(Double rain)
    {
        this.rain = rain;
    }

    public Double getSnow()
    {
        return snow;
    }

    public void setSnow(Double snow)
    {
        this.snow = snow;
    }

    public String getIcon()
    {
        return icon;
    }

    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public City getCity()
    {
        return city;
    }

    public void setCity(City city)
    {
        this.city = city;
    }

    public WeatherDesc getWeatherDescId()
    {
        return weatherDescId;
    }

    public void setWeatherDescId(WeatherDesc weatherDescId)
    {
        this.weatherDescId = weatherDescId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (forecastPK != null ? forecastPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forecast))
        {
            return false;
        }
        Forecast other = (Forecast) object;
        if ((this.forecastPK == null && other.forecastPK != null) || (this.forecastPK != null && !this.forecastPK.equals(other.forecastPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "model.Forecast[ forecastPK=" + forecastPK + " ]";
    }
    
}
