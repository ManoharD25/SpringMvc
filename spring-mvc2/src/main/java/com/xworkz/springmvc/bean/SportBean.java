package com.xworkz.springmvc.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@NamedQuery(name = "SportBean.getAllSportDataDaoImpl", query = "from SportBean")
@NamedQuery(name = "SportBean.deleteBysportName", query = "delete from SportBean where sportName =:inputname or captainName =:inputname or  sportCoach =:inputname or sheduledDate =:inputnamessss")
@NamedQuery(name = "SportBean.searchBySportName", query = "from SportBean where sportName =:inputname  or captainName =:inputname or  sportCoach =:inputname or sheduledDate =:inputname")
@NamedQuery(name = "SportBean.updateSportBeanDao", query = "update SportBean set sportName =:SPORTNAME, noOfPlayers =:NOOFPLAYRES, captainName =:CAPTAINNAME, sportCoach =:SPORTCOACH, sheduledDate =:SHEDULEDDATE where sportName =:inputname or captainName =:inputname or  sportCoach =:inputname or sheduledDate =:inputname")


@Entity
@Table(name = "Sports_Table")
public class SportBean {

	@Id
	@GenericGenerator(name = "id", strategy = "increment")
	@GeneratedValue(generator = "id")
	private int sId;
	
	@Column(name = "sport_name")
	private String sportName;
	
	@Column(name = "no_of_players")
	private int noOfPlayers;
	
	@Column(name = "captain_name")
	private String captainName;
	
	@Column(name =  "sport_coach")
	private String sportCoach;
	
	@Column(name = "sheduled_date")
	private String sheduledDate;
	
	public SportBean(String sportName, int noOfPlayers, String captainName, String sportCoach,
			String sheduledDate) {
		this.sportName = sportName;
		this.noOfPlayers = noOfPlayers;
		this.captainName = captainName;
		this.sportCoach = sportCoach;
		this.sheduledDate = sheduledDate;
	}

	public SportBean() {

	}

	public int getsId() {
		return sId;
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
		return "SportBean [sId=" + sId + ", sportName=" + sportName + ", noOfPlayers=" + noOfPlayers + ", captainName="
				+ captainName + ", sportCoach=" + sportCoach + ", sheduledDate=" + sheduledDate + "]";
	}
	
	
}
