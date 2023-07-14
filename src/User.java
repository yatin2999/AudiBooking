public class User extends Student {

    public User(String name, int id)
    {
        super(name, id);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}