package pl.dmcs.ajanisz.domain;

import javax.persistence.*;
import java.util.List;

//@Table(uniqueConstraints = { @UniqueConstraint(columnNames={"appartmentNumber", "addressValue"})})
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = { "appartmentNumber", "appartmentAddress_id" } )})
@Entity
public class Appartment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;


    private String appartmentNumber;


    @ManyToOne
    private Address appartmentAddress;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "appartment")
    private List<AppUser> appUserList;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAppartmentNumber() {
        return appartmentNumber;
    }

    public void setAppartmentNumber(String appartmentNumber) {
        this.appartmentNumber = appartmentNumber;
    }

    public Address getAppartmentAddress() {
        return appartmentAddress;
    }

    public void setAppartmentAddress(Address appartmentAddress) {
        this.appartmentAddress = appartmentAddress;
    }

    public List<AppUser> getAppUserList() {
        return appUserList;
    }

    public void setAppUserList(List<AppUser> appUserList) {
        this.appUserList = appUserList;
    }
}
