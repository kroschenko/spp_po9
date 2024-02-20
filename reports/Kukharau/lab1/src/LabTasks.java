public class LabTasks {
    private double[][] matrix;

    public IntDynamicArray ParceStringToIntArray(String arg){
        IntDynamicArray parsed_array = new IntDynamicArray();
        String[] tmp_array = new String[arg.length()];
        for(int i = 0; i < arg.length(); ++i){
            tmp_array[i] = "";
        }
        int tmp_size = 0; boolean isNew = false;
        char[] digit_check = new char[arg.length()];
        arg.getChars(0, arg.length(), digit_check, 0);

        for(int i = 0; i < digit_check.length; ++i){
            if(Character.isDigit(digit_check[i]) || digit_check[i] == '-'){
                isNew = true;
                tmp_array[tmp_size] += digit_check[i];
            } else if(digit_check[i] == '/'){
                break;
            }
            else if(isNew){
                parsed_array.add(Integer.parseInt(tmp_array[tmp_size]));
                ++tmp_size;
                isNew = false;
            }
        }
        parsed_array.add(Integer.parseInt(tmp_array[tmp_size]));

        return parsed_array;
    }
    public void showUnique(IntDynamicArray args){
        IntDynamicArray taskarr = new IntDynamicArray();
        ShowArray(args);
        for(int i = 0; i < args.size(); ++i){
            if(!taskarr.find(args.get(i))){
                taskarr.add(args.get(i));
            }
        }
        System.out.print("Unique elements array: ");
        taskarr.show();
    }
    public void ShowArray(IntDynamicArray args){
        System.out.print("Initial array:         " );
        System.out.print('[');
        for(int i = 0; i < args.size(); ++i){
            if(i < args.size()-1){
                System.out.print(args.get(i) + ", ");
            }
            else{
                System.out.print(args.get(i));
            }
        }
        System.out.print("]\n");
    }
    public void SetMatrix(double[][] argMatrix){
        int arrWidth = argMatrix.length, arrHeight = argMatrix[0].length;
        matrix = new double[arrWidth][arrHeight];
        for(int i = 0; i < arrWidth; ++i){
            System.arraycopy(argMatrix[i], 0, matrix[i], 0, arrHeight);
        }
    }
    public void randomPetrubations(){
        int arrWidth = matrix.length, arrHeight = matrix[0].length;
        double[][] new_matrix = new double[arrWidth][arrHeight];
        double[] wtmp = new double[arrHeight];
        double tmp;
        int rand_pos;
        for(int i = arrWidth - 1; i >= 0; --i){
            rand_pos = (int) (Math.random() * i);
            System.arraycopy(matrix[i], 0, wtmp,0, arrHeight);
            System.arraycopy(matrix[rand_pos], 0, matrix[i],0, arrHeight);
            System.arraycopy(wtmp, 0, matrix[rand_pos],0, arrHeight);
        }
        for(int i = 0; i < arrWidth; ++i){
            for(int j = arrHeight - 1; j >= 0; --j){
                rand_pos = (int) (Math.random() * j);
                tmp = matrix[i][j];
                matrix[i][j] = matrix[i][rand_pos];
                matrix[i][rand_pos] = tmp;
            }
        }
    }
    public void Show(){

        for(int i = 0; i < matrix.length; ++i){
            System.out.print('|');
            for(int j = 0; j < matrix[i].length; ++j){
                if(j < matrix[j].length-1){
                    System.out.print(matrix[i][j] + ", ");
                }
                else{
                    System.out.print(matrix[i][j]);
                }
            }
            System.out.print('|'); System.out.println();
        }
    }
    public boolean isAllLowerCase(String cs){
        System.out.println("Line is: " + cs);
        if(cs == null){
            return false;
        }
        if(cs.toLowerCase() == cs.toUpperCase()){
            return false;
        }
        if(cs == cs.toLowerCase()){
            return true;
        }else{
            return false;
        }
    }
}
