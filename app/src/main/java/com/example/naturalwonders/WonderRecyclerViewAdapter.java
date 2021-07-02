package com.example.naturalwonders;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class WonderRecyclerViewAdapter extends RecyclerView.Adapter<WonderRecyclerViewAdapter.CustomViewHolder>  {
    Context ct;
    ArrayList<WonderGroup> atts;

    public WonderRecyclerViewAdapter(Context ct, ArrayList<WonderGroup> atts) {
        this.ct = ct;
        this.atts = atts;
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        TextView areaName;
        ListView areaAttractions;
        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            areaName = itemView.findViewById(R.id.area_name);
            areaAttractions = itemView.findViewById(R.id.area_attractions);
        }
    }

    @NonNull
    @Override
    public WonderRecyclerViewAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.group_item, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WonderRecyclerViewAdapter.CustomViewHolder holder, int position) {
        final WonderGroup wonderGroup = (WonderGroup) atts.get(position);
        final String[] attractionNames = wonderGroup.getAttractions().stream().map(Wonder::getName).toArray(String[]::new);
        holder.areaName.setText(wonderGroup.getAreaName());
        holder.areaName.setBackgroundColor(wonderGroup.getColor());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ct, R.layout.list_item, attractionNames);
        holder.areaAttractions.setAdapter(adapter);

        holder.areaAttractions.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
                Wonder wonder = wonderGroup.getAttractions().get(pos);
                Intent intent = new Intent(ct, WonderActivity.class);
                intent.putExtra("ATTRACTION_NAME", wonder.getName());
                intent.putExtra("ATTRACTION_IMAGE", wonder.getImageDrawable());
                intent.putExtra("ATTRACTION_DESCR", wonder.getDescription());
                intent.putExtra("ATTRACTION_COORDINATES", wonder.getCoordinates());
                intent.putExtra("ATTRACTION_COLOR", wonderGroup.getColor());
                ct.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return atts.size();
    }
}
