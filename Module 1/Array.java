class Array {
    public static void main(String[] args){
        int [] arr1 = {1,2,3};
        int [] arr2 = {4,5,6};
        int l1 = arr1.length;
        int l2 = arr2.length;
        int [] arr3 = new int[l1+l2];
        int i = 0, j = 0, k = 0, x;
        while(i < l1 && j < l2){
            if(arr1[i] < arr2[j]){
                arr3[k] = arr1[i];
                i++;
                k++;
            }
            else{
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        }
        while(i < l1){
            arr3[k++] = arr1[i++];
        }
        while (j < l2){
            arr3[k++] = arr2[j++];
        }
        for(x = 0; x < l1+l2; x++){
            System.out.print(""+arr3[x]+ " ");
        }
    }
}