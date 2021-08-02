public class HomeWorkApp {

    public static void main(String[] args) {

        String[][] testArr = {
                {"1","1","1","1"},
                {"2","2","2","2"},
             // {"3","3","3","3"},
                {"3","ff5","3","3"},
                {"4","4","4","4"},
        };
        try {
            System.out.println("total summ: " + sumElemsIntArray(testArr));
        } catch (MySizeArrayException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Thank you, good bye!");
        }


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
        return sum;
    }

}
