package org.comfort.comfortapi.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.comfort.comfortapi.model.Sponsor;





public class SponsorDto {

	private Long id;
	@NotNull @NotEmpty
	private String firstName;
	@NotNull @NotEmpty
	private String lastName;

	public SponsorDto() {
	}

	public SponsorDto(Sponsor sponsor) {
		this.firstName = sponsor.getFirstName();
		this.lastName = sponsor.getLastName();
		this.id = sponsor.getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
