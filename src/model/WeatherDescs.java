/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
 *
 * @author Lefteris
 */
@Entity
@Table(name = "WEATHER_DESCS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WeatherDescs.findAll", query = "SELECT w FROM WeatherDescs w")
    , @NamedQuery(name = "WeatherDescs.findByWeatherDescId", query = "SELECT w FROM WeatherDescs w WHERE w.weatherDescId = :weatherDescId")
    , @NamedQuery(name = "WeatherDescs.findByWeatherDescGr", query = "SELECT w FROM WeatherDescs w WHERE w.weatherDescGr = :weatherDescGr")})
public class WeatherDescs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "WEATHER_DESC_ID")
    private Integer weatherDescId;
    @Column(name = "WEATHER_DESC_GR")
    private String weatherDescGr;
    @OneToMany(mappedBy = "weatherDescId")
    private List<Forecasts> forecastsList;
    @OneToMany(mappedBy = "weatherDescId")
    private List<WeatherNow> weatherNowList;

    public WeatherDescs() {
    }

    public WeatherDescs(Integer weatherDescId) {
        this.weatherDescId = weatherDescId;
    }

    public Integer getWeatherDescId() {
        return weatherDescId;
    }

    public void setWeatherDescId(Integer weatherDescId) {
        this.weatherDescId = weatherDescId;
    }

    public String getWeatherDescGr() {
        return weatherDescGr;
    }

    public void setWeatherDescGr(String weatherDescGr) {
        this.weatherDescGr = weatherDescGr;
    }

    @XmlTransient
    public List<Forecasts> getForecastsList() {
        return forecastsList;
    }

    public void setForecastsList(List<Forecasts> forecastsList) {
        this.forecastsList = forecastsList;
    }

    @XmlTransient
    public List<WeatherNow> getWeatherNowList() {
        return weatherNowList;
    }

    public void setWeatherNowList(List<WeatherNow> weatherNowList) {
        this.weatherNowList = weatherNowList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (weatherDescId != null ? weatherDescId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WeatherDescs)) {
            return false;
        }
        WeatherDescs other = (WeatherDescs) object;
        if ((this.weatherDescId == null && other.weatherDescId != null) || (this.weatherDescId != null && !this.weatherDescId.equals(other.weatherDescId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.WeatherDescs[ weatherDescId=" + weatherDescId + " ]";
    }
    
}
