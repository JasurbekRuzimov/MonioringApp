package uz.jasurbekruzimov.monitoringapp.Api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> loginWithCredentials(@Field("email") String email, @Field("password") String password);

}
