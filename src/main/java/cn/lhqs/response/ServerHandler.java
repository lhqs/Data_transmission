package cn.lhqs.response;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import org.apache.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * author : lhqs
 * email : lhqs1314@gmail.com
 * createTime : 2018-01-04 14:40
 * description : Server处理类
 * version : 1.1
 */
public class ServerHandler extends
        SimpleChannelInboundHandler<DatagramPacket> {

    private static Logger logger = Logger.getLogger(ServerHandler.class);

    @Override
    public void messageReceived(ChannelHandlerContext ctx, DatagramPacket packet)
            throws Exception {
        String req = packet.content().toString(CharsetUtil.UTF_8);
        logger.info("[the reveice message]---->" + req);

        Map<String,String> map = getMap(req);
        JdbcUtil.insertMap(map,"sensor");

        // 返回临时信息(非必要)
        ctx.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("[the return message] --> " + req,
                CharsetUtil.UTF_8), packet.sender()));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
        cause.printStackTrace();
    }

    public static Map<String,String> getMap(String message){
        Map<String,String> map = new HashMap<>();
        String splitLine = " ";
        Pattern pattern = Pattern.compile(splitLine);
        String[] results = pattern.split(message);
        String regex = "\\w{3}([+|-])?\\d{2}\\.\\d{2}([%|C])?";
        for(String str : results){
            if(str != null && str.matches(regex)){
                String key = str.substring(0,3);
                String value = str.substring(3,str.length());
                map.put(key,value);
            }
        }
        return map;
    }
}
