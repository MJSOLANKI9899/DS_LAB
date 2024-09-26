package Lab_19;

public class Bubble_sort {
    public static void main(String[] args) {
        int[] a = { 10,9,8,7,6,5,4,3,2,1,0 };
        
        for(int i = 0;i<a.length;i++){
            for(int j = 0; j < a.length - i; j++){
                if(a[j]==a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        System.out.println("Done!");
        System.out.println("Arry sorted;");
        for(int i : a){
            System.out.println(i);
        }
    }
}
