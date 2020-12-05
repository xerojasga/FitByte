/*
 */

package entrenador.models;

import java.sql.Date;

/**
 * 
 * @author developer 
 */
public class Coach {
    int id_coach; 
    int id_user;
    boolean Verified;
    float Score;
    long Contact_Number;
    
    public Coach() {}

    public Coach(int id_coach, int id_user, boolean Verified, float Score,long Contact_Number) {
        this.id_coach = id_coach;
         this.id_coach=id_coach; 
         this.id_user=id_user;
         this.Verified=Verified;
         this.Score=Score;
         this.Contact_Number=Contact_Number;
    }
    
public int getId_coach() { return id_coach;}
 public int getId_user() {return id_user;}
public float getScore() {return Score;}
public boolean isVerified() {return Verified;}
public long getContact_Number() {return Contact_Number;}

public void setId_coach(int id_coach) {this.id_coach = id_coach;}
 public void setId_user(int id_user) {this.id_user = id_user;}
public void setScore(float Score) {this.Score=Score;}
public void setVerified(boolean Verified) {this.Verified=Verified;}
public void setContact_Number(long Contact_Number) {this.Contact_Number = Contact_Number;}
}
