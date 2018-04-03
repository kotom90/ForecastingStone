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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *   @ Νικήτογλου Ελευθέριος - std100152@ac.eap.gr
 *   @ Ρούσσου Άννα - std114276@ac.eap.gr   
 *   @ Σιδηρόπουλος Κωνσταντίνος - std114284@ac.eap.gr
 *   @ Τμήμα ΘΕΣ-2 2017-18
 */

@Embeddable
public class ForecastPK implements Serializable
{

    @Basic(optional = false)
    @Column(name = "DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dt;
    @Basic(optional = false)
    @Column(name = "CITY_ID")
    private int cityId;

    public ForecastPK()
    {
    }

    public ForecastPK(Date dt, int cityId)
    {
        this.dt = dt;
        this.cityId = cityId;
    }

    public Date getDt()
    {
        return dt;
    }

    public void setDt(Date dt)
    {
        this.dt = dt;
    }

    public int getCityId()
    {
        return cityId;
    }

    public void setCityId(int cityId)
    {
        this.cityId = cityId;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (dt != null ? dt.hashCode() : 0);
        hash += (int) cityId;
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ForecastPK))
        {
            return false;
        }
        ForecastPK other = (ForecastPK) object;
        if ((this.dt == null && other.dt != null) || (this.dt != null && !this.dt.equals(other.dt)))
        {
            return false;
        }
        if (this.cityId != other.cityId)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "model.ForecastPK[ dt=" + dt + ", cityId=" + cityId + " ]";
    }
    
}
