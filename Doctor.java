public class Doctor {
    private String id;
    private String name;
    private String spec; // specialization

    public Doctor(String id, String n, String spec) {
        this.id = id;
        this.name = n;
        this.spec = spec;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getSpec() { return spec; }

    public String toString() {
        return "Doctor ID: " + id + " | Name: Dr. " + name + " | Specialist: " + spec;
    }
}
