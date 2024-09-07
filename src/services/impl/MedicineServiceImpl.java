package services.impl;

import peaksoft.dao.MedicineDao;
import peaksoft.dao.impl.MedicineDaoImpl;
import peaksoft.exceptions.DaoOperationException;
import peaksoft.exceptions.EntityNotFoundException;
import peaksoft.models.Medicine;
import services.MedicineService;

import java.util.List;

public class MedicineServiceImpl implements MedicineService {

    MedicineDao medicineDao = new MedicineDaoImpl();


    @Override
    public String saveMedicine(Long pharmacy, Medicine medicine) throws DaoOperationException, EntityNotFoundException {
       return medicineDao.saveMedicine(pharmacy, medicine);

    }

    @Override
    public List<Medicine> getAllMedicineByPharmacy(Long pharmacyId) throws DaoOperationException, EntityNotFoundException {
       return medicineDao.getAllMedicineByPharmacy(pharmacyId);

    }

    @Override
    public Medicine getById(Long medicineId) throws DaoOperationException, EntityNotFoundException {
        return medicineDao.getById(medicineId);
    }

    @Override
    public String updateMedicine(Long medicineId, Medicine medicine) throws DaoOperationException, EntityNotFoundException {
        return medicineDao.updateMedicine(medicineId, medicine);
    }

    @Override
    public String deleteMedicine(Long medicineId) throws DaoOperationException, EntityNotFoundException {
        return medicineDao.deleteMedicine(medicineId);
    }
}
