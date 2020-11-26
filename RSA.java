import java.util.*;
public class RSA {
    public List<Integer> primeNumbersBruteForce(int n) {
        List<Integer> primeNumbers = new LinkedList<>();
        if (n >= 2) {
            primeNumbers.add(2);
        }
        for (int i = 3; i <= n; i += 2) {
            if (isPrimeBruteForce(i)) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

private  boolean isPrimeBruteForce(int number) {
    for (int i = 2; i*i < number; i++) {
        if (number % i == 0) {
            return false;
        }
    }
    return true;
}


private  boolean relativelyPrime(int a, int b) {
    return gcd(a,b) == 1;
}

private  int gcd(int a, int b) {
    int t;
    while(b != 0){
        t = a;
        a = b;
        b = t%b;
    }
    return a;
}

/*public int mod(int a, int b, int c) {
    
    int mul=a*b;
    int div=(int)mul/c;
   
    if(div==1){
     return a;
    }
    else
return div;
}*/
public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int number=sc.nextInt();
    RSA r=new RSA();
    //r.primeNumbersBruteForce( n);
    List<Integer> prime =new LinkedList<Integer>();
    prime=r.primeNumbersBruteForce(number);
    System.out.println(prime);


    int p,q,n,on,temp1,e,private_key=0;
    System.out.println("Enter the first prime number p");
    p=sc.nextInt();
    System.out.println("Enter the second prime number q");
    q=sc.nextInt();
    n=p*q;
    on=(p-1)*(q-1);
    System.out.println("on is "+ on);
    Boolean temp;
    for(int i=2;i<on;i++){
        temp=r.relativelyPrime(i,on);
        if(temp==true){
            System.out.print(i+ " ");
        }
    }
    System.out.println();
    System.out.println("Choose e");
    e=sc.nextInt();
    int count=2;
    int temp3=on;
    for(int i=1;i<=temp3;i++){
        
        temp1=i*e;
        if(temp1==temp3+1){
            //System.out.println();
            private_key=i;
           // System.out.println("d is "+ i);
            //System.out.println();
            break;
        }
        if(temp1>temp3){
            temp3=on*count;
            count++;
        }
        
        
    }
    System.out.println("Public keys are " + "(" + e  + " " + n + ")");
    System.out.println("Private  keys are " + "(" +  private_key + " " + n + ")");

}
}
