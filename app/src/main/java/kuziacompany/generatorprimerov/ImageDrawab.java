package kuziacompany.generatorprimerov;

import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by Кузьма on 12.05.2016.
 */
public class ImageDrawab extends AppCompatActivity {
    //public static ImageView numberOne, numberTwo, number4, number5, equality;
    //public static ImageView Znak;
    //public static ImageView partTotalOne, partTotalTwo, partTotalThree;






    public void chooseTotalPicture(Example primer, ImageView partTotalOne, ImageView partTotalTwo, ImageView partTotalThree){
        if(primer.expNumber<10){
            Picture(primer.NumberOfButton, partTotalOne, true);
        }else if(primer.expNumber>9 && primer.expNumber<100){
            Picture(primer.NumberOfButton, partTotalTwo, true);
        }else if(primer.expNumber>99 && primer.expNumber<1000){
            Picture(primer.NumberOfButton, partTotalThree, true);






        }}


    public void GenerateSlagsPictures(Example primer, ImageView onePartSlag1, ImageView twoPartSlag1, ImageView onePartSlag2, ImageView twoPartSlag2){
        if(primer.firstSlagaemoe<10){
            Picture(primer.firstSlagaemoe, onePartSlag1, true);
            Picture(0, twoPartSlag1, false);
        }else{
            int Razr=primer.firstSlagaemoe/10;
            Picture(Razr, onePartSlag1, true);
            Razr=primer.firstSlagaemoe%10;
            Picture(Razr, twoPartSlag1, true);
        }
        if(primer.secondSlagaemoe<10){
            Picture(primer.secondSlagaemoe, onePartSlag2, true);
            Picture(0, twoPartSlag2, false);
        }else{
            int Razr=primer.secondSlagaemoe/10;
          Picture(Razr, onePartSlag2, true);
            Razr=primer.secondSlagaemoe%10;
           Picture(Razr, twoPartSlag2, true);
        }

    }


    public void returnTotalPictures(Example primer, ImageView img1, ImageView img2, ImageView img3){
        if(primer.expNumber<10){
            img1.setAlpha(0.001f);

        }else if(primer.expNumber>9 && primer.expNumber<100){
            img2.setAlpha(0.01f);

        }else if(primer.expNumber>99){
            img3.setAlpha(0.01f);

        }
    }



    public void choozeSignPicture(char SignAction, ImageView Znak){
        switch(SignAction){
            case '+':
                Znak.setImageResource(R.drawable.summ);
                break;
            case '-':
                Znak.setImageResource(R.drawable.sub);
                break;
            case '*':
                Znak.setImageResource(R.drawable.multi);
                break;

        }
    }

    public void Picture(int num, ImageView img, boolean set) {


        if (set) {
            switch (num) {
                case 1:

                    img.setImageResource(R.drawable.one);
                    img.setAlpha(0.7f);


                    break;
                case 2:

                    img.setImageResource(R.drawable.two);
                    img.setAlpha(0.7f);

                    break;
                case 3:
                    img.setImageResource(R.drawable.three);

                    img.setAlpha(0.7f);

                    break;
                case 4:
                    img.setImageResource(R.drawable.four);

                    img.setAlpha(0.7f);

                    break;
                case 5:
                    img.setImageResource(R.drawable.five);

                    img.setAlpha(0.7f);

                    break;
                case 6:

                    img.setImageResource(R.drawable.six);
                    img.setAlpha(0.7f);

                    break;
                case 7:

                    img.setImageResource(R.drawable.seven);
                    img.setAlpha(0.7f);
                    break;
                case 8:

                    img.setImageResource(R.drawable.eight);
                    img.setAlpha(0.7f);
                    img.setMaxHeight(2);

                    break;
                case 9:

                    img.setImageResource(R.drawable.nine);
                    img.setAlpha(0.7f);

                    break;
                case 0:
                    img.setImageResource(R.drawable.zero);

                    img.setAlpha(0.7f);

                    break;
            }
        } else {
            img.setAlpha(0.001f);

        }


    }

}
