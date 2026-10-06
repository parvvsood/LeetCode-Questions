import java.util.Stack;
class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public MyQueue() {
    }
    // Add element to the back of queue
    public void push(int x) {
        stack1.push(x);
    }
    // Remove element from the front
    public int pop() {
        moveElements();

        return stack2.pop();
    }
    // Return front element
    public int peek() {
        moveElements();

        return stack2.peek();
    }
    // Check if queue is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    // Move elements from stack1 to stack2
    private void moveElements() {

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */