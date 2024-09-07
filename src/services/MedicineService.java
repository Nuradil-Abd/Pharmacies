package services;

import peaksoft.exceptions.DaoOperationException;
import peaksoft.exceptions.EntityNotFoundException;
import peaksoft.models.Medicine;

import java.util.List;

public interface MedicineService {
    String saveMedicine (Long pharmacy, Medicine medicine) throws DaoOperationException, EntityNotFoundException;

    List<Medicine> getAllMedicineByPharmacy(Long pharmacyId) throws DaoOperationException, EntityNotFoundException;

    Medicine getById ( Long medicineId) throws DaoOperationException, EntityNotFoundException;

    String  updateMedicine (Long medicineId, Medicine medicine) throws DaoOperationException, EntityNotFoundException;

    String deleteMedicine(Long medicineId) throws DaoOperationException, EntityNotFoundException;
}
