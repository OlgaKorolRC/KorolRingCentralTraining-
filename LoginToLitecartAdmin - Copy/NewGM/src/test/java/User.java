import java.util.Random;

public class User {
    private int taxID;
    private String company;
    private String firstName;
    private String lastName;
    private String address1;
    private int address2;
    private int postcode;
    private String city;
    private String country;
    private  int zone;
    private String email;
    private String phone;
    private String password;

    User() {
        taxID = new Random().nextInt(100);
        company = generateString(8).concat("_company");
        firstName = generateString(8).concat("_fName");
        lastName = generateString(8).concat("_lName");
        address1 = generateString(8).concat("_add1");
        address2 = new Random(5).nextInt(100);
        postcode = new Random(10000).nextInt(99999);
        city = generateString(5).concat("_city");
        country = "United States";
        zone = new Random(1).nextInt(50);
        email = generateString(6).concat("@mail.ru");
        phone = "+1".concat(generateNumber());
        password = generateString(10).concat("passwd");
    }

    public int getTaxID() {
        return taxID;
    }
    public String getCompany() {
        return company;
    };
    public String getFirstName() {
        return company;
    };
    public String getLastName() {
        return company;
    };
    public String getAddress1() {
        return address1;
    };
    public int getAddress2() {
        return address2;
    };
    public int getPostcode() {
        return postcode;
    };
    public String getCity() {
        return city;
    };
    public String getCountry() {
        return country;
    };
    public int getZone() {
        return zone;
    };
    public String getEmail() {
        return email;
    };
    public String getPhone() {
        return phone;
    };
    public String getPassword() {
        return password;
    };

    private static final String ALPHABET = "AaBbCcDdEeFfGgHhIiJjKkLlmNnOoPpQqRrSsTtUuVvvWwXxYyZz";
    private static final String NUMBERS = "0123456789";

    public static String generateString(int length) {
        char[] text = new char[length];
        for (int i = 0; i < length; i++) {
            text[i] = ALPHABET.charAt(new Random().nextInt(ALPHABET.length()));
        }
        return new String(text);
    }

    public static String generateNumber() {
        char[] text = new char[9];
        for (int i = 0; i < 9; i++) {
            text[i] = NUMBERS.charAt(new Random(5).nextInt(NUMBERS.length()));
        }
        return new String(text);
    }

    @Override
    public String toString() {
        return "User{" +
                "taxID=" + taxID +
                ", company='" + company + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", postcode=" + postcode +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", zone=" + zone +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
