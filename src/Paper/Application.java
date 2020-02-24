package Paper;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

class Application {
    private int num;
    private float[] score;

    void input() {
        System.out.print("请输入学生的个数：");
        Scanner reader = new Scanner(System.in);
        num = reader.nextInt();
        Paper[] papers = new Paper[num];
        for (int i = 0; i < num; i++) {
            papers[i] = new Paper();
        }
        score = new float[num];
        for (int i = 0; i < num; i++) {
            papers[i].setName(i + "stu");
        }
        for (int i = 0; i < num; i++) {
            System.out.print("请输入第" + (i + 1) + "个学生的成绩：");
            float s = reader.nextFloat();
            if (s >= 0 && s <= 100) {
                papers[i].setSocre(s);
                score[i] = s;
            } else {
                i -= 1;
                System.out.println("请输入正确的成绩！");
            }
        }
        reader.close();

    }

    float getAverage() {
        float sum = 0;
        for (int i = 0; i < num; i++) {
            sum += score[i];
        }
        return sum / num;
    }

    float[] getMaxMin() {
        float max = score[0];
        float min = score[0];
        float[] m = new float[2];
        for (int i = 0; i < num; i++) {
            if (score[i] > max) {
                max = score[i];
            }
            if (score[i] < min) {
                min = score[i];
            }

        }
        m[0] = min;
        m[1] = max;
        return m;
    }

    int[] selectScore() {
        int[] r = new int[5];
        for (int i = 0; i < num; i++) {
            if (score[i] < 60) {
                r[0] += 1;
            } else if (score[i] < 70) {
                r[1] += 1;
            } else if (score[i] < 80) {
                r[2] += 1;
            } else if (score[i] < 90) {
                r[3] += 1;
            } else {
                r[4] += 1;
            }
        }
        return r;
    }

    void show(float s, float[] a, int[] r) {
        float min = a[0];
        float max = a[1];
        DecimalFormat df = new DecimalFormat("#.0");
        System.out.println("平均分：" + df.format(s));
        System.out.println("最低分：" + df.format(min));
        System.out.println("最高分：" + df.format(max));
        NumberFormat nt = NumberFormat.getPercentInstance();
        nt.setMinimumFractionDigits(1);
        System.out.println("不及格人数：" + r[0] + "  " + nt.format(((float) r[0] / num)));
        System.out.println("60-70人数：" + r[1] + "  " + nt.format(((float) r[1] / num)));
        System.out.println("70-80人数：" + r[2] + "  " + nt.format(((float) r[2] / num)));
        System.out.println("80-90人数：" + r[3] + "  " + nt.format(((float) r[3] / num)));
        System.out.println("90-100人数：" + r[4] + "  " + nt.format(((float) r[4] / num)));
    }
}
