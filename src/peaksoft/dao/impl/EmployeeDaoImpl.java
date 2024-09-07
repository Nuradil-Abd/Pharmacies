package peaksoft.dao.impl;

import peaksoft.dao.EmployeeDao;
import peaksoft.databae.Database;
import peaksoft.models.Employee;
import peaksoft.models.Pharmacy;
import peaksoft.exceptions.DaoOperationException;
import peaksoft.exceptions.EntityNotFoundException;

import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public String saveEmployee(Employee employee) throws DaoOperationException {
        try {
            Database.employees.add(employee);
            return "Employee successfully added!";
        } catch (Exception e) {
            throw new DaoOperationException("Error while adding employee", e);
        }
    }

    @Override
    public String assignEmployeeToPharmacy(Long pharmacyId, Long employeeId) throws DaoOperationException, EntityNotFoundException {
        try {
            Pharmacy pharmacy = null;
            Employee employee = null;

            for (Pharmacy p : Database.pharmacies) {
                if (p.getId().equals(pharmacyId)) {
                    pharmacy = p;
                    break;
                }
            }
            if (pharmacy == null) {
                throw new EntityNotFoundException("Pharmacy with ID " + pharmacyId + " not found!");
            }

            for (Employee e : Database.employees) {
                if (e.getId().equals(employeeId)) {
                    employee = e;
                    break;
                }
            }
            if (employee == null) {
                throw new EntityNotFoundException("Employee with ID " + employeeId + " not found!");
            }

            pharmacy.getEmployee().add(employee);
            return "Employee successfully assigned to the pharmacy!";
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoOperationException("Error while assigning employee", e);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        return Database.employees;
    }

    @Override
    public List<Employee> getAllEmployeesInPharmacy(Long pharmacyId) throws EntityNotFoundException, DaoOperationException {
        try {
            for (Pharmacy p : Database.pharmacies) {
                if (p.getId().equals(pharmacyId)) {
                    return p.getEmployee();
                }
            }
            throw new EntityNotFoundException("Pharmacy with ID " + pharmacyId + " not found!");
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoOperationException("Error while retrieving employees of the pharmacy", e);
        }
    }

    @Override
    public Employee getById(Long employeeId) throws EntityNotFoundException, DaoOperationException {
        try {
            for (Employee e : Database.employees) {
                if (e.getId().equals(employeeId)) {
                    return e;
                }
            }
            throw new EntityNotFoundException("Employee with ID " + employeeId + " not found!");
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoOperationException("Error while retrieving employee", e);
        }
    }

    @Override
    public String updateEmployees(Long employeeId, Employee newEmployee) throws DaoOperationException, EntityNotFoundException {
        try {
            Employee employee = getById(employeeId);
            employee.setFullName(newEmployee.getFullName());
            employee.setEmail(newEmployee.getEmail());
            employee.setPhoneNumber(newEmployee.getPhoneNumber());
            employee.setExperience(newEmployee.getExperience());
            employee.setPosition(newEmployee.getPosition());
            employee.setGender(newEmployee.getGender());

            return "Employee successfully updated!";
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoOperationException("Error while updating employee", e);
        }
    }

    @Override
    public String deleteEmployee(Long employeeId) throws EntityNotFoundException, DaoOperationException {
        try {
            Employee employee = getById(employeeId);
            Database.employees.remove(employee);
            return "Employee successfully deleted!";
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoOperationException("Error while deleting employee", e);
        }
    }

    @Override
    public String deleteEmployeeByPharmacyId(Long employeeId, Long pharmacyId) throws DaoOperationException, EntityNotFoundException {
        try {
            Employee employee = getById(employeeId);
            Pharmacy pharmacy = null;

            for (Pharmacy p : Database.pharmacies) {
                if (p.getId().equals(pharmacyId)) {
                    pharmacy = p;
                    break;
                }
            }
            if (pharmacy == null) {
                throw new EntityNotFoundException("Pharmacy with ID " + pharmacyId + " not found!");
            }

            boolean removed = pharmacy.getEmployee().remove(employee);
            return removed
                    ? "Employee with ID " + employeeId + " successfully removed from pharmacy with ID " + pharmacyId
                    : "Employee with ID " + employeeId + " not found in pharmacy with ID " + pharmacyId;
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoOperationException("Error while removing employee from pharmacy", e);
        }
    }

    @Override
    public String deleteAllEmployeesInPharmacy(Long pharmacyId) throws DaoOperationException, EntityNotFoundException {
        try {
            Pharmacy pharmacy = null;

            for (Pharmacy p : Database.pharmacies) {
                if (p.getId().equals(pharmacyId)) {
                    pharmacy = p;
                    break;
                }
            }
            if (pharmacy == null) {
                throw new EntityNotFoundException("Pharmacy with ID " + pharmacyId + " not found!");
            }

            pharmacy.getEmployee().clear();
            return "All employees successfully removed from pharmacy with ID " + pharmacyId;
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoOperationException("Error while removing employees from pharmacy", e);
        }
    }
}
