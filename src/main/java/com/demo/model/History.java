package com.demo.model;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Builder;


@Entity
@Table(name="History")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class History implements  Serializable  {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GenericGenerator(name="gen",strategy="increment")
	@GeneratedValue(generator="gen")
	@Column(name="History_ID", unique = true, nullable = false, precision = 15, scale = 0)
	private Long historyID;
	@Column(name="Classification")
	private String classification;	
	@Column(name="ObjectId")
	private String objectId;
	@Column(name="UserEmail")
	private String userEmail;
	@Column(name="UserName")
	private String userName;
	@Column(name="Action")
	private String action;
	@Column(name="DateTime")
	private String dateTime;
	@Column(name="Quantity")
	private int quantity;
	@Column(name="DataField1")
	private String dataField1;
	@Column(name="DataField2")
	private String dataField2;
	@Column(name="Description")
	private String description;
	
	//for Head Office
	@Column(name="HO_ObjectID")
	private String hoObjectId;
	@Column(name="Spares_Recieved_By")
	private String hoSpareRecievedBy;
	@Column(name="Action_HO_Spares")
	private String hoActionSpares;
	@Column(name="Date_Spares_Recieved")
	private String hoDateSpareRecieved;
	@Column(name="Supplier_Name")
	private String hoSupplierName;
	@Column(name="Supplier_Order_No")
	private String hoSupplierOrderNo;
	@Column(name="Quantity_Recieved")
	private int hoQuantityRecieved;
}

