package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.EpiUserType;
import epi.test_framework.GenericTest;
import epi.test_framework.TestFailure;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
public class StackWithMax {

  public static class Stack {
    public static class Freq{
      int c;
      Integer data;
      Freq(int c, Integer data){
        this.c = c;
        this.data = data;
      }
    }

    Deque<Integer> data = new LinkedList<>();
    Deque<Freq> max = new LinkedList<>();
    public boolean empty() {
      return data.size()==0;
    }
    public Integer max() {
      return max.peekLast().data;
    }
    public Integer pop() {
      if(empty()){
        throw new IllegalStateException("pop(): empty stack");
      }
      Integer val = data.removeLast();
      Freq f = max.peekLast();
      if(val.compareTo(f.data)==0){
        if(f.c>1){
          max.removeLast();
          max.addLast(new Freq(f.c-1, f.data));
        }
        else{
          max.removeLast();
        }
      }
      return val;
    }
    public void push(Integer x) {
      data.addLast(x);
      if(!max.isEmpty()) {
        Freq f = max.peekLast();
        if (x > f.data) {
          max.addLast(new Freq(1, x));
        } else if (x.compareTo(f.data)==0) {
          max.removeLast();
          max.addLast(new Freq(f.c + 1, x));
        }
      }
      else{
        max.addLast(new Freq(1, x));
      }
    }
  }

  @EpiUserType(ctorParams = {String.class, int.class})
  public static class StackOp {
    public String op;
    public int arg;

    public StackOp(String op, int arg) {
      this.op = op;
      this.arg = arg;
    }
  }

  @EpiTest(testDataFile = "stack_with_max.tsv")
  public static void stackTest(List<StackOp> ops) throws TestFailure {
    try {
      Stack s = new Stack();
      int result;
      for (StackOp op : ops) {
        switch (op.op) {
        case "Stack":
          s = new Stack();
          break;
        case "push":
          s.push(op.arg);
          break;
        case "pop":
          result = s.pop();
          if (result != op.arg) {
            throw new TestFailure("Pop: expected " + String.valueOf(op.arg) +
                                  ", got " + String.valueOf(result));
          }
          break;
        case "max":
          result = s.max();
          if (result != op.arg) {
            throw new TestFailure("Max: expected " + String.valueOf(op.arg) +
                                  ", got " + String.valueOf(result));
          }
          break;
        case "empty":
          result = s.empty() ? 1 : 0;
          if (result != op.arg) {
            throw new TestFailure("Empty: expected " + String.valueOf(op.arg) +
                                  ", got " + String.valueOf(s));
          }
          break;
        default:
          throw new RuntimeException("Unsupported stack operation: " + op.op);
        }
      }
    } catch (NoSuchElementException e) {
      throw new TestFailure("Unexpected NoSuchElement exception");
    }
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "StackWithMax.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
