package com.eipulse.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "formeventlog")
public class FormEventLog {

	@Id
	@Column(name = "EventId")
	private int eventId;
	@Column(name = "Sequence")
	private int sequence;
	@Column(name = "FormStatus")
	private String formStatus;
	@Column(name = "StartDate")
	private String startDate;
	@Column(name = "EndDate")
	private String endDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FormId", referencedColumnName = "formId")
	private FormRecord formRecord;

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}


	public String getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public FormRecord getFormRecord() {
		return formRecord;
	}

	public void setFormRecord(FormRecord formRecord) {
		this.formRecord = formRecord;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public FormEventLog() {
	}

}
