package kuziacompany.generatorprimerov;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.reflect.Array;
import java.lang.reflect.Type;


public class test extends System{
    String Tag="testLog";
    Button Next, Testing;
    String[] strBadPrimers;
    boolean[] boolPrimers;
    TextView txtCounts;
    int counts=10;
    int i=0;
    final int CountsOfPrimers=12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        onCreateFromSystem();
        Log.d(Tag, "process is go");
        Next = new Button(this);
        Testing = new Button(this);
        txtCounts = (TextView)findViewById(R.id.countsLeftAnswers);
        txtCounts.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        Next.setLayoutParams(layoutParams);
        Next.setText("Dalshe");
        Testing.setText("Proverka");
        Testing.setLayoutParams(layoutParams);
        LLayout.addView(Next);
        LLayout.addView(Testing);
        strBadPrimers = new String[CountsOfPrimers];
        boolPrimers = new boolean[CountsOfPrimers];
        Primer = new Example[CountsOfPrimers];
        Next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Primer[CurrentPrimer].Test()) {

                    Toast.makeText(getApplicationContext(), "pravilno", Toast.LENGTH_SHORT).show();
                    strBadPrimers[CurrentPrimer] = "" + String.valueOf(Primer[CurrentPrimer].firstSlagaemoe) + "+" + String.valueOf(Primer[CurrentPrimer].secondSlagaemoe) + "=" + String.valueOf(Primer[CurrentPrimer].expNumber);

                    boolPrimers[CurrentPrimer] = true;

                } else {

                    strBadPrimers[CurrentPrimer] = "" + String.valueOf(Primer[CurrentPrimer].firstSlagaemoe) + "+" + String.valueOf(Primer[CurrentPrimer].secondSlagaemoe) + "=" + String.valueOf(Primer[CurrentPrimer].expNumber) + "(" + String.valueOf(Primer[CurrentPrimer].totalNumber) + ")";
                    boolPrimers[CurrentPrimer] = false;

                }

                if (CurrentPrimer == CountsOfPrimers-1) {
                    Intent intent = new Intent(test.this, ListOfExamples.class);
                    intent.putExtra("listing", strBadPrimers);
                    intent.putExtra("boolean", boolPrimers);
                    startActivity(intent);
                } else {


                    while (Primer[CurrentPrimer].expNumber != 0) {
                        imgDraw.returnTotalPictures(Primer[CurrentPrimer], partTotalOne, partTotalTwo, partTotalThree);
                        Primer[CurrentPrimer].changeExpNumber(false);
                    }


                    CurrentPrimer++;
                    try{
                    imgDraw.GenerateSlagsPictures(Primer[CurrentPrimer], numberOne, numberTwo, number4, number5);
                    imgDraw.choozeSignPicture(Primer[CurrentPrimer].actionSighnSimbol, Znak);}catch (ArrayIndexOutOfBoundsException e){Log.d("Exeption: ",""+CurrentPrimer);}
                    txtCounts.setText((CurrentPrimer) + " из " + CountsOfPrimers);
                }
            }
        });

            Testing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Primer[CurrentPrimer].Test()){
                    Toast.makeText(getApplicationContext(), "pravilno", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    @Override
    protected void onResume() {

        super.onResume();
        CreatePrimers();
        onResumeFromSystem(Primer[CurrentPrimer]);
        for(int i=0;i<CountsOfPrimers-1;i++){
            Log.d("Primers ",""+i+": "+Primer[i].firstSlagaemoe+" "+Primer[i].showSignSimb()+ " "+Primer[i].secondSlagaemoe+" "+Primer[i].totalNumber);
        }


       // imgDraw.GenerateSlagsPictures(primer, numberOne, numberTwo, number4, number5);

       // imgDraw.choozeSignPicture(signSimb, Znak);




        txtCounts.setText((i+1)+" из 10");
    }


    void CreatePrimers() {
        FirstPrimer = 0;
        String Znaki;

        Znaki = "+-*";
        CurrentPrimer = FirstPrimer;
        int i = 0;
        try {
            while (CurrentPrimer < CountsOfPrimers) {
                do {

                    Primer[CurrentPrimer] = new Example();
                    Primer[CurrentPrimer].setSignSimb(Znaki.charAt(i));
                    if (Znaki.charAt(i) == '*') {
                        Primer[CurrentPrimer].Generator(4, 7);
                    } else {
                        Primer[CurrentPrimer].Generator(36, 64);
                    }
                    Primer[CurrentPrimer].Operation();
                    i++;
                    CurrentPrimer++;

                } while ((i < 3) && (CurrentPrimer<CountsOfPrimers));
                i = 0;
            }

            CurrentPrimer = 0;
        }catch(ArrayIndexOutOfBoundsException e){
            Log.d("Exeption :",""+CurrentPrimer);
        }

    }


}
