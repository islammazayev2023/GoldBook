import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TelefonBookDisplay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TelefonBookDatabase telefonBookDatabase = new TelefonBookDatabase();
        boolean isAdmin = true;


        while (true){
            System.out.println("Menu:  ");
            System.out.println("1 - Search for User");
            System.out.println("2 - Add a new User");
            System.out.println("3 - Update a User");
            System.out.println("4 - Delete a User");
            System.out.println("5 - Info who was deleted");
            System.out.println("6 - Exit");
            System.out.println("Enter your choice: ");


            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    System.out.println("Enter search query: ");
                    String query = sc.nextLine();
                    List<User> searchResults = searchUser(telefonBookDatabase.getAllUsers(), query);
                    if (searchResults.isEmpty()) {
                        System.out.println("No user matching. ");
                    } else {
                        System.out.println("User matching");
                        for (User user : searchResults) {
                            System.out.println(user.getFirstName() + "  " + user.getLastName());
                        }
                    }
                    break;

                case 2:
                    if (isAdmin){
                        System.out.println("Enter first name: ");
                        String firstName = sc.nextLine();

                        System.out.println("Enter last name: ");
                        String lastName = sc.nextLine();

                        System.out.println("Enter age: ");
                        int age = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Enter street: ");
                        String street = sc.nextLine();

                        System.out.println("Enter city: ");
                        String city = sc.nextLine();

                        System.out.println("Enter  postallcode: ");
                        String postalCode = sc.nextLine();

                        System.out.println("Enter port number: ");
                        int portNumber = sc.nextInt();
                        sc.nextLine();

                        System.out.println("Enter phone number (between dashes - separated): ");
                        String telefonNumberInput = sc.nextLine();
                        List<String> telefonNumbers = List.of(telefonNumberInput.split("-"));

                        User newUser = new User(firstName, lastName, age, new Address(street, city, postalCode, portNumber),telefonNumbers);
                        telefonBookDatabase.addUser(newUser);
                        System.out.println("User added successfully. ");

                    }else {
                        System.out.println("OBS only Admin can add a user. ");
                    }
                    break;

                case 3:
                    if (isAdmin){
                        System.out.println("Enter last name of user to update: ");
                        String updateLastNameOfUser = sc.nextLine();
                        User existingUser  = telefonBookDatabase.getUser(updateLastNameOfUser);

                        if (existingUser != null) {
                            System.out.print("Enter new first name: ");
                            String newFirstName = sc.nextLine();

                            System.out.print("Enter new age: ");
                            int newAge = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter new street: ");
                            String newStreet = sc.nextLine();

                            System.out.print("Enter new city: ");
                            String newCity = sc.nextLine();

                            System.out.print("Enter new postal code: ");
                            String newPostalCode = sc.nextLine();

                            System.out.print("Enter new port number: ");
                            int newPortNumber = sc.nextInt();
                            sc.nextLine();

                            System.out.print("Enter new phone number (comma-separated): ");
                            String newPhoneNumbersInput = sc.nextLine();
                            List<String> newPhoneNumbers = List.of(newPhoneNumbersInput.split(","));

                            User updatedUser = new User(newFirstName, existingUser.getLastName(), newAge, new Address(newStreet, newCity, newPostalCode, newPortNumber), newPhoneNumbers);
                            telefonBookDatabase.updateUser(updatedUser);
                            System.out.println("Profile updated successfully.");
                        } else {
                            System.out.println("Profile not found.");
                        }
                    } else {
                        System.out.println("Only administrators can update profiles.");
                    }
                    break;

                case 4:
                    if (isAdmin){
                        System.out.println("Enter last name of user to delete: ");
                        String deleteLastNameOfUser = sc.nextLine();
                        User deleteUser = telefonBookDatabase.getUser(deleteLastNameOfUser);

                        if (deleteUser != null){
                            telefonBookDatabase.deletedUser(deleteLastNameOfUser);
                            System.out.println("User deleted successfully. ");
                        }else {
                            System.out.println("User not found. ");
                        }
                    }else {
                        System.out.println("OBS only admin can delete user. ");
                    }
                    break;

                case 5:
                    if (isAdmin){
                        List<User> deleteUsers = telefonBookDatabase.getDeleteUsers();
                        System.out.println("Deleted user: ");
                        for (User user : deleteUsers){
                            System.out.println(user.getFirstName()+ " " + user.getLastName()+ " " + user.getAddress());
                        }
                    }else {
                        System.out.println("OBS only admin can view info about deleted user. ");
                    }
                    break;

                case 6:
                    System.out.println("Exiting.... ");
                    System.exit(0);
                    break;


                default:
                    System.out.println("Invalid choice. Please try again. ");

                }

            }
        }
        private static List<User> searchUser(List<User> users, String query) {
            List<User> userResults = new ArrayList<>();
            for (User user : users) {
                if (user.matches(query)) {
                    userResults.add(user);
                }
            }
            return userResults;
        }
    }