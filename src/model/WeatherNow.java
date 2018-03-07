/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lefteris
 */
@Entity
@Table(name = "WEATHER_NOW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WeatherNow.findAll", query = "SELECT w FROM WeatherNow w")
    , @NamedQuery(name = "WeatherNow.findByWeathernowid", query = "SELECT w FROM WeatherNow w WHERE w.weathernowid = :weathernowid")
    , @NamedQuery(name = "WeatherNow.findByMaintemp", query = "SELECT w FROM WeatherNow w WHERE w.maintemp = :maintemp")
    , @NamedQuery(name = "WeatherNow.findByCloudsall", query = "SELECT w FROM WeatherNow w WHERE w.cloudsall = :cloudsall")
    , @NamedQuery(name = "WeatherNow.findByWindspeed", query = "SELECT w FROM WeatherNow w WHERE w.windspeed = :windspeed")
    , @NamedQuery(name = "WeatherNow.findByDt", query = "SELECT w FROM WeatherNow w WHERE w.dt = :dt")
    , @NamedQuery(name = "WeatherNow.findByRain", query = "SELECT w FROM WeatherNow w WHERE w.rain = :rain")
    , @NamedQuery(name = "WeatherNow.findBySnow", query = "SELECT w FROM WeatherNow w WHERE w.snow = :snow")
    , @NamedQuery(name = "WeatherNow.findByIcon", query = "SELECT w FROM WeatherNow w WHERE w.icon = :icon")})
public class WeatherNow implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "WEATHERNOWID")
    private Long weathernowid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "MAINTEMP")
    private Double maintemp;
    @Column(name = "CLOUDSALL")
    private Double cloudsall;
    @Column(name = "WINDSPEED")
    private Double windspeed;
    @Column(name = "DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dt;
    @Column(name = "RAIN")
    private Double rain;
    @Column(name = "SNOW")
    private Double snow;
    @Column(name = "ICON")
    private String icon;
    @JoinColumn(name = "CITYID", referencedColumnName = "CITYID")
    @ManyToOne
    private Cities cityid;
    @JoinColumn(name = "WEATHER_DESC_ID", referencedColumnName = "WEATHER_DESC_ID")
    @ManyToOne
    private WeatherDescs weatherDescId;

    public WeatherNow() {
    }

    public WeatherNow(Long weathernowid) {
        this.weathernowid = weathernowid;
    }

    public Long getWeathernowid() {
        return weathernowid;
    }

    public void setWeathernowid(Long weathernowid) {
        this.weathernowid = weathernowid;
    }

    public Double getMaintemp() {
        return maintemp;
    }

    public void setMaintemp(Double maintemp) {
        this.maintemp = maintemp;
    }

    public Double getCloudsall() {
        return cloudsall;
    }

    public void setCloudsall(Double cloudsall) {
        this.cloudsall = cloudsall;
    }

    public Double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(Double windspeed) {
        this.windspeed = windspeed;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public Double getRain() {
        return rain;
    }

    public void setRain(Double rain) {
        this.rain = rain;
    }

    public Double getSnow() {
        return snow;
    }

    public void setSnow(Double snow) {
        this.snow = snow;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Cities getCityid() {
        return cityid;
    }

    public void setCityid(Cities cityid) {
        this.cityid = cityid;
    }

    public WeatherDescs getWeatherDescId() {
        return weatherDescId;
    }

    public void setWeatherDescId(WeatherDescs weatherDescId) {
        this.weatherDescId = weatherDescId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (weathernowid != null ? weathernowid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WeatherNow)) {
            return false;
        }
        WeatherNow other = (WeatherNow) object;
        if ((this.weathernowid == null && other.weathernowid != null) || (this.weathernowid != null && !this.weathernowid.equals(other.weathernowid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.WeatherNow[ weathernowid=" + weathernowid + " ]";
    }
    
}
