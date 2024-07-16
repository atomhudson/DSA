public class _71_DynamicCustomStack extends _68_CustomStack{
    public _71_DynamicCustomStack() {
        super();            // It Will Call _68_CustomStack()
    }
    public _71_DynamicCustomStack(int size) {
        super(size);        //It Will Call _68_CustomStack(int size)
    }
    @Override
    public boolean push(int item) {
        if (this.isFull()){
            int[] temp = new int[data.length * 2]; // Double the array size
            for (int i = 0; i < data.length; i++) { // Copy all previous item in new data
                temp[i] = data[i];
            }
            data = temp;
        }
//        at this point we know that array is not full
//        insert item
        return super.push(item);
    }
}
