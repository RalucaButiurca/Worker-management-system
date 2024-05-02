package domeniu;


public class CurrentUser {
    private static CurrentUser single_instance = null;
    private Integer id;
    private String email;
    private String name;
    private String password;

    private CurrentUser() {}

    public static CurrentUser getInstance()
    {
        if (single_instance == null)
            single_instance = new CurrentUser();

        return single_instance;
    }

    public void setName(String Name) {
        this.name = name;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setId(int id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}


