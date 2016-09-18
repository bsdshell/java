import java.util.*;
import java.io.*;
import classfile.*;

public class TryCommandLine{
    public static void main(String[] args) {
        String command = "ls";
        String output = Aron.executeCommand(command);
        System.out.println(output);
    }
}

