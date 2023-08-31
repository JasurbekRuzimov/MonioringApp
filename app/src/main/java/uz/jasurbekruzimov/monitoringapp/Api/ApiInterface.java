package uz.jasurbekruzimov.monitoringapp.Api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("login") // Endpoint nomi
    Call<LoginResponse> loginUser(
            @Field("email") String email,
            @Field("password") String password
    );

    @FormUrlEncoded
    @POST("mobile/dashboard")
    Call<DashboardResponse>dashboard(
            @Field("all") int all,
            @Field("on_progress") int progress,
            @Field("succcessfullProjects") int sccsPr
            );
}
