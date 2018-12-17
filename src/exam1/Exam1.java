package exam1;


/**
 * @author 15009276686
 *
 */
public class Exam1 {
	
	int x,y;	//x:晋级需要的最低场次；y:一共打了y场比赛
	double[][] r= new double[100][100];	//结果矩阵
	double result;
	
	/**
	 * @param n
	 * @param p
	 * @return
	 */
	public double dynamicPlanning(int n,int[] p){
		//初始化
		y = n;
		x = (int) (0.7*n);
		System.out.println("x:"+x);
		
		
		initMatrix();	//初始化结果矩阵
		
		int q[] = new int[100];	//初始化输的概率数组；存储起来，减少计算
		for(int i=1;i<=n;i++){
			q[i] = 100-p[i];
		}
		
		
		
		/**
		 * 
		 */
		
		
		for(int j=1;j<=n;j++){
			for(int i=1;i<=j;i++){
				r[i][j] = ((r[i][j-1]*(q[j]/100.00)) + (r[i-1][j-1]*(p[j]/100.00)));
			}
		}
		
		
		
		result = r[x][y];
		
		System.out.println("result:"+result);

		result = Math.round(result*100000.00)/100000.00;
		
		System.out.println("result:"+result);
		
		return result;
	}
	
	/**
	 * 
	 */
	public void initMatrix(){
		for(int i=0;i<100;i++){
			r[i][0] = 0;	//y=0时：概率为0；
			r[0][i] = 1;	//x=0时：概率为1;顺便覆盖R[0][0]=1
			for(int j=i+1;j<100;j++){	//x>y时：概率为0
					r[j][i] = 0;
			}
		}
	}
}
