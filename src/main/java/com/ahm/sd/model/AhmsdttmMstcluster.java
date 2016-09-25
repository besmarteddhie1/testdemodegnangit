package com.ahm.sd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ahm.jx.model.AhmsdttmMstrules;

/**
 * Persistent class for entity stored in table "ahmsdttm_mstcluster"
 * Created on 7 Jun 2016 ( Time 06:37:35 )
 * @author BeSmart Team
 *
 */

@Entity
@Table(name="ahmsdttm_mstcluster")
public class AhmsdttmMstcluster extends AhmsdttmMstrules {

    private static final long serialVersionUID = 1L;
    
	public static final int TYPE_PROVINSI = 1;	
	public static final int TYPE_KABUPATEN = 2;    

    @Column(name="icluster")
    private Integer cluster;

    @Column(name="frangefrom")
    private Float rangeFrom;

    @Column(name="frangethru")
    private Float rangeThru;

    @Column(name="fgrowthrate")
    private Float growthRate;
    
	@Column(name="fupper")
	private Float upper;
	
	@Column(name="fmedian")
	private Float median;
	
	@Column(name="flower")
	private Float lower;
	
	@Column(name="isequence")
	private Integer sequence;	

    @Column(name="idclutyp")
    private Integer idClusterType;    

    public AhmsdttmMstcluster() {
		super();
    }
    
    public void setCluster( Integer cluster ) {
        this.cluster = cluster;
    }

    public Integer getCluster() {
        return this.cluster;
    }
  
    public void setRangeFrom( Float rangeFrom ) {
        this.rangeFrom = rangeFrom;
    }

    public Float getRangeFrom() {
        return this.rangeFrom;
    }
  
    public void setRangeThru( Float rangeThru ) {
        this.rangeThru = rangeThru;
    }

    public Float getRangeThru() {
        return this.rangeThru;
    }
  
    public void setGrowthRate( Float growthRate ) {
        this.growthRate = growthRate;
    }

    public Float getGrowthRate() {
        return this.growthRate;
    }
  
	public Float getUpper() {
		return upper;
	}

	public void setUpper(Float upper) {
		this.upper = upper;
	}

	public Float getMedian() {
		return median;
	}

	public void setMedian(Float median) {
		this.median = median;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Float getLower() {
		return lower;
	}

	public void setLower(Float lower) {
		this.lower = lower;
	}

	public Integer getIdClusterType() {
		return idClusterType;
	}

	public void setIdClusterType(Integer idClusterType) {
		this.idClusterType = idClusterType;
	}

	@Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(super.toString());
        sb.append("]:"); 
        sb.append(cluster);
        sb.append("|");
        sb.append(rangeFrom);
        sb.append("|");
        sb.append(rangeThru);
        sb.append("|");
        sb.append(growthRate);
        return sb.toString(); 
    } 

}
