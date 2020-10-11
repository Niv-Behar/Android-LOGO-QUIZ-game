package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;


public class CountryAdapter extends BaseAdapter implements CompoundButton.OnCheckedChangeListener,View.OnClickListener{

    final int NUM_OF_CELL_TYPES = 2;

    final int REGUALAR_COUNTRY_TYPE = 0;
    final int POPULATION_COUNTRY_TYPE = 1;

    private List<Country> countries;
    private Context context;

    public CountryAdapter(List<Country> countries, Context context) {
        this.countries = countries;
        this.context = context;
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int i) {
        return countries.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Country country = countries.get(i);

        if(view == null) {
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if(country.isHasComplited()) view = layoutInflater.inflate(R.layout.special,viewGroup,false);
            else view = layoutInflater.inflate(R.layout.country,viewGroup,false);
        }


        Button moveBtn = view.findViewById(R.id.move_btn);
        moveBtn.setTag(i);
        moveBtn.setOnClickListener(this);

        TextView countryTv = view.findViewById(R.id.country_name);

        if(country.isHasComplited()) {
            TextView populationTv = view.findViewById(R.id.country_population);
            populationTv.setText(country.getComplited());
        }
        ImageView countryIv = view.findViewById(R.id.country_flag);

        countryTv.setText(country.getName());
        countryIv.setImageResource(country.getFlagResId());


        return view;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        int position  = (Integer)compoundButton.getTag();
        Country country = countries.get(position);
        country.getActive(b);
    }

    @Override
    public void onClick(View view){

        int position = (Integer)view.getTag();
        Country country = countries.get(position);
        if(country.Active())
            if(country.getName()==" 7")
                Toast.makeText(context,country.getName()+" - 15 ", Toast.LENGTH_LONG).show();
            else if(country.getName()==" 8")
                Toast.makeText(context,country.getName()+" - 20 ", Toast.LENGTH_LONG).show();
            else if(country.getName()==" 15")
                Toast.makeText(context,country.getName()+" - 20 ", Toast.LENGTH_LONG).show();
            else if(country.getName()==" 16")
                Toast.makeText(context,country.getName()+" - 25 ", Toast.LENGTH_LONG).show();
            else if(country.getName()==" 23")
                Toast.makeText(context,country.getName()+" - 20 ", Toast.LENGTH_LONG).show();
            else if(country.getName()==" 24")
                Toast.makeText(context,country.getName()+" - 30 ", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(context,country.getName()+" - 10 ", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(context,country.getName()+" X ", Toast.LENGTH_LONG).show();

    }

    @Override
    public int getViewTypeCount() {
        return NUM_OF_CELL_TYPES;
    }

    @Override
    public int getItemViewType(int position) {
        if(countries.get(position).isHasComplited()) return POPULATION_COUNTRY_TYPE;
        return REGUALAR_COUNTRY_TYPE;
    }
}

