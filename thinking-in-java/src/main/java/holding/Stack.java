package holding;

import java.util.LinkedList;

public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<>();
    public void push(T v) {
        storage.addFirst(v);
    }
    public T peek() {
        return storage.getFirst();
    }
    public T pop() {
        return storage.removeFirst();
    }
    public boolean empty() {
        return storage.isEmpty();
    }
    @Override
    public String toString() {
        return storage.toString();
    }
}
/**
 * 类名之后的<T>告诉编译器这将是一个参数化类型,而其中的类型参数,即在类被使用将会被实际类型替换的参数,
 * 就是T.大体上,这个类是在声明"我们在定义一个可以持有T类型对象的Stack."Stack是用linkedList实现的,而
 * LinkedList也被告知它将持有T类型对象.注意,push()接受的事T类型的对象,而peek()和pop将返回T类型的对象.
 * peek()方法将提供栈顶元素,但是并不将其从栈顶移除,而pop()将移除并返回栈顶元素.
 */
