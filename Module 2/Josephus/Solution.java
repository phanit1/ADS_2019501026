/**.
 * Here we use circular linked list class and solve the Josephus problem
 * @author Phaneendhar
 */
public class Solution{
	public static String Josephus(int a, int b){
		// fill you code Here
		circularLinkedList cll = new circularLinkedList();
		for(int i = 0; i < a; i++){
			cll.add(i);
		}
		/**.
		 * Here we call formCircle to form the elements into a circle
		 */
		cll.formCircle();
		int pos = 1;
		Node temp = cll.head;
		int eliminated = 0;
		String toReturn = " ";
		while (eliminated != a) {
			temp = temp.next;
			pos++;
			if(pos == b) {
				pos = 1;
				toReturn += temp.data + " ";
				Node prevNode = temp.prev;
				Node nextNode = temp.next;
				prevNode.next = nextNode;
				nextNode.prev = prevNode;
				eliminated++;
				temp = temp.next;
			}
		}
		toReturn = toReturn.trim();
		return toReturn;
	}
}
