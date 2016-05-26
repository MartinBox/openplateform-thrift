package org.openplateform.thrift.server;

import org.apache.thrift.TException;

import thrift.ThriftService.Iface;

public class ThriftService implements Iface {

	@Override
	public int add(int a, int b) throws TException {
		// TODO
		return a + b;

	}
}
