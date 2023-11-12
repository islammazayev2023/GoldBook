import java.util.List;
// Klass som representerar profil
abstract class Profile {
    private String firstName;
    private String lastNAme;
    private int age;
    private Address address;
    private List<String> telefonNumbers;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastNAme;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getTelefonNumbers() {
        return telefonNumbers;
    }

    public Profile(String firstName, String lastNAme, int age, Address address, List<String> telefonNumbers) {
        this.firstName = firstName;
        this.lastNAme = lastNAme;
        this.age = age;
        this.address = address;
        this.telefonNumbers = telefonNumbers;
    }
}
