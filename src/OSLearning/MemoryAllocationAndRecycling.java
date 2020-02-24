package OSLearning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Memory {
    String name;
    int start;
    int size;
    boolean isFree;

    Memory(String NAME, int START, int SIZE) {
        this.name = NAME;
        this.start = START;
        this.size = SIZE;
        this.isFree = true;
    }

    Memory() {

    }
}

class Memories {
    private List<Memory> memories = new ArrayList<Memory>();

    public void display() {
        System.out.println("内存分配情况");
        System.out.println("区块号\t\t起始位置\t\t区间长度\t\t区间状态");
        for (Memory memory : memories) {
            System.out.printf("%s\t\t%d\t\t%d\t\t", memory.name,
                    memory.start, memory.size);
            if (!memory.isFree) {
                System.out.println("已占用");
            } else System.out.println("空闲");
        }

    }

    public Memories() {
        ArrayList<Memory> memories = new ArrayList<Memory>();
        Memory memory = new Memory("~", 0, 512);
        memories.add(memory);
    }

    public void clear() {
        for (int i = 0; i < memories.size(); i++) {
            memories.remove(i);
        }
    }

    public void allocation(Memories memories) {
        Memory M = new Memory();
        Scanner in = new Scanner(System.in);
        System.out.print("请输入要分配内存的进程名:");
        M.name = in.next();
        System.out.print("请输入要分配内存的大小:");
        M.size = in.nextInt();
        M.isFree = true;



    }

}

public class MemoryAllocationAndRecycling {


}
