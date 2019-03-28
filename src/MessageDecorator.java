public abstract class MessageDecorator extends Message {

    protected Message m;

    public MessageDecorator(Message m){
        super(m.getMessage());
        this.m = m;
    }

    public abstract String getMessage();
}
