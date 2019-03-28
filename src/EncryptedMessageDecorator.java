public class EncryptedMessageDecorator extends MessageDecorator {

    private int key;
    public EncryptedMessageDecorator(Message m, int key){
        super(m);
        this.key = key;
    }
    
    @Override
    public String getMessage(){
        return encrypt(m.getMessage());
    }
    
    private String encrypt(String s){
        String str = "";
        char[] ary = s.toCharArray();
        for(int i=0; i< ary.length; i++){
            str += (char)(((int) ary[i]) + key);
        }

        return str;
    }
}
