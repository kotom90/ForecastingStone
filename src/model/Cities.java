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
@Table(name = "CITIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cities.findAll", query = "SELECT c FROM Cities c")
    , @NamedQuery(name = "Cities.findByCityid", query = "SELECT c FROM Cities c WHERE c.cityid = :cityid")
    , @NamedQuery(name = "Cities.findByCityname", query = "SELECT c FROM Cities c WHERE c.cityname = :cityname")})
public class Cities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CITYID")
    private Long cityid;
    @Column(name = "CITYNAME")
    private String cityname;
    @OneToMany(mappedBy = "cityid")
    private List<Forecasts> forecastsList;
    @OneToMany(mappedBy = "cityid")
    private List<WeatherNow> weatherNowList;

    public Cities() {
    }

    public Cities(Long cityid) {
        this.cityid = cityid;
    }

    public Long getCityid() {
        return cityid;
    }

    public void setCityid(Long cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
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
        hash += (cityid != null ? cityid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cities)) {
            return false;
        }
        Cities other = (Cities) object;
        if ((this.cityid == null && other.cityid != null) || (this.cityid != null && !this.cityid.equals(other.cityid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Cities[ cityid=" + cityid + " ]";
    }
    
}
