package kr.ac.kopo.simplecalculator2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;

    Button btnPlus, btnMinus, btnMultiply, btnDivide;

    TextView textResult;

    int[] btnNumIds = {R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4,
            R.id.btn_5, R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9};

    Button[] btnNums = new Button[btnNumIds.length];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edit1 = findViewById(R.id.edit1);
        edit2 = findViewById(R.id.edit2);

        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnDivide = findViewById(R.id.btn_divide);

        textResult = findViewById(R.id.text_result);

        for (int i=0; i < btnNums.length; i++){
            btnNums[i] = findViewById(btnNumIds[i]);
        }
    }


    View.OnClickListener btnOperationListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button btnEvent = (Button) v;
            String edit1Str = edit1.getText().toString();
            String edit2Str = edit2.getText().toString();

            int num1 = Integer.parseInt(edit1Str);
            int num2 = Integer.parseInt(edit2Str);
            int result = 0;

            if (btnEvent == btnPlus) {
                result = num1 + num2;
            } else if (btnEvent == btnMinus) {
                result = num1 - num2;
            } else if (btnEvent == btnMultiply) {
                result = num1 * num2;
            } else {
                if (num2 != 0) {
                    result = num1 / num2;
                }
            }

            textResult.setText("계산 결과: " + result);
        }
    };
}