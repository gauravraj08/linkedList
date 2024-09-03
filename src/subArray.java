import java.util.ArrayList;

public class subArray {
    static void sub(int[] arr1,int[] arr2){
        int n=arr1.length;
        ArrayList<Integer> ll = new ArrayList<Integer>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1;j++){
                if(arr1[i]==arr2[j]){
                    if(!ll.contains(arr1[i])){
                        ll.add(arr1[i]);
                    }
                }
            }
        }
        System.out.println(ll);
    }
    public static void main(String[] args) {
        int[] arr1={2,3,4,5,4,3};
        int[] arr2={3,3,4,4,5};
        sub(arr1,arr2);
    }
}
