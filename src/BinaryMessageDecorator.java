public class BinaryMessageDecorator extends MessageDecorator {

    public BinaryMessageDecorator(Message m){
        super(m);
    }

    @Override
    public String getMessage(){
        return encode(m.getMessage());
    }

    private String encode(String s){

        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes)
        {
            binary.append(Integer.toBinaryString(b));
        }
        return binary.toString();

        //reference
        //https://stackoverflow.com/questions/917163/convert-a-string-like-testing123-to-binary-in-java
    }
}
