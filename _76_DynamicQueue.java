public class _76_DynamicQueue extends _74_CustomCircularQueue{
    public _76_DynamicQueue() { super(); }
    public _76_DynamicQueue(int size) { super(size);}
    @Override
    public boolean insert(int item) {
        if (isEmpty()){
            int[] temp = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            front = 0 ;
            end = data.length;
            data = temp;
        }
        return super.insert(item);
    }
}
