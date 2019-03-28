import java.io.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String filename;
        String message;
        Message m;
        String decorations[];
        BufferedReader br;

        System.out.print("Type File Name: ");

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        try {
            filename = reader.readLine();
            File file = new File("src\\" + filename);
            br = new BufferedReader(new FileReader(file));
            message = br.readLine();
            m = new Message(message);
            decorations = br.readLine().split(" ");
            for(int i=0; i<decorations.length; i++){
                if(decorations[i].equals("Angry"))
                    m = new AngryMessageDecorator(m);
                if(decorations[i].equals("Binary"))
                    m = new BinaryMessageDecorator(m);
                if(decorations[i].equals("SMS"))
                    m = new SMSMessageDecorator(m);
                if(decorations[i].equals("Encrypted"))
                {
                    int key = Integer.parseInt(decorations[i+1]);
                    m = new EncryptedMessageDecorator(m, key);
                }
            }

            System.out.println(m.getMessage());

            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (java.io.IOException exc) {
            System.out.println("There was an error during reading: "
                    + exc.getMessage());
        }


    }
}
