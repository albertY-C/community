package chaoimi.community.Provider;

import chaoimi.community.dto.AccessTokenDTO;
import com.alibaba.fastjson.JSON;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GitHubProvider {
        public String getAccessToken(AccessTokenDTO accessTokenDTO){
            MediaType mediaType = MediaType.get("application/json; charset=utf-8");

            OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO), mediaType);
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            } catch (IOException e) {
            }
            return null;
        }
}
