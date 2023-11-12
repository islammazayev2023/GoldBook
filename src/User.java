// Klass som representerar en user(användare)

import java.util.List;

public class User extends Profile implements SearchProfile {
    public User(String firstName, String lastName, int age, Address address, List<String> telefoNumbesr){
        super(firstName, lastName, age, address, telefoNumbesr);
    }
    @Override
    public boolean matches(String query){
        return getFirstName().equalsIgnoreCase(query)||
                getLastName().equalsIgnoreCase(query)||
                getAddress().getStreet().equalsIgnoreCase(query)||
                getTelefonNumbers().stream().anyMatch(number -> number.contains(query));
    }

}
