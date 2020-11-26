package enums;

public enum Password {
    VALID_PASSWORD ("11test11"),
    INVALID_PASSWORD ("adasda");

    private String password;

    private Password(String password){
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
