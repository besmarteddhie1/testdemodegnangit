package com.ahm.jx.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@MappedSuperclass
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 4937288612298227896L;
	
	@Column(name="vcrea", length=60)
	@CreatedBy
	private String createBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dcrea")
	@CreatedDate
	private Date dateCreate;		
	
	@Column(name="vmodi", length=60)
	@LastModifiedBy
	private String modiBy;		
			
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dmodi")
	@LastModifiedDate
	private Date dateModi;
	
	@Version
	@Column(name="iversion")
	private Integer lockVersion;	

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getModiBy() {
		return modiBy;
	}

	public void setModiBy(String modiBy) {
		this.modiBy = modiBy;
	}

	public Integer getLockVersion() {
		return lockVersion;
	}

	public void setLockVersion(Integer lockVersion) {
		this.lockVersion = lockVersion;
	}

	public Date getDateCreate() {
		return dateCreate;
	}

	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}

	public Date getDateModi() {
		return dateModi;
	}

	public void setDateModi(Date dateModi) {
		this.dateModi = dateModi;
	}
	
	@PrePersist
	@PreUpdate
	protected void preUpdate() {
	}
	
}
