package pl.dmcs.ajanisz.domain;

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

//    @OneToMany(mappedBy = "address",fetch = FetchType.EAGER)
//    private List<AppUser> appUserList;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "appartmentAddress")
    private List<Appartment> appartmentList;


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

//    public List<AppUser> getAppUserList() {
//        return appUserList;
//    }
//
//    public void setAppUserList(List<AppUser> appUserList) {
//        this.appUserList = appUserList;
//    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }
}
