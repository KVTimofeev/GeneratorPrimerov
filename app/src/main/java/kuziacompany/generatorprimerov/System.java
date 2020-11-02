package kuziacompany.generatorprimerov;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Кузьма on 13.05.2016.
 */
public class System extends AppCompatActivity implements View.OnClickListener{
    static int f=0;
    ImageView numberOne, numberTwo, number4, number5, equality;
    ImageView Znak;
    ImageView partTotalOne, partTotalTwo, partTotalThree;
    LinearLayout LLayout;
    //Example primer;

    ///переменные для работы с индексами или нумерации примеров;
    int CurrentPrimer=0;
    int FirstPrimer=0;
    int ind_saveCurrentPrimer;
    int ind_repeatPrimer;
    Example Primer[];


    ImageDrawab imgDraw;
    final LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    Button genBtn, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0, btnReturn, btnClear;
    char signSimb;




    public void onCreateFromSystem(){
        numberOne = (ImageView) findViewById(R.id.partNumb1);
        numberTwo = (ImageView) findViewById(R.id.partNumb2);
        number4 = (ImageView) findViewById(R.id.partNumb3);
        number5 = (ImageView) findViewById(R.id.partNumb4);
        equality = (ImageView) findViewById(R.id.znakRavno);


        partTotalOne = (ImageView) findViewById(R.id.partTotalOne);
        partTotalTwo = (ImageView) findViewById(R.id.partTotalTwo);
        partTotalThree = (ImageView) findViewById(R.id.partTotalThree);

        btn1 = (Button) findViewById(R.id.id_enterOne);
        btn2 = (Button) findViewById(R.id.id_enterTwo);
        btn3 = (Button) findViewById(R.id.id_enterThree);
        btn4 = (Button) findViewById(R.id.id_enterFour);
        btn5 = (Button) findViewById(R.id.id_enterFive);
        btn6 = (Button) findViewById(R.id.id_enterSix);
        btn7 = (Button) findViewById(R.id.id_enterSeven);
        btn8 = (Button) findViewById(R.id.id_enterEight);
        btn9 = (Button) findViewById(R.id.id_enterNine);
        btn0 = (Button) findViewById(R.id.id_enterZero);

        btnReturn = (Button) findViewById(R.id.btnReturn);
        btnClear = (Button) findViewById(R.id.btnClear);
        Znak = (ImageView) findViewById(R.id.id_znak);

        LLayout = (LinearLayout) findViewById(R.id.LayoutHor);



        //primer = new Example();
        imgDraw = new ImageDrawab();



        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn0.setOnClickListener(this);
        equality.setImageResource(R.drawable.equals);

        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgDraw.returnTotalPictures(Primer[CurrentPrimer], partTotalOne, partTotalTwo, partTotalThree);
                //returnTotalPictures(primer, partTotalOne, partTotalTwo, partTotalThree);
                Primer[CurrentPrimer].changeExpNumber(false);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                while (Primer[CurrentPrimer].expNumber != 0) {
                    imgDraw.returnTotalPictures(Primer[CurrentPrimer], partTotalOne, partTotalTwo, partTotalThree);
                    //returnTotalPictures(primer, partTotalOne, partTotalTwo, partTotalThree);
                    Primer[CurrentPrimer].changeExpNumber(false);
                }
            }
        });
        numberOne.setImageResource(R.drawable.zero);
        numberTwo.setImageResource(R.drawable.zero);

        numberOne.setAlpha(0.001f);
        numberTwo.setAlpha(0.001f);
    }

    public void onResumeFromSystem(Example prim){

        imgDraw.GenerateSlagsPictures(prim, numberOne, numberTwo, number4, number5);
        imgDraw.choozeSignPicture(prim.showSignSimb(), Znak);

    }



    @Override
    public void onClick(View v) {
        NaborPrimerExpNumber(v, Primer[CurrentPrimer]);
    }


    public void NaborPrimerExpNumber(View v, Example ex){
        switch (v.getId()) {
            case (R.id.id_enterOne):
                ex.NumberOfButton = 1;
                break;
            case (R.id.id_enterTwo):
                ex.NumberOfButton = 2;
                break;
            case (R.id.id_enterThree):
                ex.NumberOfButton = 3;
                break;
            case (R.id.id_enterFour):
                ex.NumberOfButton = 4;


                break;
            case (R.id.id_enterFive):
                ex.NumberOfButton = 5;

                break;
            case (R.id.id_enterSix):
                ex.NumberOfButton = 6;

                break;
            case (R.id.id_enterSeven):
                ex.NumberOfButton = 7;

                break;
            case (R.id.id_enterEight):
                ex.NumberOfButton = 8;

                break;
            case (R.id.id_enterNine):
                ex.NumberOfButton = 9;

                break;
            case (R.id.id_enterZero):
                ex.NumberOfButton = 0;

                break;
        }
        ex.changeExpNumber(true);
        imgDraw.chooseTotalPicture(ex, partTotalOne, partTotalTwo, partTotalThree);
    }










}
