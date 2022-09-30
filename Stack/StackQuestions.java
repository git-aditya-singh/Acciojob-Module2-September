package Stack;

import java.util.*;

public class StackQuestions {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String args[]){
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int ans=reverseInteger(n);
        System.out.println(ans);

    }
    //================reverse the string=================
    public static String reverseString(String str){
        Stack<Character>st=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            st.push(ch);
        }
        String ans="";
        while(st.size()>0){
            char ch=st.pop();
            ans+=ch;
        }
        return ans;
    }
    //================Leetcode 20 is Valid=========================================
    public boolean isValid(String s) {
        Stack<Character>st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('||ch=='{'||ch=='['){
                st.push(ch);
            }else{
                if(!st.isEmpty()&&isMatching(st.peek(),ch)){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        if(st.size()==0){
            return true;
        }
        return false;

    }
    public boolean isMatching(char open,char close){
        if(open=='('&&close==')'){
            return true;
        }
        if(open=='{'&&close=='}'){
            return true;
        }
        if(open=='['&&close==']'){
            return true;
        }
        return false;
    }
    //==============reverse Integer===================
    public static int reverseInteger(int n){
        Stack<Integer>st=new Stack<>();
        while(n!=0){
            int rem=n%10;
            n=n/10;
            st.push(rem);
        }
        long ans=0;
        long mult=1;
        while(st.size()>0){
            long val=st.pop();
            ans+=val*mult;
            mult=mult*10;
        }
        if(ans>(Math.pow(2,31)-1)||ans<-(Math.pow(2,31))){
            return 0;
        }

        return (int)ans;
    }

    //====================immediate smaller element===============
    public static int[] immediateSmallerElement(int arr[]){
        int n=arr.length;
        Stack<Integer>st=new Stack<>();
        int ans[]=new int[n];
        ans[n-1]=-1;
        st.push(arr[n-1]);
        for(int i=n-2;i>=0;i--){
            if(st.size()>0&&st.peek()<arr[i]){
                ans[i]=st.peek();
            }else{
                ans[i]=-1;
            }
            st.push(arr[i]);
        }
        return ans;
    }

    //=============heightProblem============
    public static int[] heightProblem(int arr[]){
        int n=arr.length;
        Stack<Integer>st=new Stack<>();
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int val=arr[i];
            while(st.size()>0&&st.peek()>=val){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=-1;
            }else{
                ans[i]=st.peek();
            }
            st.push(val);
        }
        return ans;

    }

    //===================stock span=========================

    public static int[] stockSpan(int arr[]){
        int n=arr.length;
        Stack<Integer>st=new Stack<>();
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            int val=arr[i];
            while(st.size()>0&&arr[st.peek()]<=val){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=i+1;
            }else{
                ans[i]=i-st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    //=================isLinkedListPalindromic=======================

    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> st=new Stack<>();
        ListNode ptr=head;
        while(ptr!=null){
            st.push(ptr);
            ptr=ptr.next;
        }
        ptr=head;
        while(st.size()!=0){
            ListNode top=st.pop();
            if(ptr.val!=top.val){
                return false;
            }
            ptr=ptr.next;
        }
        return true;

    }

    //=============minstack===================================

    class MinStack {
        Stack<Integer>allData=new Stack<>();
        Stack<Integer>minData=new Stack<>();
        public MinStack() {
            allData=new Stack<>();
            minData=new Stack<>();
        }

        public void push(int val) {
            allData.push(val);
            if(minData.size()==0||val<=minData.peek()){
                minData.push(val);
            }
        }

        public void pop() {
            int val=allData.pop();
            if(minData.peek()==val){
                minData.pop();
            }
        }

        public int top() {
            return allData.peek();
        }

        public int getMin() {
            return minData.peek();
        }
    }

    //=============INFIX TO POSTFIX=======================
    public static String infixToPostfix(String str){
        Stack<String>operands=new Stack<>();
        Stack<Character>operator=new Stack<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch=='('){
                operator.push(ch);

            }else if(ch>='A'&&ch<='Z'){
                operands.push(ch+"");
            }else if(ch==')'){
                while(operator.size()>0&&operator.peek()!='('){
                    char op=operator.pop();
                    String v2=operands.pop();
                    String v1=operands.pop();
                    String ans=v1+v2+op;
                    operands.push(ans);
                }
                if(operator.size()!=0){
                    operator.pop();
                }

            }else if(ch=='+'||ch=='-'||ch=='/'||ch=='*'||ch=='^'){
                while(operator.size()>0&&operator.peek()!='('&& priority(operator.peek())>=priority(ch)){
                    char op=operator.pop();
                    String v2=operands.pop();
                    String v1=operands.pop();
                    String ans=v1+v2+op;
                    operands.push(ans);
                }
                operator.push(ch);
            }
        }
        while(operator.size()!=0){
            char op=operator.pop();
            String v2=operands.pop();
            String v1=operands.pop();
            String ans=v1+v2+op;
            operands.push(ans);
        }
        return operands.peek();
    }
    public static int priority(char op){
        if(op=='+'||op=='-'){
            return 1;
        }else if(op=='*'||op=='/'){
            return 2;
        }else{
            return 3;
        }
    }

    //================sum of subarray minimums==========================
    public static int sumOfSubarrayMinimums(int arr[]){

        int sol[]=smallerOnLeft(arr);
        int sor[]=smallerOnRight(arr);
        long ans=0;
        int mod=(int)1e9+7;
        for(int i=0;i<arr.length;i++){
            int noOfSubarrays=(sol[i]+1)*(sor[i]+1);
            ans+=noOfSubarrays*arr[i];
            ans=ans%mod;
        }
        return (int)ans;
    }
    public static int[] smallerOnLeft(int arr[]){
        int n=arr.length;
        int ans[]=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<n;i++){
            while(st.size()>0&&arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=i;
            }else{
                ans[i]=i-st.peek()-1;
            }
            st.push(i);
        }
        return ans;
    }
    public static int[] smallerOnRight(int arr[]){
        int n=arr.length;
        int ans[]=new int[n];
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(st.size()>0&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.size()==0){
                ans[i]=n-i-1;
            }else{
                ans[i]=st.peek()-i-1;
            }
            st.push(i);
        }
        return ans;
    }

    //===============next greater element 2==================

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer>st=new Stack<>();
        int n=nums.length;
        int ans[]=new int[n];
        for(int i=2*n-1;i>=0;i--){
            while(st.size()>0&&st.peek()<=nums[i%n]){
                st.pop();
            }
            if(st.size()==0){
                ans[i%n]=-1;
            }else{
                ans[i%n]=st.peek();
            }
            st.push(nums[i%n]);
        }
        return ans;
    }


}
