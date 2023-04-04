package Model;

/**
 * @author Moayad
 */
public interface IClient extends Connectable{
	/**
	 * this method connect client to given server
	 * @param server
	 * @return true if connect successfully, false otherwise 
	 */
    boolean connectTo(IServer server);

    /**
     * this method disconnect a connection with server
     * @return true if disconnect successfully, false otherwise
     */
    boolean disconnect();
    @SuppressWarnings("rawtypes")
    boolean messageSent(Message message);
    @SuppressWarnings("rawtypes")
    boolean onMessageReceived(Message message);
}
