package com.ahm.sd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.ahm.jx.config.EntityDomain;
import com.ahm.jx.model.BaseEntity;

/**
 * Persistent class for entity stored in table "ahmsdttm_mstcluster_type"
 * Created on 6 Jun 2016 ( Time 22:54:20 )
 * @author BeSmart Team
 *
 */

@Entity
@Table(name="ahmsdttm_mstclustype")
public class AhmsdttmMstclustype extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idclutyp", nullable=false)
    private Integer idClusterType;

    @Column(name="vdescription", length=EntityDomain.LENGTH_DESCRIPTION)
    private String description;

    public AhmsdttmMstclustype() {
		super();
    }    
  
	public Integer getIdClusterType() {
		return idClusterType;
	}

	public void setIdClusterType(Integer idClusterType) {
		this.idClusterType = idClusterType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(idClusterType);
        sb.append("]:"); 
        sb.append(description);
        return sb.toString(); 
    } 

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(getIdClusterType())
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmsdttmMstclustype)) return false;
		AhmsdttmMstclustype other = (AhmsdttmMstclustype) obj;
		return new EqualsBuilder()
				.append(getIdClusterType(), other.getIdClusterType())
				.isEquals();
	}
}
