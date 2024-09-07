import peaksoft.databae.GenerateId;
import peaksoft.models.Pharmacy;
import services.PharmacyService;
import services.impl.PharmacyServiceImpl;

public class Main {
    public static void main(String[] args) {
        PharmacyService pharmacyService = new PharmacyServiceImpl();
        Pharmacy pharmacy1 = new Pharmacy(GenerateId.genPharmacy(),"Neman","Vostok5");
        Pharmacy pharmacy2 = new Pharmacy(GenerateId.genPharmacy(),"Neman1","Vostok51");



    }
}