package photomanagement;
class Photo
{
    String path; LinkedList tags;
    public Photo(String path,LinkedList tags)
    {
        this.path=path;
        this.tags=tags;
    }
    public String getPath()
    {
        return path;
    }
    public LinkedList getTags()
    {
        return tags;
    }
}
//..............................................
class Album 
{
    String name,condition;PhotoManager manager;int NOC;
    public Album (String name, String condition,PhotoManager manager)
    {
            this.name=name;
            this.condition=condition;
            this.manager=manager;
    }
	// Return the name of the album
	public String getName()
        {
            return name;
        }
	// Return the condition associated with the album
	public String getCondition()
        {
            return condition;
        }
	// Return the manager
	public PhotoManager getManager()
        {
            return manager;
        }
	// Return all photos that satisfy the album condition
	public LinkedList<Photo> getPhotos()
        {
            
        }
	// Return the number of tag comparisons used to find all photos of the album
	public int getNbComps()
        {
            return NOC;
        }
}

//......................................................
class PhotoManager
{
    String path;
    public PhotoManager()
    {
        
    }
    public void addPhoto(Photo p)
    {
        
    }
    public void deletePhoto(String path)
    {
        this.path=path;
        //delete 
    }
    /*public BST<LinkList>getPhotos()
    {
        //Return the inverted index of all managed photos
    } */
}
//..........................................................
class BSTNode<T> {
	public int key;
	public T data;
	public BSTNode<T> left, right;

	public BSTNode(int key, T data) {
		this.key = key;
		this.data = data;
		left = right = null;
	}
}

class BST<T> {

	private BSTNode<T> root, current;

	public BST() {
		current = root = null;
	}

	public void clear() {
		current = root = null;
	}
	
	public boolean empty() {
		return root == null;
	}

	public boolean full() {
		return false;
	}

	public T retrieve() {
		return current.data;
	}

	public boolean findKey(int k) {

		BSTNode<T> p = root;
		while (p != null) {
			current = p;
			if (k == p.key) {
				return true;
			} else if (k < p.key) {
				p = p.left;
			} else {
				p = p.right;
			}
		}
		return false;
	}

	public boolean insert(int k, T val) {
		if (root == null) {
			current = root = new BSTNode<T>(k, val);
			return true;
		}

		BSTNode<T> p = current;
		if (findKey(k)) {
			current = p;
			return false;
		}

		BSTNode<T> tmp = new BSTNode<T>(k, val);
		if (k < current.key) {
			current.left = tmp;
		} else {
			current.right = tmp;
		}
		current = tmp;
		return true;
	}

	public boolean removeKey(int k) {

		// Search for k
		int k1 = k;
		BSTNode<T> p = root;
		BSTNode<T> q = null; // Parent of p
		while (p != null) {

			if (k1 < p.key) {
				q =p;
				p = p.left;
			} else if (k1 > p.key) {
				q = p;
				p = p.right;
			} else { // Found the key

				// Check the three cases
				if ((p.left != null) && (p.right != null)) { // Case 3: two
																// children

					// Search for the min in the right subtree
					BSTNode<T> min = p.right;
					q = p;
					while (min.left != null) {
						q = min;
						min = min.left;
					}
					p.key = min.key;
					p.data = min.data;
					k1 = min.key;
					p = min;
					// Now fall back to either case 1 or 2
				}

				// The subtree rooted at p will change here
				if (p.left != null) { // One child
					p = p.left;
				} else { // One or no children
					p = p.right;
				}

				if (q == null) { // No parent for p, root must change
					root = p;
				} else {
					if (k1 < q.key) {
						q.left = p;
					} else {
						q.right = p;
					}
				}
				current = root;
				return true;

			} 
		}

		return false; // Not found
	}
}

//..........................................................
class Node<T> {
	public T data;
	public Node<T> next;
	public Node (T val) {
		data = val;
		next = null;
	}
}
class LinkedList<T> {
	private Node<T> head;
	private Node<T> current;
	public LinkedList () {
		head = current = null;
	}
	public boolean empty () {
		return head == null;
	}
	public boolean last () {
		return current.next == null;
	}
	public boolean full () {
		return false;
	}
	public void findFirst () {
		current = head;
	}
	public void findNext () {
		current = current.next;
	}
	public T retrieve () {
		return current.data;
	}
	public void update (T val) {
		current.data = val;
	}
	public void insert (T val) {
		Node<T> tmp;
		if (empty()) {
			current = head = new Node<T> (val);
		}
		else {
			tmp = current.next;
			current.next = new Node<T> (val);
			current = current.next;
			current.next = tmp;
		}
	}
	public void remove () {
		if (current == head) {
			head = head.next;
		}
		else {
			Node<T> tmp = head;
			while (tmp.next != current)
				tmp = tmp.next;
			tmp.next = current.next;
		}
		if (current.next == null)
			current = head;
		else
			current = current.next;
	}
}

//..........................................................
public class PhotoManagement 
{
    public static void main(String[] args) 
    {
        LinkedList<String> tag1 = new LinkedList<String>();
        tag1.insert("animal");
        tag1.insert("hedgehog");
        tag1.insert("apple");
        tag1.insert("grass");

        LinkedList<String> tag2 = new LinkedList<String>();
        tag2.insert("animal");
        tag2.insert("bear");
        tag2.insert("cub");
        tag2.insert("grass");

        LinkedList<String> tag3 = new LinkedList<String>();
        tag3.insert("insect");
        tag3.insert("butterfly");
        tag3.insert("flower");
        tag3.insert("color");

        LinkedList<String> tag4 = new LinkedList<String>();
        tag4.insert("insect");
        tag4.insert("butterfly");
        tag4.insert("flower");
        tag4.insert("black");

        LinkedList<String> tag5 = new LinkedList<String>();
        tag5.insert("animal");
        tag5.insert("fox");
        tag5.insert("tree");
        tag5.insert("grass");

        LinkedList<String> tag6 = new LinkedList<String>();
        tag6.insert("animal");
        tag6.insert("bear");
        tag6.insert("panda");
        tag6.insert("grass");

        LinkedList<String> tag7 = new LinkedList<String>();
        tag7.insert("animal");
        tag7.insert("wolf");
        tag7.insert("sky");
        tag7.insert("snow");

        LinkedList<String> tag8 = new LinkedList<String>();
        tag8.insert("animal");
        tag8.insert("raccoon");
        tag8.insert("log");
        tag8.insert("snow");

        Photo p1 = new Photo("hedgehog.jpg", tag1);
        Photo p2 = new Photo("bear.jpg", tag2);//bear
        Photo p3 = new Photo("butterfly1.jpg", tag3);
        Photo p4 = new Photo("butterfly2.jpg", tag4);
        Photo p5 = new Photo("fox.jpg", tag5);
        Photo p6 = new Photo("panda.jpg", tag6);//bear
        Photo p7 = new Photo("wolf.jpg", tag7);
        Photo p8 = new Photo("raccoon.jpg", tag8);

       PhotoManager pm = new PhotoManager();

        pm.addPhoto(p1);
        pm.addPhoto(p2);
        pm.addPhoto(p3);
        pm.addPhoto(p4);
        pm.addPhoto(p5);
        pm.addPhoto(p6);
        pm.addPhoto(p7);
        pm.addPhoto(p8);

        Album a = new Album("bears", "bear", pm);//2
        LinkedList<Photo> PhotosOfA = a.getPhotos();

        if (!PhotosOfA.empty()) {

            PhotosOfA.findFirst();

            while (!PhotosOfA.last()) {

                System.out.println(PhotosOfA.retrieve().getPath());
                PhotosOfA.findNext();

            }

            System.out.println(PhotosOfA.retrieve().getPath());

        } 
        else {

            System.out.println("No Photos");
        }
        System.out.println("----------------------------------------");

        pm.deletePhoto("panda.jpg");

        PhotosOfA = a.getPhotos();

        if (!PhotosOfA.empty()) {

            PhotosOfA.findFirst();

            while (!PhotosOfA.last()) {

                System.out.println(PhotosOfA.retrieve().getPath());
                PhotosOfA.findNext();

            }

            System.out.println(PhotosOfA.retrieve().getPath());

        } else {

            System.out.println("No Photos");
        }
    }  
}