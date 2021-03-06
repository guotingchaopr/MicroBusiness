/**   
 * @Title: WeiXinUtil.java
 * @Package com.guotingchao.mb.util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-6 上午10:41:30
 * @version V1.0   
 */
package com.guotingchao.mb.util;

import java.io.InputStream;
import java.io.Writer;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.guotingchao.mb.model.Article;
import com.guotingchao.mb.model.Classes;
import com.guotingchao.mb.model.GolbalConfig;
import com.guotingchao.mb.model.Message;
import com.guotingchao.mb.model.Reply;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.core.util.QuickWriter;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * @ClassName: WeiXinUtil
 * @Description: TODO(微信工具类)
 * @author guotingchaopr guotingchaopr@gmail.com
 * @date 2014-4-6 上午10:41:30
 * 
 */
public class WeiXinUtil {
	
	private static final String TOKEN = "guotingchaopr"; 
	
	private static XStream xstream = new XStream(new XppDriver() {  
        public HierarchicalStreamWriter createWriter(Writer out) {  
            return new PrettyPrintWriter(out) {  
                // 对所有xml节点的转换都增加CDATA标记  
                boolean cdata = true;  
                public void startNode(String name, Class clazz) {  
                    super.startNode(name, clazz);  
                }  
                protected void writeText(QuickWriter writer, String text) {  
                    if (cdata) {  
                        writer.write("<![CDATA[");  
                        writer.write(text);  
                        writer.write("]]>");  
                    } else {  
                        writer.write(text);  
                    }  
                }  
            };  
        }  
    });  

	/**
	 * 
	 * @Title: sha1
	 * @Description: TODO(将传入的字符串进行SHA1加密)
	 * @param @param key
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String sha1(String key) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA1");
			md.update(key.getBytes());
			String pwd = new BigInteger(1, md.digest()).toString(16);
			return pwd;
		} catch (Exception e) {
			e.printStackTrace();
			return key;
		}
	}
	/***
	 * 
	* @Title: level_0_process
	* @Description: 0 级 提示预处理
	* @param @param request    设定文件
	* @return void    返回类型
	* @throws
	 */
    public static void level_0_process(HttpServletRequest request,Object obj){
		StringBuffer content= new StringBuffer();
		content.append("\n ===[亲，请输入对应菜单选项进入进行选择 === \n");
		for(Classes classes : (List<Classes>)obj){
			content.append("  " + classes.getId()+ " " + classes.getClassName() + "\n");
		}
			content.append("[您当前所在位置=主菜单=");
			request.setAttribute("UR_LEVEL_PROCESSED", content.toString());
    }
    
    /***
	 * 
	* @Title: level_1_process
	* @Description: 1 级 提示预处理
	* @param @param request    设定文件
	* @return void    返回类型
	* @throws
	 */
    public static void level_1_process(HttpServletRequest request,Object obj){
		StringBuffer content= new StringBuffer();
		content.append("\n ===[亲，请输入对应菜单选项进入进行选择 === \n");
		for(Classes classes : (List<Classes>)obj){
			content.append("  " + classes.getId()+ " " + classes.getClassName() + "\n");
		}
			content.append("\n 输入0  【返回上一层】 【您当前所在位置 商家选择】");
			request.setAttribute("UR_LEVEL_PROCESSED", content.toString());
    }
	
	/**
	 * 存储数据的Map转换为对应的Message对象
	 * @param map 存储数据的map
	 * @return 返回对应Message对象
	 */
	public static Message mapToMessage(Map<String,String> map){
		if(map == null) return null;
		String msgType = map.get("MsgType");
		Message message = new Message();
		message.setToUserName(map.get("ToUserName"));
		message.setFromUserName(map.get("FromUserName"));
		message.setCreateTime(new Date(Long.parseLong(map.get("CreateTime"))));
		message.setMsgType(msgType);
		message.setMsgId(map.get("MsgId"));
		if(msgType.equals(Message.TEXT)){
			message.setContent(map.get("Content"));
		}else if(msgType.equals(Message.IMAGE)){
			message.setPicUrl(map.get("PicUrl"));
		}else if(msgType.equals(Message.LINK)){
			message.setTitle(map.get("Title"));
			message.setDescription(map.get("Description"));
			message.setUrl(map.get("Url"));
		}else if(msgType.equals(Message.LOCATION)){
			message.setLocationX(map.get("Location_X"));
			message.setLocationY(map.get("Location_Y"));
			message.setScale(map.get("Scale"));
			message.setLabel(map.get("Label"));
		}else if(msgType.equals(Message.EVENT)){
			message.setEvent(map.get("Event"));
			message.setEventKey(map.get("EventKey"));
		}
		return message;
	}
	
	
	/**
	 * 将回复消息对象转换成xml字符串
	 * @param reply 回复消息对象
	 * @return 返回符合微信接口的xml字符串
	 */
	public static String replyToXml(Reply reply){
		String type = reply.getMsgType();
		if(Reply.TEXT.equals(type)){
			xstream.omitField(Reply.class, "articles");
			xstream.omitField(Reply.class, "articleCount");
			xstream.omitField(Reply.class, "musicUrl");
			xstream.omitField(Reply.class, "hQMusicUrl");
		}else if(Reply.MUSIC.equals(type)){
			xstream.omitField(Reply.class, "articles");
			xstream.omitField(Reply.class, "articleCount");
			xstream.omitField(Reply.class, "content");
		}else if(Reply.NEWS.equals(type)){
			xstream.omitField(Reply.class, "content");
			xstream.omitField(Reply.class, "musicUrl");
			xstream.omitField(Reply.class, "hQMusicUrl");
		}
		xstream.autodetectAnnotations(true);  
		xstream.alias("xml", reply.getClass());
		xstream.alias("item", new Article().getClass());
		return xstream.toXML(reply);
	}
	
	/**
	 * 
	 * @Title: parseXml
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param request
	 * @param @return 设定文件
	 * @return Map<String,String> 返回类型
	 * @throws
	 */
	public static Map<String, String> parseXml(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			InputStream inputStream = request.getInputStream();
			SAXReader reader = new SAXReader();
			Document document = reader.read(inputStream);
			Element root = document.getRootElement();
			List<Element> elementList = root.elements();
			for (Element e : elementList)
				map.put(e.getName(), e.getText());
				inputStream.close();
				inputStream = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	

	/**
	 * 根据token计算signature验证是否为weixin服务端发送的消息
	 */
	public static boolean checkWeixinReques(HttpServletRequest request) {
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		if (signature != null && timestamp != null && nonce != null) {
			String[] strSet = new String[] { TOKEN, timestamp, nonce };
			java.util.Arrays.sort(strSet);
			String key = "";
			for (String string : strSet) {
				key = key + string;
			}
			String pwd = WeiXinUtil.sha1(key);
			return pwd.equals(signature);
		} else {
			return false;
		}
	}
}
