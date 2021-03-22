package com.example.firebaseStore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database;
    DatabaseReference reference;
    EditText firstNum, secondNum;
    TextView textView;
    Button addButton, subtractButton, multiplyButton, divideButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstNum=findViewById(R.id.firstNumEditText);
        secondNum=findViewById(R.id.secondNumEditText);
        addButton=findViewById(R.id.addButton);
        subtractButton=findViewById(R.id.subtractButton);
        multiplyButton=findViewById(R.id.multiplyButton);
        divideButton=findViewById(R.id.divideButton);
        textView= findViewById(R.id.textView);
        addButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                int number1=Integer.parseInt(firstNum.getText().toString());
                int number2=Integer.parseInt(secondNum.getText().toString());
                String value1=String.valueOf(number1);
                String value2=String.valueOf(number2);
                Result result=new Result(number1,number2);
                int additionAnswer=number1+number2;
                String finalAnswer=String.valueOf(additionAnswer);
                textView.setText(additionAnswer+ "");
                String saveToDb = value1 + "+" + value2 + "=" + finalAnswer;
                FirebaseFirestore db=FirebaseFirestore.getInstance();
                HashMap<String, Object> equation =new HashMap<>();
                equation.put("equation: ", saveToDb );
                equation.put("timestamp", FieldValue.serverTimestamp());
                db.collection("equation").add(equation);

            }
        });
        subtractButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1=Integer.parseInt(firstNum.getText().toString());
                int number2=Integer.parseInt(secondNum.getText().toString());
                String value1=String.valueOf(number1);
                String value2=String.valueOf(number2);
                Result result=new Result(number1,number2);
                int additionAnswer=number1-number2;
                String finalAnswer=String.valueOf(additionAnswer);
                textView.setText(additionAnswer+ "");
                String saveToDb = value1 + "-" + value2 + "=" + finalAnswer;
                FirebaseFirestore db=FirebaseFirestore.getInstance();
                HashMap<String, Object> equation =new HashMap<>();
                equation.put("equation: ", saveToDb );
                equation.put("timestamp", FieldValue.serverTimestamp());
                db.collection("equation").add(equation);

            }
        });
        multiplyButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1=Integer.parseInt(firstNum.getText().toString());
                int number2=Integer.parseInt(secondNum.getText().toString());
                String value1=String.valueOf(number1);
                String value2=String.valueOf(number2);
                Result result=new Result(number1,number2);
                int additionAnswer=number1*number2;
                String finalAnswer=String.valueOf(additionAnswer);
                textView.setText(additionAnswer+ "");
                String saveToDb = value1 + "*" + value2 + "=" + finalAnswer;
                FirebaseFirestore db=FirebaseFirestore.getInstance();
                HashMap<String, Object> equation =new HashMap<>();
                equation.put("equation: ", saveToDb );
                equation.put("timestamp", FieldValue.serverTimestamp());
                db.collection("equation").add(equation);
            }
        });
        divideButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1=Integer.parseInt(firstNum.getText().toString());
                int number2=Integer.parseInt(secondNum.getText().toString());
                String value1=String.valueOf(number1);
                String value2=String.valueOf(number2);
                Result result=new Result(number1,number2);
                int additionAnswer=number1/number2;
                String finalAnswer=String.valueOf(additionAnswer);
                textView.setText(additionAnswer+ "");
                String saveToDb = value1 + "/" + value2 + "=" + finalAnswer;
                FirebaseFirestore db=FirebaseFirestore.getInstance();
                HashMap<String, Object> equation =new HashMap<>();
                equation.put("equation", saveToDb );
                equation.put("timestamp", FieldValue.serverTimestamp());
                db.collection("equation").add(equation);
            }
        });

    }
}
