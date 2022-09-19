package BinarySearch;

import java.util.Scanner;

public class BinarySearch {
        public static void main (String[] args) throws java.lang.Exception
        {
            Scanner scn=new Scanner(System.in);
            int n=scn.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=scn.nextInt();
            }

            int ans=count1(arr);
            System.out.println(ans);
        }

        //==========================count 1==============================
        public static int count1(int arr[]){
            int n=arr.length;
            int li=0;
            int ri=n-1;
            while(li<=ri){
                int mid=(li+ri)/2;
                if(arr[mid]==1){
                    if(mid==n-1||arr[mid+1]==0){
                        return mid+1;
                    }
                    li=mid+1;
                }else{
                    ri=mid-1;
                }
            }
            return 0;
        }
 //==========================Search insert position================

    public int searchInsert(int[] nums, int target) {
        int n=nums.length;
        int li=0;
        int ri=n-1;
        while(li<=ri){
            int mid=(li+ri)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                ri=mid-1;
            }else{
                li=mid+1;
            }
        }
        return li;
    }

    //===============================Floor in a Sorted Array==========================

    public static int findFloor(int arr[],int k){
        int n=arr.length;
        int li=0;
        int ri=n-1;
        while(li<=ri){
            int mid=(li+ri)/2;
            if(arr[mid]==k){
                return mid;
            }else if(arr[mid]<k){
                li=mid+1;
            }else{
                ri=mid-1;
            }
        }
        return ri;
    }
}
