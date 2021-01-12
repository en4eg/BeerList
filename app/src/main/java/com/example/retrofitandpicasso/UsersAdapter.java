package com.example.retrofitandpicasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserAdapterViewHolder> {
    private List<UserResponse> userResponseList;

    public UsersAdapter() {
    }

    public void setData(List<UserResponse> userResponseList) {
        this.userResponseList = userResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        return new UserAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.row_users, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterViewHolder holder, int position) {
        ((UserAdapterViewHolder) holder).bind(userResponseList.get(position));
    }

    @Override
    public int getItemCount() {
        return userResponseList.size();
    }

    public class UserAdapterViewHolder extends RecyclerView.ViewHolder {
        public UserAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(UserResponse item) {
            ImageView iv = itemView.findViewById(R.id.imageBeer);
            Picasso.get().load(item.getImageUrl()).into(iv);
            ((TextView) itemView.findViewById(R.id.beerName)).setText(item.getName());

        }
    }
}
