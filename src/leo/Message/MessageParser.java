package leo.Message;

public class MessageParser {
	public String typeOk = "OK";
	public String typeApp = "APP";
	public String typeNodeId = "NODEID";

	
	static MessageParser single = new MessageParser();
	public static MessageParser getSingleton(){
		return single;
	}	
	private MessageParser(){
		
	}	
	
	public Message parser(String msg){
		String attributes[] = msg.split(";");
		if(attributes[0].startsWith(typeOk)){
			String values[] = attributes[0].split(":");
			return MessageFactory.getSingleton().getMessageOk();			
		}else if(attributes[0].startsWith(typeNodeId)){
			String content = msg.substring(typeNodeId.length(), msg.length());
			int id = Integer.parseInt(content);
			return MessageFactory.getSingleton().getMessageNodeID(id);
		}else{
			return null;
		}
	}
	
	public static void main(String[] args) {
		String smsg = "app1 2 3 4 5 6 stampend leol o l o";
		Message msg = MessageParser.getSingleton().parser(smsg);
		System.out.println(msg.toString());
	}

}
