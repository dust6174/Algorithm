package exam1;


import junit.framework.Assert;
import junit.framework.TestCase;

public class Exam1Test extends TestCase {
	public void testDynamicPlanning()
    {
        Exam1 exam1 = new Exam1();
        int n = 10;
        int[] p = new int[11];
        for(int i=0;i<=n;i++){
        	p[i]=50;
        }
        double result = exam1.dynamicPlanning(n, p);
        // 判断方法的返回结果
        Assert.assertEquals(0.17188, result, 0.1);
    }
}
