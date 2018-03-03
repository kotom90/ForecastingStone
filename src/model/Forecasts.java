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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Aisha
 */
@Entity
@Table(name = "FORECASTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Forecasts.findAll", query = "SELECT f FROM Forecasts f")
    , @NamedQuery(name = "Forecasts.findById", query = "SELECT f FROM Forecasts f WHERE f.id = :id")
    , @NamedQuery(name = "Forecasts.findByCityid", query = "SELECT f FROM Forecasts f WHERE f.cityid = :cityid")
    , @NamedQuery(name = "Forecasts.findByCityname", query = "SELECT f FROM Forecasts f WHERE f.cityname = :cityname")
    , @NamedQuery(name = "Forecasts.findByDt", query = "SELECT f FROM Forecasts f WHERE f.dt = :dt")
    , @NamedQuery(name = "Forecasts.findByTemperature", query = "SELECT f FROM Forecasts f WHERE f.temperature = :temperature")
    , @NamedQuery(name = "Forecasts.findByDescription", query = "SELECT f FROM Forecasts f WHERE f.description = :description")
    , @NamedQuery(name = "Forecasts.findByCloudperc", query = "SELECT f FROM Forecasts f WHERE f.cloudperc = :cloudperc")
    , @NamedQuery(name = "Forecasts.findByRainheight", query = "SELECT f FROM Forecasts f WHERE f.rainheight = :rainheight")
    , @NamedQuery(name = "Forecasts.findBySnowheight", query = "SELECT f FROM Forecasts f WHERE f.snowheight = :snowheight")
    , @NamedQuery(name = "Forecasts.findByWindspeed", query = "SELECT f FROM Forecasts f WHERE f.windspeed = :windspeed")})
public class Forecasts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @Column(name = "CITYID")
    private Integer cityid;
    @Column(name = "CITYNAME")
    private String cityname;
    @Column(name = "DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TEMPERATURE")
    private Double temperature;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "CLOUDPERC")
    private Double cloudperc;
    @Column(name = "RAINHEIGHT")
    private Double rainheight;
    @Column(name = "SNOWHEIGHT")
    private Double snowheight;
    @Column(name = "WINDSPEED")
    private Double windspeed;

    public Forecasts() {
    }

    public Forecasts(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCityid() {
        return cityid;
    }

    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCloudperc() {
        return cloudperc;
    }

    public void setCloudperc(Double cloudperc) {
        this.cloudperc = cloudperc;
    }

    public Double getRainheight() {
        return rainheight;
    }

    public void setRainheight(Double rainheight) {
        this.rainheight = rainheight;
    }

    public Double getSnowheight() {
        return snowheight;
    }

    public void setSnowheight(Double snowheight) {
        this.snowheight = snowheight;
    }

    public Double getWindspeed() {
        return windspeed;
    }

    public void setWindspeed(Double windspeed) {
        this.windspeed = windspeed;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Forecasts)) {
            return false;
        }
        Forecasts other = (Forecasts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Forecasts[ id=" + id + " ]";
    }
    
}
