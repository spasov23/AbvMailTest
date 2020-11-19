package enums;

public enum Username {
    USER("ks_test_mail@abv.bg");

    private String username;

    private Username(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
