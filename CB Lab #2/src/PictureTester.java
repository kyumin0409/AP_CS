/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  /**Method to test keepOnlyBlue*/
  public static void testKeepOnlyBlue(){
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.keepOnlyBlue();
	  beach.explore();
  }
  
  /**Method to test grayscale*/
  public static void testGrayscale(){
	  Picture lion = new Picture("femaleLionAndHall.jpg");
	  lion.explore();
	  lion.grayscale();
	  lion.explore();
  }
/**Method to test negate*/
  public static void testNegate(){
	  Picture temple = new Picture("temple.jpg");
	  temple.explore();
	  temple.negate();
	  temple.explore();
  }
/**Method to test fixUnderwater*/
  public static void testFixUnderwater(){
	  Picture water = new Picture("water.jpg");
	  water.explore();
	  water.fixUnderwater();
	  water.explore();
  }
/** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /**Method to test mirrorVerticalRightToLeft*/
  public static void testMirrorVerticalRightToLeft(){
	  Picture caterpillar = new Picture("caterpillar.jpg");
	  caterpillar.explore();
	  caterpillar.mirrorVerticalRightToLeft();
	  caterpillar.explore();
  }
/**Method to test mirrorHorizontal*/
  public static void testMirrorHorizontal(){
	  Picture motorcycle = new Picture("redMotorcycle.jpg");
	  motorcycle.explore();
	  motorcycle.mirrorHorizontal();
	  motorcycle.explore();
  }
/**Method to test mirrorHorizontalBotToTop*/
  public static void testMirrorHorizontalBotToTop(){
	  Picture motorcycle = new Picture("redMotorcycle.jpg");
	  motorcycle.explore();
	  motorcycle.mirrorHorizontalBotToTop();
	  motorcycle.explore();
  }
/**Method to test mirrorDiagonal*/
  public static void testMirrorDiagonal(){
	  Picture beach = new Picture("beach.jpg");
	  beach.explore();
	  beach.mirrorDiagonal();
	  beach.explore();
  }
/**Method to test mirrorArms*/
  public static void testMirrorArms(){
	  Picture snowman = new Picture("snowman.jpg");
	  snowman.explore();
	  snowman.mirrorArms();
	  snowman.explore();
  }
/**Method to test mirrorGull*/
  public static void testMirrorGull(){
	  Picture gull = new Picture("seagull.jpg");
	  gull.explore();
	  gull.mirrorGull();
	  gull.explore();
  }
/** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /**Method to test copy*/
  public static void testCopy(){
	  Picture motorcycle = new Picture("redMotorcycle.jpg");
	  Picture flower2 = new Picture("flower2.jpg");
	  motorcycle.explore();
	  motorcycle.copy(flower2, 200, 220, 250, 270);
	  motorcycle.explore();
  }
  
  /**Method to test myCollage*/
  public static void testMyCollage(){
	  Picture wall = new Picture("wall.jpg");
	  wall.explore();
	  wall.myCollage();
	  wall.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.explore();
    swan.edgeDetection(10);
    swan.explore();
  }
/**Method to test edgeDetection2*/
  public static void testEdgeDetection2(){
	  Picture swan = new Picture("swan.jpg");
	    swan.explore();
	    swan.edgeDetection2(2);
	    swan.explore();
  }
  
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorVerticalRightToLeft();
	//testMirrorHorizontal();
	//testMirrorHorizontalBotToTop();
    //testMirrorTemple();
    testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
	//testMyCollage();
    //testEdgeDetection();
    testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}