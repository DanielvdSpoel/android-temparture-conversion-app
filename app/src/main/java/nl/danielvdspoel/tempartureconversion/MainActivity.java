package nl.danielvdspoel.tempartureconversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public Button runButton;
    public Button clearButton;
    public EditText celsiusField;
    public EditText fahrenheitField;
    public TextView errorText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runButton = findViewById(R.id.runButton);
        clearButton = findViewById(R.id.clearButton);
        celsiusField = findViewById(R.id.celsiusField);
        fahrenheitField = findViewById(R.id.fahrenheitField);
        errorText = findViewById(R.id.errorText);

        clearButton.setOnClickListener(view -> {
            celsiusField.setText("");
            fahrenheitField.setText("");
            errorText.setText("");
        });

        runButton.setOnClickListener(view -> {
            if (celsiusField.getText().toString().isEmpty() && fahrenheitField.getText().toString().isEmpty()) {
                errorText.setText("Please enter a value");
            } else if (!celsiusField.getText().toString().isEmpty() && !fahrenheitField.getText().toString().isEmpty()) {
                errorText.setText("Please only enter a value in one of the fields");
            } else if (!celsiusField.getText().toString().isEmpty()) {
                double celsius = Double.parseDouble(celsiusField.getText().toString());
                double fahrenheit = celsius * 1.8 + 32;
                fahrenheitField.setText(String.valueOf(fahrenheit));
            } else if (!fahrenheitField.getText().toString().isEmpty()) {
                double fahrenheit = Double.parseDouble(fahrenheitField.getText().toString());
                double celsius = (fahrenheit - 32) / 1.8;
                celsiusField.setText(String.valueOf(celsius));
            }
        });

    }
}