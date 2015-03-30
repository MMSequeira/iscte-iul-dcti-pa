# Introduction #

Código criado na aula.


# Details #

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages

Class Rational.java
/
  * 
  * 
package pt.iscte.dcti.pa.math;

/
  * @author Nuno Antunes
  * 
  * 
public class Rational {

> private int numerator;
> private int denominator;

> public Rational(final int numerator, final int denominator) {
> > //TODO: Verify special cases  like numerator = 0 or denominator = 0
> > if(denominator == 0)
> > > throw new IllegalArgumentException("Illegal value of denominator. Should be != 0, was [" + denominator + "]");

> > this.numerator = numerator;
> > this.denominator = denominator;
> > normalize();
> > checkInvariant();

> }

> public int getDenominator() {
> > checkInvariant(); //Esta função está a ser chamada em toda a classe. Através do AspectJava vamos ver soluções mais elegantes!!!
> > return denominator;

> }

> public int getNumerator() {
> > checkInvariant();
> > return numerator;

> }

> private void checkInvariant(){
> > assert 0 < denominator : "Illegal state. Denominator should be > 0, is [" + denominator +"].";
> > assert gcd(numerator, denominator) == 1 : "Illegal state. gcd(numerator, denominator) should be 1, is [" + gcd(numerator, denominator) +"].";

> }

> private void normalize(){
> > if(denominator == 0 && numerator == 0 ) return;


> if (denominator < 0) {
> > numerator = -numerator;
> > denominator = -denominator;

> }

> int gcd = gcd (numerator, denominator);
> numerator /= gcd;
> denominator /= gcd;
> }

> private static int gcd( int firstValue,  int secondValue) {
> > // TODO Auto-generated method stub
> > assert firstValue != 0 || secondValue != 0 : "Illegal value of arguments. Cannot be both zero.";


> while(firstValue != 0){
> > final int oldFirstValue=firstValue;
> > firstValue = secondValue % firstValue;
> > secondValue = oldFirstValue;

> }

> return secondValue;
> }

> public static void main(final String[.md](.md) args) {
> > new Rational(1, 1);
> > gcd(0, 0);

> }
}