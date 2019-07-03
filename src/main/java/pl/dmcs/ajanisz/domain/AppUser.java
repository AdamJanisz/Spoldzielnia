package pl.dmcs.ajanisz.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Table(name="appuser",uniqueConstraints = {@UniqueConstraint(columnNames = "appartment_id" )})
@Entity
public class AppUser {

    private boolean enabled;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name="firstName", nullable=false)
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;


   // @ManyToOne
   // private Address address;
   // private Building building;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "appUser")
    private Set<Bills> billsList;

    @OneToOne
    private Appartment appartment;


@ManyToMany(fetch = FetchType.EAGER)
private Set<AppUserRole> appUserRole = new HashSet<AppUserRole>(0);
    public Set<AppUserRole> getAppUserRole() {
        return appUserRole;
    }

    @Column(unique = true)
    private String login;

    private String password;

    public Appartment getAppartment() { return appartment; }

    public void setAppartment(Appartment appartment) { this.appartment = appartment; }

    public void setAppUserRole(Set<AppUserRole> appUserRole) {
        this.appUserRole = appUserRole;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isEnabled() {
   return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

//    public Address getAddress() {
//        return address;
//    }
//
//    public void setAddress(Address address) {
//        this.address = address;
//    }


    public Set<Bills> getBillsList() { return billsList; }

    public void setBillsList(Set<Bills> billsList) { this.billsList = billsList; }
}

