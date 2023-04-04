package Model;
import java.util.ArrayList;



public class Server implements IServer{
	// -------------------------------Class Members------------------------------
	private static int arc = 0;
	private int number;
	protected String ip;
	protected int port;
	protected ArrayList<Client> clients;
	protected ArrayList<Message<?,?>> receivedRequests;
	protected ArrayList<Message<?,?>> sentResponses;
	
	//TODO add member
	// -------------------------------Constructors------------------------------

	public Server(String ip,int port) {
		super();
		number = ++arc;
		this.ip = ip;
		this.port = port;
		clients = new ArrayList<>();
		receivedRequests = new ArrayList<>();
		sentResponses = new ArrayList<>();
		//TODO - done
	}

	
	// -----------------------------------------Setters&&Getters--------------------------------------
	@Override
	public boolean register(IClient client) {
		if(!clients.contains(((Client)client))&& clients.size()< 3)
		{
			clients.add(((Client)client));
			System.out.println("Registered!");
			return true;
		}
		// TODO Auto-generated method stub
		System.out.println("Unable to register");
		return false;
	}

	@Override
	//Simple boolean check if clients is empty
	public boolean isOnline() {
		return !(clients.isEmpty());
		// TODO Auto-generated method stub
	}

	@Override
	public boolean disconnectClient(IClient client) {
		if(clients.contains(((Client)client)))
		{
			((Client)client).disconnect();
		}
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean messageSent(Message message) {
		if(((Client)(message.from)).onMessageReceived(message))
		{
			int lastPlaceInMessages = ((Client)(message.from)).SentRequest.size();
			((Client)(message.from)).SentRequest.get(lastPlaceInMessages).updateStatus(message);
			return true;
		}
		return false;
		// TODO Auto-generated method stub
	}

	@Override
	@SuppressWarnings("rawtypes")
	public boolean onMessageReceived(Message message) {
		if(((Client)(message.from)).messageSent(message))
			return true;
		// TODO Auto-generated method stub
		return false;
	}
	


	//TODO Add methods
	
	// -------------------------------All Methods------------------------------

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}


	/**
	 * @return the ip
	 */
	public String getIp() {
		return ip;
	}


	/**
	 * @return the clients
	 */
	public ArrayList<Client> getClients() {
		return clients;
	}


	@Override
	public int connected() {
		return clients.size();
	}
	//TODO Add methods

	// -------------------------------hashCode equals & toString------------------------------





	/**
	 * @return the ip
	 */
	public String getIP() {
		return ip;
	}


	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(obj instanceof Server)
			if(((Server)obj).ip.equals(this.ip))
				{
					return true;
				}
		return false;
	}


	@Override
	public String toString() {
		String temp = "";
		temp = this.ip+":"+this.number;
		return temp;
	}
	
	//TODO Add hashCode equals & toString
}
