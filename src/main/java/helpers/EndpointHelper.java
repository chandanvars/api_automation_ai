package helpers;

public class EndpointHelper {
    // Pet endpoints
    public static final String ADD_PET = "/pet";
    public static final String UPDATE_PET = "/pet";
    public static final String GET_PET_BY_ID = "/pet/{petId}";
    public static final String FIND_PETS_BY_STATUS = "/pet/findByStatus";
    public static final String UPDATE_PET_FORM = "/pet/{petId}";
    public static final String DELETE_PET = "/pet/{petId}";
    public static final String UPLOAD_PET_IMAGE = "/pet/{petId}/uploadImage";

    // Store endpoints
    public static final String PLACE_ORDER = "/store/order";
    public static final String GET_ORDER_BY_ID = "/store/order/{orderId}";
    public static final String DELETE_ORDER = "/store/order/{orderId}";
    public static final String GET_INVENTORY = "/store/inventory";
}