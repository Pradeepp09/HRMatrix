import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class Employee {
    public int EID;
    public String Ename;
    public String EAddress;
    public String EDesignation;
    public String EJoiningDate;
    public String EDepartment;
    public int ESalary;

    private static int Counter;

    static {
        Counter = 0;
    }

    public Employee(String name, String address, String designation, String joiningDate, String department, int salary) {
        this.EID = ++Counter;
        this.Ename = name;
        this.EAddress = address;
        this.EDesignation = designation;
        this.EJoiningDate = joiningDate;
        this.EDepartment = department;
        this.ESalary = salary;
    }

    public static void saveToCSV(LinkedList<Employee> lobj) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee_data.csv"))) {
            writer.write("EID,Ename,EAddress,EDesignation,EJoiningDate,EDepartment,ESalary\n");
            for (Employee e : lobj) {
                writer.write(e.EID + "," + e.Ename + "," + e.EAddress + "," + e.EDesignation + "," +
                             e.EJoiningDate + "," + e.EDepartment + "," + e.ESalary + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Employee> loadFromCSV() {
        LinkedList<Employee> employeeList = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("employee_data.csv"))) {
            String line = reader.readLine(); // Skip the header
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 7) {
                    int id = Integer.parseInt(data[0]);
                    String name = data[1];
                    String address = data[2];
                    String designation = data[3];
                    String joiningDate = data[4];
                    String department = data[5];
                    int salary = Integer.parseInt(data[6]);

                    Employee e = new Employee(name, address, designation, joiningDate, department, salary);
                    e.EID = id;
                    employeeList.add(e);
                    Counter = Math.max(Counter, id);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}

class MarvellousDBMS {
    public LinkedList<Employee> lobj;

    public MarvellousDBMS() {
        lobj = Employee.loadFromCSV();
    }

    public void InsertIntoTable(String name, String address, String designation, String joiningDate, String department, int salary) {
        Employee eobj = new Employee(name, address, designation, joiningDate, department, salary);
        lobj.add(eobj);
        Employee.saveToCSV(lobj);
    }

    public void DisplayAll(JTable table) {
        String[] columns = {"EID", "Name", "Address", "Designation", "Joining Date", "Department", "Salary"};
        String[][] data = new String[lobj.size()][7];
        int index = 0;
        for (Employee e : lobj) {
            data[index++] = new String[]{
                String.valueOf(e.EID), e.Ename, e.EAddress, e.EDesignation, e.EJoiningDate, e.EDepartment, String.valueOf(e.ESalary)
            };
        }
        table.setModel(new javax.swing.table.DefaultTableModel(data, columns));
    }
}

public class EnhancedGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Enhanced Employee Management");
        frame.setSize(1200, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MarvellousDBMS dbms = new MarvellousDBMS();

        // Main panel with tabs
        JTabbedPane tabbedPane = new JTabbedPane();

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField();
        JLabel addressLabel = new JLabel("Address:");
        JTextField addressField = new JTextField();
        JLabel designationLabel = new JLabel("Designation:");
        JTextField designationField = new JTextField();
        JLabel joiningDateLabel = new JLabel("Joining Date:");
        JTextField joiningDateField = new JTextField();
        JLabel departmentLabel = new JLabel("Department:");
        JTextField departmentField = new JTextField();
        JLabel salaryLabel = new JLabel("Salary:");
        JTextField salaryField = new JTextField();
        JButton addButton = new JButton("Add Employee");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(addressLabel);
        inputPanel.add(addressField);
        inputPanel.add(designationLabel);
        inputPanel.add(designationField);
        inputPanel.add(joiningDateLabel);
        inputPanel.add(joiningDateField);
        inputPanel.add(departmentLabel);
        inputPanel.add(departmentField);
        inputPanel.add(salaryLabel);
        inputPanel.add(salaryField);
        inputPanel.add(new JLabel());
        inputPanel.add(addButton);

        // Display panel
        JPanel displayPanel = new JPanel(new BorderLayout());
        JTable employeeTable = new JTable();
        JScrollPane tableScrollPane = new JScrollPane(employeeTable);
        displayPanel.add(tableScrollPane, BorderLayout.CENTER);
        JButton refreshButton = new JButton("Refresh Data");
        displayPanel.add(refreshButton, BorderLayout.SOUTH);

        tabbedPane.addTab("Add Employee", inputPanel);
        tabbedPane.addTab("Employee Records", displayPanel);

        // Add functionality
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String address = addressField.getText();
            String designation = designationField.getText();
            String joiningDate = joiningDateField.getText();
            String department = departmentField.getText();
            int salary = Integer.parseInt(salaryField.getText());

            dbms.InsertIntoTable(name, address, designation, joiningDate, department, salary);
            JOptionPane.showMessageDialog(frame, "Employee Added Successfully!");
        });

        refreshButton.addActionListener(e -> dbms.DisplayAll(employeeTable));

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
