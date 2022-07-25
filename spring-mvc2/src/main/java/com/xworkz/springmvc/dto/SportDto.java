package com.xworkz.springmvc.dto;

import org.springframework.stereotype.Component;

@Component
public class SportDto {

	
	private String sportName;
	private int noOfPlayers;
	private String captainName;
	private String sportCoach;
	private String sheduledDate;
	
	public SportDto() {

	}
	public String getSportName() {
		return sportName;
	}
	public void setSportName(String sportName) {
		this.sportName = sportName;
	}
	public int getNoOfPlayers() {
		return noOfPlayers;
	}
	public void setNoOfPlayers(int noOfPlayers) {
		this.noOfPlayers = noOfPlayers;
	}
	public String getCaptainName() {
		return captainName;
	}
	public void setCaptainName(String captainName) {
		this.captainName = captainName;
	}
	public String getSportCoach() {
		return sportCoach;
	}
	public void setSportCoach(String sportCoach) {
		this.sportCoach = sportCoach;
	}
	public String getSheduledDate() {
		return sheduledDate;
	}
	public void setSheduledDate(String sheduledDate) {
		this.sheduledDate = sheduledDate;
	}
	
	@Override
	public String toString() {
		return "SportDto [sportName=" + sportName + ", noOfPlayers=" + noOfPlayers + ", captainName=" + captainName
				+ ", sportCoach=" + sportCoach + ", sheduledDate=" + sheduledDate + "]";
	}
	
	
	
}
