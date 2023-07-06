package api;

import java.util.HashMap;

public class LoginPageObject {

    public HashMap<String, String> getQueryParams(String username, String password){

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("client_id","web_ey");
        queryParams.put("client_secret","secret");
        queryParams.put("grant_type","password");
        queryParams.put("username", username);
        queryParams.put("password", password);
        return queryParams;
    }
}
