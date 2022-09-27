import java.util.HashSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author arpita
 */

public class Sudoku {

   private final char[][] data;
   // HashMap<Integer, Character> dataMap = new HashMap<>();
    public Sudoku() {
        data = new char[9][9];
        for(int i=0;i<9;i++)
        {
          for(int j=0;j<9;j++) 
          {
              data[i][j]=' ';
          }
        }
    }
    
    public void set(int i,int j,char c)
    {
        try{
        if(c!=' ')
        { 
        data[i][j]= c;    
        Integer.parseInt(String.valueOf(c));
        }
         
         
        }
        catch(NumberFormatException e){
            System.out.printf("Trying to set illegal character %c to (%d, %d)!\n",c,i,j);
            data[i][j]=' ';
            
        }
        catch(ArrayIndexOutOfBoundsException ai)
        {
            System.out.printf("Trying to access illegal cell (%d, %d)!\n",i,j);
        }
    }
    
    public void print()
    {
        System.out.println("#####################################");
        int k =0;
        for(int i=0;i<9;i++)
        {
            System.out.print("#");
            for(int j=0;j<9;j++)
            {
                if(k==2)
                {
                    k=0;
                    System.out.printf(" %c #",data[i][j]);
                }
                else
                {
                    k+=1;
                    System.out.printf(" %c |",this.data[i][j]);
                }
                
                
              
            }
            if((i+1)%3==0)
            {
               System.out.println("\n#####################################"); 
            }
            else
            {
            if(i<8)    
            System.out.println("\n#---+---+---#---+---+---#---+---+---#");
            }
            
        }
        
    }
    
 public boolean check()
 {
    boolean result= notInRow(this.data);
    return result;
 }
 
 private boolean notInRow(char arr[][])
    {
 
        // Set to store characters seen so far.
        HashSet<Character> st ;
 
        for (int i = 0; i < 9; i++) {
            st = new HashSet<>();
            for(int j=0;j<9;j++)
            {
            if (st.contains(arr[i][j]))
            {
                System.out.printf("Row %d has multiple %c's!\n",i,arr[i][j]);
                return false;
            }
           
            if (arr[i][j] != ' ')
                st.add(arr[i][j]);
            }
        }
        return notInCol(this.data);
    }
 
    // Checks whether there is any duplicate
    // in current column or not.
private boolean notInCol(char arr[][])
    {
        HashSet<Character> st ;
 
        for (int i = 0;i < 9; i++) {
            st = new HashSet<>();
           for(int j=0;j<9;j++)
           {
            if (st.contains(arr[j][i]))
            {
                System.out.printf("Column %d has multiple %c's!\n",i,arr[j][i]);
                return false;
            }
 
          
            if (arr[j][i] != ' ')
                st.add(arr[j][i]);
           }
        }
        return notInBox(this.data);
    }
 
    // Checks whether there is any duplicate
    // in current 3x3 box or not.
private boolean notInBox(char arr[][])
    {
        HashSet<Character> st;
        for(int i=0;i<7;i+=3)
        {
            for(int j=0;j<7;j+=3)
            {
                 st = new HashSet<>(); 
                for (int row = 0; row < 3; row++) {
                      for (int col = 0; col < 3; col++) {
                 char curr
                    = arr[row + i][col + j];
 
                // If already encountered before, return
                // false
                if (st.contains(curr))
                {
                    System.out.printf("Block at (%d, %d) has multiple %c's!\n",i,j,curr);
                    return false;
                }
 
                // If it is not an empty cell,
                // insert value at current cell in set
                if (curr != ' ')
                    st.add(curr);
                }
        } 
            }
        }
       
        return true;
    }
}
