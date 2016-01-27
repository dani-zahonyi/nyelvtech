package csaladfa_DOM;

import java.util.ArrayList;

public class Szemely {
	
private String nev;
private String szuletesi_ido;

public ArrayList<String> testverekid = new ArrayList<String>();
public ArrayList<String> gyerekekid = new ArrayList<String>();
public String hazastarsid;

private ArrayList<Szemely> testverek = new ArrayList<Szemely>();
private ArrayList<Szemely> gyerekek = new ArrayList<Szemely>();
private Szemely hazastars;
private String id;
private String nem;


public Szemely(String nev, String szuletesi_ido, String id, String nem) {
	super();
	this.nev = nev;
	this.szuletesi_ido = szuletesi_ido;
	this.id = id;
	this.nem = nem;
}

public Szemely addHazastars(Szemely e){
	this.hazastars=e;
	return this;
}

public ArrayList<String> getTestverekid() {
	return testverekid;
}

public Szemely setTestverekid(ArrayList<String> testverekid) {
	this.testverekid = testverekid;
	return this;
}

public ArrayList<String> getGyerekekid() {
	return gyerekekid;
}

public Szemely setGyerekekid(ArrayList<String> gyerekekid) {
	this.gyerekekid = gyerekekid;
	return this;
}

public String getHazastarsid() {
	return hazastarsid;
}

public Szemely setHazastarsid(String hazastarsid) {
	this.hazastarsid = hazastarsid;
	return this;
}

public void addGyerek(Szemely e){
	for(Szemely gyerek:gyerekek){
		if(gyerek.getNev()==e.nev)
			return;
	}
	gyerekek.add(e);
}

public void addTestver(Szemely e){
	
	for(Szemely testver:testverek)
		if(testver.getNev()==e.nev)
			return;
		
	
	
	testverek.add(e);
	
	e.addTestver(this);
	
}

public String getNev() {
	return nev;
}
public void setNev(String nev) {
	this.nev = nev;
}
public String getSzuletesi_ido() {
	return szuletesi_ido;
}
public void setSzuletesi_ido(String szuletesi_ido) {
	this.szuletesi_ido = szuletesi_ido;
}
public ArrayList<Szemely> getTestverek() {
	return testverek;
}
public void setTestverek(ArrayList<Szemely> testverek) {
	this.testverek = testverek;
}
public ArrayList<Szemely> getGyerekek() {
	return gyerekek;
}
public void setGyerekek(ArrayList<Szemely> gyerekek) {
	this.gyerekek = gyerekek;
}
public Szemely getHazastars() {
	return hazastars;
}
public void setHazastars(Szemely hazastars) {
	this.hazastars = hazastars;
}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public String getNem() {
	return nem;
}
public void setNem(String nem) {
	this.nem = nem;
}

private String testverek(){
	StringBuilder nevek = new StringBuilder();
	
	for(Szemely e:testverek)
		nevek.append(e.getNev()+", ");
	
	return nevek.toString();
}

@Override
	public String toString() {
		
		return "\n"+nev+"\n"+szuletesi_ido+"\n"+nem+"\nTestverek: \n"+testverek();
	}

}
