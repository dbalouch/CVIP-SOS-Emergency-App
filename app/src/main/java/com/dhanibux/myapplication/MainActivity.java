package com.dhanibux.myapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.telephony.SmsManager;
import android.content.Intent;
import android.net.Uri;



import java.util.ArrayList;
import java.util.List;

// Import statements

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EmergencyContactsAdapter adapter;
    public final List<EmergencyContact> emergencyContacts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Use the correct layout

        recyclerView = findViewById(R.id.recyclerView); // Initialize the recyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Add sample emergency contacts (replace with your data)
        emergencyContacts.add(new EmergencyContact("Police", "15"));
        emergencyContacts.add(new EmergencyContact("Ambulance", "16"));
        emergencyContacts.add(new EmergencyContact("Dhani BuX", "03432717869"));
        adapter = new EmergencyContactsAdapter(emergencyContacts);
        recyclerView.setAdapter(adapter);
    }




    public void onSOSButtonClicked(View view) {

        Toast.makeText(this, "Emergency SOS triggered!", Toast.LENGTH_SHORT).show();
    }

    public void onSendMessageButtonClicked(View view) {
        // TODO: Implement sending emergency messages
        // For this example, we'll use a dummy message
        String message = "Emergency: I need help!";
        String phoneNumber = "03432717869";
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
        Toast.makeText(this, "Emergency message sent!", Toast.LENGTH_SHORT).show();
    }

    public void onMakeCallButtonClicked(View view) {
        // TODO: Implement making emergency calls
        // For this example, we'll use a dummy number
        String phoneNumber = "15"; // Replace with the emergency contact number
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
        startActivity(callIntent);
    }

    // Add more functions for handling emergency contacts, settings, etc.
}
