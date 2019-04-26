package com.pramati.flashsale.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass()
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditingEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2266421363637403069L;

	private @Column(name = "created_date",
			updatable = false) @Temporal(TemporalType.TIMESTAMP) @CreatedDate Date createdDate;
	private @Column(name = "modified_date") @Temporal(TemporalType.TIMESTAMP) @LastModifiedDate Date modifiedDate;
	

}
