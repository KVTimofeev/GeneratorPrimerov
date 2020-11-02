package kuziacompany.generatorprimerov;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by Кузьма on 03.05.2016.
 */
public class Example extends AppCompatActivity {
    int firstSlagaemoe=0;
    int secondSlagaemoe=0;
    int expNumber=0;
     int totalNumber=0;
    static int NumberOfButton;
    char actionSighnSimbol;

    int diapazon;

    void setSignSimb(char sign){
        actionSighnSimbol=sign;
    }
    char showSignSimb(){
        return actionSighnSimbol;
    }

    void Generator(int Start, int End){
        Random rand = new Random();
       firstSlagaemoe= Start+rand.nextInt(End);
       secondSlagaemoe = Start+rand.nextInt(End);
    }
    void enterSlags(int first, int Second){
       firstSlagaemoe=first;
       secondSlagaemoe=Second;
    }
    public void changeExpNumber(boolean change){
        if(change){
            if(expNumber==0){
              expNumber=NumberOfButton;
            }else if(expNumber>0 && expNumber<100){
                expNumber=expNumber*10;

                expNumber=expNumber+NumberOfButton;
            }

        }
        if(change==false){
            if(expNumber>0){
               expNumber/=10;
            }
        }
        Log.d("changeExpNumber:","expNum= "+expNumber+ "this.exp"+this.expNumber);

    }

    int Operation(){

        switch( actionSighnSimbol){
            case '+':
                totalNumber= firstSlagaemoe+secondSlagaemoe;
                break;
            case '-':
                if(firstSlagaemoe<secondSlagaemoe){

                    int x=firstSlagaemoe;
                    firstSlagaemoe=secondSlagaemoe;
                    secondSlagaemoe=x;


                }
                totalNumber= firstSlagaemoe-secondSlagaemoe;


                break;
            case '*':
                totalNumber= firstSlagaemoe*secondSlagaemoe;
                break;
            case '/':
                totalNumber= firstSlagaemoe*secondSlagaemoe;
                break;
        }
        return totalNumber;
    }

    boolean Test(){
        if(this.totalNumber==this.expNumber) {
            return true;
        }else{return false;}
        }

    public void setterAll(Example p){
        firstSlagaemoe=p.firstSlagaemoe;
        secondSlagaemoe=p.secondSlagaemoe;
        totalNumber=p.totalNumber;
        actionSighnSimbol=p.actionSighnSimbol;
    }

    }


