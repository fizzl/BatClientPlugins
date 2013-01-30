package net.fizzl.batioproxy;

public interface NetworkCallback {
	public void Send(String msg);
	public void Disconnect(IOThread t);
}
