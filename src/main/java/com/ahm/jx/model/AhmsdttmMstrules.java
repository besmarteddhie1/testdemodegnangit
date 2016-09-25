
package com.ahm.jx.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ahm.jx.model.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.joda.time.DateTime;

import com.ahm.jx.config.EntityDomain;

/**
 * Persistent class for entity stored in table "ahmsdttm_mstrules"
 * Created on 7 Jun 2016 ( Time 06:16:35 )
 * @author BeSmart Team
 *
 */

@Entity
@Table(name="ahmsdttm_mstrules")
@Inheritance(strategy=InheritanceType.JOINED)
public class AhmsdttmMstrules extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idrule", nullable=false)
    private Integer idRule;

    @Column(name="vdescription", length=EntityDomain.LENGTH_DESCRIPTION)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dtfrom", nullable=false)
    private Date dateFrom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dtthru", nullable=false)
    private Date dateThru;

    @ManyToOne
    @JoinColumn(name="idruletype", referencedColumnName="idruletype", insertable=false, updatable=false)
    private AhmsdttmMstruletype ruleType;
    
    @Column(name="idruletype")
    private Integer idRuleType;    

    public AhmsdttmMstrules() {
		super();
    }
    
    public AhmsdttmMstrules(Integer id, String desc) {
		super();
		this.idRule = id;
		this.description = desc;
    }    
    
    public void setIdRule( Integer idRule ) {
        this.idRule = idRule ;
    }

    public Integer getIdRule() {
        return this.idRule;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
  
    public void setDateFrom( Date dateFrom ) {
        this.dateFrom = dateFrom;
    }

    public Date getDateFrom() {
        return this.dateFrom;
    }
  
    public void setDateThru( Date dateThru ) {
        this.dateThru = dateThru;
    }

    public Date getDateThru() {
        return this.dateThru;
    }

	public AhmsdttmMstruletype getRuleType() {
		return ruleType;
	}

	public void setRuleType(AhmsdttmMstruletype ruleType) {
		this.ruleType = ruleType;
	}

	public Integer getIdRuleType() {
		return idRuleType;
	}

	public void setIdRuleType(Integer idRuleType) {
		this.idRuleType = idRuleType;
	}

	@Override
	protected void preUpdate() {
		super.preUpdate();
		
		if (this.dateFrom == null)
			this.dateFrom = new Date();
		
		if (this.dateThru == null)
			this.dateThru = new DateTime(2020, 12, 31, 23, 59, 59, 999).toDate();		
		
	}
	@Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(idRule);
        sb.append("]:"); 
        sb.append(description);
        sb.append("|");
        sb.append(dateFrom);
        sb.append("|");
        sb.append(dateThru);
        return sb.toString(); 
    } 

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(getIdRule())
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmsdttmMstrules)) return false;
		AhmsdttmMstrules other = (AhmsdttmMstrules) obj;
		return new EqualsBuilder()
				.append(getIdRule(),other.getIdRule())
				.isEquals();
	}
}
