package sg.edu.np.madpractical2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.app.AlertDialog;
import java.util.Random;

public class ListActivity extends AppCompatActivity {
    AlertDialog.Builder builder;
    DBHandler dbhandler = new DBHandler(this, null, null, 1);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        if (dbhandler.checkDBexists() == false) {
            for (int i = 0; i < 20; i++) {
                User user = new User();
                Random r = new Random();
                int nameID = r.nextInt(999999999);
                String name = String.valueOf(nameID);
                user.setName("Name " + name);
                int description_no = r.nextInt(999999999);
                String description = String.valueOf(description_no);
                user.setDescription("Description " + description);
                int followed_no = r.nextInt(2);
                if (followed_no == 0) {
                    user.setFollowed(true);
                }
                else {
                    user.setFollowed(false);
                }
                user.setId(i);
                dbhandler.addUser(user);
            }
        }

        RecyclerView rvUsers = findViewById(R.id.rvUsers);
        UsersAdapter adapter = new UsersAdapter(this, dbhandler.getUsers());
        System.out.println(dbhandler.getUsers().size());
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rvUsers.setLayoutManager(lm);
        rvUsers.setAdapter(adapter);

    }
}