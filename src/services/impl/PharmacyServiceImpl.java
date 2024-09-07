package services.impl;

import peaksoft.dao.PharmacyDao;
import peaksoft.dao.impl.PharmacyDaoImpl;
import peaksoft.exceptions.DaoOperationException;
import peaksoft.exceptions.EntityNotFoundException;
import peaksoft.models.Pharmacy;
import services.PharmacyService;

import java.util.List;

public class PharmacyServiceImpl implements PharmacyService {
    PharmacyDao pharmacyDao = new PharmacyDaoImpl();

    @Override
    public String savePharmacy(Pharmacy pharmacy) throws DaoOperationException {
        return pharmacyDao.savePharmacy(pharmacy);
    }

    @Override
    public List<Pharmacy> getAllPharmacy() {
        return pharmacyDao.getAllPharmacy();
    }

    @Override
    public Pharmacy getById(Long pharmacyId) throws EntityNotFoundException {
        return pharmacyDao.getById(pharmacyId);
    }

    @Override
    public String updatePharmacy(Long pharmacyId, Pharmacy newPharmacy) throws DaoOperationException, EntityNotFoundException {
        return pharmacyDao.updatePharmacy(pharmacyId, newPharmacy);
    }

    @Override
    public String deletePharmacy(Long pharmacyId) throws DaoOperationException, EntityNotFoundException {
        return pharmacyDao.deletePharmacy(pharmacyId);
    }
}
