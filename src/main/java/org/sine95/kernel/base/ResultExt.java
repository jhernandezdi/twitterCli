package org.sine95.kernel.base;

public  class ResultExt<T> extends Result<T> {
	
	private String ticket;

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	
	public ResultExt()
	{
		super();
	}
	public ResultExt(Result<T> res,String ticket)
	{
		super();
		setTicket(ticket);
		setData(res.getData());
		setInfoEWI(res);
	}
	
}
