/**
 * The class represents a banker
 */
public class Banker {
    private String name;
    private String password;

    public Banker(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void password(String password) {
       this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
