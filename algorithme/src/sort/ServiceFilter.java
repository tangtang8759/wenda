package sort;

import java.util.HashMap;
import java.util.Map;

public class ServiceFilter {
	
	private TreeNode rootNode = new TreeNode();
	
	private class TreeNode{
		private boolean isEnd = false;
		private Map<Character, TreeNode> subNodes = new HashMap<Character, TreeNode>();
		
		public void addSubNode(Character key, TreeNode node) {
			subNodes.put(key, node);
		}
		
		public TreeNode getSubNode(Character key) {
			return subNodes.get(key);
		}
		
		public boolean isEnd() {
			return isEnd;
		}
		public void setEnd(boolean isEnd) {
			this.isEnd = isEnd;
		}
		public void addWord(String text) {
			TreeNode currentNode = this;
			for(int i=0;i<text.length();i++) {
				Character tempKey = text.charAt(i);
				TreeNode node = currentNode.getSubNode(tempKey);
				if(node==null){
					node = new TreeNode();
					currentNode.addSubNode(tempKey, node);
				}
				currentNode = node;
				if(i==text.length()-1) {
					currentNode.setEnd(true);
				} 
			}
		}
	}
	
	public void addWord(String text) {
		rootNode.addWord(text);
	}
	
	public String filter(String text) {
		int begin=0;
		int position=0;
		TreeNode currentNode = rootNode;
		
		StringBuilder sb = new StringBuilder();
		
		Character tempC;
		TreeNode tempNode;
		while(begin < text.length()) {

			tempC=text.charAt(position);
			if(tempC==' ') {
				if(currentNode == rootNode) {
					sb.append(tempC);
					begin++;
				}
				position++;
				continue;
			}
			
			tempNode = currentNode.getSubNode(tempC);
			if(tempNode==null) {
				sb.append(text.charAt(begin));
				begin = begin+1;
				position = begin;
				currentNode = rootNode;
				
			}else {
				position = position +1;
				currentNode = tempNode;
				if(currentNode.isEnd) {
					begin = position;
					sb.append("xxx");
					currentNode = rootNode;
				} 
				
			}
			
		}
		return sb.toString();
		
	}
	
}
