package peaksoft.dao;

import peaksoft.exceptions.DaoOperationException;
import peaksoft.exceptions.EntityNotFoundException;
import peaksoft.models.Pharmacy;

import java.util.List;

public interface PharmacyDao {

    //CRUD?
    // TODO create

    String savePharmacy (Pharmacy pharmacy) throws DaoOperationException;

    // TODO read

    List<Pharmacy> getAllPharmacy();

    Pharmacy getById(Long pharmacyId) throws EntityNotFoundException;
    // TODO update
    String updatePharmacy(Long pharmacyId, Pharmacy newPharmacy) throws DaoOperationException, EntityNotFoundException;


    // TODO delete
    String deletePharmacy(Long pharmacyId) throws DaoOperationException, EntityNotFoundException;
}
