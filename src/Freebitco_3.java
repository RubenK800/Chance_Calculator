
import java.util.Random;

public class Freebitco_3 {
    public static void main(String[] args) {
        int number = 0;
        int countTRUE = 0;
        int countFALSE = 0;
        int numbersInterval=10_000;
        int wagercount = 100_000_000;
        int[] TrueArray = new int[wagercount];
        int[] FalseArray = new int[wagercount];
        int sum=0;
        int countofNeededSequence=0;
        boolean pushed = false;
        Random rand = new Random();
        // создание матрицы  реузультов побед и поражении
            for (int i = 0; i < wagercount; i++) {// количество ставок
                number = rand.nextInt(numbersInterval);//интервал чисел
                if (number < 4750) {
                    countFALSE++;
                    FalseArray[i] = countFALSE;
                    sum--;
                } else if (number > 5250) {
                    countTRUE++;
                    TrueArray[i] = countTRUE;
                    sum++;
                } else {
                    countFALSE++;
                    FalseArray[i] = countFALSE;
                    sum--;
                }
                countTRUE = 0;
                countFALSE = 0;
            }

            //поиск максимального количества поражений в подряд
            int maxFalse = 0;
            int temp = 0;
            //int temp1=0;
            int countFalse = 0;
            for (int i = 0; i < FalseArray.length; i++) {
                if (FalseArray[i] == 0) {
                    countFalse++;
                } else {
                    temp = countFalse;
                    if (temp > maxFalse) {
                        maxFalse = temp;
                    }
                    //количество выпадении нужной последовательности
                    if(temp>=20-1){
                        countofNeededSequence++;
                    }
                    countFalse = 0;
                }
            }
            System.out.println("максимум количество поражении == " + maxFalse);
        System.out.println("авто-выигрыш (все ставки по 1 сатоши) = " +sum);
        double procent1=(double)sum/(double)wagercount*100;
        System.out.println("проценты (авто-выигрыш) = "+procent1+"%");
        System.out.println("количество выпадении нужной последовательности = " +countofNeededSequence);
        double procent2=(double)countofNeededSequence/(double)wagercount*100;
        System.out.println("проценты (количество выпадении нужной последовательности) = "+procent2+"%");
    }
}