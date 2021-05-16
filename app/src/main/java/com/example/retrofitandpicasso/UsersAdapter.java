package com.example.retrofitandpicasso;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserAdapterViewHolder> {
    private List<UserResponse.Item> mUserResponseList = new ArrayList<>();

    @Override
    public int getItemCount() {
        return mUserResponseList.size();
    }

    @NonNull
    @Override
    public UserAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        return new UserAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.row_users, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterViewHolder holder, int position) {
        holder.bind(mUserResponseList.get(position));
    }

    public void setData(List<UserResponse.Item> heroes) {
        mUserResponseList = heroes;
        notifyDataSetChanged();
    }

    public static class UserAdapterViewHolder extends RecyclerView.ViewHolder {
        public UserAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(UserResponse.Item userResponse) {
            ImageView iv = itemView.findViewById(R.id.imageBeer);
            Picasso.get()
                    .load(userResponse.image.url)
                    .into(iv);
            ((TextView) itemView.findViewById(R.id.beerName)).setText(userResponse.name);


        }
    }
}
