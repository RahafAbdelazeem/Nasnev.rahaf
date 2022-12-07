package demo.demo.appuser;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

@Entity
public class Appuser implements UserDetails {



    private  long id;
    private String name;
    private  String username;
    private String Email;
    private String address;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;
    private Boolean locked;
    private Boolean enabeled;

    public Appuser(long id, String name, String username, String email, String address, AppUserRole appUserRole) {
        this.id = id;
        this.name = name;
        this.username = username;
        Email = email;
        this.address = address;
        this.appUserRole = appUserRole;
    }

    @SequenceGenerator(
            name="user_Sequance",
             sequenceName ="Student_sequance",
            allocationSize = 1

    )
    @Id
    @GeneratedValue(
            strategy= GenerationType.SEQUENCE,
            generator="student_sequance"
    )



    @java.lang.Override
    public java.util.Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @java.lang.Override
    public java.lang.String getPassword() {
        return null;
    }

    @java.lang.Override
    public java.lang.String getUsername() {
        return null;
    }

    @java.lang.Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @java.lang.Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @java.lang.Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @java.lang.Override
    public boolean isEnabled() {
        return false;
    }
}
