package services.impl;

import peaksoft.dao.EmployeeDao;
import peaksoft.dao.impl.EmployeeDaoImpl;
import peaksoft.exceptions.DaoOperationException;
import peaksoft.exceptions.EntityNotFoundException;
import peaksoft.models.Employee;
import services.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    @Override
    public String saveEmployee(Employee employee) throws DaoOperationException {
        return employeeDao.saveEmployee(employee);
    }

    @Override
    public String assignEmployeeToPharmacy(Long pharmacyId, Long employeeId) throws DaoOperationException, EntityNotFoundException {
        return employeeDao.assignEmployeeToPharmacy(pharmacyId, employeeId);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public List<Employee> getAllEmployeesInPharmacy(Long pharmacyId) throws DaoOperationException, EntityNotFoundException {
        return employeeDao.getAllEmployeesInPharmacy(pharmacyId);
    }

    @Override
    public Employee getById(Long employeeId) throws DaoOperationException, EntityNotFoundException {
        return employeeDao.getById(employeeId);
    }

    @Override
    public String updateEmployees(Long employeeId, Employee newEmployee) throws DaoOperationException, EntityNotFoundException {
        return employeeDao.updateEmployees(employeeId, newEmployee);
    }

    @Override
    public String deleteEmployee(Long employeeId) throws DaoOperationException, EntityNotFoundException {
        return employeeDao.deleteEmployee(employeeId);
    }

    @Override
    public String deleteEmployeeByPharmacyId(Long employeeId, Long pharmacyId) throws DaoOperationException, EntityNotFoundException {
        return employeeDao.deleteEmployeeByPharmacyId(employeeId, pharmacyId);
    }

    @Override
    public String deleteAllEmployeesInPharmacy(Long pharmacyId) throws DaoOperationException, EntityNotFoundException {
        return employeeDao.deleteAllEmployeesInPharmacy(pharmacyId);
    }
}
