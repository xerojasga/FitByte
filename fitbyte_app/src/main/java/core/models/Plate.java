package com.core.models;

/*
@author kevin
*/

public class Plate{

	private int plateID;
	private String plateName;
	private String plateDescription;
	private String plateRecipee;
	private boolean platePublic;

	public Plate(){}
	public Plate (int plateID){this.plateID=plateID;}
        public Plate(int plateID, String plateName){
		this.plateID=plateID;
		this.plateName=plateName;
		this.platePublic=true;
	}
	public Plate(int plateID, String plateName, String plateDescription){
        this.plateID=plateID;
		this.plateName=plateName;
		this.plateDescription=plateDescription;
		this.platePublic=true;		
	}
	public Plate(int plateID, String plateName, String plateDescription, String plateRecipee){
		this.plateID=plateID;
		this.plateName=plateName;
		this.plateDescription=plateDescription;
		this.plateRecipee=plateRecipee;
		this.platePublic=true;
	}
	public Plate(int plateID, String plateName, String plateDescription, String plateRecipee, boolean platePublic){
		this.plateID=plateID;
		this.plateName=plateName;
		this.plateDescription=plateDescription;
		this.plateRecipee=plateRecipee;
		this.platePublic=platePublic;
	}

     public void setPlateID(int plateID){this.plateID=plateID;}
     public void setPlateName(String plateName){this.plateName=plateName;}
     public void setPlateDescription(String plateDescription){this.plateDescription=plateDescription;}
     public void setPlateRecipee(String plateRecipee){this.plateRecipee=plateRecipee;}
     public void setPlatePublic(Boolean platePublic){this.platePublic=platePublic;}

     public int getPlateID(){return plateID;}
     public String getPlateName(){return plateName;}
     public String getPlateDescription(){return plateDescription;}
     public String getPlateRecipee(){return plateRecipee;}
     public boolean getPlatePublic(){return platePublic;}

}