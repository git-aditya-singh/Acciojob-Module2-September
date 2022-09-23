package Stack;

import java.util.*;

public class StackQuestions {
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
        int ans=0;
        int mult=1;
        while(st.size()>0){
            int val=st.pop();
            ans+=val*mult;
            mult=mult*10;
        }

        return ans;
    }
}
