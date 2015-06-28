
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * by Sanat Rohatgi
 */
public class BrainFuckCompiler {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        char program[];
        int bracketPosition[], register[], flagposition[];
        int bpPointer=0, registerPntr=0;
        char ctemp;
        int size = 0, brackets = 0,temp,flag = 0,count=0;
        BufferedReader checkFileSize = new BufferedReader(new FileReader("squares.b")); //Filename goes here.Used to check size and match [ ]
        BufferedReader copyProgram = new BufferedReader(new FileReader("squares.b"));//Used to read the program minto a char[]
        BufferedReader userInputObject = new BufferedReader(new InputStreamReader(System.in));//
        while ((temp = checkFileSize.read()) != -1) { // check size and match the brackets.
            ctemp = (char) temp;
            if (ctemp == '[') {
                brackets++;
            } else if (ctemp == ']') {
                brackets--;
            }
            if (brackets < 0) {
                System.out.println("Brackets not matched");
                System.exit(1);
            }
            size++;
        }
        
        program = new char[size];                //Used to store the program.
        flagposition = new int[size];            //Stores 123 where the loop skipping starts
        bracketPosition = new int[size];         //Stores the location of brackets as they occur in the program.
                                                 //Positions are added and removed dynamically
        register = new int[30000];               //Register
       
        copyProgram.read(program);               //Copies the program into char program[]
        for (int i = 0; i < size; i++) {            //Starts execution
          
              switch (program[i]) {
                case '>':
                    if (flag != 1) {
                        ++registerPntr;
                        break;
                    } else {
                        break;
                    }
                case '<':
                    if (flag != 1) {
                        --registerPntr;
                         break;
                    } 
                        break;
                        case '+':
                    if (flag != 1) {
                        ++register[registerPntr];
                        break;
                    }
                        break;
                    
                case '-':
                    if (flag != 1) {
                        --register[registerPntr];
                        break;
                    }
                        break;
                    
                case '.':
                    if (flag != 1) {
                        System.out.print((char) register[registerPntr]);
                        break;
                    }
                        break;
                    
                case ',':
                    if (flag != 1) {
                        register[registerPntr] = (int) userInputObject.read();
                        break;
                    }
                        break;
                    
                case '[': {
                    if(register[registerPntr]!=0){                      //If loop has to begin
                        bpPointer++;                                    //Increase pointer
                        bracketPosition[bpPointer]=i;                   //Add the [ position so that it can return back for reiteration
                        break;
                    }
                    if(register[registerPntr]==0){                      //Loop has to skip.Increase the count of no. of times the flags is raised.
                                                                        //Raise the flag.and store the position of the flag.
                        flag=1;
                        bpPointer++;bracketPosition[bpPointer]=i;flagposition[bpPointer]=123; count+=1; 
                        break;
                    }
                    
                    
                }
                case ']':{
                    if(flag==0){
                        if(register[registerPntr]!=0){                          //Reiterate the loop by sending the parser to the start of the loop 
                            i=bracketPosition[bpPointer]-1;
                            bpPointer--;                                        //Remove the matching [ postion from the array
                            break;
                        }
                        
                        if(register[registerPntr]==0){                          //End loop.
                            bpPointer--;
                            break;
                        }
                    }
                    else{   
                    if(flagposition[bpPointer]==123){                           //if the matching ] of a skipped loop is met.
                        count-=1;if(count==0){flag=0;}                          //Decrease no. of times flag raised by 1
                                                                                // Bring down the flag only if there is no loop being skipped.
                                bpPointer--;                                    //Remove the matching [ ostion from the array
                                break;
                        
                    }                    
                    else{
                        bpPointer--;break;
                    }
                    }
                }
            default:{}
            ;
           }
        }
        System.out.println("\n\nCompiled");
    }

}
