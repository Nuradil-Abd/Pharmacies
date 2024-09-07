package peaksoft.databae;

public class GenerateId {

    public static Long pharmacyId = 0L;
    public static Long employeeId = 0L;
    public static Long medicineId = 0L;

    public static long genPharmacy(){
        return ++pharmacyId;
    }
    public static long genMedicine(){
        return ++medicineId;
    }
    public static long genEmployee(){
        return ++employeeId;
    }
}
