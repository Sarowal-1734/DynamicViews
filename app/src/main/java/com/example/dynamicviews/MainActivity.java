package com.example.dynamicviews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout linearLayout_views_list;
    private ArrayList<CricketerModel> cricketerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout_views_list = findViewById(R.id.linearLayout_views_list);
        cricketerList = new ArrayList<>();
    }

    public void onAddButtonClicked(View view) {
        // Inflate the view
        View cricketerView = getLayoutInflater().inflate(R.layout.cricketer_list, null, false);

        // Init
        AutoCompleteTextView editTextCricketerName = (AutoCompleteTextView) cricketerView.findViewById(R.id.editTextCricketerName);
        AutoCompleteTextView editTextTeam = (AutoCompleteTextView) cricketerView.findViewById(R.id.editTextTeam);
        ImageView imageViewDelete = (ImageView) cricketerView.findViewById(R.id.imageViewDelete);

        // Set adapter on editTextTeam
        ArrayList<String> teams = new ArrayList<>();
        teams.add("Australia");
        teams.add("Bangladesh");
        teams.add("India");
        teams.add("South Africa");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1
                , teams);
        editTextTeam.setAdapter(adapter);

        // Set the view
        linearLayout_views_list.addView(cricketerView);

        // Remove the view when click the delete image
        imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout_views_list.removeView(cricketerView);
            }
        });
    }

    public void onSubmitButtonClicked(View view) {
        if (validation()) {
            // Show data to recyclerView
            RecyclerView recyclerView = findViewById(R.id.recyclerView);
            CricketerAdapter adapter = new CricketerAdapter(MainActivity.this, cricketerList);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adapter);
        }
    }

    private boolean validation() {
        cricketerList.clear();
        boolean result = true;

        if (linearLayout_views_list.getChildCount() == 0) {
            Toast.makeText(this, "Add Cricketers First!", Toast.LENGTH_SHORT).show();
            return false;
        }

        for (int i=0; i<linearLayout_views_list.getChildCount(); i++) {
            View view = linearLayout_views_list.getChildAt(i);
            AutoCompleteTextView editTextCricketerName = (AutoCompleteTextView) view.findViewById(R.id.editTextCricketerName);
            AutoCompleteTextView editTextTeam = (AutoCompleteTextView) view.findViewById(R.id.editTextTeam);
            CricketerModel cricketerModel = new CricketerModel();

            if (!editTextCricketerName.getText().toString().equals("")) {
                cricketerModel.setCricketerName(editTextCricketerName.getText().toString());
            } else {
                result = false;
                break;
            }
            if (!editTextTeam.getText().toString().equals("")) {
                cricketerModel.setTeamName(editTextTeam.getText().toString());
            } else {
                result = false;
                break;
            }

            cricketerList.add(cricketerModel);
        }

        if (!result) {
            Toast.makeText(this, "All Fields Are Required!", Toast.LENGTH_SHORT).show();
        }
        return result;
    }
}