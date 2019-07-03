

package checkers;

import java.util.Random;
import java.math.*;
/**
 *
 * @author taylorwhite
 */
public class BoardLogic 
{
    private int [][] board = new int [8][8];//board space
    private int [] chosenOne = new int [2];//the piece the user chooses to move
    private int [] aipieces = new int [12];//list of all ai pieces encoded as y*10 +x
    private int number = 12;//number of ai pieces
    private int win = 0;//for win checking(not used)
    private int jumpy = 0;//for human double jumps
    public BoardLogic() 
    {
      
        
        int count = 0;
        chosenOne[0]=-1;
        chosenOne[1]=-1;
        //initializing the board
        //white side
        for(int i = 0;i<3;i++)
        {
            if(i%2==1)
            {
                for(int e = 0;e<8;e++)
                {
                
                    if(e%2==1)
                    {
                        board[i][e]=0;
                    }
                    else
                    {
                        board[i][e]=1;
                        aipieces[count]=i*10+e;
                        count = count+1;
                    }
                    
                
                
                }
            }
            else
            {
                for(int e = 0;e<8;e++)
                {
                
                    if(e%2==0)
                    {
                        board[i][e]=0;
                    }
                    else
                    {
                        board[i][e]=1;
                        aipieces[count]=i*10+e;
                        count = count+1;
                    }
                
                
                }
            }
        }
        
        //middle
        
        for(int i = 3;i<5;i++)
        {
            for(int e = 0;e<8;e++)
            {
                
               
               board[i][e]=0;
                
            }
        }
        
        //black side
        for(int i = 5;i<8;i++)
        {
            if(i%2==1)
            {
                for(int e = 0;e<8;e++)
                {
                
                    if(e%2==1)
                    {
                        board[i][e]=0;
                    }
                    else
                        board[i][e]=3;
                
                
                }
            }
            else
            {
                for(int e = 0;e<8;e++)
                {
                
                    if(e%2==0)
                    {
                        board[i][e]=0;
                    }
                    else
                        board[i][e]=3;
                
                
                }
            }
        }
        
        
        
        
        
        //Display a = new Display();
        //a.setVisible(true);
        
        
        
        
       
    }
    
    public int getBoard(int x, int y)
    {
        int state = board[x][y];
        return state;
    }
    public void setState(int x, int y, int state)
    {
        board[x][y]=state;
    }
    
    public int getChosenX()
    {
        return chosenOne[0];
    }
    
    public int getChosenY()
    {
        return chosenOne[1];
    }
    
    public void setChosen(int x, int y)
    {
        if(jumpy == 0);
        {
        //System.out.println("I'm Mr. Meeseeks, Look at me!");
        chosenOne[0]=x;
        chosenOne[1]=y;
        //System.out.println(chosenOne[0] + " " + chosenOne[1]);
        }
       
    }
    
    public boolean movePlayer(int x, int y)
    {
        
        
        int xx = chosenOne[0]/70;
        int yy = chosenOne[1]/70;
        
        x = x/70;
        y=y/70;
        
        jumpy = 0;
        if(board[yy][xx]==3)
        {
            if(y==yy-1)//if moving one square
            {
                if(xx==x+1||xx==x-1)
                {
                   if(board[y][x]==0)//if theres nothing in the way
                   {
                       if(y==0)
                            {
                                board[y][x]=4;//set new board positions
                                board[yy][xx]=0;
                                return true;
                            }
                       else
                       {
                           board[y][x]=3;//set new board positions
                           board[yy][xx]=0;
                           return true;
                       }
                       
                   }
                }
                
            }
            else if(y==yy-2)//if jumping over a piece
            {
                if(xx==x+2)//if moving two squares right
                {
                   if(board[y][x]==0)//if theres nothing in the way
                   {
                       if(board[yy-1][xx-1]==1||board[yy-1][xx-1]==2)
                       {
                           if(y==0)
                           {
                            board[y][x]=4;
                            board[yy-1][xx-1]=0;
                            board[yy][xx]=0;
                            humanDoubleJump(y, x);
                                
                            return true;
                           }
                           else
                           {
                               board[y][x]=3;
                            board[yy-1][xx-1]=0;
                            board[yy][xx]=0;
                            humanDoubleJump(y, x);
                            return true;
                           }
                       }
                   }
                }
                if(xx==x-2)//if moving two squares left
                {
                   if(board[y][x]==0)//if theres nothing in the way
                   {
                       if(board[yy-1][xx+1]==1||board[yy-1][xx+1]==2)
                       {
                           if(y==0)
                           {
                            board[y][x]=4;
                            board[yy-1][xx+1]=0;
                            board[yy][xx]=0;
                            humanDoubleJump(y, x);
                            return true;
                           }
                           else
                           {
                              board[y][x]=3;
                            board[yy-1][xx+1]=0;
                            board[yy][xx]=0;
                            humanDoubleJump(y, x);
                            return true; 
                           }
                       }
                   }
                }
            }
            
            
        }
        else if(board[yy][xx]==4)
        {
            if(y==yy-1)//if moving one square
            {
                if(xx==x+1||xx==x-1)
                {
                   if(board[y][x]==0)//if theres nothing in the way
                   {
                       board[y][x]=4;//set new board positions
                       board[yy][xx]=0;
                       return true;
                       
                   }
                }
                
            }
            else if(y==yy+1)//if moving one square
            {
                if(xx==x+1||xx==x-1)
                {
                   if(board[y][x]==0)//if theres nothing in the way
                   {
                       board[y][x]=4;//set new board positions
                       board[yy][xx]=0;
                       return true;
                       
                   }
                }
                
            }
            else if(y==yy-2)//if jumping over a piece
            {
                if(xx==x+2)//if moving two squares right
                {
                   if(board[y][x]==0)//if theres nothing in the way
                   {
                       if(board[yy-1][xx-1]==1||board[yy-1][xx-1]==2)
                       {
                           
                            board[y][x]=4;
                            board[yy-1][xx-1]=0;
                            board[yy][xx]=0;
                            humanDoubleJump(y, x);
                            return true;
                           
                       }
                   }
                }
                if(xx==x-2)//if moving two squares left
                {
                   if(board[y][x]==0)//if theres nothing in the way
                   {
                       if(board[yy-1][xx+1]==1||board[yy-1][xx+1]==2)
                       {
                           
                            board[y][x]=4;
                            board[yy-1][xx+1]=0;
                            board[yy][xx]=0;
                            humanDoubleJump(y, x);
                            return true;
                           
                       }
                   }
                }
            }
            else if(y==yy+2)//if jumping over a piece
            {
                if(xx==x+2)//if moving two squares right
                {
                   if(board[y][x]==0)//if theres nothing in the way
                   {
                       if(board[yy+1][xx-1]==1||board[yy+1][xx-1]==2)
                       {
                           
                            board[y][x]=4;
                            board[yy+1][xx-1]=0;
                            board[yy][xx]=0;
                            humanDoubleJump(y, x);
                            return true;
                           
                       }
                   }
                }
                if(xx==x-2)//if moving two squares left
                {
                   if(board[y][x]==0)//if theres nothing in the way
                   {
                       if(board[yy+1][xx+1]==1||board[yy+1][xx+1]==2)
                       {
                           
                            board[y][x]=4;
                            board[yy+1][xx+1]=0;
                            board[yy][xx]=0;
                            humanDoubleJump(y, x);
                            return true;
                           
                       }
                   }
                }
            }
        }
        
        
        //chosenOne[0]=-1;
        //chosenOne[1]=-1;
         //System.out.print(y + " " + x);
        return false;
    }
    public void debug()
    {
       // System.out.println("I'm Mr. Meeseeks, Look at me!");
        for(int i = 0;i<8;i++)
        {
            for(int e = 0;e<8;e++)
            {
                System.out.print(board[i][e]);
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public boolean computerMove()
    {
        int y = -1;
        int x = -1;
        int increment;
        int goal;
        int start;
        Random rand = new Random();
        int yy = -1;
        int xx = -1;
        int piece = -1;
        int maxH = 0;
        
        for(int i = 0;i<12;i++)
        {
            //System.out.println(aipieces[i]);
            if(aipieces[i]!=-1)
            {
                y=aipieces[i]/10;
                x=aipieces[i]%10;
                if(board[y][x]!=1&&board[y][x]!=2)
                {
                    aipieces[i]=-1;
                }
            }
        }
        
        if(Math.abs(rand.nextInt()%2)==1)
        {
           increment = -1;
           start = 11;
           goal = -1;
        }
        else
        {
           increment = 1;
           start = 0;
           goal = 12; 
        }
        
        //looking at potential moves
        for(int i =start;i!=goal;i=i+increment)
        {
            if(aipieces[i]!=-1)
            {
                y = aipieces[i]/10;
                x = aipieces[i]%10;
                if(board[y][x]==1)
                {
                try
                {
                    if(board[y+1][x-1]==0)//if left diagonal is open
                    {
                        if(maxH<1)//set max heuristic to 1
                        {
                           
                            maxH=1;
                            yy=y;
                            xx=x;
                            piece = i;
                            
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
                try
                {
                    if(board[y+1][x+1]==0)//if right diagonal is open
                    {
                        if(maxH<1)//set max heuristic to 1
                        {
                            
                            maxH=1;
                            yy=y;//x and y saved for later use
                            xx=x;
                            piece = i;
                            
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    
                }
                try
                {
                    if(board[y+2][x-2]==0)//if left diagonal is open
                    {
                        if(board[y+1][x-1]==3||board[y+1][x-1]==4)
                        if(maxH<2)//set max heuristic to 2
                        {
                            
                            maxH=2;
                            yy=y;
                            xx=x;
                            piece = i;
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
                try
                {
                    if(board[y+2][x+2]==0)//if left diagonal is open
                    {
                        if(board[y+1][x+1]==3||board[y+1][x+1]==4)
                        if(maxH<2)//set max heuristic to 2
                        {
                            
                            maxH=2;
                            yy=y;
                            xx=x;
                            piece = i;
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
            }
                else if(board[y][x]==2)//for ai kings
                {
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    try
                    {
                        if(board[y-1][x-1]==0)
                        {
                      if(maxH<1)//set max heuristic to 1
                        {
                           
                            maxH=1;
                            yy=y;
                            xx=x;
                            piece = i;
                            
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
                try
                {
                    if(board[y-1][x+1]==0)//if right diagonal is open
                    {
                        if(maxH<1)//set max heuristic to 1
                        {
                            
                            maxH=1;
                            yy=y;//x and y saved for later use
                            xx=x;
                            piece = i;
                            
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    
                }
                try
                {
                    if(board[y-2][x-2]==0)//if left diagonal is open
                    {
                        if(board[y-1][x-1]==3||board[y-1][x-1]==4)
                        if(maxH<2)//set max heuristic to 2
                        {
                            
                            maxH=2;
                            yy=y;
                            xx=x;
                            piece = i;
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
                try
                {
                    if(board[y-2][x+2]==0)//if left diagonal is open
                    {
                        if(board[y-1][x+1]==3||board[y-1][x+1]==4)
                        if(maxH<2)//set max heuristic to 2
                        {
                            
                            maxH=2;
                            yy=y;
                            xx=x;
                            piece = i;
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }  
                try
                    {
                        if(board[y+1][x-1]==0)
                        {
                      if(maxH<1)//set max heuristic to 1
                        {
                           
                            maxH=1;
                            yy=y;
                            xx=x;
                            piece = i;
                            
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
                try
                {
                    if(board[y+1][x+1]==0)//if right diagonal is open
                    {
                        if(maxH<1)//set max heuristic to 1
                        {
                            
                            maxH=1;
                            yy=y;//x and y saved for later use
                            xx=x;
                            piece = i;
                            
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    
                }
                try
                {
                    if(board[y+2][x-2]==0)//if left diagonal is open
                    {
                        if(board[y+1][x-1]==3||board[y+1][x-1]==4)
                        if(maxH<2)//set max heuristic to 2
                        {
                            
                            maxH=2;
                            yy=y;
                            xx=x;
                            piece = i;
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
                try
                {
                    if(board[y+2][x+2]==0)//if left diagonal is open
                    {
                        if(board[y+1][x+1]==3||board[y+1][x+1]==4)
                        if(maxH<2)//set max heuristic to 2
                        {
                            
                            maxH=2;
                            yy=y;
                            xx=x;
                            piece = i;
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
                }
        }
        }
        
        
        
        
        
        
        
        
        if(maxH==1)
        {
            if(board[yy][xx]==1)
            {
                try
                    {
                        if(board[yy+1][xx-1]==0)//if left diagonal is open
                        {
                            if(yy+1==7)
                            {
                                board[yy+1][xx-1]=2;
                                board[yy][xx]=0;
                                aipieces[piece]=(yy+1)*10+xx-1;
                                return true;
                            }
                            else
                            {
                                board[yy+1][xx-1]=1;
                                board[yy][xx]=0;
                                aipieces[piece]=(yy+1)*10+xx-1;
                                return true;
                            }
                        }
                    }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
                try
                {   
                        if(board[yy+1][xx+1]==0)//if right diagonal is open
                        {
                            if(yy+1==7)
                            {
                                board[yy+1][xx+1]=2;
                                board[yy][xx]=0;
                                aipieces[piece]=(yy+1)*10+xx+1;
                                return true;
                            }
                            else
                            {
                                board[yy+1][xx+1]=1;
                                board[yy][xx]=0;
                                aipieces[piece]=(yy+1)*10+xx+1;
                                return true;
                            }
                        }
                    }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    
                }
            }
            else if(board[yy][xx]==2)
            {
                try
                    {
                        if(board[yy-1][xx-1]==0)//if left diagonal is open
                        {
                            
                            board[yy-1][xx-1]=2;
                            board[yy][xx]=0;
                            aipieces[piece]=(yy-1)*10+xx-1;
                            return true;
                        }
                    }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
                try
                {   
                        if(board[yy-1][xx+1]==0)//if right diagonal is open
                        {
                            board[yy-1][xx+1]=2;
                            board[yy][xx]=0;
                            aipieces[piece]=(yy-1)*10+xx+1;
                            return true;
                        }
                    }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    
                }
            
                try
                    {
                        if(board[yy+1][xx-1]==0)//if left diagonal is open
                        {
                            
                            board[yy+1][xx-1]=2;
                            board[yy][xx]=0;
                            aipieces[piece]=(yy+1)*10+xx-1;
                            return true;
                        }
                    }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
                try
                {   
                        if(board[yy+1][xx+1]==0)//if right diagonal is open
                        {
                            board[yy+1][xx+1]=2;
                            board[yy][xx]=0;
                            aipieces[piece]=(yy+1)*10+xx+1;
                            return true;
                        }
                    }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    
                }
            }
        }
        else if(maxH==2)//if jumping over a piece
        {
            if(board[yy][xx]==1)
            {
            try
                {
                    if(board[yy+2][xx-2]==0)//if left diagonal is open
                    {
                        
                        if(board[yy+1][xx-1]==3||board[yy+1][xx-1]==4)
                        
                            
                           if(yy+2==7)
                           {
                             board[yy+2][xx-2]=2;
                            board[yy][xx]=0;
                            board[yy+1][xx-1]=0;
                            aipieces[piece]=(yy+2)*10+xx-2;
                            computerDoubleJump(yy+2,xx-2,2, piece);
                            return true;
                           }
                        else
                           {
                                board[yy+2][xx-2]=1;
                                
                            board[yy][xx]=0;
                            board[yy+1][xx-1]=0;
                            aipieces[piece]=(yy+2)*10+xx-2;
                            computerDoubleJump(yy+2,xx-2,1, piece);
                            return true;
                           }
                        
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
                try
                {
                    if(board[yy+2][xx+2]==0)//if left diagonal is open
                    {
                        
                        if(board[yy+1][xx+1]==3||board[yy+1][xx+1]==4)
                        {
                            if(yy+2==7)
                            {
                            board[yy+2][xx+2]=2;
                            board[yy][xx]=0;
                            board[yy+1][xx+1]=0;
                            aipieces[piece]=(yy+2)*10+xx+2;
                            computerDoubleJump(yy+2,xx+2,2, piece);
                            return true;
                            }
                            else
                            {
                                board[yy+2][xx+2]=1;
                            board[yy][xx]=0;
                            board[yy+1][xx+1]=0;
                            aipieces[piece]=(yy+2)*10+xx+2;
                            computerDoubleJump(yy+2,xx+2,1, piece);
                            return true;
                            }
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
            }
            else if(board[yy][xx]==2)//if ai king
            {
                try
                {
                    if(board[yy-2][xx-2]==0)//if left diagonal is open
                    {
                        
                        if(board[yy-1][xx-1]==3||board[yy-1][xx-1]==4)  
                        {
                            
                            
                             board[yy-2][xx-2]=2;
                            board[yy][xx]=0;
                            board[yy-1][xx-1]=0;
                            aipieces[piece]=(yy-2)*10+xx-2;
                            computerDoubleJump(yy-2,xx-2,2, piece);
                            return true;
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
                try
                {
                    if(board[yy-2][xx+2]==0)//if left diagonal is open
                    {
                        
                        if(board[yy-1][xx+1]==3||board[yy-1][xx+1]==4)
                        {
                           
                            
                            board[yy-2][xx+2]=2;
                            board[yy][xx]=0;
                            board[yy-1][xx+1]=0;
                            aipieces[piece]=(yy-2)*10+xx+2;
                            computerDoubleJump(yy-2,xx+2,2, piece);
                            return true;
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
                try
                {
                    if(board[yy+2][xx-2]==0)//if left diagonal is open
                    {
                        
                        if(board[yy+1][xx-1]==3||board[yy+1][xx-1]==4)  
                        {
                            
                             board[yy+2][xx-2]=2;
                            board[yy][xx]=0;
                            board[yy+1][xx-1]=0;
                            aipieces[piece]=(yy+2)*10+xx-2;
                            computerDoubleJump(yy+2,xx-2,2, piece);
                            return true;
                        }
                        
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
                try
                {
                    if(board[yy+2][xx+2]==0)//if left diagonal is open
                    {
                        
                        if(board[yy+1][xx+1]==3||board[yy+1][xx+1]==4)
                        {
                           
                            
                            board[yy+2][xx+2]=2;
                            board[yy][xx]=0;
                            board[yy+1][xx+1]=0;
                            aipieces[piece]=(yy+2)*10+xx+2;
                            computerDoubleJump(yy+2,xx+2,2, piece);
                            return true;
                        }
                    }
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    //will continue code if arrayindexoutofbounds
                }
            }
        }
        /*
        for(int i=0;i<12;i++)
        {
            y = aipieces[i]/10;
            x = aipieces[i]%10;
            
            if(y!=0)//making sure that piece is in borders so no arrayindex error
            {
                if(x>0&&x<7)
                {
                    if(board[y+1][x-1]==0)//if left diagonal is open
                    {
                        if(maxH<1)//set max heuristic to 1
                            maxH=1;
                    }
                    if(board[y+1][x+1]==0)//if right diagonal is open
                    {
                        if(maxH<1)//set max heuristic to 1
                            maxH=1;
                    }
                    if(x>1&&x<6)//continuing to make sure it is in bounds
                    {
                        if(board[y+2][x+2]==0)
                            {
                                if(board[y+1][x+1]==3)//if there is a piece you can jump
                                {
                                    if(maxH<2)//set max heuristic to 1
                                        maxH=2;
                                }
                                
                            }
                        if(board[y+2][x-2]==0)
                            {
                                if(board[y+1][x-1]==3)//if there is a piece you can jump
                                {
                                    if(maxH<2)//set max heuristic to 1
                                        maxH=2;
                                }
                                
                            }
                    }
                }
            }
        }
        
        
        
        
        //moving pieces
        if(maxH==1)
        {
            for(int i=0;i<12;i++)
            {
                y = aipieces[i]/10;
                x = aipieces[i]%10;
            
                if(y!=0)//making sure that piece is in borders so no arrayindex error
                {
                    if(x>0&&x<7)
                    {
                        if(board[y+1][x-1]==0)//if left diagonal is open
                        {
                           board[y+1][x-1]=1; 
                           board[y][x]=0;
                           return true;
                        }
                        if(board[y+1][x+1]==0)//if right diagonal is open
                        {
                            board[y+1][x+1]=1; 
                            board[y][x]=0;
                            return true;
                        }
                        
                    }
                }
            }
        }
        
        
        
        
        
        if(maxH==2)
        {
            for(int i=0;i<12;i++)
            {
                y = aipieces[i]/10;
                x = aipieces[i]%10;
            
                if(y!=0)//making sure that piece is in borders so no arrayindex error
                {
                    if(x>0&&x<7)
                    {
                        if(board[y+2][x-2]==0)//if left diagonal is open
                        {
                            if(board[y+1][x-1]==3||board[y+1][x-1]==4)
                            {
                                board[y+1][x-1]=0; 
                                board[y][x]=0;
                                board[y+2][x-2]=1;
                                return true;
                            }
                        }
                        if(board[y+2][x+2]==0)//if left diagonal is open
                        {
                            if(board[y+1][x+1]==3||board[y+1][x+1]==4)
                            {
                                board[y+1][x+1]=0; 
                                board[y][x]=0;
                                board[y+2][x+2]=1;
                                return true;
                            }
                        }
                        
                    }
                }
            }
        }
         */       
                
        return false;        
                
        
        
    }
    
    public void computerDoubleJump(int y, int x, int type, int piece)
    {
       //for checking if computer can double jump, has some recursion
        if(type == 1)
        {
           
            try
            {
                if(board[y+1][x+1]==3||board[y+1][x+1]==4)
                {
                    
                    if(board[y+2][x+2]==0)
                    {
                        if((y+2)==7)
                        {
                            board[y][x]=0;
                            board[y+1][x+1]=0;
                            board[y+2][x+2]=2;
                            aipieces[piece]=(y+2)*10+x+2;
                            computerDoubleJump(y+2,x+2,2, piece);
                            return;
                        }
                        else
                        {
                            board[y][x]=0;
                            board[y+1][x+1]=0;
                            board[y+2][x+2]=1;
                            aipieces[piece]=(y+2)*10+x+2;
                            computerDoubleJump(y+2,x+2,1, piece);
                            return;
                        }
                    }
                    
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                
            }
            try
            {
                if(board[y+1][x-1]==3||board[y+1][x-1]==4)
                {
                   
                    if(board[y+2][x-2]==0)
                    {
                        if((y+2)==7)
                        {
                            board[y][x]=0;
                            board[y+1][x-1]=0;
                            board[y+2][x-2]=2;
                            aipieces[piece]=(y+2)*10+x-2;
                            computerDoubleJump(y+2,x-2,2, piece);
                            return;
                        }
                        else
                        {
                            board[y][x]=0;
                            board[y+1][x-1]=0;
                            board[y+2][x-2]=1;
                            aipieces[piece]=(y+2)*10+x-2;
                            computerDoubleJump(y+2,x-2,1, piece);
                            return;
                        }
                    }
                    
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                
            }
        }
        if(type==2)
        {
            try
            {
                if(board[y+1][x+1]==3||board[y+1][x+1]==4)
                {
                    if(board[y+2][x+2]==0)
                    {
                       
                            board[y][x]=0;
                            board[y+1][x+1]=0;
                            board[y+2][x+2]=2;
                            aipieces[piece]=(y+2)*10+x+2;
                            computerDoubleJump(y+2,x+2,2, piece);
                            return;
                        
                        
                    }
                    
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                
            }
            try
            {
                if(board[y+1][x-1]==3||board[y+1][x-1]==4)
                {
                    if(board[y+2][x-2]==0)
                    {
                        
                        
                            board[y][x]=0;
                            board[y+1][x-1]=0;
                            board[y+2][x-2]=2;
                            aipieces[piece]=(y+2)*10+x-2;
                            computerDoubleJump(y+2,x-2,2, piece);
                            return;
                       
                    }
                    
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                
            }
            
            try
            {
                if(board[y-1][x+1]==3||board[y-1][x+1]==4)
                {
                    if(board[y-2][x+2]==0)
                    {
                        
                            board[y][x]=0;
                            board[y-1][x+1]=0;
                            board[y-2][x+2]=2;
                            aipieces[piece]=(y-2)*10+x+2;
                            computerDoubleJump(y-2,x+2,2, piece);
                            return;
                        
                    }
                    
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                
            }
            try
            {
                if(board[y-1][x-1]==3||board[y-1][x-1]==4)
                {
                    if(board[y-2][x-2]==0)
                    {
                     
                            board[y][x]=0;
                            board[y-1][x-1]=0;
                            board[y-2][x-2]=2;
                            aipieces[piece]=(y-2)*10+x-2;
                            computerDoubleJump(y-2,x-2,2, piece);
                            
                        
                    }
                    
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                
            }
        }
    }
    public boolean humanDoubleJump(int y, int x)
    {
        if(board[y][x]==3)//for human double jump
        {
            try
            {
                if(board[y-1][x-1]==1||board[y-1][x-1]==2)
                {
                    if(board[y-2][x-2]==0)
                    {
                        setChosen(y,x);
                        jumpy = 1;
                        return true;
                    }
                    
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                
            }
            try
            {
                if(board[y-1][x+1]==1||board[y-1][x+1]==2)
                {
                    if(board[y-2][x+2]==0)
                    {
                        setChosen(y,x);
                        jumpy = 1;
                        return true;
                    }
                    
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                
            }
        }
        else if(board[y][x]==4)
        {
            try
            {
                if(board[y+1][x-1]==1||board[y+1][x-1]==2)
                {
                    if(board[y+2][x-2]==0)
                    {
                        setChosen(y,x);
                        jumpy = 1;
                        return true;
                    }
                    
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                
            }
            try
            {
                if(board[y+1][x+1]==1||board[y+1][x+1]==2)
                {
                    if(board[y+2][x+2]==0)
                    {
                        setChosen(y,x);
                        jumpy = 1;
                        return true;
                    }
                    
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                
            }
            try
            {
                if(board[y-1][x-1]==1||board[y-1][x-1]==2)
                {
                    if(board[y-2][x-2]==0)
                    {
                        setChosen(y,x);
                        jumpy = 1;
                        return true;
                    }
                    
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                
            }
            try
            {
                if(board[y-1][x+1]==1||board[y-1][x+1]==2)
                {
                    if(board[y-2][x+2]==0)
                    {
                        setChosen(y,x);
                        jumpy = 1;
                        return true;
                    }
                    
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                
            }
        }
        setChosen(-1,-1);
        return false;
    }
    public int getJumpy()
    {
        return jumpy;
    }
    
    
}
