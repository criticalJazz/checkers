package checkers;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 

/**
 * @author taylorwhite
 */


public class Display extends JFrame implements MouseListener
{
    
    private int width = 560;
    private int height = 560;
    private BoardLogic board;
    private DrawCanvas canvas;
    private int squareSize = 70;
    private PointerInfo point = MouseInfo.getPointerInfo();
    
    public Display()
    {
    board = new BoardLogic();
    initComponents();
    }
    
    public void initComponents()
    {
        canvas = new DrawCanvas();   
        canvas.setPreferredSize(new Dimension(width, height));
        Container cp = getContentPane();
        cp.add(canvas);
        setDefaultCloseOperation(EXIT_ON_CLOSE);   // Handle the CLOSE button
        pack();              // Either pack() the components; or setSize()
        setTitle("Checkers");  // title for application, might change to something more catchy
        addMouseListener(this);//"listens" for mouse actions
        
    }

    

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {//what to do if mouse click
        int x = e.getX();
        int y = e.getY();
        Graphics g = null;
       if(board.getChosenX()==-1)//if no piece has been chosen
       {
           board.setChosen(x, y);//chosen piece to move
           canvas.setVisible(false);
           canvas.setVisible(true);
           
       }
       else
       {
           if(board.movePlayer(x, y)==true)
           {
               boolean l = false;
               canvas.setVisible(false);
               canvas.setVisible(true);
               //board.debug();//for development
             if(board.getJumpy()==0)//if human cant double jump
             {
               l = board.computerMove();
               
               canvas.setVisible(false);
               canvas.setVisible(true);
               board.setChosen(-1, -1);
               //board.debug();//for development
             }
           }
           else if(board.movePlayer(x, y)==false)
           {
               board.setChosen(-1, -1);
           }
           
       }
        
    }
    
    private class DrawCanvas extends JPanel//for drawing board
    {
        @Override
        public void paintComponent(Graphics g) {
         super.paintComponent(g);     // paint parent's background
         setBackground(Color.GRAY);  // set background color for this JPanel
 
         
         g.setColor(Color.PINK);    // set the drawing color
         
         for(int i = 0;i<8;i++)
         {
             if(i%2==0)//board squares are staggered so this arrangement gets the correct look
             {
                for(int e = 0;e<8;e++)
                {
                    if(e%2==0)
                    {
                        g.fillRect(e*squareSize, i*squareSize, squareSize, squareSize);
                    }
                   
                    switch (board.getBoard(i,e)) {
                    //should probably use switch
                        case 1:
                            g.setColor(Color.BLACK);
                            g.fillOval(e*squareSize+10, i*squareSize+10, 50, 50);
                            g.setColor(Color.PINK);
                            break;
                        case 2:
                            g.setColor(Color.BLACK);
                            g.fillOval(e*squareSize+10, i*squareSize+10, 50, 50);
                            g.setColor(Color.GRAY);
                            g.drawLine(e*squareSize+30, i*squareSize+35, e*squareSize+40, i*squareSize+35);
                            g.drawLine(e*squareSize+35, i*squareSize+30, e*squareSize+35, i*squareSize+40);
                            g.setColor(Color.PINK);
                            break;
                        case 3:
                            g.setColor(Color.RED);
                            g.fillOval(e*squareSize+10, i*squareSize+10, 50, 50);
                            g.setColor(Color.PINK);
                            break;
                        case 4:
                            g.setColor(Color.RED);
                            g.fillOval(e*squareSize+10, i*squareSize+10, 50, 50);
                            g.setColor(Color.PINK);
                            g.drawLine(e*squareSize+30, i*squareSize+35, e*squareSize+40, i*squareSize+35);
                            g.drawLine(e*squareSize+35, i*squareSize+30, e*squareSize+35, i*squareSize+40);
                            g.setColor(Color.PINK);
                            break;
                        default:
                            break;
                    }
                    if(board.getChosenX()!=-1)
                    {
                    if((board.getChosenX()/squareSize)==e&&(board.getChosenY()/squareSize)==i)
                    {
                        
                        g.setColor(Color.YELLOW);
                        g.drawOval(e*squareSize+9, i*squareSize+9, 52, 52);
                        g.setColor(Color.PINK);
                    }
                    }
                    
                }
             }
             
             else
             {
                 for(int e = 0;e<8;e++)
                {
                    if(e%2==1)
                    {
                        g.fillRect(e*squareSize, i*squareSize, squareSize, squareSize);
                    }
                    
                     switch (board.getBoard(i,e)) {
                         case 1:
                             g.setColor(Color.BLACK);
                             g.fillOval(e*squareSize+10, i*squareSize+10, 50, 50);
                             g.setColor(Color.PINK);
                             break;
                         case 2:
                             g.setColor(Color.BLACK);
                             g.fillOval(e*squareSize+10, i*squareSize+10, 50, 50);
                             g.setColor(Color.GRAY);
                             g.drawLine(e*squareSize+30, i*squareSize+35, e*squareSize+40, i*squareSize+35);
                             g.drawLine(e*squareSize+35, i*squareSize+30, e*squareSize+35, i*squareSize+40);
                             g.setColor(Color.PINK);
                             break;
                         case 3:
                             g.setColor(Color.RED);
                             g.fillOval(e*squareSize+10, i*squareSize+10, 50, 50);
                             g.setColor(Color.PINK);
                             break;
                         case 4:
                             g.setColor(Color.RED);
                             g.fillOval(e*squareSize+10, i*squareSize+10, 50, 50);
                             g.setColor(Color.PINK);
                             g.drawLine(e*squareSize+30, i*squareSize+35, e*squareSize+40, i*squareSize+35);
                             g.drawLine(e*squareSize+35, i*squareSize+30, e*squareSize+35, i*squareSize+40);
                             g.setColor(Color.PINK);
                             break;
                         default:
                             break;
                     }
                    
                    if(board.getChosenX()!=-1)
                    {
                    if((board.getChosenX()/squareSize)==e&&(board.getChosenY()/squareSize)==i)
                    {
                        
                        g.setColor(Color.YELLOW);
                        g.drawOval(e*squareSize+9, i*squareSize+9, 52, 52);
                        g.setColor(Color.PINK);
                    }
                    }

                }
             }
             
         }
         
         //g.fillOval(300, 310, 30, 50);
         //g.fillRect(400, 350, 60, 50);
         
         
         
        
      }
        
       
        
      
        
   }
    
   
    
    
    }
      
        
    
    
    
    
    

