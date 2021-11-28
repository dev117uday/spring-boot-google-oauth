package com.example.jwt.utility;

import java.io.IOException;

import com.example.jwt.entity.OAuthException;
import com.example.jwt.model.User;
import com.google.gson.Gson;

import org.springframework.stereotype.Component;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Component
public class GoogleOAuthUtility {

	public User verifyUserFromIdToken(String idToken) throws IOException, OAuthException {
		
		OkHttpClient client = new OkHttpClient().newBuilder()
				.build();

		String url = "https://www.googleapis.com/oauth2/v3/tokeninfo?id_token=" + idToken;

		Request request = new Request.Builder()
				.url(url)
				.method("GET", null)
				.build();
		Response response = client.newCall(request).execute();

		// TODO : tc for .execute();
		
		String userInfoString = response.body().string();
		Integer responseCode = response.code();

		response.close();

		// TODO : error handling acc. to status code
		
		if(responseCode/100 == 4) {
			throw new OAuthException("invalid id token", 400);
		}

		Gson gson = new Gson();
		User user = gson.fromJson(userInfoString, User.class);
		
		// TODO : JSON syntax error

		return user;
	}

}