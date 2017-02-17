package appewtc.masterung.bsrufriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

public class ListFriend extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_friend);

        ListView listView = (ListView) findViewById(R.id.ListViewFriend);

        // Create Listview
        try {

            GetUser getUser = new GetUser(ListFriend.this);


        } catch (Exception ex) {
            Log.d("17V4", "ERROR Create ListView => " + ex);

        }
    }
}
