package tcp;
import java.io.*;



import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


public class ChatClient {
	private static final int PORT = 3000;
	//private static DatagramSocket clientSocket;

	public static void main(String[] args) throws Exception{
		System.out.println("Client running...");
		String clientSentence;
		String message;
		
        while (true) {
           	// Step 1. create a socket
        	Socket clientSocket = new Socket("localhost", PORT);
        	// Step 2.  Get input from the Keyboard
        	BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        	//Read until end of line is reached
        	clientSentence = inFromUser.readLine();
        	if(clientSentence.equals("Quit")){
        		break;
        		}
        	// Step 3.  Creating the stream to send to the server
        	DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        	try{
        		outToServer.writeBytes(clientSentence + '\n');
        		} catch (IOException ex) {
        		System.out.println("Input Output error.");
        		}
        	//Server response
        	BufferedReader inFromServer = new BufferedReader (new 
        	InputStreamReader(clientSocket.getInputStream()));
        	message = inFromServer.readLine();
        	System.out.println("FROM SERVER: " + message);
        	
        
        	clientSocket.close();
       // } catch (UnknownHostException e[]) {     
       // System.out.println("Unknown Host exception.");
       // e.printStackTrace();
       // break;
      //  } catch (IOException e) {
       // System.out.println("IO Exception encountered.");
       // e.printStackTrace();
        //break;
        }
        }
	}
