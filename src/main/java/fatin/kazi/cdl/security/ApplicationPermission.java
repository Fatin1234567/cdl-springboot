package fatin.kazi.cdl.security;

public enum ApplicationPermission {


    CDL_READ("cdl:read"),
    CDL_WRITE("cdl:write");

    private String permission;

    ApplicationPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }


}
