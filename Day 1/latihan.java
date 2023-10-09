import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Soal:
//Buat List A, integer: 1, 2, 3
//Buat List B, integer: 2, 3, 4
//Buat List C hasil intersection dari A dan B: 2, 3


public class latihan {
    public static void main(String[] args) {
        List<Integer> listA = Arrays.asList(1,2,3);
        List<Integer> listB = Arrays.asList(2,3,4);
        List<Integer> listC = new ArrayList<>();
        for(Integer number1 : listA){
            for(Integer number2: listB){
                if(number1.equals(number2)){
                    listC.add(0, number1);
                }
            }
        }
        listC.sort(null);
        System.out.println("List C = "+ listC);
    }
}
