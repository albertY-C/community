package chaoimi.community.Provider;

import chaoimi.community.dto.AccessTokenDTO;
import chaoimi.community.dto.GitHubUser;
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
                String string = response.body().string();
                System.out.println(string);
                return string;
            } catch (IOException e) {
            }
            return null;
        }

        public GitHubUser gitHubUser(String accessToken){
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url("https://api.github.com/user?access_token="+accessToken)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                String string = response.body().string();
                GitHubUser gitHubUser = JSON.parseObject(string, GitHubUser.class);
                return gitHubUser;
            } catch (IOException e) {
            }
            return null;
        }
}
