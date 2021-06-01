package sg.edu.np.madpractical2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DBHandler dbhandler = new DBHandler(this, null, null, 1);
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView nameTextView = (TextView) findViewById(R.id.textView);
        final TextView descriptionTextView = (TextView) findViewById(R.id.textView2);
        final Button followButton = findViewById(R.id.button4);
        nameTextView.setText(getIntent().getStringExtra("Name"));
        descriptionTextView.setText(getIntent().getStringExtra("Description"));
        if (getIntent().getBooleanExtra("Followed", false) == true) {
            followButton.setText(R.string.unfollow_button);
        }
        followButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                User u = dbhandler.getUsers().get(getIntent().getIntExtra("Id",
                        0));
                System.out.println(u.getId());
                if (followButton.getText().equals("Follow")) {
                    followButton.setText(R.string.unfollow_button);
                    u.setFollowed(true);
                    dbhandler.updateUser(u);
                    Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT).show();
                } else {
                    followButton.setText(R.string.follow_button);
                    u.setFollowed(false);
                    Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}