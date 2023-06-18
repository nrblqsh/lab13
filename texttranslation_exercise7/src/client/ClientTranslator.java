package client;

import java.net.Socket;
import java.net.InetAddress;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * This class will input text from the client
 * Client will input targeted language
 * Client will request connection from server
 * @author norbalqish
 *
 */
public class ClientTranslator {

    public static void main(String[] args) {
    	
    	//ClientFrame class object
        ClientFrame clientFrame = new ClientFrame();

        try {
            // Retrieve the word/phrase and target language from the GUI components
            String text = "What’s up?";
            String targetLanguage = "Arabic";

            // Connect to the server @ localhost, port 2225
            Socket socket = new Socket(InetAddress.getLocalHost(), 2225);

            // Update the status of the connection
            clientFrame.updateConnectionStatus(socket.isConnected());
            System.out.println(socket.isConnected());

            // Write text and target language to the server
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);

            // Send text and target language
            printWriter.println(text);
            printWriter.println(targetLanguage);

            // Read translated text from the server
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Display translated text
            String translated = bufferedReader.readLine();
            clientFrame.updateTranslatedWord(translated);
            

            // Close 
            bufferedReader.close();
            printWriter.flush();
            printWriter.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}