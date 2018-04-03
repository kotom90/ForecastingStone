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
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "WEATHER_NOW")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "WeatherNow.findAll", query = "SELECT w FROM WeatherNow w")
    , @NamedQuery(name = "WeatherNow.findByMaintemp", query = "SELECT w FROM WeatherNow w WHERE w.maintemp = :maintemp")
    , @NamedQuery(name = "WeatherNow.findByCloudsall", query = "SELECT w FROM WeatherNow w WHERE w.cloudsall = :cloudsall")
    , @NamedQuery(name = "WeatherNow.findByWindspeed", query = "SELECT w FROM WeatherNow w WHERE w.windspeed = :windspeed")
    , @NamedQuery(name = "WeatherNow.findByDt", query = "SELECT w FROM WeatherNow w WHERE w.weatherNowPK.dt = :dt")
    , @NamedQuery(name = "WeatherNow.findByCityId", query = "SELECT w FROM WeatherNow w WHERE w.weatherNowPK.cityId = :cityId")
    , @NamedQuery(name = "WeatherNow.findByRain", query = "SELECT w FROM WeatherNow w WHERE w.rain = :rain")
    , @NamedQuery(name = "WeatherNow.findBySnow", query = "SELECT w FROM WeatherNow w WHERE w.snow = :snow")
    , @NamedQuery(name = "WeatherNow.findByIcon", query = "SELECT w FROM WeatherNow w WHERE w.icon = :icon")
    
    // custom queries
        
    // Διαγραφή περιεχομένων του πίνακα WeatherNow  
    , @NamedQuery(name = "WeatherNow.deleteAll",  query = "DELETE FROM WeatherNow")     
    //Εύρεση ονομάτος πόλης  
    , @NamedQuery(name = "WeatherNow.findByCityName", query = "SELECT w FROM WeatherNow w WHERE w.city.cityName = :cityName")
})
public class WeatherNow implements Serializable
{

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WeatherNowPK weatherNowPK;
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
    @ManyToOne(fetch=FetchType.EAGER,optional = false)
    private City city;
    @JoinColumn(name = "WEATHER_DESC_ID", referencedColumnName = "WEATHER_DESC_ID")
    @ManyToOne(fetch=FetchType.EAGER,optional = false)
    private WeatherDesc weatherDescId;

    public WeatherNow()
    {
    }

    public WeatherNow(WeatherNowPK weatherNowPK)
    {
        this.weatherNowPK = weatherNowPK;
    }

    public WeatherNow(Date dt, int cityId)
    {
        this.weatherNowPK = new WeatherNowPK(dt, cityId);
    }

    public WeatherNowPK getWeatherNowPK()
    {
        return weatherNowPK;
    }

    public void setWeatherNowPK(WeatherNowPK weatherNowPK)
    {
        this.weatherNowPK = weatherNowPK;
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
        hash += (weatherNowPK != null ? weatherNowPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WeatherNow))
        {
            return false;
        }
        WeatherNow other = (WeatherNow) object;
        if ((this.weatherNowPK == null && other.weatherNowPK != null) || (this.weatherNowPK != null && !this.weatherNowPK.equals(other.weatherNowPK)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "model.WeatherNow[ weatherNowPK=" + weatherNowPK + " ]";
    }
    
}
