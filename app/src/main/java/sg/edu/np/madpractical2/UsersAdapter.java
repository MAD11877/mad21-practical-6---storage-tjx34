package sg.edu.np.madpractical2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UserViewHolder> {
    Context context;
    ArrayList<User> userList;
    AlertDialog.Builder builder;

    private static final int LAYOUT = 0;
    private static final int LAYOUT_EXTRA = 1;

    @Override
    public int getItemViewType(int position) {
        User user = userList.get(position);
        if (user.getName().substring(user.getName().length() - 1).equals("7")) {
            return LAYOUT_EXTRA;
        }
        else {
            return LAYOUT;
        }
    }

    public UsersAdapter(Context c, ArrayList<User> ul) {
        context = c;
        userList = ul;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View item;
        if (viewType == LAYOUT_EXTRA) {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_user_extra,
                    parent, false);
        }
        else {
            item = LayoutInflater.from(parent.getContext()).inflate(R.layout.vh_user, parent,
                    false);
        }
        return new UserViewHolder(item);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        builder = new AlertDialog.Builder(context);
        User user = userList.get(position);

        if (holder.getItemViewType() == LAYOUT_EXTRA) {
            ;
        }
        else {
            holder.name.setText(user.getName());
            holder.description.setText(user.getDescription());
        }
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                builder.setMessage(user.getName())
                        .setCancelable(false)
                        .setPositiveButton("View", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(context, MainActivity.class);
                                i.putExtra("Name", user.getName());
                                i.putExtra("Description", user.getDescription());
                                i.putExtra("Followed", user.getFollowed());
                                i.putExtra("Id", user.getId());
                                context.startActivity(i);
                            }
                        })
                        .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.setTitle("Profile");
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
