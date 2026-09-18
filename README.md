# 🏥 Clinic Management & Prescription System


A robust, terminal-based **Clinic Management System** built  using Core Java. Designed following strict Object-Oriented Programming (OOP) principles, this application provides an efficient in-memory solution for managing patient registries, doctor rosters, appointment scheduling with collision detection, and medical prescriptions without relying on external databases or complex GUI frameworks.

---

## 📑 Table of Contents
- [✨ Core Features](#-core-features)
- [📂 Project Structure](#-project-structure)
- [🛠️ Technical Architecture & Design Patterns](#️-technical-architecture--design-patterns)
- [⚙️ Prerequisites & System Requirements](#️-prerequisites--system-requirements)
- [🚀 Setup & Execution Instructions](#-setup--execution-instructions)
- [💻 Usage Workflow Example](#-usage-workflow-example)

---

## ✨ Core Features

* **👨‍⚕️ Doctor & Patient Management:** 
  * Register new patients with unique ID validation, age constraints, and phone verification.
  * Add qualified doctors with custom specialties to the active clinic roster.
* **📅 Smart Appointment Scheduling:** 
  * Book appointments mapped to specific patient and doctor IDs.
  * **Collision Detection:** Automatically scans existing schedules to block overlapping time slots, preventing doctor double-booking.
* **💊 Prescription & Lifecycle Tracking:** 
  * Complete pending appointments by attaching specific medication names and dosage instructions.
  * Dynamically updates appointment statuses (`Scheduled` → `Completed` or `Cancelled`).
* **📂 Medical History Retrieval:** 
  * Query the system using a Patient ID to instantly output a chronological log of all past and active visits along with associated prescriptions.

---

## 📂 Project Structure

The project uses a clean, modular multi-file architecture where each entity is encapsulated within its own class file:

```text
├── Main.java         # Handles the console menu loop, user input, and business logic
├── Patient.java      # Data model representing clinic patients
├── Doctor.java       # Data model representing medical professionals
└── Appointment.java  # Data model handling visit slots, states, and prescriptions
```

---

## 🛠️ Technical Architecture & Design Patterns

* **Encapsulation:** All internal data fields (`id`, `name`, `age`, `status`, etc.) are marked `private` and accessed securely via standard getter and setter methods.
* **In-Memory Storage:** Utilizes dynamic `java.util.ArrayList` collections to manage runtime data efficiently without file input/output or database overhead.
* **Exception Handling:** Built-in `try-catch` validation blocks handle invalid inputs (such as text entered into numeric age fields), ensuring the CLI application never crashes unexpectedly.
* **Command-Line Interface (CLI):** Fully executable via standard terminal input/output streams (`Scanner` and `System.out`), meeting rigorous command-line execution guidelines[cite: 9].

---

## ⚙️ Prerequisites & System Requirements

* **Java Development Kit (JDK):** Version 8 or higher installed on your machine.
* **Terminal Environment:** Command Prompt (Windows), PowerShell, or Bash/Zsh (Linux/macOS). 

*Note: This project contains zero external dependencies, third-party libraries, or GUI packages, ensuring seamless execution across any environment[cite: 9].*

---

## 🚀 Setup & Execution Instructions

Follow these step-by-step instructions to compile and run the project locally[cite: 9]:

1. **Clone or Download the Repository:**
   Place all four `.java` files (`Main.java`, `Patient.java`, `Doctor.java`, `Appointment.java`) into your project root directory.

2. **Open Terminal / Command Prompt:**
   Navigate to the folder where your source files are saved:
   ```bash
   cd path/to/your/project-folder
   ```

3. **Compile the Source Files:**
   Compile all Java classes simultaneously:
   ```bash
   javac *.java
   ```

4. **Run the Application:**
   Launch the interactive CLI dashboard:
   ```bash
   java Main
   ```

---

## 💻 Usage Workflow Example

Upon running `java Main`, an interactive numbered menu appears in your terminal. 

1. **Pre-Loaded Data:** The application automatically loads sample records (e.g., Doctors `D1`, `D2` and Patient `P1`) on startup so you can test features immediately.
2. **Booking a Visit:** Select option `3`, provide a unique appointment ID, choose an existing Patient ID and Doctor ID, and specify a time slot (e.g., `10:00 AM`).
3. **Prescribing Medicine:** Select option `4` after a visit to attach prescriptions. This changes the appointment status to `Completed`.
4. **Checking History:** Select option `6` and enter a Patient ID to view their complete medical timeline.

