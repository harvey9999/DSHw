package hw5;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExprMonger {
    //Lecture Note,Parm,Ink,Taem,Pao,Chakeera,Nonnie.
    public static double evalFullyParenthesized(List<String> tokens) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        for (String tok : tokens) {
            if(tok.equals("("));
            else if(tok.equals("+")) ops.push(tok);
            else if(tok.equals("-")) ops.push(tok);
            else if(tok.equals("*")) ops.push(tok);
            else if(tok.equals("/")) ops.push(tok);
            else if(tok.equals("**")) ops.push(tok);
            else if(tok.equals(")")) {
                String op = ops.pop();
                double v  = vals.pop();
                double u  = vals.pop();
                vals.push(operator(u, op, v));}
            else vals.push(Double.parseDouble(tok));
        }
        return vals.peek();
    }

    static double operator(double u, String op, double v) {
        if(op.equals("+")) return u + v;
        else if(op.equals("-"))return u - v;
        else if(op.equals("*")) return u * v;
        else if(op.equals("/")) return u / v;
        else if(op.equals("**")) return Math.pow(u,v);
        else return Double.NaN;
    }

    public static List<String> augmentExpr(List<String> tokens) {
        Stack<String> ops  = new Stack <>();
        Stack<String> vals = new Stack <>();

        for(String tok : tokens) {
            if(tok.equals("(")) {
                ops.push(tok);
            }
            else if(tok.equals("+"))  BODMAS(ops, vals, tok);
            else if(tok.equals("-"))  BODMAS(ops, vals, tok);
            else if(tok.equals("*"))  BODMAS(ops, vals, tok);
            else if(tok.equals("/"))  BODMAS(ops, vals, tok);
            else if(tok.equals("**"))  BODMAS(ops, vals, tok);
            else if(tok.equals(")")) {
                while(ops.peek().equals("(")==false){
                    String v = vals.pop();
                    String u = vals.pop();
                    String op = ops.pop();
                    String checking = concat(op, u, v);
                    vals.push(checking);
                }
                ops.pop();
            }
            else vals.push(tok);
        }
        List<String> newTokens = new ArrayList<>();
        if(ops.isEmpty()){
            newTokens.add(vals.pop());
            return newTokens;
        }
        while(ops.isEmpty()==false){
            String v = vals.pop();
            String u = vals.pop();
            String op = ops.pop();
            String ans = "("+u+op+v+")";
            vals.push(ans);
        }
        newTokens = Utils.tokenize(vals.pop());
        return newTokens;
    }
    public static void BODMAS(Stack<String> ops, Stack<String> vals, String oprnd){
        if(ops.isEmpty()||ops.peek().equals("(")){
            ops.push(oprnd);
            return;
        }
        String firsttop = ops.pop();
        if(oprnd.equals("*")||oprnd.equals("/")){
            if(firsttop.equals("+")||firsttop.equals("-")){
                ops.push(firsttop);
                ops.push(oprnd);
                return;
            }else{
                String v = vals.pop();
                String u = vals.pop();
                vals.push(concat(firsttop, u, v));
                ops.push(oprnd);
                return;
            }
        }
        if(oprnd.equals("**")){
            ops.push(firsttop);
            ops.push(oprnd);
            return;
        }
        if(oprnd.equals("+")||oprnd.equals("-")){
            String v = vals.pop();
            String u = vals.pop();
            vals.push(concat(firsttop, u, v));
            ops.push(oprnd);
            return;
        }

    }
    public static String concat(String op, String val1, String val2){
        if(op.equals("+")) return "(" + val1 + "+" + val2 + ")";
        else if(op.equals("-"))return "(" + val1 + "-" + val2 + ")";
        else if(op.equals("*")) return "(" +  val1 + "*" + val2 + ")";
        else if(op.equals("/")) return "(" + val1 + "/" + val2 + ")";
        else if(op.equals("**")) return "(" + val1 + "**" + val2 + ")";
        else return "";

    }
    public static double evalExpr(List<String> tokens) {
        List<String> fullyParenthesized = augmentExpr(tokens);
        return evalFullyParenthesized(fullyParenthesized);
    }
}