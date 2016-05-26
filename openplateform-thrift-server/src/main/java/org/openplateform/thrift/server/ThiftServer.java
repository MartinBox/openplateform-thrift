package org.openplateform.thrift.server;

import org.apache.thrift.TProcessor;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class ThiftServer {

	public static void main(String[] args) {
		try {
			// 设置服务端口为 7911 
			TServerSocket serverTransport = new TServerSocket(7911);
			// 设置协议工厂为 TBinaryProtocol.Factory 
			Factory proFactory = new TBinaryProtocol.Factory();
			// 关联处理器与 Hello 服务的实现
			TProcessor processor = new thrift.ThriftService.Processor(new ThriftService());

			TThreadPoolServer.Args targs = new TThreadPoolServer.Args(serverTransport);
			targs.protocolFactory(proFactory);

			targs.processor(processor);
			TServer server = new TThreadPoolServer(targs);

			System.out.println("Start server on port 7911...");
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}
}
