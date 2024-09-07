package peaksoft.dao.impl;

import peaksoft.dao.MedicineDao;
import peaksoft.databae.Database;
import peaksoft.models.Medicine;
import peaksoft.models.Pharmacy;
import peaksoft.exceptions.DaoOperationException;
import peaksoft.exceptions.EntityNotFoundException;

import java.util.List;

public class MedicineDaoImpl implements MedicineDao {

    @Override
    public String saveMedicine(Long pharmacyId, Medicine medicine) throws DaoOperationException, EntityNotFoundException {
        try {
            Pharmacy pharmacy = getPharmacyById(pharmacyId);
            pharmacy.getMedicines().add(medicine);
            return "Medicine successfully saved!";
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoOperationException("Error while saving medicine", e);
        }
    }

    @Override
    public List<Medicine> getAllMedicineByPharmacy(Long pharmacyId) throws EntityNotFoundException, DaoOperationException {
        try {
            Pharmacy pharmacy = getPharmacyById(pharmacyId);
            return pharmacy.getMedicines();
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoOperationException("Error while retrieving medicines by pharmacy", e);
        }
    }

    @Override
    public Medicine getById(Long medicineId) throws EntityNotFoundException, DaoOperationException {
        try {
            for (Pharmacy pharmacy : Database.pharmacies) {
                for (Medicine medicine : pharmacy.getMedicines()) {
                    if (medicine.getId().equals(medicineId)) {
                        return medicine;
                    }
                }
            }
            throw new EntityNotFoundException("Medicine with ID " + medicineId + " not found!");
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoOperationException("Error while retrieving medicine", e);
        }
    }

    @Override
    public String updateMedicine(Long medicineId, Medicine medicine) throws DaoOperationException, EntityNotFoundException {
        try {
            Medicine existingMedicine = getById(medicineId);
            existingMedicine.setName(medicine.getName());
            existingMedicine.setDescription(medicine.getDescription());
            existingMedicine.setPrice(medicine.getPrice());
            existingMedicine.setExpirationDate(medicine.getExpirationDate());
            return "Medicine successfully updated!";
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoOperationException("Error while updating medicine", e);
        }
    }

    @Override
    public String deleteMedicine(Long medicineId) throws DaoOperationException, EntityNotFoundException {
        try {
            Medicine medicineToRemove = getById(medicineId);
            boolean removed = false;

            for (Pharmacy pharmacy : Database.pharmacies) {
                if (pharmacy.getMedicines().remove(medicineToRemove)) {
                    removed = true;
                    break;
                }
            }

            if (removed) {
                return "Medicine successfully deleted!";
            } else {
                return "Medicine with ID " + medicineId + " could not be removed!";
            }
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoOperationException("Error while deleting medicine", e);
        }
    }

    private Pharmacy getPharmacyById(Long pharmacyId) throws EntityNotFoundException {
        for (Pharmacy pharmacy : Database.pharmacies) {
            if (pharmacy.getId().equals(pharmacyId)) {
                return pharmacy;
            }
        }
        throw new EntityNotFoundException("Pharmacy with ID " + pharmacyId + " not found!");
    }
}
