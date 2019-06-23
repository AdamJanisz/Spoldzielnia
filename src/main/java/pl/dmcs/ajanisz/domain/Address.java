package pl.dmcs.ajanisz.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="address")
public class Spoldzielnia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String city;
    private String street;
    private String apartmentNumber;
    @OneToMany(mappedBy = "address",fetch = FetchType.EAGER)
    //@JoinTable(name="appuser_address",joinColumns = @JoinColumn(name="appuser_id"), inverseJoinColumns = @JoinColumn(name="address_id"))
    private List<AppUser> appUserList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public List<AppUser> getAppUserList() {
        return appUserList;
    }

    public void setAppUserList(List<AppUser> appUserList) {
        this.appUserList = appUserList;
    }
}
