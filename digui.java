//递归算法
//对于一个复杂的问题，把原问题分解为若干个相对简单类同的子问题，继续下去直到子问题简单到能够直接求解，
//也就是说到了递推的出口，这样原问题就有递推得解。
//递归出口：就是一个条件，当满足了这个条件的时候我们就不再递归了。
//关键要抓住的是：a，递归出口。b，递归逐步向出口逼近
//第一个列子：计算阶乘值
import java.util.Scanner;
class A{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		A a = new A();
		System.out.println(a.T(i));
	}
	public double T(int i ){
		if(i<=1){
			return i;
		}else{
			return i*T(i-1);
		}
	}
}
