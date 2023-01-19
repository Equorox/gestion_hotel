package hotel;

public class Session {
    private String login;
    private String password;
    
    /**
     * @param login
     * @param password
     */
    public Session(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }
    
    
}