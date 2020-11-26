package enums;

public enum Username {
    VALID_USER("ks_test_mail@abv.bg"),
    INVALID_USER("dsadasdsa");

    private String username;

    private Username(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
