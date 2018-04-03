/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *   @ Νικήτογλου Ελευθέριος - std100152@ac.eap.gr
 *   @ Ρούσσου Άννα - std114276@ac.eap.gr   
 *   @ Σιδηρόπουλος Κωνσταντίνος - std114284@ac.eap.gr
 *   @ Τμήμα ΘΕΣ-2 2017-18
 */

@Entity
@Table(name = "WEATHER_DESC")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "WeatherDesc.findAll", query = "SELECT w FROM WeatherDesc w")
    , @NamedQuery(name = "WeatherDesc.findByWeatherDescId", query = "SELECT w FROM WeatherDesc w WHERE w.weatherDescId = :weatherDescId")
    , @NamedQuery(name = "WeatherDesc.findByWeatherDescGr", query = "SELECT w FROM WeatherDesc w WHERE w.weatherDescGr = :weatherDescGr")
    
      // Διαγραφή στοιχείων του πίνακα WeatherDesc
    , @NamedQuery(name = "WeatherDesc.deleteAll", query = "DELETE FROM WeatherDesc") 
})
public class WeatherDesc implements Serializable
{

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "WEATHER_DESC_ID")
    private Integer weatherDescId;
    @Basic(optional = false)
    @Column(name = "WEATHER_DESC_GR")
    private String weatherDescGr;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "weatherDescId")
    private List<Forecast> forecastList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "weatherDescId")
    private List<WeatherNow> weatherNowList;

    public WeatherDesc()
    {
    }

    public WeatherDesc(Integer weatherDescId)
    {
        this.weatherDescId = weatherDescId;
    }

    public WeatherDesc(Integer weatherDescId, String weatherDescGr)
    {
        this.weatherDescId = weatherDescId;
        this.weatherDescGr = weatherDescGr;
    }

    public Integer getWeatherDescId()
    {
        return weatherDescId;
    }

    public void setWeatherDescId(Integer weatherDescId)
    {
        this.weatherDescId = weatherDescId;
    }

    public String getWeatherDescGr()
    {
        return weatherDescGr;
    }

    public void setWeatherDescGr(String weatherDescGr)
    {
        this.weatherDescGr = weatherDescGr;
    }

    @XmlTransient
    public List<Forecast> getForecastList()
    {
        return forecastList;
    }

    public void setForecastList(List<Forecast> forecastList)
    {
        this.forecastList = forecastList;
    }

    @XmlTransient
    public List<WeatherNow> getWeatherNowList()
    {
        return weatherNowList;
    }

    public void setWeatherNowList(List<WeatherNow> weatherNowList)
    {
        this.weatherNowList = weatherNowList;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (weatherDescId != null ? weatherDescId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WeatherDesc))
        {
            return false;
        }
        WeatherDesc other = (WeatherDesc) object;
        if ((this.weatherDescId == null && other.weatherDescId != null) || (this.weatherDescId != null && !this.weatherDescId.equals(other.weatherDescId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "model.WeatherDesc[ weatherDescId=" + weatherDescId + " ]";
    }
    
}
