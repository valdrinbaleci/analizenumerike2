{\rtf1\ansi\ansicpg1252\deff0\deflang1033{\fonttbl{\f0\fswiss\fcharset0 Arial;}}
{\*\generator Msftedit 5.41.15.1515;}\viewkind4\uc1\pard\f0\fs20 public class Polynomial \{\par
\tab\par
\tab private double[] terms;\par
\tab\par
\tab public Polynomial(double[] t)\{\par
\tab\tab terms = t;\par
\tab\}\par
\tab\par
\tab public double[] toArray()\{\par
\tab\tab return terms;\par
\tab\}\par
\tab\tab\par
\tab public double evaluate(double x)\{\par
\tab\tab\par
\tab\tab double result = terms[terms.length-1];\par
\tab\tab\par
\tab\tab for(int i=terms.length-2; i>=0; i--)\{\par
\tab\tab\tab result = (result*x)+terms[i];\par
\tab\tab\}\par
\tab\tab\par
\tab\tab return result;\par
\tab\}\par
\par
\}\par
}
 