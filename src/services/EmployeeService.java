package services;

import peaksoft.exceptions.DaoOperationException;
import peaksoft.exceptions.EntityNotFoundException;
import peaksoft.models.Employee;

import java.util.List;

public interface EmployeeService {

    String saveEmployee(Employee employee) throws DaoOperationException;
    String assignEmployeeToPharmacy(Long pharmacyId, Long employeeId) throws DaoOperationException, EntityNotFoundException;
    List<Employee> getAllEmployees();
    List<Employee> getAllEmployeesInPharmacy(Long pharmacyId) throws DaoOperationException, EntityNotFoundException;
    Employee getById (Long employeeId) throws DaoOperationException, EntityNotFoundException;
    String updateEmployees (Long employeeId, Employee newEmployee) throws DaoOperationException, EntityNotFoundException;
    String deleteEmployee (Long employeeId) throws DaoOperationException, EntityNotFoundException;
    String deleteEmployeeByPharmacyId (Long employeeId, Long pharmacyId ) throws DaoOperationException, EntityNotFoundException;
    String deleteAllEmployeesInPharmacy(Long pharmacyId) throws DaoOperationException, EntityNotFoundException;
}
