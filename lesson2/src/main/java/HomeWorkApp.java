public class HomeWorkApp {
    // для теста пробрасываем выше в  мейн
    public static void main(String[] args) throws MyArrayDataException, MySizeArrayException {

        String[][] testArr = {
                {"1","1","1","1"},
                {"2","2","2","2"},
             // {"3","3","3","3"},
                {"3","blba","3","3"},
                {"4","4","4","4"},
        };

        sumElemsIntArray(testArr);

    }


    public static int sumElemsIntArray (String[][] arr) throws MySizeArrayException, MyArrayDataException {

        if (arr.length != 4 || arr[0].length !=4 ) throw new MySizeArrayException("Array has wrong size (4x4 expected)");

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++ ) {

              try {
                  sum+= Integer.valueOf(arr[i][j]);
              } catch (NumberFormatException e) {
                  throw new MyArrayDataException("incorrect data type of array`s element");
              }

            }
        }
        System.out.println("total sum:" + sum);
        return sum;
    }

}
