// klass som representerar address
public class Address {
    private String city;
    private String street;
    private String postalCode;
    private int portNummer;

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getPortNummer() {
        return portNummer;
    }

    public Address(String city, String street, String postalCode, int portNummer) {
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.portNummer = portNummer;
    }
}
