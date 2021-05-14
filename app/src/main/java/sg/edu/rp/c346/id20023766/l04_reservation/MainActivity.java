package sg.edu.rp.c346.id20023766.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name;
    EditText mb;
    EditText groupsize;
    RadioGroup table;
    Button reset;
    Button Confirmation;
    DatePicker dp;
    TimePicker tp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.inputName);
        mb = findViewById(R.id.inputNunber);
        groupsize = findViewById(R.id.inputSize);
        table = findViewById(R.id.tableoption);
        reset = findViewById(R.id.resetButton);
        Confirmation = findViewById(R.id.Confirmation);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);

        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);
        dp.updateDate(2021, 0 , 1 );

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                if(tp.getCurrentHour() >= 21){
                    tp.setCurrentHour(20);
                }

            }
        });

    Confirmation.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String message = "";

            if(name.getText().toString().equals("") || mb.getText().toString().equals("") || groupsize.getText().toString().equals("")){
                Toast.makeText(MainActivity.this, "The fields required are empty", Toast.LENGTH_SHORT).show();
            }else{
                message += "[Name: " + name.getText().toString() + "]";
                message += " [Mobile Number: " + mb.getText().toString() + "]";
                message += " [Group Size: " + groupsize.getText() + "]";
            }

            int tablechoice = table.getCheckedRadioButtonId();
            if(tablechoice == R.id.nonsmokingtable){
                message += " [Table Area: Non-Smoking]";
            }else{
                message += " [Table Area: Smoking]";
            }

            message += " [Date: " + dp.getMonth() + "-" + dp.getDayOfMonth() + "-" + dp.getYear() + "]";
            message += " [Time: " + tp.getCurrentHour() + ":" + tp.getCurrentMinute() + "]";

            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    });

    reset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            name.setText("");
            mb.setText("");
            groupsize.setText("");
            tp.setCurrentHour(0);
            tp.setCurrentMinute(0);
            dp.updateDate(2021, 0 , 1 );

        }
    });
    }
}