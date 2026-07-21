class CallStack {

    static class Frame{
        String functionName;
        Frame next;

        Frame(String name, Frame next){
            this.functionName=name;
            this.next=next;
        }
    }

    private Frame top;

    public void push(String name){
        top=new Frame(name,top);
    }

    public String pop(){
        if(isEmpty()) throw new RuntimeException("No active call");
        String ans=top.functionName;
        top=top.next;
        return ans;
    }

    public String peek(){
        if(isEmpty()) throw new RuntimeException("Empty Stack");
        return top.functionName;
    }

    public boolean isEmpty(){
        return top==null;
    }
}
