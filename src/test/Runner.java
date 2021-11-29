package test;

public class Runner {
    public static void main(String[] args) {
        int[] nums = {12,5,8,11,87,45,21};

        for( int index = 0 ; index < nums.length ; index++ ){
            System.out.printf("nums[%d]=%d\n",index,nums[index]);
        }

        System.out.println();

        for( int num : nums ){
            System.out.printf("%d\t",num);
        }
        float definitive = 3.4456656f;
        System.out.println(Math.round(definitive*10.0f)/10.0f);
    }
}
