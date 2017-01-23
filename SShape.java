public class SShape {
  int colOrigin;  
  int rowOrigin;
  int col0;
  int row0;
  int col1;
  int row1;
  int col2;
  int row2;
  int direction; // 0: EAST 1: SOUTH 2: WEST 3: NORTH
  Grid grid;
  
  public void initPointsFromOrigin(int initCol, int initRow) {
    colOrigin = initCol;
    rowOrigin = initRow;
    col0 = initCol - 1;
    row0 = initRow;
    col1 = initCol;
    row1 = initRow - 1;
    col2 = initCol + 1;
    row2 = initRow - 1;
    direction = 0;
  }
  
  public boolean moveDown() {
    boolean left =
      grid.isEmpty(col0, row0 + 1) &&
      grid.isInBounds(col0, row0 + 1);
    boolean down =
      grid.isEmpty(colOrigin, rowOrigin + 1) &&
      grid.isInBounds(colOrigin, rowOrigin + 1);
    boolean right =
      grid.isEmpty(col2, row2 + 1) &&
      grid.isInBounds(col2, row2 + 1);
      
    if (left && down && right) {
      ++rowOrigin;
      ++row0;
      ++row1;
      ++row2;

      return true;
    }
      
    return false;
  }
  
  public boolean moveLeft() {
    //*******direction 0*************
    if(direction == 0){
      boolean left =
        grid.isEmpty(col0 - 1, row0) &&
        grid.isInBounds(col0 - 1, row0);
      boolean right  = 
        grid.isEmpty(col1 - 1, row1)&&
        grid.isInBounds(col1 - 1, row1);
      
      if (left && right) {
        --colOrigin;
        --col0;
        --col1;
        --col2;
        
        return true;
      }
    //*******direction 1*************
    }else if (direction == 1){
      boolean left0 =
        grid.isEmpty(col0 - 1, row0) &&
        grid.isInBounds(col0 - 1, row0);
      boolean leftO  = 
        grid.isEmpty(colOrigin - 1, rowOrigin)&&
        grid.isInBounds(colOrigin - 1, rowOrigin);
      boolean left2 = 
        grid.isEmpty(col2 - 1, row2)&&
        grid.isInBounds(col2 - 1, row2);
      if (left0 && leftO && left2) {
        --colOrigin;
        --col0;
        --col1;
        --col2;
        return true;
      }
      //*******direction 2*************
    }else if (direction == 2){
      boolean leftO =
        grid.isEmpty(colOrigin - 1, rowOrigin) &&
        grid.isInBounds(colOrigin - 1, rowOrigin);
      boolean left2  = 
        grid.isEmpty(col2 - 1, row2)&&
        grid.isInBounds(col2 - 1, row2);
      
      if (leftO && left2) {
        --colOrigin;
        --col0;
        --col1;
        --col2;
        
        return true;
      }
    //*******direction 3*************
    }else if (direction == 3){
      boolean left0 =
        grid.isEmpty(col0 - 1, row0) &&
        grid.isInBounds(col0 - 1, row0);
      boolean left1  = 
        grid.isEmpty(col1 - 1, row1)&&
        grid.isInBounds(col1 - 1, row1);
      boolean left2 = 
        grid.isEmpty(col2 - 1, row2)&&
        grid.isInBounds(col2 - 1, row2);
      if (left0 && left1 && left2) {
        --colOrigin;
        --col0;
        --col1;
        --col2;
        return true;
      }  
      
    }
    
    return false;
  }
  
  public boolean moveRight() {
    //if(direction == 0){
    //boolean rightTop =
      //grid.isEmpty(col2 + 1, row0) &&
      //grid.isInBounds(col2 + 1, row0);
    //boolean rightBottom =
      //grid.isEmpty(colOrigin + 1, row0) &&
      //grid.isInBounds(colOrigin + 1, row0);
    
    //if (rightTop && rightBottom) {
      //++colOrigin;
      //++col0;
      //++col1;
      //++col2;
      //return true;
    //}
    //}
    //return false;
    if(direction == 0){
      boolean right2 =
        grid.isEmpty(col2 + 1, row2) &&
        grid.isInBounds(col2 + 1, row2);
      boolean rightO  = 
        grid.isEmpty(colOrigin + 1, rowOrigin)&&
        grid.isInBounds(colOrigin + 1, rowOrigin);
      
      if (right2 && rightO) {
        ++colOrigin;
        ++col0;
        ++col1;
        ++col2;
        
        return true;
      }
    //*******direction 1*************
    }else if (direction == 1){
      boolean right0 =
        grid.isEmpty(col0 + 1, row0) &&
        grid.isInBounds(col0 + 1, row0);
      boolean right1 = 
        grid.isEmpty(col1 + 1, row1)&&
        grid.isInBounds(col1 + 1, row1);
      boolean right2 = 
        grid.isEmpty(col2 + 1, row2)&&
        grid.isInBounds(col2 + 1, row2);
      if (right0 && right1 && right2) {
        ++colOrigin;
        ++col0;
        ++col1;
        ++col2;
        return true;
      }
      //*******direction 2*************
    }else if (direction == 2){
      boolean right0 =
        grid.isEmpty(col0 + 1, row0) &&
        grid.isInBounds(col0 + 1, row0);
      boolean right1 = 
        grid.isEmpty(col1 + 1, row1)&&
        grid.isInBounds(col1 + 1, row1);
      
      if (right0 && right1) {
        ++colOrigin;
        ++col0;
        ++col1;
        ++col2;
        
        return true;
      }
    //*******direction 3*************
    }else if (direction == 3){
      boolean right0 =
        grid.isEmpty(col0 + 1, row0) &&
        grid.isInBounds(col0 + 1, row0);
      boolean rightO  = 
        grid.isEmpty(colOrigin + 1, rowOrigin)&&
        grid.isInBounds(colOrigin + 1, rowOrigin);
      boolean right2 = 
        grid.isEmpty(col2 + 1, row2)&&
        grid.isInBounds(col2 + 1, row2);
      if (right0 && rightO && right2) {
        ++colOrigin;
        ++col0;
        ++col1;
        ++col2;
        return true;
      }  
      
    }
    
    return false;
    
  } 
  
  public boolean rotate() {

      // *************** direction 0 ************
      if (direction == 0) {
        boolean rotate1 =  
          grid.isEmpty(col1 + 1, row1 + 1)&&
          grid.isInBounds(col1 + 1, row1 + 1);
        boolean rotate2 = 
          grid.isEmpty(col2, row2 + 2)&&
          grid.isInBounds(col2, row2 + 2);
        if(rotate1 && rotate2){ 
          --row0;
          ++col0;
          ++row1;
          ++col1;
          row2 = row2 + 2;
          direction = 1;
          return true;
        }
    // *************** direction 1 ************
      } else if (direction == 1) {
        boolean rotate1 =  
          grid.isEmpty(col1 - 1, row1 + 1)&&
          grid.isInBounds(col1 - 1, row1 + 1);
        boolean rotate2 = 
          grid.isEmpty(col2-2, row2 )&&
          grid.isInBounds(col2-2, row2 );
        if(rotate1 && rotate2){
          ++row0;
          ++col0;
          --col1;
          ++row1;
          col2 = col2 - 2;
          
          direction = 2;
          return true;
        }
    // *************** direction 2 ************    
      } else if (direction == 2) {
        boolean rotate1 =  
          grid.isEmpty(col1 + 1, row1 + 1)&&
          grid.isInBounds(col1 + 1, row1 + 1);
        boolean rotate2 = 
          grid.isEmpty(col2, row2 + 2)&&
          grid.isInBounds(col2, row2 + 2);
        if(rotate1 && rotate2){
          ++row0;
          --col0;
          --row1;
          --col1;
          row2 = row2 - 2;
          
          direction = 3;
          return true;
        }
    // *************** direction 3 ************    
      } else if (direction == 3) {
        boolean rotate1 =  
          grid.isEmpty(col1 + 1, row1 - 1)&&
          grid.isInBounds(col1 + 1, row1 - 1);
        boolean rotate2 = 
          grid.isEmpty(col2 + 2, row2 )&&
          grid.isInBounds(col2 + 2, row2 );
        if(rotate1 && rotate2){  
          --row0;
          --col0;
          --row1;
          ++col1;
          col2 = col2 + 2;
          
          direction = 0;
        
          return true; 
        }
      }
      //return true;
    return false;
  }
}