package pl.dmcs.ajanisz.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="appuser")
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
@ManyToMany(fetch = FetchType.EAGER)
private Set<AppUserRole> appUserRole = new HashSet<AppUserRole>(0);
    public Set<AppUserRole> getAppUserRole() {
        return appUserRole;
    }

    @Column(unique = true)
    private String login;

    private String password;



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
}

