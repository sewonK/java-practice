package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch_1920 {
    static int N, M;
    static int[] nums;
    static String[] numString;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        numString = br.readLine().split(" ");
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(numString[i]);
        }
        Arrays.sort(nums);
        M = Integer.parseInt(br.readLine());
        numString = br.readLine().split(" ");
        for(int i=0; i<M; i++){
            int searchNum = Integer.parseInt(numString[i]);
            if(binarySearch(searchNum)){
                System.out.println(1);
            }
            else {
                System.out.println(0);
            }
        }
    }

    static boolean binarySearch(int searchNum) {
        int start = 0;
        int end = N-1;
        int mid;
        while(start <= end){
            mid = (start + end)/2;
            if(searchNum == nums[mid]) {
                return true;
            } else if(searchNum < nums[mid]){
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}
