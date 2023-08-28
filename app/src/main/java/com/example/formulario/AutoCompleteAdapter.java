package com.example.formulario;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteAdapter extends ArrayAdapter<String> implements Filterable {
    private List<String> data;

    public AutoCompleteAdapter(Context context, List<String> data) {
        super(context, android.R.layout.simple_dropdown_item_1line, data);
        this.data = new ArrayList<>(data);
    }

    public AutoCompleteAdapter(MainActivity context, String[] allCareers) {
        super(context, android.R.layout.simple_dropdown_item_1line);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public String getItem(int position) {
        return data.get(position);
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults results = new FilterResults();
                List<String> filteredData = new ArrayList<>();

                // Implementa aquí el filtrado según las necesidades
                // ...

                results.values = filteredData;
                results.count = filteredData.size();
                return results;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results.values != null) {
                    data = (List<String>) results.values;
                    notifyDataSetChanged();
                }
            }
        };
    }
}
