package org.pixelora.util.constants;

public enum Privileges {
    RESET_ANY_USER_PASSWORD(1l,"RESET_ANY_USER_PASSWORD"),
    ACCESS_ADMIN_PANEL(2l,"ACCESS_ADMIN_PANEL");

    private  Long Id;
    private String privilege;

    private Privileges(Long authorityId, String authorityString){
        this.Id=authorityId;
        this.privilege=privilege;
    }
    public long getId() {
        return Id;
    }

    public String getPrivilege() {
        return privilege;
    }
}
