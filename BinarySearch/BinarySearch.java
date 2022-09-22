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
    //======================search in 2d matrix  O(n)==================
    public static void searchin2d(int arr[][],int x){
            int n=arr.length;
            int i=0;
            int j=n-1;
            while(i<n&&j>=0){
               if(arr[i][j]==x){
                   System.out.print(i+" "+j+" ");
                   break;
               }else if(arr[i][j]>x){
                    j--;
               }else{
                   i++;
               }
           }
           if(i>=n||j<0){
               System.out.println(-1+" "+-1+" ");
           }
           System.out.println();
    }
    //=========================search in 2d matrix O(log(n))===========================
    public static void searchin2dLogn(int arr[][],int x){
        int n=arr.length;
        if(n==1){
            if(arr[0][0]==x){
                System.out.println(0+" "+0);
            }else{
                System.out.println(-1+" "+-1);
            }
            return;
        }
        //reduced the no of rows to 2
        int c=n-1;
        int r1=0;
        int r2=n-1;
        while(r1+1!=r2){
            int mid=(r1+r2)/2;
            if(arr[mid][c]==x){
                System.out.println(mid+" "+c);break;
            }else if(arr[mid][c]>x){
                r2=mid;
            }else{
                r1=mid;
            }
        }
        if(r1+1!=r2){
            return;
        }
        boolean ans;
        ans=binarysearch(arr,r1,x);
        if(!ans){
            ans=binarysearch(arr,r2,x);
        }
        if(!ans){
            System.out.println(-1+" "+-1);
        }
    }
    public static boolean binarysearch(int arr[][],int r,int x){
        int li=0;
        int ri=arr[0].length-1;
        while(li<=ri){
            int mid=(li+ri)/2;
            if(arr[r][mid]==x){
                System.out.println(r+" "+mid);return true;
            }else if(arr[r][mid]<x){
                li=mid+1;
            }else{
                ri=mid-1;
            }
        }
        return false;
    }
    //===========================Capacity To Ship Packages Within B Days=======================

    public static int capShipInBDays(int arr[],int days){
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int val:arr){
            sum+=val;
            max=Math.max(max,val);
        }
        int li=max;
        int ri=sum;
        int ans=0;
        while(li<=ri){
            int mid=(li+ri)/2;
            if(possible(mid,arr,days)){
                ans=mid;ri=mid-1;
            }else{
                li=mid+1;
            }
        }
        return ans;
    }
    public static boolean possible(int mid,int arr[],int days){
        int count=1;int temp=mid;
        for(int val:arr){
            if(val<=temp){
                temp-=val;
            }else{
                count++;
                temp=mid-val;
            }
        }
        if(count<=days){
            return true;
        }
        return false;
    }

    //=========================search for a range==================

    public static void searchForRange(int arr[],int tar){
        int n=arr.length;
        int li=0;
        int ri=n-1;
        int sp=-1;
        int ep=-1;
        while(li<=ri){
            int mid=(li+ri)/2;
            if(arr[mid]==tar){
                sp=mid;
                ri=mid-1;
            }else if(arr[mid]>tar){
                ri=mid-1;
            }else{
                li=mid+1;
            }
        }

        li=0;
        ri=n-1;
        while(li<=ri){
            int mid=(li+ri)/2;
            if(arr[mid]==tar){
                ep=mid;
                li=mid+1;
            }else if(arr[mid]>tar){
                ri=mid-1;
            }else{
                li=mid+1;
            }
        }
        System.out.println(sp+" "+ep);

    }
    //====================find peak element==========
    public int findPeakElement(int[] arr) {
        int n=arr.length;
        int li=0;
        int ri=n-1;
        while(li<=ri){
            int mid=(li+ri)/2;
            long l,r;
            //finding neighbouring elements
            if(mid==0){
                l=Long.MIN_VALUE;
            }else{
                l=arr[mid-1];
            }
            if(mid==n-1){
                r=Long.MIN_VALUE;
            }else{
                r=arr[mid+1];
            }
            if(arr[mid]>l&&arr[mid]>r){
                return mid;
            }else if(l>arr[mid]){
                ri=mid-1;
            }else{
                li=mid+1;
            }

        }
        return -1;

    }

    //==============allocate pages========================================
    public static long allocatePages(int arr[],int stu){
        if(arr.length<stu){
            return -1;
        }
        int n=arr.length;

        int li=Integer.MIN_VALUE;
        int ri=0;
        for(int val:arr){
            li=Math.max(li,val);
            ri=ri+val;
        }
        long ans=-1;
        while(li<=ri){
            long mid=(li+ri)/2;
            if(validate(arr,mid,stu)){
                ans=mid;
                ri=(int)mid-1;
            }else{
                li=(int)mid+1;
            }
        }
        return ans;

    }
    public static boolean validate(int arr[],long mid,int stu){
        int currst=1;int sum=0;
        for(int val:arr){
            sum+=val;
            if(sum>mid){
                currst++;
                sum=val;
            }
        }
        if(currst<=stu){
            return true;
        }
        return false;

    }
    //==================min penalty======================================
    public static int minPenalty(int arr[],int maxop){
        int li=1;
        int ri=Integer.MIN_VALUE;
        for(int val:arr){
            ri=Math.max(val,ri);
        }
        int ans=-1;
        while(li<=ri){
            int mid=(li+ri)/2;
            if(possible(arr,mid,maxop)){
                ans=mid;
                ri=mid-1;
            }else{
                li=mid+1;
            }
        }
        return ans;

    }
    public static boolean possible(int arr[],int mid,int maxop){
        int op=0;
        for(int val:arr){
            int temp=val/mid;
            if(val%mid==0){
                temp--;
            }
            op+=temp;
        }
        if(op<=maxop)return true;
        return false;
    }

    //====================Kevin and fruits=================
    public static int KevinAndFruits(int arr[],int m){
        int li=0;
        int ri=Integer.MIN_VALUE;
        for(int val:arr){
            ri=Math.max(ri,val);
        }
        int ans=-1;
        while(li<=ri){
            int mid=(li+ri)/2;
            if(possible1(arr,mid,m)){
                ans=mid;
                li=mid+1;
            }else{
                ri=mid-1;
            }
        }
        return ans;
    }
    public static boolean possible1(int arr[],int mid,int m){
        int totalfruits=0;
        for(int val:arr){
            int temp=val-mid;
            if(temp>0){
                totalfruits+=temp;
            }
        }
        if(totalfruits>=m){
            return true;
        }
        return false;
    }
}
