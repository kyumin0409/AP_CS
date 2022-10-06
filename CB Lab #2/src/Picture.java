import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method to keep only the blue value*/
  public void keepOnlyBlue(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray: pixels){
		  for(Pixel pixelObj: rowArray){
			  pixelObj.setRed(0);
			  pixelObj.setGreen(0);
		  }
	  }
  }

  /**Method to make the image gray*/
  public void grayscale(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray: pixels){
		  for(Pixel pixelObj: rowArray){
			  int avg = (pixelObj.getRed()+pixelObj.getGreen()+pixelObj.getBlue())/3;
			  pixelObj.setRed(avg);
			  pixelObj.setGreen(avg);
			  pixelObj.setBlue(avg);
		  }
	  }
  }

  /**Method to negate the image*/
  public void negate(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray: pixels){
		  for(Pixel pixelObj: rowArray){
			  pixelObj.setRed(255-pixelObj.getRed());
			  pixelObj.setGreen(255-pixelObj.getGreen());
			  pixelObj.setBlue(255-pixelObj.getBlue());
		  }
	  }
  }

  /**Method to make the fish underwater more visible*/
  public void fixUnderwater(){
	  Pixel[][] pixels = this.getPixels2D();
	  for(Pixel[] rowArray: pixels){
		  for(Pixel pixelObj: rowArray){
			  pixelObj.setRed(pixelObj.getRed()+20);
			  if(pixelObj.getBlue()>=pixelObj.getGreen()){
				  pixelObj.setBlue(pixelObj.getBlue()+10);
				  pixelObj.setGreen(pixelObj.getGreen()-20);
				  pixelObj.setRed(pixelObj.getRed()+25);
			  }
		  }
	  }
  }

/** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /**Method that mirrors the picture around a 
   * vertical mirror in the center of the picture from
   * right to left
   */
  public void mirrorVerticalRightToLeft(){
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  int width = pixels[0].length;
	  for(int row=0; row<pixels.length; row++){
		  for(int col=width/2; col<width; col++){
			  rightPixel = pixels[row][col];
			  leftPixel = pixels[row][width-col-1];
			  leftPixel.setColor(rightPixel.getColor());
		  }
	  }
  }

  /**Method that mirrors the picture around a 
   * horizontal mirror in the center of the picture from
   * top to bottom
   */
  public void mirrorHorizontal(){
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int length = pixels.length;
	  for(int row=0; row<length/2; row++){
		  for(int col=0; col<pixels[0].length; col++){
			  topPixel = pixels[row][col];
			  bottomPixel = pixels[length-row-1][col];
			  bottomPixel.setColor(topPixel.getColor());
		  }
	  }
  }

  /**Method that mirrors the picture around a 
   * horizontal mirror in the center of the picture from 
   * bottom to top
   */
  public void mirrorHorizontalBotToTop(){
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topPixel = null;
	  Pixel bottomPixel = null;
	  int length = pixels.length;
	  for(int row=length/2; row<length; row++){
		  for(int col=0; col<pixels[0].length; col++){
			  bottomPixel = pixels[row][col];
			  topPixel = pixels[length-row-1][col];
			  topPixel.setColor(bottomPixel.getColor());
		  }
	  }
  }

  /**Method that mirrors the picture around
   * a diagonal mirror of the picture
   */
  public void mirrorDiagonal(){
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftBot = null;
	  Pixel rightTop = null;
	  int length = pixels.length;
	  for(int row = 0; row<length; row++){
		  for(int col =0; col<row; col++){
			  rightTop = pixels[row][col];
			  leftBot = pixels[col][row];
			  leftBot.setColor(rightTop.getColor());
		  }
	  }
  }

  /** Method that mirrors arms on the snowman
   * making the snowman have 4 arms
   */
  public void mirrorArms(){
	  int mirrorPoint1 = 196;
	  int mirrorPoint2 = 197;
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel topLeft = null;
	  Pixel bottomLeft = null;
	  Pixel topRight = null;
	  Pixel bottomRight = null;
	  for(int row = 158; row<mirrorPoint1; row++){//left arm
		  for(int col = 104; col<171; col++){
			  topLeft = pixels[row][col];
			  bottomLeft = pixels[mirrorPoint1-row+mirrorPoint1][col];
			  bottomLeft.setColor(topLeft.getColor());
		  }
	  }
	  for(int row = 171; row<mirrorPoint2; row++){//right arm
		  for(int col = 238; col<293; col++){
			  topRight = pixels[row][col];
			  bottomRight = pixels[mirrorPoint2-row+mirrorPoint2][col];
			  bottomRight.setColor(topRight.getColor());
		  }
	  }
  }

  /**Method that mirrors the gull on the beach
   * 
   */
  public void mirrorGull(){
	  int mirrorPoint = 347;
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  for(int row=235; row<324; row++){
		  for(int col = 239; col<mirrorPoint; col++){
			  leftPixel = pixels[row][col];
			  rightPixel = pixels[row][mirrorPoint-col+mirrorPoint];
			  rightPixel.setColor(leftPixel.getColor());
		  }
	  }
  }

/** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
	int count = 0;
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    
    System.out.println(count);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /**
   * copy from the passed fromPic to the specified startRow
   *  and startCol in the current picture to the specified
   *  endRow and endCol
   * @param fromPic the picture to copy from
   * @param startRow the start row to copy to
   * @param startCol the start col to copy to
   * @param endRow the end row to copy till
   * @param endCol the end col to copy till
   */
  public void copy(Picture fromPic, int startRow, int startCol, int endRow, int endCol){
	  Pixel fromPixel = null;
	  Pixel toPixel = null;
	  Pixel[][] toPixels = this.getPixels2D();
	  Pixel[][] fromPixels = fromPic.getPixels2D();
	  
	  for(int fromRow =0, toRow = startRow; fromRow<fromPixels.length && toRow<endRow; fromRow++, toRow++){
		  for(int fromCol =0, toCol = startCol; fromCol<fromPixels[0].length && toCol<endCol; fromCol++, toCol++){
			  fromPixel = fromPixels[fromRow][fromCol];
			  toPixel = toPixels[toRow][toCol];
			  toPixel.setColor(fromPixel.getColor());
		  }
	  }
  }

/** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  
  /** Method that creates my unique collage*/
  public void myCollage(){
	  Picture robot = new Picture("robot.jpg");
	  Picture flower1 = new Picture("flower1.jpg");
	  Picture flower2 = new Picture("flower2.jpg");
	  this.copy(robot,0,0);
	  this.copy(flower1, 100, 230, 200, 300);
	  this.copy(flower2, 100, 300, 150, 400);
	  this.mirrorHorizontal();
  }

/** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel bottomPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color bottomColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
    	for( int row2 = row; row2 < row+1 && row2<pixels.length-1; row2++){
    		leftPixel = pixels[row][col];
            rightPixel = pixels[row][col+1];
            bottomPixel = pixels[row2][col];
            rightColor = rightPixel.getColor();
            bottomColor = bottomPixel.getColor();
            if (leftPixel.colorDistance(rightColor) > edgeDist
            		|| leftPixel.colorDistance(bottomColor)>edgeDist){
              leftPixel.setColor(Color.BLACK);
            }else{
              leftPixel.setColor(Color.WHITE);
            }
    	}
      }
    }
  }
  
  /**
   * Method to show large changes in color
   * @param edgeDist the distance for finding edges
   */
  public void edgeDetection2(int edgeDist){
	  Pixel [][] pixels = this.getPixels2D();
	  Pixel leftPixel = null;
	  Pixel rightPixel = null;
	  Pixel bottomPixel = null;
	  for(int row = 0; row<pixels.length; row++){
		  for(int col = 0; col < pixels[0].length-1; col++){
			  for(int row2 = row; row2 < row+1 && row2<pixels.length-1; row2++){
				  leftPixel = pixels[row][col];
				  rightPixel = pixels[row][col+1];
				  bottomPixel = pixels[row2][col];
				  int leftAvg = (leftPixel.getRed()+leftPixel.getGreen()+leftPixel.getBlue())/3;
				  int rightAvg = (rightPixel.getRed()+rightPixel.getGreen()+rightPixel.getBlue())/3;
				  int botAvg = (bottomPixel.getRed()+bottomPixel.getGreen()+bottomPixel.getBlue())/3;
				  if(rightAvg - leftAvg > edgeDist || botAvg - leftAvg > edgeDist){
					  leftPixel.setColor(Color.BLACK);
		          }else{
		              leftPixel.setColor(Color.WHITE); 
				  }
			  }
		  }
	  }
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
