package com.ahm.jx.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.ahm.jx.config.EntityDomain;

/**
 * Persistent class for entity stored in table "ahmjxmst_geo_boundary"
 * Created on 6 Jun 2016 ( Time 22:54:19 )
 * @author BeSmart Team
 *
 */

@Entity
@Table(name="ahmsdttm_mstgeobou")
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="idgeoboutype", discriminatorType=DiscriminatorType.INTEGER)
public class AhmsdttmMstgeobou extends BaseEntity {

	private static final long serialVersionUID = 4318067752688227150L;

	@Id
    @Column(name="vidgeobou", nullable=false, length=EntityDomain.LENGTH_UUID)
    private String idGeoBoundary;

    @Column(name="vidgeo", length=EntityDomain.LENGTH_ID_STRING)
    private String idGeo;
    
    @Column(name="vidgeoserver", length=EntityDomain.LENGTH_ID_STRING)
    private String idGeoServer; 

    @Column(name="vname", length=EntityDomain.LENGTH_NAME)
    private String name;

    @Column(name="vdescription", length=EntityDomain.LENGTH_DESCRIPTION)
    private String description;

    @Column(name="findexpotensi")
    private Float indexPotensi;

    @Column(name="fconsumerrate")
    private Float consumerRate;
    
    @Column(name="vidprnbou", insertable=false, updatable=false)
    private String idParentGeoBoundary;    

    @ManyToOne
    @JoinColumn(name="vidprnbou", referencedColumnName="vidgeobou")
    private AhmsdttmMstgeobou parentBoundary;

    @OneToMany(cascade={CascadeType.MERGE, CascadeType.REMOVE}, mappedBy="parentBoundary")
    @MapKeyColumn(name="vidgeo")
    private Map<String, AhmsdttmMstgeobou> boundaries = new HashMap<String, AhmsdttmMstgeobou>();

    public AhmsdttmMstgeobou() {
		super();
    }
     
    public void setIdGeoBoundary( String idGeoBoundary ) {
        this.idGeoBoundary = idGeoBoundary ;
    }

    public String getIdGeoBoundary() {
        return this.idGeoBoundary;
    }

    public void setIdGeo( String idGeo ) {
        this.idGeo = idGeo;
    }

    public String getIdGeo() {
        return this.idGeo;
    }
  
    public String getIdGeoServer() {
		return idGeoServer;
	}

	public void setIdGeoServer(String idGeoServer) {
		this.idGeoServer = idGeoServer;
	}

	public void setName( String name ) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
  
    public void setDescription( String description ) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
  
    public void setIndexPotensi( Float indexPotensi ) {
        this.indexPotensi = indexPotensi;
    }

    public Float getIndexPotensi() {
        return this.indexPotensi;
    }
  
	public AhmsdttmMstgeobou getParentBoundary() {
		return parentBoundary;
	}

	public void setParentBoundary(AhmsdttmMstgeobou parentBoundary) {
		this.parentBoundary = parentBoundary;
	}

	public String getIdParentGeoBoundary() {
		return idParentGeoBoundary;
	}

	public void setIdParentGeoBoundary(String idParentGeoBoundary) {
		this.idParentGeoBoundary = idParentGeoBoundary;
	}

	public Float getConsumerRate() {
		return consumerRate;
	}

	public void setConsumerRate(Float consumerRate) {
		this.consumerRate = consumerRate;
	}
	
	public void addChilds(AhmsdttmMstgeobou d) {		
		if (boundaries.containsKey(d.getIdGeo())) return;
		d.setParentBoundary(this);
		boundaries.put(d.getIdGeo(), d);
	}
	
	public List<AhmsdttmMstgeobou> listChilds() {
		return new ArrayList<AhmsdttmMstgeobou>(getBoundaries().values());
	}

	public Map<String, AhmsdttmMstgeobou> getBoundaries() {
		return boundaries;
	}

	public void setBoundaries(Map<String, AhmsdttmMstgeobou> boundaries) {
		this.boundaries = boundaries;
	}
	
	@Override
	protected void preUpdate() {
		super.preUpdate();
		if (this.idGeoBoundary == null) {
			this.idGeoBoundary = UUID.randomUUID().toString();
		}		
	}

	@Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(idGeoBoundary);
        sb.append("]:"); 
        sb.append(idGeo);
        sb.append("|");
        sb.append(name);
        sb.append("|");
        sb.append(description);
        sb.append("|");
        sb.append(indexPotensi);
        sb.append("|");
        sb.append(consumerRate);
        return sb.toString(); 
    } 

	@Override
	public int hashCode() {
		return new HashCodeBuilder()
				.append(getIdGeoBoundary())
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof AhmsdttmMstgeobou)) return false;
		AhmsdttmMstgeobou other = (AhmsdttmMstgeobou) obj;
		return new EqualsBuilder()
				.append(getIdGeoBoundary(),other.getIdGeoBoundary())
				.isEquals();
	}
}
