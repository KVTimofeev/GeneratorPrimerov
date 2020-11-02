package kuziacompany.generatorprimerov;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ListOfExamples extends AppCompatActivity {
    Intent intent;
    TextView example;
    LinearLayout layout;
    String[] Primers;
    Example[] newPrimer;
    boolean[] Pravilno;
    TextView assesment;
    int rightCounts=0;
    Button transform;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_examples);

        final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        layout = (LinearLayout)findViewById(R.id.listingExamples);
         assesment = new TextView(this);
        assesment.setLayoutParams(layoutParams);
         assesment.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
         assesment.setTextColor(Color.GRAY);
        intent = new Intent();
        intent = getIntent();
         int counts;
         Primers = new String[5];
         Pravilno = new boolean[5];
        Primers= intent.getStringArrayExtra("listing");
         Pravilno = intent.getBooleanArrayExtra("boolean");

        for(int i=0; i<11;i++){
            example = new TextView(this);
            example.setTextSize(TypedValue.COMPLEX_UNIT_SP,44);
            example.setLayoutParams(layoutParams);
            if(Pravilno[i]){
                example.setTextColor(Color.GREEN);

            }else{
                example.setTextColor(Color.RED);
                rightCounts++;
            }

            example.setText(""+Primers[i]);

            layout.addView(example);
        }
         switch(rightCounts){
             case(2):assesment.setText("Оценка 3");break;
             case(1):assesment.setText("Оценка 4");break;
             case(0):assesment.setText("Оценка 5");break;
             default:assesment.setText("Оценка 2");break;
         }
         layout.addView(assesment);
         if(rightCounts>5){
             assesment.setText("Оценка 2.\n Боллее 5 ошибок!!\n Очень рекомендую потренироваться!!");
             transform = new Button(this);
             transform.setLayoutParams(layoutParams);
             transform.setText("Начать тренировку!!!");
             layout.addView(transform);
             transform.setOnClickListener(OnTransformClick);
         }


    }

    View.OnClickListener OnTransformClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ListOfExamples.this,Stretch.class);
            startActivity(intent);
        }
    };
}
