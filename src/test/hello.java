package test;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class hello{
	static volatile int num = 0;
	  static volatile boolean flag = false;

	  public static void main(String[] args) {

	    Thread t1 = new Thread(() -> {
	      for (; 100 > num; ) {
	        if (!flag && (num == 0 || ++num % 2 == 0)) {

	          try {
	            Thread.sleep(100);// 防止打印速度过快导致混乱
	          } catch (InterruptedException e) {
	            //NO
	          }

	          System.out.println(num);
	          flag = true;
	        }
	      }
	    }
	    );

	    Thread t2 = new Thread(() -> {
	      for (; 100 > num; ) {
	        if (flag && (++num % 2 != 0)) {

	          try {
	            Thread.sleep(100);// 防止打印速度过快导致混乱
	          } catch (InterruptedException e) {
	            //NO
	          }

	          System.out.println(num);
	          flag = false;
	        }
	      }
	    }
	    );

	    t1.start();
	    t2.start();

	  }
}
