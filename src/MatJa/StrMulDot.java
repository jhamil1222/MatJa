/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MatJa;

/**
 *
 * @author daniroldanlopez
 */
public class StrMulDot {
    public double[][] dot(double [][] a,double [][]b)
    {
       double p1=a[0][0]*(b[0][1]-b[1][1]);
       double p2=(a[0][0]+a[0][1])*b[1][1];
       double p3=(a[1][0]+a[1][1])*b[0][0];
       double p4=a[1][1]*(b[1][0]-b[0][0]);
      double p5=(a[0][0]+a[1][1])*(b[0][0]+b[1][1]);
      double p6=(a[0][1]-a[1][1])*(b[1][0]+b[1][1]);
      double p7=(a[0][0]-a[1][0])*(b[0][0]+b[0][1]);
     
       return new double [][]{{p5+p4-p2+p6,p1+p2},{p3+p4,p1+p5-p3-p7}};
    }
    
}
