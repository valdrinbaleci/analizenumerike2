{\rtf1\ansi\ansicpg1252\deff0\deflang1033{\fonttbl{\f0\fswiss\fcharset0 Arial;}}
{\*\generator Msftedit 5.41.15.1515;}\viewkind4\uc1\pard\f0\fs20 import java.util.Arrays;\par
\par
public class Lagrange \{\par
\par
\tab public static Polynomial interpolate(double[] values)\{\par
\par
\tab\tab double[] Px = new double[values.length];\tab\tab // polinomi i Lagranzhit\par
\tab\tab double[] binomial = new double[2];\tab\tab\tab\tab // perkohesisht mban binomet per shumezim\par
\tab\tab for(int x = 0; x<values.length; x++)\{\par
\par
\tab\tab\tab //llogarit Pi(x)\par
\tab\tab\tab double[] Pix = new double[values.length];\tab\tab\tab // Pi terma te PL, qe mbilidhen per te gjetur PL \par
\tab\tab\tab double[] accumulator = new double[values.length]; \tab\par
\par
\tab\tab\tab Pix[0] = values[x];\tab\tab // inicializo Pix ne Yi\par
\tab\tab\tab // shumezo binomet \par
\tab\tab\tab for(int k = 0; k<values.length; k++)\{\par
\tab\tab\tab\tab // kalo nese k==x\par
\tab\tab\tab\tab if(k==x) continue;\par
\par
\tab\tab\tab\tab //krijo binom (p.sh. x+3)\par
\tab\tab\tab\tab binomial[1] = (double)1/(x-k);\tab\tab // x terma\par
\tab\tab\tab\tab binomial[0] = (double)(-k)/(x-k);\tab\tab // terma konstant\par
\tab\tab\tab\tab\par
\tab\tab\tab\tab //shumezo akumulatorin nga binomi\par
\tab\tab\tab\tab Pix = biMult(Pix,binomial);\par
\par
\tab\tab\tab\}\par
\par
\tab\tab\tab // Shto Pi(x termave)\par
\tab\tab\tab for(int j=0; j<values.length; j++)\{\par
\tab\tab\tab\tab Px[j] = Px[j] + Pix[j];\par
\tab\tab\tab\}\par
\tab\tab\}\par
\par
\tab\tab Polynomial result = new Polynomial(Px);\par
\tab\tab return result;\par
\tab\}\par
\par
\tab public static double[] biMult(double[] polynomial, double[] binomial)\{\par
\par
\tab\tab double[] accumulator = new double[polynomial.length];\par
\tab\tab\tab\par
\tab\tab for(int i=0; i<polynomial.length; i++)\{\par
\tab\tab\tab double a = polynomial[i]*binomial[0];\par
\par
\tab\tab\tab double b;\par
\tab\tab\tab if(i-1<0) b = 0;\par
\tab\tab\tab else b = polynomial[i-1]*binomial[1];\par
\par
\tab\tab\tab accumulator[i] = a+b;\par
\tab\tab\}\par
\tab\tab\par
\tab\tab return accumulator;\par
\tab\}\par
}
 