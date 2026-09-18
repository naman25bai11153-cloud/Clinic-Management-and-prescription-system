import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Patient> patient = new ArrayList<>();
    static ArrayList<Doctor> dl = new ArrayList<>();
    static ArrayList<Appointment> apptList = new ArrayList<>();

    static Scanner scan = new Scanner(System.in);

    //add a new patient to the system.
    public static void add_Patient() {
        System.out.print("enter patient ID: ");
        String id = scan.nextLine();
        for (Patient p : patient) {
            if (p.getId().equals(id)) {
                System.out.println("Error: Patient ID already exists!");
                return;
            }
        }
        System.out.print("Enter Name: ");
        String name = scan.nextLine();
        System.out.print("Enter Age: ");
        int a = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter Phone: ");
        String ph = scan.nextLine();

        // checks whether the phone number is valid.
        if (ph.length() < 10 || ph.length() > 12) {
            System.out.println("Invalid phone number");
            return;
        }

        //makes new patient object
        Patient p = new Patient(id, name, a, ph);
        patient.add(p);
        System.out.println("patient added successfully");
    }

    // adding a new doctor to the system
    public static void add_Doctor() {
        System.out.print("Enter Doctor ID: ");
        String id = scan.nextLine();

        //checks whether doctor with given id already exists
        for (Doctor d : dl) {
            if (d.getId().equals(id)) {
                System.out.println("Doctor already exists with this ID. please add another ID");
                return;
            }
        }

        System.out.print("Enter Name: ");
        String name = scan.nextLine();

        System.out.print("Enter Specialization: ");
        String spec = scan.nextLine();

        Doctor d = new Doctor(id, name, spec);
        dl.add(d);
        System.out.println("Doctor added successfully!");
    }

    public static void book_app() {
        System.out.print("Enter Application ID: ");
        String app_Id = scan.nextLine();
        
        //checks if the appointment slot has already been booked aqt this time
        for (Appointment a : apptList) {
            if (a.getAptId().equals(app_Id)) {
                System.out.println("Error: Appointment ID already taken!");
                return;
            }
        }

        System.out.print("Enter Patient ID: ");
        String pId = scan.nextLine();

        // 1. patient varification
        boolean pat_Found = false;
        for (Patient p : patient) {
            if (p.getId().equals(pId)) {
                pat_Found = true;
                break; // Stop searching once we find them
            }
        }

        if (!pat_Found) {
            System.out.println("Error: Patient ID does not exist!");
            return; // Stop the booking process right here
        }

        System.out.print("Enter Doctor ID: ");
        String d_Id = scan.nextLine();

        // 2. Verify whether doctor already exists
        boolean doc_found = false;
        for (Doctor d : dl) {
            if (d.getId().equals(d_Id)) {
                doc_found = true;
                break;
            }
        }

        if (!doc_found) {
            System.out.println("Error: Doctor ID does not exist!");
            return;
        }

        System.out.print("Enter Time (e.g. 10:00 AM): ");
        String time = scan.nextLine();


        // 3. to Verify if the doctor's slot is already booked
        for (Appointment a : apptList) {
            if (a.getDoctorId().equals(d_Id) &&
                    a.getTime().equals(time) &&
                    a.getStatus().equals("Scheduled")) {

                System.out.println("Error: Doctor is already busy at this time!");
                return;
            }
        }

        Appointment newApt = new Appointment(app_Id, pId, d_Id, time);
        apptList.add(newApt);
        System.out.println("Appointment booked!");
    }

    public static void prescribe() {
        System.out.print("Enter appointment ID to complete: ");
        String id = scan.nextLine();

        // find if the appointment is already present in the list
        Appointment found = null;
        for (int i = 0; i < apptList.size(); i++) {
            if (apptList.get(i).getAptId().equals(id)) {
                found = apptList.get(i);
                break;
            }
        }

        if (found == null) {
            System.out.println("Appointment not found.");
            return;
        }

        System.out.print("Enter Medicine Name: ");
        String med = scan.nextLine();

        System.out.print("Enter Dosage: ");
        int dose = scan.nextInt();
        
        
        found.givePrescription(med, dose);
        System.out.println("Prescription added and appointment completed.");
    }

    public static void cancel() {
        System.out.print("Enter appointment ID: ");
        String id = scan.nextLine();
        
        //cancels appointment if it exists by returning nothing before it prints out next line
        for (Appointment a : apptList) {
            if (a.getAptId().equals(id)) {
                a.setStatus("Cancelled");
                System.out.println("Appointment cancelled.");
                return;
            }
        }

        System.out.println("Appointment not found.");
    }

    public static void showHistory() {
        System.out.print("Enter Patient ID: ");
        String pat_Id = scan.nextLine();

        System.out.println("\n--- History for Patient " + pat_Id + " ---");
        boolean f = false;
        
        //checks for records
        for (Appointment a : apptList) {
            if (a.getPatientId().equals(pat_Id)) {
                System.out.println(a);
                f = true;
            }
        }

        if (!f) {
            System.out.println("No records found.");
        }
    }

    public static void showAll() {
        if (apptList.size() == 0) {
            System.out.println("No appointments booked yet.");
            return;
        }

        System.out.println("\n--- All Appointments ---");
        for (int i = 0; i < apptList.size(); i++) {
            System.out.println(apptList.get(i));
        }
    }

    public static void main(String[] args) {
        dl.add(new Doctor("D1", "Rancho", "Physician"));
        dl.add(new Doctor("D2", "Sam", "Physician"));
        dl.add(new Doctor("D3", "Sunny", "Physician"));
        patient.add(new Patient("P1", "Amit", 20, "9999999999"));

        boolean running = true;

        while (running) {
            System.out.println("\n--- CLINIC SYSTEM ---");
            System.out.println("1. add patient");
            System.out.println("2. add doctor");
            System.out.println("3. book appointment");
            System.out.println("4. complete & prescribe");
            System.out.println("5. cancel appointment");
            System.out.println("6. view patient history");
            System.out.println("7. show all appointments");
            System.out.println("8. exit");
            System.out.print("enter your choice: ");

            String choice = scan.nextLine();


            if (choice.equals("1")) {
                add_Patient();
            } else if (choice.equals("2")) {
                add_Doctor();
            } else if (choice.equals("3")) {
                book_app();
            } else if (choice.equals("4")) {
                prescribe();
            } else if (choice.equals("5")) {
                cancel();
            } else if (choice.equals("6")) {
                showHistory();
            } else if (choice.equals("7")) {
                showAll();
            } else if (choice.equals("8")) {
                System.out.println("Exiting the program...");
                running = false;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
    }
}
