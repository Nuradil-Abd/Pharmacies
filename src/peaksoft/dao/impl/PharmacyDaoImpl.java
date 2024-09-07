package peaksoft.dao.impl;

import peaksoft.dao.PharmacyDao;
import peaksoft.databae.Database;
import peaksoft.models.Pharmacy;
import peaksoft.exceptions.DaoOperationException;
import peaksoft.exceptions.EntityNotFoundException;

import java.util.List;

public class PharmacyDaoImpl implements PharmacyDao {

    @Override
    public String savePharmacy(Pharmacy pharmacy) throws DaoOperationException {
        try {
            Database.pharmacies.add(pharmacy);
            return "Pharmacy successfully saved!";
        } catch (Exception e) {
            throw new DaoOperationException("Error while saving pharmacy", e);
        }
    }

    @Override
    public List<Pharmacy> getAllPharmacy() {
        return Database.pharmacies;
    }

    @Override
    public Pharmacy getById(Long pharmacyId) throws EntityNotFoundException {
        for (Pharmacy pharmacy : Database.pharmacies) {
            if (pharmacy.getId().equals(pharmacyId)) {
                return pharmacy;
            }
        }
        throw new EntityNotFoundException("Pharmacy with ID " + pharmacyId + " not found!");
    }

    @Override
    public String updatePharmacy(Long pharmacyId, Pharmacy newPharmacy) throws DaoOperationException, EntityNotFoundException {
        try {
            Pharmacy pharmacy = getById(pharmacyId);
            pharmacy.setName(newPharmacy.getName());
            pharmacy.setAddress(newPharmacy.getAddress());
            return "Pharmacy successfully updated!";
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoOperationException("Error while updating pharmacy", e);
        }
    }

    @Override
    public String deletePharmacy(Long pharmacyId) throws DaoOperationException, EntityNotFoundException {
        try {
            Pharmacy pharmacy = getById(pharmacyId);
            Database.pharmacies.remove(pharmacy);
            return "Pharmacy successfully deleted!";
        } catch (EntityNotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new DaoOperationException("Error while deleting pharmacy", e);
        }
    }
}
