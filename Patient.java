public class Patient {
    private String id;
    private String name;
    private int age;
    private String phone;

    public Patient(String id, String n, int a, String p) {
        this.id = id;
        this.name = n;
        this.age = a;
        this.phone = p;
    }

    // getter methods
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getPhone() { return phone; }

    public String toString() {
        return "Patient ID: " + id + " | Name: " + name + " | Age: " + age + " | Phone: " + phone;
    }
}