package pl.dmcs.ajanisz.domain;

import javax.persistence.*;

@Entity
@Table(name="bills")
public class Bills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String electricity;
    private String hotWater;
    private String coldWater;
    private String sewage;
    private String repairFund;

    @OneToOne
    private AppUser appUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getElectricity() {
        return electricity;
    }

    public void setElectricity(String electricity) {
        this.electricity = electricity;
    }

    public String getHotWater() {
        return hotWater;
    }

    public void setHotWater(String hotWater) {
        this.hotWater = hotWater;
    }

    public String getColdWater() {
        return coldWater;
    }

    public void setColdWater(String coldWater) {
        this.coldWater = coldWater;
    }

    public String getSludge() {
        return sewage;
    }

    public void setSludge(String sewage) {
        this.sewage = sewage;
    }

    public String getRepairFund() {
        return repairFund;
    }

    public void setRepairFund(String repairFund) {
        this.repairFund = repairFund;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}
