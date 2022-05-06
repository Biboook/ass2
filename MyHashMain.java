import java.util.ArrayList;

public class MyHashMain {
	public static void main(String[] args) {
		
	}
}

public class MyHash<K, V> {
	private static class Node<Key, Value> {
		Node<Key, Value> next;
		Node<Key, Value> prev;
	    Key key;
	    Value value;
	    
	    public Node(Key key, Value value) {
	    	this.key = key;
	    	this.value = value;
	    }
	}


public V put(K key, V value) {
	Node<K, V> node = getNodesKey(key);
	if (node != null) {
	      V Value = node.value;
	      node.value = value; 
	      return Value;
	}

    node = new Node<K, V>(key, value);
    int index = getIndexsKey(key);
    if (arr.get(index) != null) {
      node.next = arr.get(index);
      node.next.prev = node;
    }
    arr.set(index, node);
    return null;
}

private ArrayList<Node<K, V>> arr;

public V remove(K key) {
	Node<K, V> node = getNodesKey(key);
	if(node == null) {
		return null;
	}

	if (node.prev != null) {
	  node.prev.next = node.next;
	} else {
	  
	  int hashKey = getIndexsKey(key);
	  arr.set(hashKey, node.next);
	}
	
	if (node.next != null) {
	  node.next.prev = node.prev;
	}
	return node.value;
	}

public V get(K key) {
	if(key == null)  {
		return null;
	}
	
	Node<K, V> node = getNodesKey(key);
	
	if(node == null) {
		return null;
	} else {
		return node.value;
	}
}

private Node<K, V> getNodesKey(K key) {
    int index = getIndexsKey(key);
    Node<K, V> current = arr.get(index);
    while (current != null) {
      if (current.key == key) {
        return current;
      }
      current = current.next;
    }
    return null;
}

public int getIndexsKey(K key) {
    return Math.abs(key.hashCode() % arr.size());
  }
}
