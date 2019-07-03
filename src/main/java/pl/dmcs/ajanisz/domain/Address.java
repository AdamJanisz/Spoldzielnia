package pl.dmcs.ajanisz.domain;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;

@Table(name="address",uniqueConstraints = {@UniqueConstraint(columnNames = { "city", "street","buildingNumber" } )})
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    private String city;
    private String street;
    private String buildingNumber;

    private int electricityPrice;
    private int hotWaterPrice;
    private int coldWaterPrice;
    private int sewagePrice;
    private int repairFundPrice;
    @ManyToOne
    private AppUser owner;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "appartmentAddress")
    private List<Appartment> appartmentList;

    public AppUser getOwner() { return owner; }

    public void setOwner(AppUser owner) { this.owner = owner; }

    public List<Appartment> getAppartmentList() { return appartmentList; }

    public void setAppartmentList(List<Appartment> appartmentList) { this.appartmentList = appartmentList; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public int getElectricityPrice() { return electricityPrice; }

    public void setElectricityPrice(int electricityPrice) { this.electricityPrice = electricityPrice; }

    public int getHotWaterPrice() { return hotWaterPrice; }

    public void setHotWaterPrice(int hotWaterPrice) { this.hotWaterPrice = hotWaterPrice; }

    public int getColdWaterPrice() { return coldWaterPrice; }

    public void setColdWaterPrice(int coldWaterPrice) { this.coldWaterPrice = coldWaterPrice; }

    public int getSewagePrice() { return sewagePrice; }

    public void setSewagePrice(int sewagePrice) { this.sewagePrice = sewagePrice; }

    public int getRepairFundPrice() { return repairFundPrice; }

    public void setRepairFundPrice(int repairFundPrice) { this.repairFundPrice = repairFundPrice; }
}
