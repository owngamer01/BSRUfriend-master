package appewtc.masterung.bsrufriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

public class ListFriend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friend);

        ListView listView = (ListView) findViewById(R.id.ListViewFriend);

        // Create Listview
        try {

            GetUser getUser = new GetUser(ListFriend.this);
            MyConstand myConstand = new MyConstand();
            getUser.execute(myConstand.getUrlPHP());
            String strJSON = getUser.get();

            JSONArray jsonArray = new JSONArray(strJSON);
            final String[] nameStrings = new String[jsonArray.length()];
            final String[] imageStrings1 = new String[jsonArray.length()];
            final String[] latStrings1 = new String[jsonArray.length()];
            final String[] lngStrings1 = new String[jsonArray.length()];

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                nameStrings[i] = jsonObject.getString("Name");
                imageStrings1[i] = jsonObject.getString("Image");
                latStrings1[i] = jsonObject.getString("Lat");
                lngStrings1[i] = jsonObject.getString("Lng");

            } // forLoop

            FriendAdapter friendAdapter = new FriendAdapter(ListFriend.this, imageStrings1, nameStrings);
            listView.setAdapter(friendAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    Intent intent = new Intent(ListFriend.this, DetailFriend.class);
                    intent.putExtra("Name", nameStrings[i]);
                    intent.putExtra("Image", imageStrings1[i]);
                    intent.putExtra("Lat", latStrings1[i]);
                    intent.putExtra("Lng", lngStrings1[i]);
                    startActivity(intent);

                }
            });






        } catch (Exception ex) {
            Log.d("17V4", "ERROR Create ListView => " + ex);

        }
    }
}
