package com.example.lab1.adapters;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.lab1.R;
import com.example.lab1.model.MovieItem;

import java.util.ArrayList;

public class MoviesListAdapter extends ArrayAdapter<String> {

    private final Fragment context;
    private final ArrayList<MovieItem> movies;
    private final ArrayList<String> maintitle;

    public MoviesListAdapter(Fragment context, ArrayList<MovieItem> movies, ArrayList<String> maintitle) {

        super(context.getContext(), R.layout.display_movie_item, maintitle);

        this.context=context;
        this.movies=movies;
        this.maintitle = maintitle;
        System.out.println("Got here con");
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        @SuppressLint({"ViewHolder", "InflateParams"}) View rowView=inflater.inflate(R.layout.display_movie_item, null,true);

        ImageView image = (ImageView) rowView.findViewById(R.id.poster);
        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        TextView yearText = (TextView) rowView.findViewById(R.id.year);
        TextView typeText = (TextView) rowView.findViewById(R.id.type);

        int drawableResourceId = this.getContext().getResources().getIdentifier(
                movies.get(position).getPoster().toLowerCase().replace(".jpg", ""),
                "drawable", this.getContext().getPackageName());
        if (drawableResourceId == 0)
            image.setImageResource(R.drawable.no_poster);
        else
            image.setImageResource(drawableResourceId);

        titleText.setText(maintitle.get(position));
        yearText.setText(movies.get(position).getYear());
        typeText.setText(movies.get(position).getType());

        return rowView;
    };
}
