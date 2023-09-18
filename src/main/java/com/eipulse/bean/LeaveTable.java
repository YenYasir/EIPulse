package com.eipulse.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LeaveTable")
public class LeaveTable {

	@Column(name = "Textle")
	private String textle;
	@Id
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FormId", referencedColumnName = "formId")
	private FormRecord formRecord;

	public String getTextle() {
		return textle;
	}

	public void setTextle(String textle) {
		this.textle = textle;
	}

	public FormRecord getFormRecord() {
		return formRecord;
	}

	public void setFormRecord(FormRecord formRecord) {
		this.formRecord = formRecord;
	}

	public LeaveTable() {
		super();
	}

}
