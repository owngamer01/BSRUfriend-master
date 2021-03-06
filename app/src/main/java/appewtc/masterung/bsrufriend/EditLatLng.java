package appewtc.masterung.bsrufriend;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by echolaojue on 17-Feb-17.
 */

public class EditLatLng extends AsyncTask<String, Void, String> {

    // Explicit
    private Context context;
    private String idString;
    private static final String urlPHP = "http://swiftcodingthai.com/bsru/edit_latlng_tae.php";

    public EditLatLng(Context context, String idString) {
        this.context = context;
        this.idString = idString;
    }


    @Override
    protected String doInBackground(String... strings) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("id", idString)
                    .add("Lat", strings[0])
                    .add("Lng", strings[1])
                    .build();

            Request.Builder builder = new Request.Builder();
            Request request = builder.url(urlPHP).post(requestBody).build();
            Response response = okHttpClient.newCall(request).execute();

        } catch (Exception ex) {
            Log.d("17V2", "Error doInBack => " + ex);
        }
        return null;
    }
}   // Main Class
