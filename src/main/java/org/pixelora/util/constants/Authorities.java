package org.pixelora.util.constants;

public enum Authorities {
    RESET_ANY_USER_PASSWORD(1l,"RESET_ANY_USER_PASSWORD"),
    ACCESS_ADMIN_PANEL(2l,"ACCESS_ADMIN_PANEL");

    private  Long authorityId;
    private String authorityString;

    private Authorities(Long authorityId,String authorityString){
        this.authorityId=authorityId;
        this.authorityString=authorityString;
    }
    public long getAuthorityId() {
        return authorityId;
    }

    public String getAuthorityString() {
        return authorityString;
    }
}
