package com.cafimanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="spring_session")
@Entity
public class AA implements Serializable{

	@Column(name="PRIMARY_ID")
	private  String PRIMARY_ID ;
	
	@Column(name="SESSION_ID")
	private  String SESSION_ID ;
	
	@Column(name="CREATION_TIME")
	private  long CREATION_TIME ;
	
	@Column(name="LAST_ACCESS_TIME")
	private  long LAST_ACCESS_TIME ;
	
	
	@Column(name="MAX_INACTIVE_INTERVAL")
	private  int MAX_INACTIVE_INTERVAL ;
	
	@Column(name="EXPIRY_TIME")
	private  long EXPIRY_TIME ;
	
	
	@Column(name="PRINCIPAL_NAME")
	private  String PRINCIPAL_NAME ;


	public AA() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AA(String pRIMARY_ID, String sESSION_ID, long cREATION_TIME, long lAST_ACCESS_TIME,
			int mAX_INACTIVE_INTERVAL, long eXPIRY_TIME, String pRINCIPAL_NAME) {
		super();
		PRIMARY_ID = pRIMARY_ID;
		SESSION_ID = sESSION_ID;
		CREATION_TIME = cREATION_TIME;
		LAST_ACCESS_TIME = lAST_ACCESS_TIME;
		MAX_INACTIVE_INTERVAL = mAX_INACTIVE_INTERVAL;
		EXPIRY_TIME = eXPIRY_TIME;
		PRINCIPAL_NAME = pRINCIPAL_NAME;
	}


	public String getPRIMARY_ID() {
		return PRIMARY_ID;
	}


	public void setPRIMARY_ID(String pRIMARY_ID) {
		PRIMARY_ID = pRIMARY_ID;
	}


	public String getSESSION_ID() {
		return SESSION_ID;
	}


	public void setSESSION_ID(String sESSION_ID) {
		SESSION_ID = sESSION_ID;
	}


	public long getCREATION_TIME() {
		return CREATION_TIME;
	}


	public void setCREATION_TIME(long cREATION_TIME) {
		CREATION_TIME = cREATION_TIME;
	}


	public long getLAST_ACCESS_TIME() {
		return LAST_ACCESS_TIME;
	}


	public void setLAST_ACCESS_TIME(long lAST_ACCESS_TIME) {
		LAST_ACCESS_TIME = lAST_ACCESS_TIME;
	}


	public int getMAX_INACTIVE_INTERVAL() {
		return MAX_INACTIVE_INTERVAL;
	}


	public void setMAX_INACTIVE_INTERVAL(int mAX_INACTIVE_INTERVAL) {
		MAX_INACTIVE_INTERVAL = mAX_INACTIVE_INTERVAL;
	}


	public long getEXPIRY_TIME() {
		return EXPIRY_TIME;
	}


	public void setEXPIRY_TIME(long eXPIRY_TIME) {
		EXPIRY_TIME = eXPIRY_TIME;
	}


	public String getPRINCIPAL_NAME() {
		return PRINCIPAL_NAME;
	}


	public void setPRINCIPAL_NAME(String pRINCIPAL_NAME) {
		PRINCIPAL_NAME = pRINCIPAL_NAME;
	}
	
	
	
}
