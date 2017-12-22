package com.dongnaoedu;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 */
public class PipeTransfer {

    private static class Print implements Runnable{
        private PipedReader in;

        public Print(PipedReader in) {
            this.in = in;
        }

        @Override
        public void run() {
           int receive =0;
            try {
                while((receive=in.read())!=-1){
                    System.out.println((char) receive);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        //必须进行连接
        out.connect(in);

        Thread t1 = new Thread(new Print(in),"PrintThread");
//        t1.start();
        int receive =0;
        try {
            while((receive=System.in.read())!=-1){
                out.write(receive);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            out.close();
        }
    }

}
