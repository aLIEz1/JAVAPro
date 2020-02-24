package OSLearning;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ProcessorSchedulingAlgorithm {
    static class PCB {
        int pid; //进程id
        int priorityRight; //进程优先权
        int needTime; //进程需要运行时间
        int runTime; //进程已运行时间

        //初始化进程控制块信息
        PCB(int id, int pt, int nt) {
            pid = id;
            priorityRight = pt;
            needTime = nt;
            runTime = 0;
        }

        //实现动态优先算法
        void run() {
            this.runTime++;
            if (this.priorityRight > 0) {
                this.priorityRight--;
            }
        }

        //判断已运行时间是否与需要运行时间相等
        Boolean isFinished() {
            return this.needTime == this.runTime;
        }

        //重写toString方法，便于打印PCB信息
        @Override
        public String toString() {
            return "pid:" + pid + " priorityRight:" + priorityRight + " runTime:" + runTime;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int clock = 0; //定义时钟

        //定义窗口基本框架
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame jFrame =new JFrame("进程调度");
        jFrame.setBounds(600, 300, 500, 400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //定义容器
        JPanel jPanel =new JPanel(null);
        jFrame.getContentPane().add(jPanel, BorderLayout.NORTH);

        //定义标签
        JLabel jLabel1 = new JLabel();
        jLabel1.setText("HELLO");
        jPanel.add(jLabel1);

        /*
         * PriorityQueue是Java中的优先权队列，定义队列容量为5
         * 比较器(Comparator)为PCB中的优先权(priorityRight)
         *优先权高者处于队首
         * */
        Queue<PCB> PriorityQueue = new PriorityQueue<>(5,
                (o1, o2) -> o2.priorityRight - o1.priorityRight);

        //输入PCB的优先权和需要运行的时间
        for (int i = 1; i <= 5; i++) {
            int priority;
            int needTime;
            Scanner input = new Scanner(System.in);
            System.out.printf("请输入pid=%d的优先级(非负):", i);
            priority = input.nextInt();
            System.out.printf("请输入pid=%d的要求运行时间(非负):", i);
            needTime = input.nextInt();
            PriorityQueue.add(new PCB(i, priority, needTime)); //向队列中添加此次输入的PCB
        }

        //执行和打印PCB信息
        while (!PriorityQueue.isEmpty()) {
            System.out.printf("当期时间：%d\t", clock);
            PCB pcb = PriorityQueue.poll(); //输出并删除队首PCB
            assert pcb != null;
            System.out.println(pcb.toString());
            pcb.run(); //实现动态优先算法:runTime+1,priorityRight-1
            PriorityQueue.add(pcb); //向优先权队列新加入运行run方法之后的PCB，实现对优先权队列的更新
            System.out.println("执行后");
            System.out.println(pcb.toString());
            System.out.println("=====================================");
            Thread.sleep(1000);
            clock++;

            //判断进程runTime是否等于needTime
            if (pcb.isFinished()) {
                PriorityQueue.remove(pcb); //该进程结束，删除此PCB
                System.out.printf("进程%d结束\n", pcb.pid);
            }
        }
    }
}
