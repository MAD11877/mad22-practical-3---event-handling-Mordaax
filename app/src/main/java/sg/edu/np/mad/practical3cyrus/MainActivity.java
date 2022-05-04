package sg.edu.np.mad.practical3cyrus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent receivingEnd = getIntent();
        int randomInteger = receivingEnd.getIntExtra("randomInteger", 1);

        User newUser = new User("MAD"+" "+randomInteger,"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua",1,false);

        TextView textViewName = findViewById(R.id.textViewName);
        textViewName.setText(newUser.name);

        TextView textViewDescription = findViewById(R.id.textViewDescription);
        textViewDescription.setText(newUser.description);

        Button buttonFollow = findViewById(R.id.buttonFollow);
        buttonFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonFollow.setText(newUser.followed ? "Follow" : "UnFollow");
                Toast.makeText(getApplicationContext(), newUser.followed? "UnFollowed" : "Followed",Toast.LENGTH_SHORT).show();
                newUser.followed = !newUser.followed;
            }
        });

        Button buttonMessage = findViewById(R.id.buttonMessage);
        buttonMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loadMessageGroup = new Intent(MainActivity.this,MessageGroup.class);
                startActivity(loadMessageGroup);
            }
        });

    }
}