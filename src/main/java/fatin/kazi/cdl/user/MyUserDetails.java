package fatin.kazi.cdl.user;

import fatin.kazi.cdl.security.ApplicationUserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;


public class MyUserDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean active;
    private Set<? extends GrantedAuthority>  authorities;
    public MyUserDetails(User user){

        this.userName = user.getUserName();
        this.password = user.getPassword();
        this.active = user.isActive();

        if(user.getRole().equals("ADMIN")){
            this.authorities = ApplicationUserRole.ADMIN.getGrantedAuthorities();
        }else{
            this.authorities = ApplicationUserRole.CLIENT.getGrantedAuthorities();
        }

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
