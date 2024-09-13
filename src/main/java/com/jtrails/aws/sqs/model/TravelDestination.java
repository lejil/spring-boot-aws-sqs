package com.jtrails.aws.sqs.model;

/**
 * @author Lejil
 *
 */

public class TravelDestination {

	private String destinationName;
	private String country;
	private String city;
	private String description;



	public String getDestinationName() {
		return destinationName;
	}

	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "TravelDestination [destinationName=" + destinationName + ", country=" + country + ", city=" + city
				+ ", description=" + description + "]";
	}



}