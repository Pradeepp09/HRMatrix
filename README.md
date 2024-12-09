
# HRMatrix

**HRMatrix** is a Java-based desktop application designed to streamline employee management tasks. With an intuitive graphical user interface (GUI) built using Java Swing, HRMatrix allows users to manage employee records efficiently while maintaining data persistence through CSV file storage.

---

### **Features**
- **Add Employees**: Add employee details, including Name, Address, and Salary.
- **View Employee Records**: Display all employee data in a tabular format.
- **Search Functionality**: Search for employees by ID or Name.
- **Delete Employee Records**: Remove employees by their ID or Name.
- **Salary Calculations**: Compute the total and average salaries of employees.
- **Data Persistence**: All data is stored and retrieved from a CSV file.

---

### **Technologies Used**
- **Java**: Core language for application development.
- **Swing**: For building a responsive and user-friendly GUI.
- **File I/O**: For reading and writing employee data in CSV format.

---

### **Installation Instructions**

1. **Clone the Repository**:
   Clone the repository to your local machine:
   ```bash
   git clone https://github.com/yourusername/HRMatrix.git
   ```

2. **Set Up Your Environment**:
   Ensure Java Development Kit (JDK) 8 or later is installed on your system. Download it from the [official Java website](https://www.oracle.com/java/technologies/javase-downloads.html) if needed.

3. **Compile the Code**:
   Navigate to the project directory and compile the Java files:
   ```bash
   javac -d bin src/*.java
   ```

4. **Run the Application**:
   Execute the application using the following command:
   ```bash
   java -cp bin HRMatrix
   ```

---

### **Usage**

1. **Add Employees**:
   - Fill in the fields for **Name**, **Address**, and **Salary**.
   - Click the **Insert Employee** button to save the data.

2. **View All Employees**:
   - Click **Display All Employees** to view a table of all stored employee records.

3. **Search Employee**:
   - Use the **Search by ID** or **Search by Name** options to find specific employees.

4. **Delete Employees**:
   - Use the **Delete by ID** or **Delete by Name** buttons to remove employees from the system.

5. **Salary Aggregation**:
   - View the total and average salary of all employees with the provided options.

---

### **File Storage**
- Data is stored in `employee_data.csv`, located in the project directory.
- The file format is as follows:
  ```csv
  EID,Ename,EAddress,ESalary
  1,John Doe,123 Main St,50000
  2,Jane Smith,456 Oak Ave,60000
  ```

---

### **Contributing**
We welcome contributions to HRMatrix! Here's how you can get involved:
1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Create a Pull Request.

---

### **License**
This project is licensed under the MIT License. See the `LICENSE` file for details.

---

### **Contact**
For questions or suggestions, feel free to reach out:
- **Email**: pradeepparaskar143@gmail.com
- **GitHub**: [Pradeepp09](https://github.com/Pradeepp09)

Enjoy using **HRMatrix**!
