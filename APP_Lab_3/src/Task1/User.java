package Task1;

public class User {
    String firstName;
    String lastName;
    Address address;
    int age;
    String phoneNumber;

    public User(String firstName, String lastName, Address address, int age, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.phoneNumber = phoneNumber;

        validate();
    }

    public void validate() {
        if (firstName.matches("(.*[\\d\\s]+.*)+"))
            throw new HttpException(HttpCode.BAD_REQUEST_400, "Incorrect firstname!", firstName);

        if (lastName.matches("(.*[\\d\\s]+.*)+"))
            throw new HttpException(HttpCode.BAD_REQUEST_400, "Incorrect lastname!", firstName);

        if (age <= 0)
            throw new HttpException(HttpCode.BAD_REQUEST_400, "Incorrect age!", String.valueOf(age));

        /*
        * (123) 456 7899
        * (123).456.7899
        * (123)-456-7899
        * 123-456-7899
        * 123 456 7899
        * 1234567899
        * */

        if (!phoneNumber.matches("\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})"))
            throw new HttpException(HttpCode.BAD_REQUEST_400, "Incorrect phonenumber!", phoneNumber);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        validate();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        validate();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        validate();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        validate();
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + "\n" +
                "\tAge: " + age + "\n" +
                "\tAddress: " + address + "\n" +
                "\tpPhone number: " + phoneNumber;
    }
}
