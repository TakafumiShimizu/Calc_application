package jp.techacademy.takafumi.shimizu.calc_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mEditText1;
    EditText mEditText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button1);
        button.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(this);


        mEditText1 = (EditText) findViewById(R.id.editText1);
        mEditText2 = (EditText) findViewById(R.id.editText2);
    }

    @Override
    public void onClick(View v) {
        String str1 = mEditText1.getText().toString();
        if (str1.equals("")) {
            return;
        }
        double val1 = Double.parseDouble(str1);

        String str2 = mEditText2.getText().toString();
        if (str2.equals("")) {
            return;
        }
        double val2 = Double.parseDouble(str2);

        Intent intent = new Intent(this, ResultActivity.class);
        double result = 0;

        if (v.getId() == R.id.button1) {
            result = val1 + val2;
        } else if (v.getId() == R.id.button2) {
            result = val1 - val2;
        } else if (v.getId() == R.id.button3) {
            result = val1 * val2;
        } else if (v.getId() == R.id.button4) {
            if (val2 != 0) {
                result = val1 / val2;
            } else {
                return;
            }
        }
        intent.putExtra("RESULT", result);
        startActivity(intent);
    }
}
