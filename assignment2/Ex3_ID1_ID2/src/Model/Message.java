package Model;
import utils.*;

public class Message<E,F> {
	private int requestNumber;
	private Object data;
	F from;
	E to;
	private E_MessageStatus status;
	private int replyToRequestNum;
	/**
	 * @param requestNumber
	 * @param data
	 * @param from
	 * @param to
	 * @param status
	 * @param replyToRequestNum
	 */
	public Message(int requestNumber, Object data, F from, E to) {
		super();
		this.requestNumber = requestNumber;
		if (data instanceof Integer || data instanceof String) {
		      this.data = data;
		    } else {
		      throw new IllegalArgumentException("ID must be either int or String");
		    }
		this.from = from;
		this.to = to;
		this.status = E_MessageStatus.PENDING;;
		this.replyToRequestNum = 0;
	}
	/**
	 * @return the status
	 */
	public E_MessageStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void updateStatus(Message<?,?> response) {
		if((this.data instanceof Integer && response.data instanceof Integer) || (this.data instanceof String && response.data instanceof String))
		{
			this.status = E_MessageStatus.SUCCESS;
		}
		else this.status = E_MessageStatus.FAILURE;
	}
	/**
	 * @return the replyToRequestNum
	 */
	public int getReplyToRequestNum() {
		return replyToRequestNum;
	}
	/**
	 * @param replyToRequestNum the replyToRequestNum to set
	 */
	public void setReplyToRequestNum(Message<?,?> replay) {
		if (replay.from.getClass()==Server.class)
		{
			this.replyToRequestNum = replay.requestNumber;
		}
		// TODO Auto-generated method stub
	}
	 
	
	
}
