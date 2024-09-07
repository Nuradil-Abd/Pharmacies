package services;

import peaksoft.exceptions.DaoOperationException;
import peaksoft.exceptions.EntityNotFoundException;
import peaksoft.models.Pharmacy;

import java.util.List;

public interface PharmacyService {
    String savePharmacy(Pharmacy pharmacy) throws DaoOperationException;
    List<Pharmacy> getAllPharmacy();
    Pharmacy getById(Long pharmacyId) throws EntityNotFoundException;
    String updatePharmacy(Long pharmacyId, Pharmacy newPharmacy) throws DaoOperationException, EntityNotFoundException;
    String deletePharmacy(Long pharmacyId) throws DaoOperationException, EntityNotFoundException;
}
