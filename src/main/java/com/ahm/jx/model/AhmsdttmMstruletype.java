package com.ahm.jx.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.ahm.jx.model.BaseEntity;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.ahm.jx.config.EntityDomain;

/**
 * Persistent class for entity stored in table "ahmjxmst_rule_type"
 * Created on 7 Jun 2016 ( Time 06:48:21 )
 * @author BeSmart Team
 *
 */

@Entity
@Table(name="ahmsdttm_mstruletype")
@Inheritance(strategy=InheritanceType.JOINED)
public class AhmsdttmMstruletype extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idruletype", nullable=false)
    private Integer idRuleType;

    @Column(name="vdescription", length=EntityDomain.LENGTH_DESCRIPTION)
    private String description;

    @OneToMany(mappedBy="parentType", targetEntity=AhmsdttmMstruletype.class)
    private List<AhmsdttmMstruletype> listOfRuleType;

    @OneToMany(mappedBy="ruleType", targetEntity=AhmsdttmMstrules.class)
    private List<AhmsdttmMstrules> listOfRules;

    @ManyToOne
    @JoinColumn(name="idprnrultyp", referencedColumnName="idruletype")
    private AhmsdttmMstruletype parentType;

    public AhmsdttmMstruletype() {
		super();
    }
    
    public void setIdRuleType( Integer idRuleType ) {
        this.idRuleType = idRuleType ;
    }

    public Integer getIdRuleType() {
        return this.idRuleType;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
 
	public List<AhmsdttmMstruletype> getListOfRuleType() {
		return listOfRuleType;
	}

	public void setListOfRuleType(List<AhmsdttmMstruletype> listOfRuleType) {
		this.listOfRuleType = listOfRuleType;
	}

	public List<AhmsdttmMstrules> getListOfRules() {
		return listOfRules;
	}

	public void setListOfRules(List<AhmsdttmMstrules> listOfRules) {
		this.listOfRules = listOfRules;
	}

	public AhmsdttmMstruletype getParentType() {
		return parentType;
	}

	public void setParentType(AhmsdttmMstruletype parentType) {
		this.parentType = parentType;
	}

	@Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(idRuleType);
        sb.append("]:"); 
        sb.append(description);
        return sb.toString(); 
    } 

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(getIdRuleType())
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmsdttmMstruletype)) return false;
		AhmsdttmMstruletype other = (AhmsdttmMstruletype) obj;
		return new EqualsBuilder()
				.append(getIdRuleType(),other.getIdRuleType())
				.isEquals();
	}
}
