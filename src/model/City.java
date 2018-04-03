/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *   @ Νικήτογλου Ελευθέριος - std100152@ac.eap.gr
 *   @ Ρούσσου Άννα - std114276@ac.eap.gr   
 *   @ Σιδηρόπουλος Κωνσταντίνος - std114284@ac.eap.gr
 *   @ Τμήμα ΘΕΣ-2 2017-18
 */

@Entity
@Table(name = "CITY")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c")
    , @NamedQuery(name = "City.findByCityId", query = "SELECT c FROM City c WHERE c.cityId = :cityId")
    , @NamedQuery(name = "City.findByCityName", query = "SELECT c FROM City c WHERE c.cityName = :cityName")
    //custom queries
    , @NamedQuery(name = "City.deleteAll", query = "DELETE FROM City") // Διαγραφή στοιχείων του πίνακα City
})
public class City implements Serializable
{

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CITY_ID")
    private Integer cityId;
    @Basic(optional = false)
    @Column(name = "CITY_NAME")
    private String cityName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    private List<Forecast> forecastList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    private List<WeatherNow> weatherNowList;

    public City()
    {
    }

    public City(Integer cityId)
    {
        this.cityId = cityId;
    }

    public City(Integer cityId, String cityName)
    {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public Integer getCityId()
    {
        return cityId;
    }

    public void setCityId(Integer cityId)
    {
        Integer oldCityId = this.cityId;
        this.cityId = cityId;
        changeSupport.firePropertyChange("cityId", oldCityId, cityId);
    }

    public String getCityName()
    {
        return cityName;
    }

    public void setCityName(String cityName)
    {
        String oldCityName = this.cityName;
        this.cityName = cityName;
        changeSupport.firePropertyChange("cityName", oldCityName, cityName);
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
        hash += (cityId != null ? cityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof City))
        {
            return false;
        }
        City other = (City) object;
        if ((this.cityId == null && other.cityId != null) || (this.cityId != null && !this.cityId.equals(other.cityId)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "model.City[ cityId=" + cityId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
