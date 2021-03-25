import java.util.Scanner;

public class Input {
    //all input handled by this class
    //allows for scanner to not be used in any other class

    private static Scanner scanner = new Scanner(System.in);

    public int readInt(){
        int no = scanner.nextInt();
        scanner.nextLine();
        return no;
    }

    public double readDouble(){
        double no = scanner.nextDouble();
        scanner.nextLine();
        return no;
    }

    public float readFloat(){
        float no = scanner.nextFloat();
        scanner.nextLine();
        return no;
    }

    public long readLong(){
        long no = scanner.nextLong();
        scanner.nextLine();
        return no;
    }

    public short readShort(){
        short no = scanner.nextShort();
        scanner.nextLine();
        return no;
    }

    public char readChar(){
        //to remove any whitespaces
        char c = scanner.next().trim().charAt(0);
        return c;
    }

    public String readString(){
        String s = scanner.nextLine();
        return s;
    }

    public byte readByte(){
        byte no = scanner.nextByte();
        scanner.nextLine();
        return no;
    }

    public boolean readBool(){
        boolean bool = scanner.nextBoolean();
        return bool;
    }

}
