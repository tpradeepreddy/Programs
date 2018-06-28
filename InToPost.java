import java.util.*;
import java.io.*;
public class InToPost{
    
    void convert(String s){
        String res="";
        Stack<Character> op=new Stack<>();
        for(int i=0;i<s.length();i++){
            char t=s.charAt(i);
            if(Character.isLetterOrDigit(t))
            res=res+t;
            else if(t=='(')
            op.push(t);
            else if(t==')')
            {
                while(!op.empty() && op.peek()!='(')
                {
                    res=res+op.peek();
                    op.pop();
                }
                op.pop();

            }
            else if(isOperator(t))
            {
                while(!op.empty() && op.peek()!='(' && highPrecedence(op.peek(),t))
                {
                    res=res+op.peek();
                    op.pop();
                }
                op.push(t);
            }
            
        }
        while(!op.empty())
        {
            res=res+op.pop();
        }
        System.out.println(res);
    }
    boolean isOperator(char c)
    {
        if(c=='+' || c=='-' || c=='*' || c=='/' || c=='^')
        return true;
        else return false;
    }
    int weight(char c)
    {
        switch(c)
        {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            case '^': return 3;
            default : return -1;
        }
    }
    boolean highPrecedence(char a, char b)
    {
        int w1=weight(a);
        int w2=weight(b);
        if(w1==w2){
            if(isRightAs(b))
            return true;
            else 
            return false;
        }
        return w1>w2?true:false;
    }
    boolean isRightAs(char c)
    {
        if(c=='^')
        return true;
        else
        return false;
    }
    
    public static void main(String args[]){
        
        Scanner sc=new Scanner(System.in);
        String s=new String(sc.next());
        InToPost obj=new InToPost();
        obj.convert(s);
    }
}
