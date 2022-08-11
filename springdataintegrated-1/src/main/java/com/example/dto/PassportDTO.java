package com.example.dto;

import java.time.LocalDate;
import java.util.Objects;

public class PassportDTO {
	private int id;
	private LocalDate dateOfIssue;
	private LocalDate dateOfExpiry;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(LocalDate dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public LocalDate getDateOfExpiry() {
		return dateOfExpiry;
	}
	public void setDateOfExpiry(LocalDate dateOfExpiry) {
		this.dateOfExpiry = dateOfExpiry;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dateOfExpiry, dateOfIssue, id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassportDTO other = (PassportDTO) obj;
		return Objects.equals(dateOfExpiry, other.dateOfExpiry) && Objects.equals(dateOfIssue, other.dateOfIssue)
				&& id == other.id;
	}
	@Override
	public String toString() {
		return "PassportDTO [id=" + id + ", dateOfIssue=" + dateOfIssue + ", dateOfExpiry=" + dateOfExpiry + "]";
	}
	
}
