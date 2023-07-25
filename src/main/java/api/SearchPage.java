package api;

import java.util.HashMap;

public class SearchPage {

    public HashMap<String, String> getQueryParams(String query) {

        HashMap<String, String> queryParams = new HashMap<>();
        queryParams.put("scope", "desktop");
        queryParams.put("lang", "es");
        queryParams.put("store", "es");
        queryParams.put("session", "493f2f2b-db18-4844-b9a0-fc66239221a7");
        queryParams.put("rows", "24");
        queryParams.put("start", "0");
        queryParams.put("origin", "default");
        queryParams.put("q", query);
        return queryParams;
    }
}
