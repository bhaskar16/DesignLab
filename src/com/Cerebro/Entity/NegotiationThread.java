package com.Cerebro.Entity;
/** Author : Abhirup Mukherjee,Bhaskar Ghosh Dastidar  **/
public class NegotiationThread {
	
	private Contract contractSettlement;
	private Message messages[];
	private int threadId;
	
	public Message[] getTutorName() 
	{
	    return messages;
	}
	
	public boolean addMessage(Message m)
	{
		return false;
		
	}
	
	public Contract getContract() 
	{
	    return contractSettlement;
	}
	public void setContract(Contract contractSettlement) 
	{
		this.contractSettlement=contractSettlement;
	}
	
	public int getthreadID() 
	{
	    return threadId;
	}
	public void setthreadId(int threadId) 
	{
		this.threadId=threadId;
	}

}
