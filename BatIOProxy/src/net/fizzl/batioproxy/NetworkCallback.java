/*
Copyright fizzl@fizzl.net 2011-2013
Licensed under LGPL 3. See LICENSE.txt 
*/
package net.fizzl.batioproxy;

public interface NetworkCallback {
	public void Send(String msg);
	public void Disconnect(IOThread t);
}
