package p3_package.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Reiziger {
	private int reizigerid;
	private String voorletters;
	private String tussenvoegsel = "";
	private String achternaam;
	private Date geboorteDatum;
	public ArrayList<Ov_Chipkaart> ovC = new ArrayList();

	// all general information from Reiziger, as taken from the database
	public Reiziger() {
	}

	public int getReizigerid() {
		return reizigerid;
	}

	public void setReizigerid(int reizigerid) {
		this.reizigerid = reizigerid;
	}

	public String getVoorletters() {
		return voorletters;
	}

	public void setVoorletters(String voorletters) {
		this.voorletters = voorletters;
	}

	public String getTussenvoegsel() {
		return tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		if (tussenvoegsel != null) {
			this.tussenvoegsel = tussenvoegsel;
		} else {
			this.tussenvoegsel = "";
		}
	}

	public String getAchternaam() {
		return achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public Date getGeboorteDatum() {
		return geboorteDatum;
	}

	public void setGeboorteDatum(Date geboorteDatum) {
		this.geboorteDatum = geboorteDatum;
	}

	public ArrayList<Ov_Chipkaart> getOvC() {
		return ovC;
	}

	public void setOvC(ArrayList<Ov_Chipkaart> ovC) {
		this.ovC = ovC;
	}

	@Override
	public String toString() {
		return "Reiziger [reizigerid=" + reizigerid + ", voorletters=" + voorletters + ", tussenvoegsel="
				+ tussenvoegsel + ", achternaam=" + achternaam + ", geboorteDatum=" + geboorteDatum + ", ovC=" + ovC
				+ "]";
	}

}
