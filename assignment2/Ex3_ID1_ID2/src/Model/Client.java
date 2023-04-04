package Model;
import java.util.ArrayList;


public class Client implements IClient{
	// -------------------------------Class Members------------------------------
	private static int arc = 0;
	private int number;
	protected String ip;
	protected Server connectToServer;
	protected ArrayList<Message<?,?>> SentRequest;
	protected ArrayList<Message<?,?>> receivedResponses;
	//TODO add member - Done!
	
	// -------------------------------Constructors------------------------------
	public Client(String iP) {
		super();
		number = ++arc;
		ip = iP;
		connectToServer = null;
		SentRequest = new ArrayList<>();
		receivedResponses = new ArrayList<>();
		//TODO - Done
	}
	// -----------------------------------------Setters&&Getters--------------------------------------

	@Override
	public boolean connectTo(IServer server) {
		if (this.connectToServer == null && (((Server)server).clients).size() < 3)
		{
			this.connectToServer = (Server)server;
			((Server)server).clients.add(this);
			System.out.println("Connected to the server!");
			return true;
		}
		System.out.println("Unable to connect");
		return false;
	}

	@Override
	public boolean disconnect() {
		if (this.connectToServer != null)
		{
			this.connectToServer.clients.remove(this);
			this.connectToServer = null;
			System.out.println("Disconnected Successfully");
			return true;
		}
		// TODO Auto-generated method stub
		System.out.println("Unable to Disconnect");
		return false;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean messageSent(Message message) {
		if (this.connectToServer != null && ((Server)(message.to)).clients.contains(this))
		{
			this.connectToServer.receivedRequests.add(message);
			this.SentRequest.add(message);
			System.out.println("Message sent!");
			return true;
		}
		// TODO Auto-generated method stub
		System.out.println("Unable to send a message");
		return false;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean onMessageReceived(Message message) {
		if (this.connectToServer != null &&((Server)(message.to)).clients.contains(this))
		{
			this.receivedResponses.add(message);
			this.connectToServer.sentResponses.add(message);
			System.out.println("Response received");
		}
		// TODO Auto-generated method stub
		System.out.println("Unable to receive response");
		return false;
	}


	
	//TODO Add methods - Done
	
	// -------------------------------All Methods------------------------------
	
	//TODO Add methods
	
	// -------------------------------hashCode equals & toString------------------------------
	@Override
	public boolean equals(Object obj) {
		if (obj.getClass() == Client.class)
		{
			if(((Client)obj).ip.equals(this.ip))
				return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String toString() {
		String temp = "";
		temp = this.ip+":"+this.number;
		return temp;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	//TODO Add hashCode equals & toString

}
