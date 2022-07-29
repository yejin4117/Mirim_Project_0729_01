package kr.hs.emirim.yejin.mirim_project_0729_01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        int num1 = intent.getIntExtra("num1", 0);
        int num2 = intent.getIntExtra("num2", 0);
        int op = intent.getIntExtra("op", 0);
        switch (op){
            case MainActivity.PLUS:
                sum = num1 + num2;
                break;
            case MainActivity.MINUS:
                sum = num1 - num2;
                break;
            case MainActivity.MULTI:
                sum = num1 * num2;
                break;
            case MainActivity.DIVIDE:
                sum = num1 / num2;
                break;
        }

        Button btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(btnBackListener);
    }

    View.OnClickListener btnBackListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.putExtra("sum", sum);
            setResult(RESULT_OK, intent);
            finish();
        }
    };
}