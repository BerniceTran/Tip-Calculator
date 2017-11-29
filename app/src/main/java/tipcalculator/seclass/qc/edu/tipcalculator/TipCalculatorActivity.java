package tipcalculator.seclass.qc.edu.tipcalculator;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TipCalculatorActivity extends AppCompatActivity implements View.OnClickListener
{

    Button buttonCompute;
    EditText partySizeValue;
    EditText checkAmountValue;
    TextView fifteenPercentTipValue;
    TextView twentyPercentTipValue;
    TextView twentyfivePercentTipValue;
    TextView fifteenPercentTotalValue;
    TextView twentyPercentTotalValue;
    TextView twentyfivePercentTotalValue;

    Double amount;
    Integer partySize;
    Integer fifteenPercentTipAmount;
    Integer totalFifteenPercentTipAmount;
    Integer twentyPercentTipAmount;
    Integer totalTwentyPercentTipAmount;
    Integer twentyfivePercentTipAmount;
    Integer totalTwentyfivePercentTipAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        checkAmountValue = (EditText) findViewById(R.id.checkAmountValue);
        partySizeValue = (EditText) findViewById(R.id.partySizeValue);
        buttonCompute = (Button) findViewById(R.id.buttonCompute);
        fifteenPercentTipValue = (TextView) findViewById(R.id.fifteenPercentTipValue);
        fifteenPercentTotalValue = (TextView) findViewById(R.id.fifteenPercentTotalValue);
        twentyPercentTipValue = (TextView) findViewById(R.id.twentyPercentTipValue);
        twentyPercentTotalValue = (TextView) findViewById(R.id.twentyPercentTotalValue);
        twentyfivePercentTipValue = (TextView) findViewById(R.id.twentyfivePercentTipValue);
        twentyfivePercentTotalValue = (TextView) findViewById(R.id.twentyfivePercentTotalValue);

        buttonCompute.setOnClickListener(this);
    }

    public void onClick(View view)
    {
        amount = Double.parseDouble(checkAmountValue.getText().toString());
        partySize = Integer.parseInt(partySizeValue.getText().toString());

        //15% tip
        fifteenPercentTipAmount = (int)(Math.round((amount/partySize)*.15));
        totalFifteenPercentTipAmount = (int)Math.round((amount/partySize)+fifteenPercentTipAmount);
        fifteenPercentTipValue.setText(fifteenPercentTipAmount.toString());
        fifteenPercentTotalValue.setText(totalFifteenPercentTipAmount.toString());

        //20% tip
        twentyPercentTipAmount = (int)(Math.round((amount/partySize)*.2));
        totalTwentyPercentTipAmount = (int)Math.round((amount/partySize)+twentyPercentTipAmount);
        twentyPercentTipValue.setText(twentyPercentTipAmount.toString());
        twentyPercentTotalValue.setText(totalTwentyPercentTipAmount.toString());

        //25% tip
        twentyfivePercentTipAmount = (int)(Math.round((amount/partySize)*.25));
        totalTwentyfivePercentTipAmount = (int)Math.round((amount/partySize)+twentyfivePercentTipAmount);
        twentyfivePercentTipValue.setText(twentyfivePercentTipAmount.toString());
        twentyfivePercentTotalValue.setText(totalTwentyfivePercentTipAmount.toString());

        if ((amount <= 0) && (partySize <= 0))
        {
            Context context = getApplicationContext();
            CharSequence text = "Invalid input.";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.setGravity(Gravity.CENTER, 0, 400);
            toast.show();
        }
    }
}
