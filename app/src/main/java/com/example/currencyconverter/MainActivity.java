package com.example.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText inputtext;
    TextView result;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button convert;
    public static String s;   //create objects

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  //load xml file
        inputtext = findViewById(R.id.editTextinput);
        result = findViewById(R.id.textViewresult);
        radioGroup = findViewById(R.id.radioGroupcurr);
        convert = findViewById(R.id.buttonconvert);         //fetched all ids and connected them with the objects
            convert.setOnClickListener(new View.OnClickListener() {  //set on click listener
                    @Override
                    public void onClick (View v){
                    int radioID = radioGroup.getCheckedRadioButtonId(); //fetch the id of the checked radio button
                    radioButton = findViewById(radioID);    //radio button is connected with the id
                    final String selectedradiobutton = (String) radioButton.getText();  //fetching the name of the checked radio button
                    try {
                        s = inputtext.getText().toString(); // getting the input as a string
                        Float a = Float.parseFloat(s);  //converting it to a value
                        switch (selectedradiobutton)            // figure out a way to fetch values from strings.xml and compare
                        {
                            case "US Dollar":
                                double res = a * 0.014;  //calc result
                                setText(res);   //update result in this function call
                                break;
                            case "Austrailian Dollar":
                                double res1 = a * 0.020;  //calc result
                                setText(res1);  //update result in this function call
                                break;
                            case "Euro":
                                double res2 = a * 0.013;  //calc result
                                setText(res2);  //update result in this function call
                                break;
                            case "Yen":
                                double res3 = a * 1.49;  //calc result
                                setText(res3);  //update result in this function call
                                break;
                            default:
                                Toast.makeText(getApplicationContext(), "Choose a currency", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                    catch(Exception e)  //if the input is empty then catch it and log it
                        {
                            Log.d(String.valueOf(e),"Exception Occurred");
                            Toast.makeText(getApplicationContext(),"Enter a currency",Toast.LENGTH_SHORT).show();
                        }
                }

                private void setText(double res) {
                    String resStr = String.valueOf(res);  //convert result to string
                    result.setText(resStr);  //update result
                }
            });
        }

    /*
    private void converttoyen() {
        float a = Float.parseFloat(s);
        float res = (float) (a * 1.49);
        String resStr = String.valueOf(res);
        result.setText(resStr);
    }

    private void converttoeur() {
        float a = Integer.parseInt(s);
        float res = (float) (a * 0.013);
        String resStr = String.valueOf(res);
        result.setText(resStr);
    }

    private void converttoaus() {
        float a = Integer.parseInt(s);
        float res = (float) (a * 0.020);
        String resStr = String.valueOf(res);
        result.setText(resStr);
    }

    private void converttousd() {
        float a = Integer.parseInt(s);
        float res = (float) (a * 0.014);
        String resStr = String.valueOf(res);
        result.setText(resStr);


    }
    */
}
