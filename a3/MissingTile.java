package Tile;
//collaborators Pao,Taem,Ink
public class MissingTile {
    public static void tileGrid(Grid board){
        titlegridHelper(board,board.getPaintedCellX(),board.getPaintedCellY(),board.size(),0,0);
    }
    static void titlegridHelper(Grid board,int holeX,int holeY,int size,int posX,int posY) {
        if(size==1){
            return ;
        }
        if (size==2){
            if (holeX==posX+1&& holeY==posY+1){                                 //If the missing tile is in the upper left quadrant
                board.setTile(posX+1,posY+1,1);          //Sets a tile with orientation 1
            } else if (holeX==posX && holeY==posY){                             //If the missing tile is in the lower right quadrant
                board.setTile(posX,posY,3);                    //Sets a tile with orientation 3
            } else if (holeX==posX+1 && holeY==posY){                           //If the missing tile is in the upper right quadrant
                board.setTile(posX + 1,posY,0);             //Sets a tile with orientation 0
            } else{                                                             //If the missing tile is in the lower left quadrant
                board.setTile(posX,posY + 1,2);             //Sets a tile with orientation 2
            }
        } else{
            size = size / 2;
            if (holeX < size + posX && holeY < size + posY){             
                board.setTile(posX + size - 1, posY + size - 1, 3);
                titlegridHelper(board, holeX, holeY, size, posX, posY);
                titlegridHelper(board, posX + size, posY + size - 1, size, posX + size, posY);
                titlegridHelper(board, posX + size - 1, posY + size, size, posX, posY + size);
                titlegridHelper(board, posX + size, posY + size, size, posX + size, posY + size);
            }
            else if (holeX < size + posX && holeY >= size + posY){
                board.setTile(posX + size - 1, posY + size, 2);
                titlegridHelper(board, posX + size - 1, posY + size - 1, size, posX, posY);
                titlegridHelper(board, posX + size, posY + size - 1, size, posX + size, posY);
                titlegridHelper(board, holeX, holeY, size, posX, posY + size);
                titlegridHelper(board, posX + size, posY + size, size, posX + size, posY + size);
            }
            else if (holeX >= size + posX && holeY >= size + posY){
                board.setTile(posX + size, posY + size, 1);
                titlegridHelper(board, posX + size - 1, posY + size - 1, size, posX, posY);
                titlegridHelper(board, posX + size, posY + size - 1, size, posX + size, posY);
                titlegridHelper(board, posX + size - 1, posY + size, size, posX, posY + size);
                titlegridHelper(board, holeX, holeY, size, posX + size, posY + size);
            }
            else{
                board.setTile(posX + size, posY + size - 1, 0);
                titlegridHelper(board, posX + size - 1, posY + size - 1, size, posX, posY);
                titlegridHelper(board, holeX, holeY, size, posX + size, posY);
                titlegridHelper(board, posX + size - 1, posY + size, size, posX, posY + size);
                titlegridHelper(board, posX + size, posY + size, size, posX + size, posY + size);
            }
        }
    }
}