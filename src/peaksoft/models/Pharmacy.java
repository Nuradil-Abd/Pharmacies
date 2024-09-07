package peaksoft.models;

import java.util.ArrayList;
import java.util.List;

public class Pharmacy {

    private Long id;
    private String name;
    private  String address;
    private List<Employee> employee = new ArrayList<>();
    private List<Medicine> medicines = new ArrayList<>();

    public Pharmacy() {
    }
    public Pharmacy(Long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Pharmacy(Long id, String name, String address, List<Employee> employee, List<Medicine> medicines) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.employee = employee;
        this.medicines = medicines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", employee=" + employee +
                ", medicines=" + medicines +
                '}';
    }
}
