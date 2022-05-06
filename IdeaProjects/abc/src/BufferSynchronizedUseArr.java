public class BufferSynchronizedUseArr {// Thiết kế lại lớp Buffer
    private int[] buffer = new int[10];// mang hang doi quay vong
    private int tt = 0;
    private boolean writable = true;
    private boolean readable = true;
    public  BufferSynchronizedUseArr (){}

    public synchronized void set( int value ){
        while (!writable){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        buffer[tt] = value;
        tt = tt + 1;
        if(tt == 10){
            writable = false;
        }
        readable = true;
        notify();
    }

    public synchronized int get(){
        while(readable == false){
            try{
                wait();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        writable = true;
        tt = tt - 1;
        if(tt == 0){
            readable = false;
        }
        notify();
        return buffer[tt];
    }
}
