package sg.edu.np.mad.practical3cyrus;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ImageView imageCenter = findViewById(R.id.imageView);

        imageCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                builder.setTitle("Profile");
                builder.setMessage("MADness");
                builder.setCancelable(true);
                builder.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int min = 0;
                        int max = 999999999;
                        int int_random = (int)Math.floor(Math.random()*(max-min+1)+min);
                        Intent loadProfile = new Intent(ListActivity.this, MainActivity.class);
                        loadProfile.putExtra("randomInteger",int_random);
                        startActivity(loadProfile);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){}
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}