package pl.dmcs.ajanisz.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name="bills")
public class Bills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private boolean confirmed;
    private int electricity;
    private int hotWater;
    private int coldWater;
    private int sewage;
    private int repairFund;
    private int totalAmount;
    //@DateTimeFormat
    private String date;

    @ManyToOne
    private AppUser appUser;


    public boolean isConfirmed() { return confirmed; }

    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(long id) { this.id = id; }

    public long getId() {
        return id;
    }

    public AppUser getAppUser() { return appUser; }

    public void setAppUser(AppUser appUser) { this.appUser = appUser; }

    public int getElectricity() {
        return electricity;
    }

    public void setElectricity(int electricity) {
        this.electricity = electricity;
    }

    public int getHotWater() {
        return hotWater;
    }

    public void setHotWater(int hotWater) {
        this.hotWater = hotWater;
    }

    public int getColdWater() {
        return coldWater;
    }

    public void setColdWater(int coldWater) {
        this.coldWater = coldWater;
    }

    public int getSewage() {
        return sewage;
    }

    public void setSewage(int sewage) {
        this.sewage = sewage;
    }

    public int getRepairFund() {
        return repairFund;
    }

    public void setRepairFund(int repairFund) {
        this.repairFund = repairFund;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
}
