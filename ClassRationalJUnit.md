# Introduction #

Código criado na aula.


# Details #

Add your content here.  Format your content with:
  * Text in **bold** or _italic_
  * Headings, paragraphs, and lists
  * Automatic links to other wiki pages

/
  * 
  * 
package pt.iscte.dcti.pa.math;


import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/
  * @author Nuno Antunes
  * 
  * 
public class RationalTester {

> /
    * @throws java.lang.Exception
    * 
> @BeforeClass
> public static void setUpBeforeClass() throws Exception {
> }

> /
    * @throws java.lang.Exception
    * 
> @AfterClass
> public static void tearDownAfterClass() throws Exception {
> }

> /
    * @throws java.lang.Exception
    * 
> @Before
> public void setUp() throws Exception {
> }

> /
    * @throws java.lang.Exception
    * 
> @After
> public void tearDown() throws Exception {
> }

> @Test
> public void testTwoArgumentsConstructor(){
> > Rational r = new Rational(1024, 512);


> assertEquals(2, r.getNumerator());
> assertEquals(1, r.getDenominator());
> }

> @Test(expected = IllegalArgumentException.class)
> public void testConstructorWithZero(){
> > new Rational (1,0);

> }

}