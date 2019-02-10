package pl.edu.agh.qualitycalculator;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import pl.edu.agh.qualitycalculator.R;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText etNum1;
    EditText etNum2;
    EditText etNum3;

    Button btnAdd;
    Button btnSub;
    Button btnMult;
    Button btnDiv;
    Button btnAvg;

    TextView tvResult;

    Calculations calculations = new Calculations();
    CalculationsVerbalizer verbalizer = new CalculationsVerbalizer();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNum1 = (EditText) findViewById(R.id.etNum1);
        etNum2 = (EditText) findViewById(R.id.etNum2);
        etNum3 = (EditText) findViewById(R.id.etNum3);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnAvg = (Button) findViewById(R.id.btnAvg);

        tvResult = (TextView) findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMult.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnAvg.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            tvResult.setText("Enter some data to calculate");
            return;
        }

        Operation selectedOperation = null;
        switch (v.getId()) {
            case R.id.btnAdd:
                selectedOperation = Operation.SUM;
                break;
            case R.id.btnSub:
                selectedOperation = Operation.SUBTRACT;
                break;
            case R.id.btnMult:
                selectedOperation = Operation.MULTIPLY;
                break;
            case R.id.btnDiv:
                selectedOperation = Operation.DIVIDE;
                break;
            case R.id.btnAvg:
                selectedOperation = Operation.AVERAGE;
                break;
            default:
                break;
        }

        float num1 = Float.parseFloat(etNum1.getText().toString());
        float num2 = Float.parseFloat(etNum2.getText().toString());
        float num3 = Float.parseFloat(etNum3.getText().toString());
        try {
            float result = calculations.calculate(selectedOperation, num1, num2, num3);
            String verbalizedOperation = verbalizer.verbalize(selectedOperation, num1, num2,num3, result);
            tvResult.setText(verbalizedOperation);
        }
        catch (Exception ex) {
            tvResult.setText("An error ocurred: " + ex.toString());
        };

    }
}