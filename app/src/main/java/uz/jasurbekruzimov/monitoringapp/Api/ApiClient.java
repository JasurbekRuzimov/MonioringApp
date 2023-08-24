package uz.jasurbekruzimov.monitoringapp.Api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "https://a1pms.uz/api/"; //serverning asosiy manzili
    private static Retrofit retrofit = null;

    public static ApiInterface getLoginApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ApiInterface.class);
    }


}

