package data;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkhttpClient {

    OkHttpClient client = new OkHttpClient().newBuilder()
            .build();
    MediaType mediaType = MediaType.parse("text/plain");
    RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
            .addFormDataPart("pond_id","625d7033a9a73e090c65cda2")
            .addFormDataPart("feed_type_id","625d74fba9a73e090c65cda5")
            .addFormDataPart("feed_dose","1500")
            .build();
    Request request = new Request.Builder()
            .url("http://jft.web.id/fishapi/api/feedhistorys")
            .method("POST", body)
            .build();
    Response response = client.newCall(request).execute();

    public OkhttpClient() throws IOException {
    }
}
