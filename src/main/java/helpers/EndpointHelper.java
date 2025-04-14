package helpers;

public class EndpointHelper {
    // Pet endpoints
    public static final String ADD_PET = "/pet";
    public static final String UPDATE_PET = "/pet";
    public static final String FIND_PET_BY_ID = "/pet/{petId}";
    public static final String FIND_PETS_BY_STATUS = "/pet/findByStatus";
    public static final String UPDATE_PET_FORM = "/pet/{petId}";
    public static final String DELETE_PET = "/pet/{petId}";
    
    // Store endpoints
    public static final String PLACE_ORDER = "/store/order";
    public static final String GET_ORDER_BY_ID = "/store/order/{orderId}";
    public static final String DELETE_ORDER = "/store/order/{orderId}";
    public static final String GET_INVENTORY = "/store/inventory";
}