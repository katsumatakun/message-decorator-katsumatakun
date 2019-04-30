

public class SMSMessageDecorator extends MessageDecorator {

    private static final int msgSize = 5;

    public SMSMessageDecorator(Message m){
        super(m);
    }

    @Override
    public String getMessage(){
        return segment(m.getMessage());
    }

    private String segment(String s){
        if(s=="")
            return "";
        char ary[] = s.toCharArray();
        String newStr = "";
        newStr+= ary[0];
        for(int i=1; i<ary.length; i++){
            if(i % msgSize == 0)
                newStr+="...\n";
            newStr+= ary[i];
        }
        return newStr;
    }


}
