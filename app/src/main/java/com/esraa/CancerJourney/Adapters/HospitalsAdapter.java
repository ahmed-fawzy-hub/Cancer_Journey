package com.esraa.CancerJourney.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.esraa.CancerJourney.Models.ModelKeyData;
import com.esraa.CancerJourneyApp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HospitalsAdapter extends RecyclerView.Adapter<HospitalsAdapter.viewHolder> {
    private ArrayList<ModelKeyData> list;
    private Context context;
    private interfaceClickListener mListener;

    public void  setUpOnClickListener(interfaceClickListener mListener) {
        this.mListener = mListener;
    }

    public HospitalsAdapter(ArrayList<ModelKeyData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_profile, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ModelKeyData data = list.get(position);
        holder.name.setText(data.getName());

        if (data.getImageUrl()!=null && !data.getImageUrl().isEmpty())
            Picasso.get().load(Uri.parse(data.getImageUrl())).placeholder(R.color.placeholder_bg).into(holder.image);
        else
            holder.image.setImageResource(R.drawable.hospital_assit);
    }

    @Override
    public int getItemCount() {
        return(list!=null? list.size() : 0);
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.text_name) TextView name;
        @BindView(R.id.profileImage) ImageView image;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.holderClick(getAdapterPosition());
                }
            });
        }
    }

    public interface interfaceClickListener{
        void holderClick(int position);
    }
}
