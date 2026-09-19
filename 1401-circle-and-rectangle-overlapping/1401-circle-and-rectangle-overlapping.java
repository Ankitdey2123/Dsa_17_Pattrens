class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xClose,yClose;
        if(xCenter<x1){
            xClose=x1;
        }
        else if(xCenter>x2){
            xClose=x2;
        }
        else{
            xClose=xCenter;
        }

        if(yCenter<y1){
            yClose=y1;
        }
        else if(yCenter>y2){
            yClose=y2;
        }
        else{
            yClose=yCenter;
        }

        int dis = (xCenter - xClose) * (xCenter - xClose)
                + (yCenter - yClose) * (yCenter - yClose);

        if(dis<=radius*radius){
            return true;
        }
        else{
            return false;
        }
    }
}