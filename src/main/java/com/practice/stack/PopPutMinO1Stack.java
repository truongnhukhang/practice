package com.practice.stack;

public class PopPutMinO1Stack extends StackImplementSimple<PopPutMinO1Stack.NodeMin> {

  @Override
  public void add(NodeMin data) {
    if(top!=null) {
      data.min = Math.min(data.data,getMin());
    } else {
      data.min = data.data;
    }
    super.add(data);
  }

  public Integer getMin() {
    return this.peek().min;
  }

  public static class NodeMin {
    Integer data;
    Integer min;

    public NodeMin(Integer data) {
      this.data = data;
    }
  }
}
