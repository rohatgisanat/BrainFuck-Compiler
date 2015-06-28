# BrainFuck-Compiler
BrainFuck Compiler in Java
<html> 
<p>
BrainFuck is highly popular an esoteric programming language created by Urban Mueller. Having only 8 instructions ,this language is known for its minimalism
It consists of a 30000 cell register each of 1 byte. and a pointer that moves left or right between the register.
Instruction Set: <br/>
<ul>
<li><b>,</b> Used to accept value from the user.</li>
<li><b>.</b> Used to print the register value to the output screen</li>
<li><b>+</b> Used to increase the pointer (shift right)</li>
<li><b>-</b> Used to decrease the pointer (shift left)</li>
<li><b>></b> Used to print the register value to the output screen</li>
<li><b><</b> Used to print the register value to the output screen</li>
<li><b>[</b> Used to start the loop.The loop is skipped if the register[pointer]=0. </li>
<li><b>]</b> Used to close the loop.The loop iterates if register[pointer]>0.</li>
The point to be noted is that the pointer at the end of the loop may/may not point to the same reigster at the beginning of the loop.
</ul>
This program here is a compiler for this language in Java. Instead of a single byte array,the register uses an int array of size 30000.
The UI is in progress.
</p>
</html>
