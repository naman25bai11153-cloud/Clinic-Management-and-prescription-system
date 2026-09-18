public class Appointment {
    private String aptId;
    private String patientId;
    private String doctorId;
    private String time;
    private String status;

    // prescription details
    private String medicine = "";
    private int dosage;

    public Appointment(String aptId, String patientId, String doctorId, String time) {
        this.aptId = aptId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.time = time;
        this.status = "Scheduled";
    }

    public String getAptId() { return aptId; }
    public String getPatientId() { return patientId; }
    public String getDoctorId() { return doctorId; }
    public String getTime() { return time; }
    public String getStatus() { return status; }

    public void setStatus(String s) {
        this.status = s;
    }

    // adds medicine and marks appointment as done
    public void givePrescription(String med, int dose) {
        this.medicine = med;
        this.dosage = dose;
        this.status = "Completed";
    }

    public String toString() {
        String info = "Appt ID: " + aptId + " | Patient: " + patientId +
                " | Doctor: " + doctorId + " | Time: " + time +
                " | Status: " + status;

        // if there is a medicine given, attach it to the print statement
        if (!medicine.equals("")) {
            info = info + "\n   ---> Rx: " + medicine + " (Dosage: " + dosage + ")";
        }
        return info;
    }
}
