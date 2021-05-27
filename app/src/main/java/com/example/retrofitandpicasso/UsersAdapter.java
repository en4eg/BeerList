package com.example.retrofitandpicasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitandpicasso.data.remote.model.HeroResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserAdapterViewHolder> {
    private List<HeroResponse.Item> mUserResponseList = new ArrayList<>();
    private List<HeroResponse.Item> mFilteredUserResponseList = new ArrayList<>();
    private String mFilter = "";
    private OnClickListener mOnClickListener = null;

    @Override
    public int getItemCount() {
        return mUserResponseList.size();
    }

    @NonNull
    @Override
    public UserAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        return new UserAdapterViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapterViewHolder holder, int position) {
        holder.bind(mFilteredUserResponseList.get(position));
    }

    public void setListener(OnClickListener listener) {
        mOnClickListener = listener;
    }

    public void setData(List<HeroResponse.Item> heroes) {
        mUserResponseList = heroes;
        notifyDataSetChanged();
    }

    public int getHeroesCount() {
        return mUserResponseList.size();
    }

    public void addHeroes(List<HeroResponse.Item> heroes) {
        mUserResponseList.addAll(heroes);
        for (HeroResponse.Item pokemon : heroes) {
            if (pokemon.name.contains(mFilter)) {
                mFilteredUserResponseList.add(pokemon);
            }
        }
    }

    public void setFilter(String filter) {
        mFilter = filter;
        mFilteredUserResponseList.clear();
        if (filter.length() == 0) {
            mFilteredUserResponseList.addAll(mUserResponseList);
        } else {
            for (HeroResponse.Item pokemon : mUserResponseList) {
                if (pokemon.name.contains(filter)) {
                    mFilteredUserResponseList.add(pokemon);
                }
            }
        }
    }

    interface OnClickListener {
        void onClick(HeroResponse.Item item);

    }

    public class UserAdapterViewHolder extends RecyclerView.ViewHolder {
        public UserAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bind(HeroResponse.Item userResponse) {
            ImageView iv = itemView.findViewById(R.id.imageBeer);
            Picasso.get()
                    .load(userResponse.image.url)
                    .into(iv);
            ((TextView) itemView.findViewById(R.id.beerName)).setText(userResponse.name);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnClickListener.onClick(userResponse);
                }
            });
        }
    }
}
