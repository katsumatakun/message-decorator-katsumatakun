public class AngryMessageDecorator extends MessageDecorator {

    public AngryMessageDecorator(Message m){
        super(m);
    }

    @Override
    public String getMessage(){
        return m.getMessage().toUpperCase();
    }
}
