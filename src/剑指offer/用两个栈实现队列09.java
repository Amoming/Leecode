package 剑指offer;

import java.util.Stack;

public class 用两个栈实现队列09 {
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(5);
        cQueue.appendTail(2);
        System.out.println(cQueue.stackAppend);
        System.out.println(cQueue.deleteHead());
    }
}

class CQueue{
    public Stack<Integer> stackAppend;
    public Stack<Integer> stackDelete;

    public CQueue() {
        stackAppend = new Stack<>();
        stackDelete = new Stack<>();
    }

    public void appendTail(int value) {
        stackAppend.push(value);
    }

    public int deleteHead() {
        if(stackAppend.size() < 1) return -1;
        while (!stackAppend.isEmpty()){ // stack长度会变
            stackDelete.push(stackAppend.pop());
        }
        Integer res = stackDelete.pop();
        while (!stackDelete.isEmpty()){
            stackAppend.push(stackDelete.pop());
        }
        return res;
    }
}
