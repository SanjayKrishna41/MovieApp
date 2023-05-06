package com.sanjay.app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MovieViewHolder> {
    List<Search> movieList;
    private Context context;

    MovieListAdapter(List<Search> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MovieListAdapter.MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_containor, parent, false);
        MovieViewHolder viewHolder = new MovieViewHolder(view);
        context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Search movie = movieList.get(position);
        Glide.with(context)
                .load(movie.getPoster())
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.moviePoster);
        holder.movieTitle.setText("Title : "+movie.getTitle());
        holder.movieYear.setText("Year : "+movie.getYear());
        holder.type.setText("Type : "+movie.getType());
        holder.movieCard.setOnClickListener(view -> {
            Intent intent = new Intent(context,MovieDetailsActivity.class);
            intent.putExtra("imdb_id",movie.getImdbID());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        public ImageView moviePoster;
        public TextView movieTitle;
        public TextView movieYear;
        public TextView type;
        public CardView movieCard;

        public MovieViewHolder(View itemView) {
            super(itemView);
            this.moviePoster = (ImageView) itemView.findViewById(R.id.movie_poster);
            this.movieTitle = (TextView) itemView.findViewById(R.id.movie_title);
            this.movieYear = (TextView) itemView.findViewById(R.id.movie_year);
            this.type = (TextView) itemView.findViewById(R.id.movie_type);
            this.movieCard = (CardView) itemView.findViewById(R.id.movie_card);
        }
    }
}
