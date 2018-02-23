
package cn.lhqs.response;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import org.apache.log4j.Logger;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-01-04 14:33
 * description : Server入口
 * version : 1.1
 */
public class Server {
	private Logger logger = Logger.getLogger(Server.class);

	public void run(int port) throws Exception {
    	EventLoopGroup group = new NioEventLoopGroup();
		try {
		    Bootstrap b = new Bootstrap();
		    b.group(group).channel(NioDatagramChannel.class)
			    .option(ChannelOption.SO_BROADCAST, true)
			    .handler(new ServerHandler());
		    b.bind(port).sync().channel().closeFuture().await();
		} finally {
		    group.shutdownGracefully();
		}
    }

    public static void main(String[] args) throws Exception {
		new Server().run(9922);
}
}
