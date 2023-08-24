package com.dhanibux.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView; // Make sure to import TextView

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.List;

public class EmergencyContactsAdapter extends RecyclerView.Adapter<EmergencyContactsAdapter.ViewHolder> {

    private List<EmergencyContact> contacts;

    public EmergencyContactsAdapter(List<EmergencyContact> contacts) {
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        EmergencyContact contact = contacts.get(position); // Get the specific contact at this position
        holder.contactNameTextView.setText(contact.getName()); // Set the name of the contact
        holder.contactNumberTextView.setText(contact.getPhoneNumber()); // Set the phone number of the contact
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView contactNameTextView;
        TextView contactNumberTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contactNameTextView = itemView.findViewById(R.id.contactName); // Make sure it matches your XML
            contactNumberTextView = itemView.findViewById(R.id.contactNumber); // Make sure it matches your XML
        }
    }
}
