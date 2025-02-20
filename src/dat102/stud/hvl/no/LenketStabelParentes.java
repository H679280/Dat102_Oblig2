package dat102.stud.hvl.no;
import java.util.EmptyStackException;

public class LenketStabelParentes<T> {
		private Node topNode;

		public LenketStabelParentes() {
			topNode = null;
		}

		public void push(T newEntry) {
			topNode = new Node(newEntry, topNode);
		}

		public T pop() {
			if (isEmpty())
				throw new EmptyStackException();
			
			T data =  topNode.data; 
			topNode = topNode.neste;
			return data;
			
		}

		public boolean isEmpty() {
			return topNode == null;
		}

		
		/* ----------------------------------------------------------- */

		private class Node {
			
			private T data;
			private Node neste;

			private Node(T data) {
				this(data, null);
			}

			private Node(T data, Node neste) {
				this.data = data;
				this.neste = neste;
			}
		}
	}

