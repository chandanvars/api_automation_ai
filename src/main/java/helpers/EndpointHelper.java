package helpers;

public class EndpointHelper {

    public static String getPetEndpoint() {
        return "/pet";
    }

    public static String getPetByIdEndpoint(long petId) {
        return "/pet/" + petId;
    }

    public static String getFindByStatusEndpoint() {
        return "/pet/findByStatus";
    }

    public static String getPetFormUpdateEndpoint(long petId) {
        return "/pet/" + petId;
    }

    public static String getDeletePetEndpoint(long petId) {
        return "/pet/" + petId;
    }
}
