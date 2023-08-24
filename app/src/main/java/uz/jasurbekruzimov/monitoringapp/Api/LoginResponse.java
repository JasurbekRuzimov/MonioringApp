package uz.jasurbekruzimov.monitoringapp.Api;

public class LoginResponse {
    private boolean success; //kirish muvaffaqiyatli bo'lsa true qiymat qaytaradi
    private String message; //kirish haqida xabar
    private String token; //kirish muvaffaqiyatli bo'lsa token qiymat qaytaradi

    //getter va setter metodlari
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    //getter va setter metodlari
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //getter va setter metodlari
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}