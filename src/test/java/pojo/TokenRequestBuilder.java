package pojo;

public class TokenRequestBuilder {

    private String usernameOrEmailAddress;
    private String password;

    public TokenRequestBuilder(String usernameOrEmailAddress, String password) {
        this.usernameOrEmailAddress = usernameOrEmailAddress;
        this.password = password;
    }

    public String getUsernameOrEmailAddress() {
        return usernameOrEmailAddress;
    }

    public void setUsernameOrEmailAddress(String usernameOrEmailAddress) {
        this.usernameOrEmailAddress = usernameOrEmailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
