package sg.edu.np.madpractical2;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder{
    public View view;
    public TextView name;
    public TextView description;

    public UserViewHolder(View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.textViewName);
        description = itemView.findViewById(R.id.textViewDescription);
        view = itemView;
    }
}
