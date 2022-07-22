package com.sinanfen.landmarkbookjava;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.sinanfen.landmarkbookjava.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    private ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());//XML ile CODE u baglayan bir yer. (Inflate)
        View view = binding.getRoot();
        setContentView(view);



        //Intent intent = getIntent();
        //Casting
        //Landmark selectedLandmark = (Landmark) intent.getSerializableExtra("landmark");
        //Landmark selectedLandmark = chosenLandmark;
        Singleton singleton = Singleton.getInstance();
        Landmark selectedLandmark = singleton.getSelectedLandmark();

        binding.nameText.setText(selectedLandmark.name);
        binding.countryText.setText(selectedLandmark.country);
        binding.imageView.setImageResource(selectedLandmark.image);

    }
}