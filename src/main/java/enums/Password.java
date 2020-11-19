package enums;

public enum Password {
    PASSWORD ("11test11");

    private String password;

    private Password(String password){
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
