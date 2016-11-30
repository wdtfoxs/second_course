package BaseOfData.entitys;

public class User {
    private String login;
    private String password;
    private String email;

    public User(String login, String password, String email) {

        this.login = login;
        this.password = password;
        this.email = email;
    }
    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }
}
