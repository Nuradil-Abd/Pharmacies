package peaksoft.dao;

import peaksoft.exceptions.DaoOperationException;
import peaksoft.exceptions.EntityNotFoundException;
import peaksoft.models.Employee;

import java.util.List;

public interface EmployeeDao {
    String saveEmployee(Employee employee) throws DaoOperationException;
    String assignEmployeeToPharmacy(Long pharmacyId, Long employeeId) throws EntityNotFoundException, DaoOperationException;
    List<Employee> getAllEmployees();
    List<Employee> getAllEmployeesInPharmacy(Long pharmacyId) throws EntityNotFoundException, DaoOperationException;
    Employee getById (Long employeeId) throws EntityNotFoundException, DaoOperationException;
    String updateEmployees (Long employeeId, Employee newEmployee) throws DaoOperationException, EntityNotFoundException;
    String deleteEmployee (Long employeeId) throws EntityNotFoundException, DaoOperationException;
    String deleteEmployeeByPharmacyId (Long employeeId, Long pharmacyId ) throws DaoOperationException, EntityNotFoundException;
    String deleteAllEmployeesInPharmacy(Long pharmacyId) throws DaoOperationException, EntityNotFoundException;
}
