package kuziacompany.generatorprimerov;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class Stretch extends System {
    Button discoverAnswer;
    Button Test;
    TextView otvetTxt, countsRightAnswers, countsLeftAnswers, Rat;
    int haveLeftAnswers;
    String Tag = "message";
    int CountsOfPrimers = 12;
    int NumericRepeatPrimer = 0;
    int CounterExampes = 0;
    boolean AccsesTest = true;
    boolean noAccsesTest = false;

    boolean rebornPrimers = false;
    boolean runRepeatExamples = false;


    Example saveCurrentPrimer;


    ArrayList<Example> repeatPrimer = new ArrayList<Example>();

    boolean norightExample = false;

    String strTag = "stretchTAg";
    Rating rating = new Rating();


    String T = "TAG: ";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        Primer = new Example[CountsOfPrimers];

        CounterExampes = 0;


        onCreateFromSystem();

        discoverAnswer = new Button(this);
        discoverAnswer.setLayoutParams(layoutParams);
        Test = new Button(this);
        countsLeftAnswers = (TextView) findViewById(R.id.countsLeftAnswers);
        countsRightAnswers = (TextView) findViewById(R.id.countsRightsAnswers);
        countsLeftAnswers.setTextColor(Color.WHITE);
        countsRightAnswers.setTextColor(Color.WHITE);
        Rat = (TextView) findViewById(R.id.Rat);
        Test.setLayoutParams(layoutParams);
        Test.setText("Проверка");
        LLayout.addView(Test);
        Test.setOnClickListener(OnTestClick);
        discoverAnswer.setOnClickListener(OnDiscoverAnswerClick);

        otvetTxt = new TextView(this);
        otvetTxt.setTextColor(Color.WHITE);
        otvetTxt.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        genBtn = new Button(this);
        genBtn.setText("Пропустить пример");
        genBtn.setOnClickListener(OnGeneratorClick);
        noAccsesTest = true;


        saveCurrentPrimer = new Example();

        //Primer = new Example[CountsOfPrimers];


    }

    // repeatPrimer[repeatPrimersTestingOnRepeats(Primer[CurrentPrimer])].setterAll(Primer[CurrentPrimer]);


    View.OnClickListener OnGeneratorClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            while (Primer[CurrentPrimer].expNumber != 0) {
                imgDraw.returnTotalPictures(Primer[CurrentPrimer], partTotalOne, partTotalTwo, partTotalThree);
                Primer[CurrentPrimer].changeExpNumber(false);
            }




            if (norightExample) {
                if (CurrentPrimer == CountsOfPrimers - 1) {
                    runRepeatExamples=true;
                    CreatePrimers();
                    norightExample=false;
                    CurrentPrimer = -1;
                }
            }else {
                if(CurrentPrimer==CountsOfPrimers-1){
                    CreatePrimers();
                    CurrentPrimer=-1;
                }
            }
            CurrentPrimer++;
            /*
            if (runRepeatExamples) {
                Primer[CurrentPrimer].setterAll(repeatPrimer.get(CurrentPrimer));
            }*/

            for (int i = 0; i < CountsOfPrimers; i++) {
                try {
                    Log.d("Primers ", "" + i + ": " + Primer[i].firstSlagaemoe + " " + Primer[i].showSignSimb() + " " + Primer[i].secondSlagaemoe + " " + Primer[i].totalNumber + "  ");
                } catch (IndexOutOfBoundsException e) {
                    Log.d("exep: ", "IndexOutOfBoundsException");
                }
            }
            for (int x = 0; x < repeatPrimer.size(); x++) {
                try {
                    Log.d("repeatPrimers ", "" + x + ": " + repeatPrimer.get(x).firstSlagaemoe + " " + repeatPrimer.get(x).showSignSimb() + " " + repeatPrimer.get(x).secondSlagaemoe + " " + repeatPrimer.get(x).totalNumber + "  ");
                } catch (IndexOutOfBoundsException e) {
                    Log.d("exep: ", "IndexOutOfBoundsException");
                }
            }
            imgDraw.GenerateSlagsPictures(Primer[CurrentPrimer], numberOne, numberTwo, number4, number5);
            imgDraw.choozeSignPicture(Primer[CurrentPrimer].showSignSimb(), Znak);
            LLayout.removeView(otvetTxt);
            LLayout.removeView(genBtn);
            if (LLayout.getChildCount() == 0) {
                LLayout.addView(Test);
            }
        }
    };

    View.OnClickListener OnDiscoverAnswerClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            norightExample = true;
            haveLeftAnswers = 1;
            LLayout.removeView(Test);
            otvetTxt.setText("Ответ был: " + Primer[CurrentPrimer].totalNumber + "\nВы написали" + Primer[CurrentPrimer].expNumber);
            rating.Lefts++;
            countsLeftAnswers.setText("Количество НЕправильных ответов = " + rating.Lefts);
            if(!testOnRepeatsExamples(Primer[CurrentPrimer], repeatPrimer)){
                repeatPrimer.add(Primer[CurrentPrimer]);
            }

            LLayout.addView(genBtn);
            LLayout.removeView(discoverAnswer);
        }
    };


    View.OnClickListener OnTestClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("Test^ ", "" + Primer[CurrentPrimer].expNumber);
            TestClick(Primer[CurrentPrimer]);
            try {
                Log.d("Primers ", "" + CurrentPrimer + ": " + Primer[CurrentPrimer].firstSlagaemoe + " " + Primer[CurrentPrimer].showSignSimb() + " " + Primer[CurrentPrimer].secondSlagaemoe + " " + Primer[CurrentPrimer].totalNumber + "  " + Primer[CurrentPrimer].expNumber);

            } catch (IndexOutOfBoundsException e) {
                Log.d("exep: ", "IndexOutOfBoundsException");
            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        CurrentPrimer = 0;
        CreatePrimers();
        onResumeFromSystem(Primer[CurrentPrimer]);
        try {
            for (int i = 0; i < CountsOfPrimers - 1; i++) {
                Log.d("Primers ", "" + i + ": " + Primer[CurrentPrimer] + "   " + Primer[i].firstSlagaemoe + " " + Primer[i].showSignSimb() + " " + Primer[i].secondSlagaemoe + " " + Primer[i].totalNumber);
            }
        } catch (NullPointerException e) {
            Log.d("Exep: ", "NullPointerExep");
        }

    }


    public void ChooseZnak(int CountZnak) {
        if (CurrentPrimer < CountsOfPrimers) {
            CurrentPrimer++;
        } else {
            CurrentPrimer = FirstPrimer;
        }
        Primer[CurrentPrimer] = new Example();
        if (CountZnak > 0 & CountZnak < 4) {
            switch (CountZnak) {
                case (3):
                    Primer[CurrentPrimer].Generator(36, 64);
                    Primer[CurrentPrimer].actionSighnSimbol = '+';
                    break;
                case (1):
                    Primer[CurrentPrimer].Generator(36, 64);
                    Primer[CurrentPrimer].actionSighnSimbol = '-';
                    break;
                case (2):
                    Primer[CurrentPrimer].Generator(4, 7);
                    Primer[CurrentPrimer].actionSighnSimbol = '*';
                    break;
            }
            Primer[CurrentPrimer].Operation();
            imgDraw.GenerateSlagsPictures(Primer[CurrentPrimer], numberOne, numberTwo, number4, number5);
            imgDraw.choozeSignPicture(Primer[CurrentPrimer].actionSighnSimbol, Znak);
        } else {


            Primer[CurrentPrimer].setterAll(Primer[ind_repeatPrimer]);
            Primer[CurrentPrimer].Operation();
            imgDraw.GenerateSlagsPictures(Primer[ind_repeatPrimer], numberOne, numberTwo, number4, number5);
            imgDraw.choozeSignPicture(Primer[ind_repeatPrimer].actionSighnSimbol, Znak);
            norightExample = false;
        }


    }


    public void TestClick(Example ex) {
        if (ex.Test()) {
            if (LLayout.getChildCount() > 2) {
                LLayout.addView(genBtn);
                LLayout.removeView(discoverAnswer);
            }
            if (LLayout.getChildCount() == 1) {
                LLayout.addView(otvetTxt);
                LLayout.addView(genBtn);
            }
            otvetTxt.setText("Абсолютно Верно!!!!\n Давай дальше");
            genBtn.setText("Следующий пример");
            rating.Rights++;
            genBtn.setOnClickListener(OnGeneratorClick);
            AccsesTest = true;
            countsRightAnswers.setText("Количество правильных ответов = " + rating.Rights);


            LLayout.removeView(Test);


        } else {
            if (LLayout.getChildCount() == 1) {
                LLayout.addView(otvetTxt);
                LLayout.addView(discoverAnswer);
            }
            otvetTxt.setText("Неверно!!!!\n Попробуй еще раз");
            discoverAnswer.setText("Узнать ответ");
            Toast toast = Toast.makeText(getApplicationContext(), "Nepravillno", Toast.LENGTH_LONG);
            toast.show();
            AccsesTest = false;
        }
    }

    public void CreatePrimers() {
        FirstPrimer = 0;
        String Znaki;
        int c_size = CountsOfPrimers;
        Znaki = "+-*";
        CurrentPrimer = FirstPrimer;
        int i = 0;
        if (!runRepeatExamples) {
            try {
                while (CurrentPrimer < c_size) {
                    do {
                        if (!rebornPrimers) {
                            Primer[CurrentPrimer] = new Example();
                        }
                        Primer[CurrentPrimer].setSignSimb(Znaki.charAt(i));
                        if (Znaki.charAt(i) == '*') {
                            Primer[CurrentPrimer].Generator(4, 7);
                        } else {
                            Primer[CurrentPrimer].Generator(36, 64);
                        }
                        Primer[CurrentPrimer].Operation();
                        i++;

                        CurrentPrimer++;


                    } while ((i < 3) && (CurrentPrimer < c_size));
                    i = 0;
                }

                CurrentPrimer = 0;
                rebornPrimers = true;
            } catch (ArrayIndexOutOfBoundsException e) {
                Log.d("Exeption :", "" + CurrentPrimer);
            }
        } else {
            while (CurrentPrimer < repeatPrimer.size()) {


                Primer[CurrentPrimer].setterAll(repeatPrimer.get(CurrentPrimer));


                CurrentPrimer++;


            }
            CountsOfPrimers = repeatPrimer.size();

            runRepeatExamples = false;
            for (int f = 0; f < repeatPrimer.size(); f++) {
                repeatPrimer.remove(f);
            }
            CurrentPrimer = 0;

        }


    }

    boolean testOnRepeatsExamples(Example Primer, ArrayList<Example>repeatPrimer){
        boolean test=false;

     for(int x=0;x<repeatPrimer.size();x++){
         if(repeatPrimer.get(x).equals(Primer)){
             test = true;
         }
        }
       return test;
    }
};










