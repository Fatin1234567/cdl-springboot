package fatin.kazi.cdl.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static fatin.kazi.cdl.security.ApplicationPermission.CDL_READ;
import static fatin.kazi.cdl.security.ApplicationPermission.CDL_WRITE;

public enum ApplicationUserRole {

    ADMIN(Sets.newHashSet(CDL_READ,CDL_WRITE)),
    CLIENT(Sets.newHashSet(CDL_READ));

    private final Set<ApplicationPermission> permissionSet;

    ApplicationUserRole(Set<ApplicationPermission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<ApplicationPermission> getPermissionSet() {
        return permissionSet;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
        Set<SimpleGrantedAuthority> permissions = getPermissionSet().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;

    }






}
