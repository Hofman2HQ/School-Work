package Model;
/**
 * @author Moayad
 */
public interface IServer extends Connectable{

    /**
     * Register the Client to this server
     * @param client
     * @return 
     */
    boolean register(IClient client);

    /**
     * 
     * @return true if there are connected for clients , false otherwise
     */
    boolean isOnline();

    /**
     * this method un-registers the client
     * @return true if the un-registers successfully,false otherwise.
     */
    int connected();
    boolean disconnectClient(IClient client);
    boolean messageSent(Message message);
    boolean onMessageReceived(Message message);
}
