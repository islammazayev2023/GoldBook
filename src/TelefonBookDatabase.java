
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// klass som representerar en Telefon book
public class TelefonBookDatabase {
    private Map<String,User> usersMap;
    private List<User> deletedUsers;

    public TelefonBookDatabase(){
        usersMap = new HashMap<>();
        deletedUsers = new ArrayList<>();
    }


    public void addUser(User user){
        usersMap.put(user.getLastName(),user);
    }


    public User getUser(String lastName){
        return usersMap.get(lastName);
    }


    public void deletedUser(String lastName){
        User user   = usersMap.remove(lastName);
        if (user != null){
            deletedUsers.add(user);
        }
    }


    public void updateUser(User user){
        usersMap.put(user.getLastName(), user);
    }

   /* public List<User> searschUser(String query){
        List<User> rslt = new ArrayList<>();
        for (User user : usersMap.values()){
            if (user.matches(query)){
                rslt.add(user);
            }
        }
        return rslt;
    }*/
    public List<User> getAllUsers(){
        return new ArrayList<>(usersMap.values());
    }


    public List<User> getDeleteUsers(){
        return deletedUsers;
    }

}

